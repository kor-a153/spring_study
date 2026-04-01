package com.app.mybatis.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
