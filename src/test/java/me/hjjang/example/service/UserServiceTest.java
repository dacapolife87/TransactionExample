package me.hjjang.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Rollback(value = false)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void transactionTestForPropagationRequired() throws Exception {

        assertThatThrownBy(() -> {
            userService.userSave("hJJang6", 34);
        }).isInstanceOf(UnexpectedRollbackException.class);
    }

    @Test
    void transactionTestForPropagationNewCase() throws Exception {
        Long saveUser = userService.userSavePropagationNew("hJJang6", 34);
        assertNotNull(saveUser);

    }
}
