package com.app.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.Attribute;
import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/ex/*")
public class ExampleController {

    @GetMapping("ex01")
    public String ex01(String name, int age){
        log.info("ex01 응답 완료");
        log.info("name : {}, age : {} , realAge: {}" ,name,age,age-1);

//        get방식으로 데이터를 어떻게 보내야 하는가?
//        이름과 나이를 요청보내고,
//        이름과 나이, 만나이를 로그에 출력하기


        /*ex01.html */
//        ex01 -> templates/ex01.html
//        ex/ex/ex01 -> templates/ex/ex/ex01.html
//        응답되는 페이지의 파일 경로
        return "ex01";
    }
    @PostMapping("/user/info")
    public String info(String name, Integer age) {
        int Age = age - 1;

        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("만나이: " + Age);

        return "ex01";
    }

//    @GetMapping("ex03")
//    public String ex03 (Model model) {
//        ArrayList<String> namess = new
//    }

//    ModelAttribute : 반드시 쿼리스트링 값을 전달해야 한다.
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name")String name){
        return "ex04";
    }

//    ex05
//    Model 어노테이션 활용
//    이름, 취미를 받고
//    화면에이름 :000
//    취미: 000 으로 출력하기
    @GetMapping("ex05")
    public String ex05(@ModelAttribute("name")String name,
                       @ModelAttribute("hobby") String hobby){
        return "ex05";
    }


}
