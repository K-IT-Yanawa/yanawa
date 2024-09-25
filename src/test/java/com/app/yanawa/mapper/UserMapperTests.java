package com.app.yanawa.mapper;
import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.mapper.member.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

//    회원가입
    @Test
    public void testInsert() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserName("test1");
        memberDTO.setUserEmail("test2@gmail.com");
        memberDTO.setUserNickName("test2");
        memberDTO.setUserPhone("010-2222-2222");
        memberDTO.setUserPassword("4321");
        memberDTO.setUserGender("남성");
        memberDTO.setUserPoint(100);
        memberDTO.setUserIntroduce("잘부탁드립니다");
        memberDTO.setUserSportKind("족구");
        memberDTO.setUserPositionKind("공격수");
        memberDTO.setUserSportHistory("2년");
        memberDTO.setUserBirth("2000-03-03");
        log.info("{}","회원 가입 성공!!");
        userMapper.insert(memberDTO.toVO());
    }
}
