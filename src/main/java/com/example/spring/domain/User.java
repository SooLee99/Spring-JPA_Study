package com.example.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

/* 기본적으로 사용하는 Lombok에 대한 설명. */

/*  각 필드에 접근하려면 객체지향의 기본적인 캡슐화 원칙을 지키기 위해서
    => @Getter / @Setter 을 만들어줘야함. */
// @Getter
// @Setter

/* toString() : UserTest.java 테스트코드에 설명 작성. */
// @ToString

/* JAP 사용 시, Entity 객체를 생성해야 하는 경우가 많이 생김.*/
@NoArgsConstructor // : 인자 없는 기본 생성자 [User user = new User();] 를 선언해주는 역활.
@AllArgsConstructor // : 인자 있는 기본 생성자 [User user1 = new User("martin", "martin@fastcampus", "", "");] 를 선언해주는 역활.
@RequiredArgsConstructor // : final 이나 @NonNull 인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.

// @EqualsAndHashCode : (자주 사용 X)
// => equals, hashCode를 자동으로 생성해주는 어노테이션.
//    equals :  두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자
//    hashCode : 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자
//    자바 bean에서 동등성 비교를 위해 equals와 hashcode 메소드를 오버라이딩해서 사용하는데,
//    @EqualsAndHashCode 어노테이션을 사용하면 자동으로 이 메소드를 생성할 수 있다.

@Builder

@Data
// @Data : @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한번에 설정해주는 어노테이션이다.

@Entity
// @Entity : DB 테이블에 대응하는 하나의 클래스.
public class User {
    /* 필드: 이름, 이메일 */
    @Id             // @Id 애노테이션 : JPA 엔티티 "기본키(PK)"(객체의 식별자)로 사용할 필드에 적용
    @GeneratedValue // @GeneratedValue : 기본 키를 자동 생성해주는 어노테이션.
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    /* 필드: 생성 시간, 수정 시간 */
    // => 일반적으로 jpa 도메인 객체에는 포함이 되어 있어야 한다. => DB 데이터 이력을 관리하기 위함.
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
