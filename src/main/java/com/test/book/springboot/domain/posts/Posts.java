package com.test.book.springboot.domain.posts;

import com.test.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             // Lombok 어노테이션 // @Setter 는 Entity 클래스에서 생성하지 않는다.
@NoArgsConstructor  // Lombok 어노테이션 --> 기본 생성자 자동 추가
@Entity             // JPA의 어노테이션
public class Posts extends BaseTimeEntity { // 실제 DB 테이블에 매칭될 클래스 --> Entity 클래스라고도함 ( 사실상 테이블명 )

    @Id // 테이블의 Primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY) // Primary key의 생성 규칙
    private Long id;

    @Column( length = 500, nullable = false )
    private String title;

    @Column( columnDefinition = "TEXT", nullable = false )
    private String content;

    private String author;


    @Builder
    public Posts( String title, String content, String author ){
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update( String title, String content ){
        this.title = title;
        this.content = content;
    }


}
