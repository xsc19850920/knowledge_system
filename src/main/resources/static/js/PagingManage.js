/**
 * 对页面进行分页
 * @param obj 页码标签对象
 * @param  pageCount number 总页面数
 * @param  pageSize number 分页大小
 * @param currentPage number 当前页
 */
function PagingManage(obj, pageCount, pageSize, currentPage,pages) {
    if (obj) {
        var dataCount = pageCount; //数据总数
        var pagesize = pageSize;//单页数量
        var currentpage = currentPage;//当前页面
        var pageNum = pages;//分页总数
        var showPageNum = 6;//显示多少个页码

        var pagehtml = "";
        var divId = "" + obj.attr('id');

        //只有一页内容
        if (pageNum <= 1) {
            pagehtml = "";
        }

        //大于一页内容
        if (pageNum > 1) {
            pagehtml = "<span>共 <b>"+dataCount+"</b> 条 每页 <b>"+pagesize+"</b>条"+currentpage+"/"+pageNum+" </span><div class='pageWrap'>";
            if (currentpage > 1) {
                pagehtml += '<a href="javascript:void(0);" class="pagePre" onclick="switchPage(\'' + divId + '\',' + (currentpage - 1) + ')"><i class="ico-pre">&nbsp;</i></a>';
            }

            var startPage = 1;
            //计算页码开始位置
            if (showPageNum > pageNum) {//如果要显示的页码大于总的页码数
                startPage = 1
            } else {//如果要显示的页码小于总的页码数
                if (currentpage - (showPageNum / 2) <= 0) {//如果当前页面
                    startPage = 1;
                } else if (currentpage + (showPageNum / 2) >= pageNum) {
                    startPage = pageNum - showPageNum;
                } else {
                    startPage = currentpage - (showPageNum / 2);
                }
            }

            startPage = parseInt(startPage);

            for (var i = startPage; i < (startPage + showPageNum); i++) {

                //如果要输出的页面大于总的页面数,则退出
                if (i > pageNum) {
                    break;
                }

                if (i == currentpage) {
                    pagehtml += '<a href="javascript:void(0);" class="pagenumb cur" onclick="switchPage(\'' + divId + '\',' + i + ')">' + i + '</a>';
                } else {
                    pagehtml += '<a href="javascript:void(0);" class="pagenumb" onclick="switchPage(\'' + divId + '\',' + i + ')">' + i + '</a>';
                }
            }


            if (currentpage < pageNum) {
                pagehtml += '<a href="javascript:void(0);" class="pagenext" onclick="switchPage(\'' + divId + '\',' + (currentpage + 1) + ')"><i class="ico-next">&nbsp;</i></a></div>';
            }
        }
        obj.html(pagehtml);
    }  }