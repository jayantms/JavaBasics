package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @Disabled
    @Test
    public void testFindByUserName() {
        //assertEquals(2,1+1);

        User luser = userRepo.findByUserName("Ram");
        System.out.println(luser.getUserName());

        assertNotNull(luser);
    }

    @ParameterizedTest
//    @ValueSource
//    @EnumSource
    @CsvSource ({
        "1,1,2",
        "2,2,4",
        "3,3,6"
    })
    public void testAdd(int a, int b, int result) {
        assertEquals(result, a+b);
    }
}

