package com.spring.jpa.chap05_practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(exclude = {"hashTags"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private long id;

    @Column(nullable = false)
    private String writer; // 작성자

    @Column(nullable = false)
    private String title; // 제목

    private String content; // 내용

    @CreationTimestamp
    @Column(updatable = false) // 한번 인서트 이후엔 다시는 변하지 않는다
    private LocalDateTime createDate; // 작성시간

    @UpdateTimestamp
    private LocalDateTime updateDate; // 수정시간

    // 양방향 연관관계를 위한 초기화 설정
    @OneToMany(mappedBy = "post") // 선언된 변수명으로 작성
    private List<HashTag> hashTags = new ArrayList<>();

}
