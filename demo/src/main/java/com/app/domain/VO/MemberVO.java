package com.app.domain.VO;


import com.app.domain.DTO.MemberJoinRequestDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class MemberVO implements Serializable {
    private String id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;


    //정적메서드 팩토리

    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO ) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
    }
}
