package xyz.innky.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegController {

    @RequestMapping("/login_page")
    public String loginPage(){
        return "请登录";
    }
}
