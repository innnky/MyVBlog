package xyz.innky.web.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import xyz.innky.web.bean.User;

public class Util {
    public static User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
