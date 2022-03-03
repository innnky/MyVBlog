package xyz.innky.web.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.web.utils.Util;
import xyz.innky.web.bean.User;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/currentUserName")
    public String currentUserName(){
        User currentUser = Util.getCurrentUser();

        return currentUser.getNickname();
    }

    @RequestMapping("/isAdmin")
    public Boolean isAdmin() {
        Collection<? extends GrantedAuthority> authorities = Util.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")) {
                return true;
            }
        }
        return false;
    }
    @RequestMapping("/currentUserEmail")
    public String currentUserEmail() {
        return Util.getCurrentUser().getEmail();
    }
}
