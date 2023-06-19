package com.spring.jpa.chap04_relation.repository;

import com.spring.jpa.chap04_relation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees")
    // 테이블명이 아닌 변수명으로 설정해줘야 인식하게 된다
    List<Department> findAllIncludeEmployees();



}
