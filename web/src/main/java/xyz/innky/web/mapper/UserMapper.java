package xyz.innky.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.innky.web.bean.Role;
import xyz.innky.web.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRolesByUid(Long id);

    List<User> getUserByNickname(String nickname);

    int deleteUserById(Integer uid);

    int deleteUserRoleById(Integer uid);

    List<Role> getAllRoles();

    int updateUserEnabled(@Param("enabled") Boolean enabled,@Param("uid") Long uid);

}
