package com.app.ncs.controller;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;
//--------- 회원가입
    @GetMapping("join")
    public void goToJoin(MemberVO memberVO) {;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

//    ------------------- 로그인
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> found = memberMapper.selectMemberEmailAndMemberPassword(memberVO);

// 멤버 정보가 없다면.
        if (found.isEmpty()) {
            redirectAttributes.addFlashAttribute("isLogin", false);
            return new RedirectView("/members/login");
        }

        session.setAttribute("member", found.get());
        return new RedirectView("/members/my-page");
    }

//    ------------마이페이지
    @GetMapping("my-page")
    public void goToMyPage() {;}

//    -------------- 수정
    @GetMapping("update")
    public void goToUpdate(Model model) {
        model.addAttribute("member", session.getAttribute("member"));
    }

    @PostMapping("update")
    public RedirectView update(MemberVO memberVO) {
        memberMapper.update(memberVO);
        Optional<MemberVO> found = memberMapper.selectMemberEmailAndMemberPassword(memberVO);
        if(found.isPresent()){
            session.setAttribute("member" , found);
        }
        return new RedirectView("/members/my-page");
    }
// --------- 로그아웃
   public RedirectView logout() {
        session.

                return new RedirectView("/member/login");
   }


//------------삭제
    @DeleteMapping("withdraw")
    public RedirectView withdraw() {
        MemberVO member = (MemberVO) session.getAttribute("member");
        memberMapper.delete(member.getId());
        return new RedirectView("/members/join");
    }
}