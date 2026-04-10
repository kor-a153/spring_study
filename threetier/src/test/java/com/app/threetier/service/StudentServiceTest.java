package com.app.threetier.service;

import com.app.threetier.domain.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void registerStudentTest(){
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("장보고");
        studentVO.setEng(30);
        studentVO.setKor(88);
        studentVO.setMath(20);
        studentService.registerStudent(studentVO);
        log.info("수정후 student: {}", studentService.getStudent(studentVO.getId()));


    }

    @Test
    public void deleteStudnetTest() {
        studentService.deleteStudent(21L);
    }

}
