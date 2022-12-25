package com.test.book.springboot;

import com.test.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // SpringRunner라는 스프링 실행자를 사용한다. ( Spring Boot와  JUnit 사이의 연결자이다. )
@WebMvcTest( controllers = HelloController.class ) // Web 테스트에 집중할 수 있는 어노테이션
public class HelloControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{


        String hello = "hello";

        mvc.perform( get( "/hello") ).andExpect(status().isOk()).andExpect(content().string(hello));

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }

}
