package xyz.innky.web.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.innky.web.bean.RespBean;
import xyz.innky.web.bean.Role;
import xyz.innky.web.bean.User;
import xyz.innky.web.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserManaController {

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return userService.getAllRoles();
    }

    @PutMapping("/user/enabled")
    public RespBean updateUserEnabled(Boolean enabled, Long uid){
        if (userService.updateUserEnabled(enabled, uid) == 1) {
            return new RespBean("success", "更新成功!");
        } else {
            return new RespBean("error", "更新失败!");
        }
    }

    @Autowired
    UserService userService;
    @GetMapping("/user")
    public List<User> getUserByNickname(@RequestParam("nickname") String nickname){
        return userService.getUserByNickname(nickname);
    }

    @DeleteMapping("/user/{uid}")
    public RespBean deleteUserById(@PathVariable("uid") Integer uid){
        if(userService.deleteUserById(uid)==1){
            return new RespBean("success", "删除成功！");
        }else {
            return new RespBean("error", "删除失败！");
        }
    }


}
