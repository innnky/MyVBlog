package xyz.innky.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.innky.web.bean.Role;
import xyz.innky.web.bean.User;
import xyz.innky.web.mapper.UserMapper;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null){
            return new User();
        }
        user.setRoles(userMapper.getRolesByUid(user.getId()));
        return user;
    }


    public List<User> getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    public int deleteUserById(Integer uid) {

        int i = userMapper.deleteUserById(uid);
        int res =userMapper.deleteUserRoleById(uid);
        return i;

    }

    public List<Role> getAllRoles() {
        return userMapper.getAllRoles();
    }

    public int updateUserEnabled(Boolean enabled, Long uid) {
        return userMapper.updateUserEnabled(enabled, uid);
    }
}
