package com.example.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // MockMvc : 실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서
    // 애플리케이션 서버에 배포하지 않고도 스프링 MVC 동작을 재현할 수 있는 클래스를 의미합니다.

    @Test
    void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
                // perform() : 요청을 전송하는 역할을 합니다. 결과로 ResultActions 객체를 받으며,
                // ResultActions 객체는 리턴 값을 검증하고 확인할 수 있는 andExcpect() 메소드를 제공해줍니다.

                .andDo(print())
                // andDo(print()) : 요청/응답 전체 메세지를 확인할 수 있습니다.

                .andExpect(status().isOk())
                // andExpect() : 응답을 검증하는 역할을 합니다.
                // isOk() : 200

                .andExpect(content().string("hello-world"));
                // content() : 응답에 대한 정보를 검증해줍니다.
    }

}