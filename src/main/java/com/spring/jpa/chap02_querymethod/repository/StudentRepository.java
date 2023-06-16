package com.spring.jpa.chap02_querymethod.repository;

import com.spring.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name); // 변수명은 entity 클래스의 필드명으로 작성해야 함
    List<Student> findByCityAndMajor(String city, String major);

    List<Student> findByMajorContaining(String major);

    // 네이티브 쿼리 사용
    @Query(value = "SELECT * FROM tbl_student WHERE stu_name = :nm", nativeQuery = true)
    Student findNameWithSQL(@Param("nm") String name);
    // 쿼리문의 조건이 변수명과 같으면 알아서 입력,
    // 다르다면 @Param("")을 사용하여 인식 시켜준다
    // 생쿼리문 이라는것을 지목해야 내가 작성한 쿼리문으로 실행이 된다

    // JPQL
    // SELECT 별칭 FROM 엔터티클래스명 AS 별칭
    // WHERE 별칭.필드명 = ?

    // native-sql : SELECT * FROM tbl_student
    //              WHERE stu_name = ?

    // jpql : SELECT st FROM Student AS st
    //        WHERE st.name = ?
    // 테이블의 구조를 몰라도 조회하고자 하는 객체의 구성만 알면 충분히 사용 가능

    // 도시 이름으로 학생 조회
    @Query("SELECT s FROM Student s WHERE s.city = ?1")
    List<Student> getByCityWithJPQL(String city);

    @Query("SELECT st FROM Student st WHERE st.name LIKE %:nm%")
    List<Student> searchByNamesWithJPQL(@Param("nm") String name);

    // JPQL로 수정 삭제 쿼리 쓰기
    @Modifying // 조회가 아닌 경우에는 무조건 붙여야 함
    @Query("DELETE FROM Student s WHERE s.name = ?1")
    void deleteByNameWithJPQL(String name);

}



















