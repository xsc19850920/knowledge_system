package com.knowledge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RouterController {

    @RequestMapping(value = "index")
    public String toHome() {
        return "index";
    }

    @RequestMapping(value = "public_left")
    public String toLeft() {
        return "public_left";
    }

    @RequestMapping(value = "public_header")
    public String toHeader() {
        return "public_header";
    }

    @RequestMapping(value = "wenzhang")
    public String toWenzhang() {
        return "wenzhang";
    }

    @RequestMapping(value = "listen")
    public String toListen() {
        return "listen";
    }

    @RequestMapping(value = "review")
    public String toReview() {
        return "review";
    }

    @RequestMapping(value = "learn")
    public String toLearn() {
        return "learn";
    }

    @RequestMapping(value = "read")
    public String toRead() {
        return "read";
    }

    @RequestMapping(value = "user")
    public String toUser() {
        return "user";
    }

    @RequestMapping(value = "userAdd")
    public String toUserAdd() {
        return "userAdd";
    }

    @RequestMapping(value = "reviewAdd")
    public String toReviewAdd() {
        return "reviewAdd";
    }

    @RequestMapping(value = "readAdd")
    public String toReadAdd() {
        return "readAdd";
    }

    @RequestMapping(value = "learnAdd")
    public String toLearnAdd() {
        return "learnAdd";
    }

    @RequestMapping(value = "listenAdd")
    public String toListenAdd() {
        return "listenAdd";
    }
}
