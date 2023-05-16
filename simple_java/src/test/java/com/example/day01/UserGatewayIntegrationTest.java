package com.example.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.day01.data.UserResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserGatewayIntegrationTest {
    @Autowired
    private UserGateway userGateway;

    @Test
    public void successWithUserId() {
        // Act
        UserResponse result = this.userGateway.getById(1);
        assertEquals("Sincere@april.biz", result.getEmail());
        assertEquals("Leanne Graham", result.getName());
    }
}
