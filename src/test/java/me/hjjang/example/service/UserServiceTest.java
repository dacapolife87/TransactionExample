package me.hjjang.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@Rollback(value = false)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void transactinoTest() throws Exception {
        userService.userSave("hJJang6", 34);
    }
}