package com.app.yanawa.mapper;
import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

//    회원가입
    @Test
    public void testInsert() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberName("test1");
        memberDTO.setMemberEmail("test2@gmail.com");
        memberDTO.setMemberNickName("test2");
        memberDTO.setMemberPhone("010-2222-2222");
        memberDTO.setMemberPassword("4321");
        memberDTO.setMemberGender("남성");
        memberDTO.setMemberPoint(100);
        memberDTO.setMemberIntroduce("잘부탁드립니다");
        memberDTO.setMemberSportKind("족구");
        memberDTO.setMemberPositionKind("공격수");
        memberDTO.setMemberSportHistory("2년");
        memberDTO.setMemberBirth("2000-03-03");
        log.info("{}","회원 가입 성공!!");
        memberMapper.insert(memberDTO.toVO());
    }
}
