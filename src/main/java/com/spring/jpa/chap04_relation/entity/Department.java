package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_dept")
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name", nullable = false)
    private String name;

}



