package xyz.innky.web;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.innky.web.mapper.UserMapper;


@SpringBootTest
class WebApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.loadUserByUsername("linghu"));
        System.out.println(userMapper.getRolesByUid(7L));
    }

}
