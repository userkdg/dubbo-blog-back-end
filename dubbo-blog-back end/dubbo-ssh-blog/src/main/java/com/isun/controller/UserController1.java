package com.isun.controller;

import com.alibaba.fastjson.JSON;
import com.isun.entity.AcctUser;
import com.isun.service.IUserService;
import com.isun.service.impl.DemoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController1 {
    private static final Logger LOGGER = Logger.getLogger(UserController1.class);

    @Autowired
    private IUserService userService;

    private DemoServiceImpl demoService;

    public void setDemoService(DemoServiceImpl demoService){
        this.demoService = demoService;
    }

    @RequestMapping("/demo")
    public String getUserList(ModelMap modelMap, @PathVariable String userId){
        LOGGER.info("查询用户：" + userId);
        List<AcctUser> userList = demoService.getUserList();
        modelMap.addAttribute("userInfo", JSON.toJSON(userList));
        return "/user/showInfo";
    }

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable String userId){
        LOGGER.info("查询用户：" + userId);
        AcctUser userInfo = userService.load(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "/user/showInfo";
    }

    @RequestMapping("/showInfos")
    public @ResponseBody
    AcctUser showUserInfos(){
        LOGGER.info("查询用户全部用户");
        AcctUser userInfos = userService.get("1");

        return userInfos;
    }
}
