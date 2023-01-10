package com.test.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //method의 파라미터에서만 생성 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 이 파일을 annotaion으로 지정
}
