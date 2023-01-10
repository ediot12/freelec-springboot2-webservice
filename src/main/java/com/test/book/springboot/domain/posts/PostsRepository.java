package com.test.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> { // DB에 접근하게 해 줄 JpaRepository 생성

    // 사실상 Dao라고 보면될듯 < 클래스 , pk 타입 >
    // 클래스와 Repository는 함께 위치해야한다.

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

}
