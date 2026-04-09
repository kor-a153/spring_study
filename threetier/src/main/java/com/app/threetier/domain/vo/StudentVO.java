package com.app.threetier.domain.vo;

//CREATE OR REPLACE VIEW VIEW_STUDENT AS (
//        SELECT
//        ID, STUDENT_NAME, KOR ,ENG, MATH,
//        KOR + ENG + MATH AS TOTAL,
//        ROUND ((KOR + ENG + MATH) /3 ,2) AS AVERAGE
//        FROM TBL_STUDENT

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class StudentVO {
    Long id;
    String studentName;
    Long kor
}
