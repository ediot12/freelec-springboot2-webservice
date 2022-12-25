package com.test.book.springboot.web;

import com.test.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(method=RequestMethod.GET, value="/hello")
    public String hello(){

        return "hello";
    }


    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto (@RequestParam("name") String name, @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);

    }

}
