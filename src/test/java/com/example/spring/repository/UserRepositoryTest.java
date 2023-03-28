package com.example.spring.repository;

import com.example.spring.domain.User;
import jakarta.transaction.Transactional;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud(){
        // 리스트를 이용해 5개의 테스트 객체 리턴
        User user = userRepository.getOne(1L);
        System.out.println(user);

        /*User user1 = new User("jack", "jack@fastcampus.com");
        User user2 = new User("steve", "steve@fastcampus.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);*/

        /* List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        // users.forEach(System.out::println); */
        /* List<User> users1 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
        // users1.forEach(System.out::println);
        // userRepository.save(new User());
        // userRepository.findAll().forEach(System.out::println);*/
    }

}