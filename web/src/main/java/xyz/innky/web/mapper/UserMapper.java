package xyz.innky.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.web.bean.Role;
import xyz.innky.web.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUid(Long id);
}
