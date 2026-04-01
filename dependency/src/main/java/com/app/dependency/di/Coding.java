package com.app.dependency.di;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor //초기화 생성자   기본생성자는 Data하면 자동으로 생성
//@Data: getter,setter , toString , equals, hashCode
//@NoArgsConstructor : 기본생성자
//@AllArgsConstructor : 초기화생성자
//@Getter : getter
//@Setter : setter
//@ToString : tostring
//@EqualsAndHashCode : equals , hashcode

public class Coding {


//     필드 주입을 하면 안되는 이유 == 값이 바뀔수있으니까.
//    1.불변 상태를 만들 수 없다.
//    final로 해결 X
//    2. 순환 참조 발생 여부를 알 수 없다.
//    서버 -> 코딩 -> 컴퓨터 -> 코딩 -> 컴퓨터

//    사용하면 안됨. 시점상 final을 사용 할 수 없음
//    @Autowired
//    final private Computer computer;

//    setter 주입 . 안됨
//    private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//    생성자 주입으로 불변성 유지. == private 없으면 생성자 주입못받음.
    final private Computer computer;

    private String type ;
    private String content;

}
