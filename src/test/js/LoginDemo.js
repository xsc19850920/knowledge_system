import React from 'react';
import ReactDOM from 'react-dom';
import {User} from './usermodel';
import {Button} from 'antd';
import Reqwest from 'reqwest';
import JWT from 'jsonwebtoken';


var CryptoJS = require("crypto-js");
var Base64 = require("./Base64");


const App = React.createClass({
    handleClick() {
        console.log('发生请求');
        Reqwest({
            url: '/getImageVerifyCode',
            method: 'GET',
            type: 'json',
            contentType: 'application/json',
            data: JSON.stringify(this.state.infos),
            error: function(error) {
                var txt = error.responseText;
                var value = JSON.parse(txt);
                console.log(value.message);

            }.bind(this),
            success: function(resp) {
                var image = 'data:image/png;base64,'+resp.imageStr;
                //var data = resp.content;
                console.log(image);
                //var jwt = resp.key;
                //var token = JWT.sign({ foo: jwt }, 'hahaha');
                //sessionStorage.setItem('jwt', token);


            }.bind(this)
        });

        //$.ajax({
        //    type: 'GET',
        //    url: 'http://localhost:8080/api/view',
        //    dataType: 'json',
        //    contentType: "application/json; charset=utf-8",
        //    success: function(data,stats) {
        //        //this.setState({data: data});
        //        //console.log(data);
        //        if (stats === "success") {
        //            console.log(data);
        //        }
        //
        //    }.bind(this),
        //    error: function(xhr, status, err) {
        //
        //        //console.error('http://localhost:8080/api/view', status, err.toString());
        //    }.bind(this)
        //});
    },

    handle2Click() {
        console.log('验证');
//        var token = 'eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX25hbWUiOiJ3YW53ZWkiLCJ1c2VyX2FjY291bnQiOiIxMjMiLCJ1c2VyX3Bob25lIjoiMTg2NDI2MjE5MzUifQ.2FZflbIrsAok43DEbsrTTOhn6DP-pm_0glW8HI-5sWctq3VW2_s5DjtuH70l7G1ZXP0yNEHxTALPQnxw9q5YKg';
//        var decoded = JWT.verify(token, 'hahaha');
        var JsonFormatter = {
                stringify: function (cipherParams) {
                    // create json object with ciphertext
                    var jsonObj = {
                        ct: cipherParams.ciphertext.toString(CryptoJS.enc.Hex)
                    };
                    // optionally add iv and salt
                    if (cipherParams.iv) {
                        jsonObj.iv = cipherParams.iv.toString();
                    }
                    if (cipherParams.salt) {
                        jsonObj.s = cipherParams.salt.toString();
                    }

                    // stringify json object
                    return JSON.stringify(jsonObj);
                },
                parse: function (jsonStr) {
                    // parse json string
                    var jsonObj = JSON.parse(jsonStr);
                    // extract ciphertext from json object, and create cipher params object
                    var cipherParams = CryptoJS.lib.CipherParams.create({
                        ciphertext: CryptoJS.enc.Hex.parse(jsonObj.ct)
                    });
                    // optionally extract iv and salt
                    if (jsonObj.iv) {
                        cipherParams.iv = CryptoJS.enc.Hex.parse(jsonObj.iv)
                    }
                    if (jsonObj.s) {
                        cipherParams.salt = CryptoJS.enc.Hex.parse(jsonObj.s)
                    }
                    return cipherParams;
                }
            };
        var digestString = CryptoJS.MD5("00000000000", { asString: true });
        console.log(digestString.toString());
        var pwd =  CryptoJS.enc.Hex.parse(digestString.toString());//密码必须用Hex或其他方式处理为byte数组，如果直接使用字符串，CryptoJS会用加盐的方法重新生成密码，而且加的盐是随机数，这样在java端就没法解秘了。
        var iv = CryptoJS.enc.Hex.parse('11111111111111111111111111111111');//iv在java中必须为16byte长，所以js中也必须设置为相同的长度，否则加密后的结果在java中无法解密。
        var setting={iv:iv,
            //mode:CryptoJS.mode.CBC, //默认值，可以不设置
            //padding:CryptoJS.pad.Pkcs7,//同上
            format: JsonFormatter
            };
        var dataVar ={
        		name: 'wvty',
        		phone: '13344444444'
        } 
        var ciphertext = CryptoJS.AES.encrypt(JSON.stringify(dataVar), pwd,setting);
        ciphertext = JSON.parse(ciphertext.toString());
        console.log(ciphertext.ct); 
        var params = ciphertext.ct;//Base64.encode(ciphertext.toString());
         console.log(params); 
//        console.log(decoded.foo); // bar
        Reqwest({
            url: '/root/view',
            headers: {
                jwt_token: '00000000000'//'eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX25hbWUiOiJ3YW53ZWkiLCJ1c2VyX2FjY291bnQiOiIxMjMiLCJ1c2VyX3Bob25lIjoiMTg2NDI2MjE5MzUifQ.2FZflbIrsAok43DEbsrTTOhn6DP-pm_0glW8HI-5sWctq3VW2_s5DjtuH70l7G1ZXP0yNEHxTALPQnxw9q5YKg'
            },
            method: 'GET',
            type: 'json',
            contentType: 'application/json',
            data: {pushi_params : params},
            error: function (error) {
                //alert(error);
            }.bind(this),
            success: function (resp) {
                //var data = resp.content;
                //console.log(resp.key);


            }.bind(this)
        });
    },

    getInitialState() {
        const temp = new User();
        temp.userName = 'wvty';
        return {
            infos:temp,
        }

    },

    render() {

        return(<div>
            <h1>Login</h1>
            <form action="" method="post">
                <input type="text" name="username" 
                       onChange={e=>{const tes = this.state.infos; tes.userName = e.target.value; this.setState({infos: tes});}} placeholder={this.state.infos.userName}/>
                <input type="password" name="password" 
                       onChange={e=>{this.state.infos.uPassword = e.target.value; this.setState({infos: this.state.infos});}}
                       placeholder="密码"/>
                <Button type="dashed" onClick={this.handleClick}>登录</Button>
                <Button type="dashed" onClick={this.handle2Click}>验证</Button>

            </form>
             <div>
                <p>或使用以下账号直接登录:</p>
                <p>
                    <a className="facebook" href=""></a>
                    <a className="weixin" href=""></a>
                </p>
            </div>
            </div>


    );
    }
});

ReactDOM.render(<App/>, document.getElementById('content'));