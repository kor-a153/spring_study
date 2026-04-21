package com.app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public void save (MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }
}
