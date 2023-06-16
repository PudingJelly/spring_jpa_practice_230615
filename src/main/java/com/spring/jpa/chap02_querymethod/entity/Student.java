package com.spring.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Setter // 실무적 측면에서 setter는 신중하게 만들 것. 고유해야 하는 값이 변경 될 수도 있기 때문
@Getter
@ToString
@EqualsAndHashCode(of = "id") // id가 같으면 같은 객체로 인식 시키겠다!
//@EqualsAndHashCode(of = {"name", "id"}) 두개 이상 비교시엔 중괄호로 적용
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    // 변수명이 스네이크케이스와 카멜케이스가 같을 경우 굳이 컬럼 어노테이션을 붙일 필요 없음
    @Column(name = "stu_id")
    // 컬럼 어노테이션을 사용하기 위해 변수명을 일부러 다르게 설정함
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid", name = "uid")
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;
    private String major;
}
