package com.greydawn.hotelms.controller;

import com.greydawn.hotelms.service.AccountService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    AccountService accountService;

//    @RequestMapping("/account/list")
//    public String gotoIndex(){
//        accountService.findAll();
//        return "account/account_list";
//    }

}
