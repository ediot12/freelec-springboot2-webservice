package com.test.book.springboot.domain.posts;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        String title = "테스트 게시글";
        String content = "테스트 본문";

        // insert update 쿼리를 수행함
        // id가 있으면 update 없으면 insert
        postsRepository.save( Posts.builder()
                                .title(title)
                                .content(content)
                                .author("jojoldu@gmail.com")
                                .build()
                            );

        // posts에 있는 모든 데이터를 조회함
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat( posts.getTitle()).isEqualTo(title);
        assertThat( posts.getContent()).isEqualTo(content);
        System.out.println("ㅎㅇㅎㅇㅎㅇㅎㅇ");

    }


    @Test
    public void BaseTimeEntity_등록(){

        LocalDateTime now = LocalDateTime.of( 2019, 6,4,0,0,0);

        postsRepository.save( Posts.builder()
                                .title("title")
                                .content("content")
                                .author("author")
                                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedTime() +", modifiedDate="+ posts.getModifiedTime() );

        assertThat( posts.getCreatedTime()).isAfter(now);
        assertThat( posts.getModifiedTime()).isAfter(now);



    }


}
