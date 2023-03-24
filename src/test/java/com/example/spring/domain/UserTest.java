package com.example.spring.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());

        User user1 = new User(null, "martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("martin", "martin@fastcampus.com");
        User user3 = User.builder()
                        .name("martin")
                        .email("martin@fastcampus.com")
                        .build();

        System.out.println(">>> " + user);
        // => (문제) 위의 테스트 결과 값을 보면
        //          해당 객체의 내용이 아닌, 클래스의 해시코드를 확인할 수 있다.

        // => (결론) 이름과 이메일이 객체에 재대로 들어갔는지 확인할 수가 없다.

        // => (원인) 모든 자바 클래스는 Object 클래스의 하위 객체이다.
        //          Object 클래스에서 toString() 메소드를 살펴보면,
        //          getClass().getName() + "@" + Integer.toHexString(hashCode());
        //          암묵적으로 toString()이 실행되기 때문에 이와 같은 결과가 나옴.



    }
}