package com.spring.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product") // 테이블 명
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 전략
    @Column(name = "prod_id") // 컬럼 명
    private long id;

    @Column(name = "prod_name", nullable = false)
    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp // 업데이트 되면 자동으로 updatedDate 변수가 들어감
    private LocalDateTime updatedDate;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }



}
