package com.app.yanawa.mapper;
import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    //    회원가입
    @Test
    public void testInsert() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberName("테스트");
        memberDTO.setMemberEmail("test1@gmail.com");
        memberDTO.setMemberNickName("테스트1");
        memberDTO.setMemberPhone("01011111111");
        memberDTO.setMemberPassword("1111");
        memberDTO.setMemberGender("남성");
        memberDTO.setMemberPoint(100);
        memberDTO.setMemberIntroduce("잘부탁드립니다");
        memberDTO.setMemberSportKind("축구");
        memberDTO.setMemberPositionKind("공격수");
        memberDTO.setMemberSportHistory("1년");
        memberDTO.setMemberBirth("2000-03-03");
        log.info("{}", "회원 가입 성공!!");
        memberMapper.insert(memberDTO.toVO());
    }

    //    로그인
    @Test
    public void testSelectByMemberEmailAndMemberPassword() {
        String email = "test5@gmail.com";
        String password = "7677";

        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmailAndMemberPassword(email, password);

        // Optional에서 MemberVO를 추출하여 정보 출력
        if (foundMember.isPresent()) {
            MemberVO memberVO = foundMember.get();
            log.info("로그인성공 ! : {}", memberVO.toString()); // MemberVO의 toString() 호출
        } else {
            log.info("로그인실패 ! (회원정보가 없습니다)");
        }
    }
}
