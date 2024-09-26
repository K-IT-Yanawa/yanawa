package com.app.yanawa.service;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.service.member.MemberService;
import com.app.yanawa.service.team.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    //    팀 생성하기
    @Test
    public void testSelectMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(1L);

        Optional<MemberDTO> foundMember =
                memberService.getMember(memberDTO.getId());

        foundMember.map(MemberDTO::toString).ifPresent(log::info);
    }
}
