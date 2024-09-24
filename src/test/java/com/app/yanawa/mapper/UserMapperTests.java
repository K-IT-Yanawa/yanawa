package com.app.yanawa.mapper;
import com.app.yanawa.domain.user.UserDTO;
import com.app.yanawa.mapper.user.UserMapper;
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
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("test1");
        userDTO.setUserEmail("test2@gmail.com");
        userDTO.setUserNickName("test2");
        userDTO.setUserPhone("010-2222-2222");
        userDTO.setUserPassword("4321");
        userDTO.setUserGender("남성");
        userDTO.setUserPoint(100);
        userDTO.setUserIntroduce("잘부탁드립니다");
        userDTO.setUserSportKind("족구");
        userDTO.setUserPositionKind("공격수");
        userDTO.setUserSportHistory("2년");
        userDTO.setUserBirth("2000-03-03");
        log.info("{}","회원 가입 성공!!");
        userMapper.insert(userDTO.toVO());
    }
}
