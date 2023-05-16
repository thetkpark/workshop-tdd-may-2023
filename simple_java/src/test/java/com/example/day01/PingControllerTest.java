package com.example.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void pingSuccess() {
        ResponseEntity<PingResponse> response = this.restTemplate.getForEntity("/ping", PingResponse.class);

        // Assert response code == 200
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(200, response.getStatusCode().value());
        // Assert message = "pong"
        assertEquals("pong", response.getBody().getMessage());
    }
}
