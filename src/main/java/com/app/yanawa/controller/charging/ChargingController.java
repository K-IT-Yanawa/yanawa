package com.app.yanawa.controller.charging;

import com.app.yanawa.domain.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charginghomepage/*")
public class ChargingController {
    // 모든 요청 전 세션에 테스트용 사용자 정보 설정
    @ModelAttribute
    public void setTestMember(HttpSession session) {
        if (session.getAttribute("member") == null) {
            session.setAttribute("member", new MemberVO(
                    2L,
                    "",      // memberName
                    "",         // memberEmail
                    "",              // memberNickName
                    "",          // memberPhone
                    "",      // memberPassword
                    "",      // memberGender
                    "",
                    "",
                    "",
                    true,
                    "",      // memberBirth
                    "",      // createdDate
                    ""       // updatedDate
            ));
        }
    }

    @RequestMapping("charginghome")
    public String chargingHome(Model model) {
        model.addAttribute("memberId", 2L);
        return "/charginghomepage/charginghome";
    }
}
