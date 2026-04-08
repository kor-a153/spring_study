package com.app.controller.domain.vo.dto;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long PostReadCount;
    private String MemberEmail;
    private String MemberName;
}
