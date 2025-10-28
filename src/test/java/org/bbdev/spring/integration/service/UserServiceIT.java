package org.bbdev.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.bbdev.spring.database.pool.ConnectionPool;
import org.bbdev.spring.integration.annotation.IT;
import org.bbdev.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test(){
        System.out.println();
    }

    @Test
    void test2(){
        System.out.println();
    }


}
