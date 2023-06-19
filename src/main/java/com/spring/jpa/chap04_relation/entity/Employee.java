package com.spring.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_emp")
@Setter @Getter
@ToString(exclude = {"department"})
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

    // EAGER: 항상 무조건 조인을 수행
    // LAZY: 필요한 경우에만 조인을 수행 (실무)
    @ManyToOne(fetch = FetchType.LAZY) // fetch의 기본값 = EAGER
    @JoinColumn(name = "dept_id") // 조회 시 조인에 사용될 컬럼명을 지목(foreign key)
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
        department.getEmployees().add(this);
    }
}

