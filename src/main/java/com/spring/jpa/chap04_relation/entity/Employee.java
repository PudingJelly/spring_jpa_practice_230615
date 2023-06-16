package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_emp")
@Setter @Getter @ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "dept_id") // 조회 시 조인에 사용될 컬럼명을 지목(foreign key)
    private Department department;

}

