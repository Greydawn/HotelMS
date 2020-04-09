package com.greydawn.hotelms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.greydawn.hotelms.domain.Account;
import com.greydawn.hotelms.domain.User;
import com.greydawn.hotelms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class AccountController {

    @Autowired   //按类型注入
    private AccountService accountService;

    //登录表单提交
    @PostMapping(value = "/login")
    public String loginIn(HttpServletRequest request, HttpSession session){
        String userid=request.getParameter("userid");
        String userpwd=request.getParameter("userpwd");
        System.out.println("userid="+userid+",userpwd="+userpwd);
        User user=new User();
        user.setId(Integer.parseInt(userid));
        user.setPwd(userpwd);
        session.setAttribute("LoginUser",user);
        return "redirect:account/dashboard";
    }

    //跳转登录页面
    @GetMapping(value = "/login")
    public String toLogin(){
        return "account/login";
    }

    //首页跳转主板页面
    @RequestMapping(value = "account/dashboard")
    public String index(){
        return "account/dashboard";
    }

    //查询所有账户1
//    @RequestMapping("/account/findAll")
//    public String findAll(){
//        System.out.println("Controller表现层：查询所有账户...");
//        return "account/account_list";
//    }

    //查询所有账户2
//    @RequestMapping("/account/findAll")
//    public ModelAndView findAll(ModelAndView mav){
//        List<Account> list = accountService.findAll();
//        mav.addObject("accountList",list);
//        mav.setViewName("account/account_list");
//        return mav;
//    }

    //查询所有账户3
    @RequestMapping(value = "/account/findAll")
    public String findAll(Model model){
        List<Account> list = accountService.findAll();
        model.addAttribute("accountList",list);
        return "account/account_list";
    }

    //访问添加账户页面
    @RequestMapping(value = "/account/add")
    public String add() throws IOException {
       return "account/account_add";
    }

    //添加账户发送添加请求
    @RequestMapping(value = "/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("content-type","text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

    //根据id查询账户请求
    @ResponseBody
    @RequestMapping(value = "/account/find/{id}")
    public JSONObject findById(@PathVariable(name="id") Integer id){
        JSONObject jsonObject = new JSONObject();
        Account account = accountService.findById(id);
        String obj2json=JSON.toJSONString(account);
        System.out.println(obj2json);
        jsonObject=JSONObject.parseObject(obj2json);
        return jsonObject;
    }

    //测试多选批量删除请求
    @ResponseBody
    @RequestMapping(value = "account/delete")
    public JSONObject deleteAccount(Integer [] aids){
        JSONObject jsonObject= new JSONObject();
//        Map<String,Account> accountMap= new HashMap<>();
        System.out.println(Arrays.asList(aids));
//        String accountStr="";
//        for(Integer aid:aids) {
//            Account account = accountService.findById(aid);
//            accountStr=accountStr+","+JSON.toJSONString(account);
//            System.out.println(account);
//        }
        jsonObject=JSON.parseObject("");
        return jsonObject;
    }

    //测试文件上传请求
    @PostMapping("account/upload")
    public String uploadFile(Model model, HttpServletRequest request , MultipartFile uploadFile) throws IOException {
        String fileName=UUID.randomUUID().toString().replaceAll("-","")+".png";
        uploadFile.transferTo(new File("D:\\Download\\"+fileName));
        model.addAttribute("imgPath",fileName);
        return "account/account_upload";
    }

    //访问上传页面请求
    @GetMapping("account/toupload")
    public String toUpload(){
        return "account/account_upload";
    }


}

