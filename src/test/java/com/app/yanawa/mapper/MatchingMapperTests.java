
package com.app.yanawa.mapper;

import com.app.yanawa.domain.matching.MatchingDTO;

import com.app.yanawa.service.matching.MatchingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MatchingMapperTests {
    @Autowired
    private MatchingService matchingService;

    @Test
    public void testinsertMatching() {
        MatchingDTO matchingDTO = new MatchingDTO();
        matchingDTO.setPostTitle("test");
        matchingDTO.setPostContent("test내용");
        matchingDTO.setPostType(2);;
        matchingDTO.setMemberName("tester");
        matchingDTO.setMemberEmail("test@test.com");
        matchingDTO.setMemberPhone("123456789");
        matchingDTO.setSportKindValue("축구");
        matchingDTO.setTeamId(1L);
        matchingDTO.setTeamName("test팀");
        matchingDTO.setDateRegister("2024-09-24");
        matchingDTO.setChoiceAmPm("오전");
        matchingDTO.setTimeRegister("2시~13시");
        matchingDTO.setTimeCordinate("가능");
        matchingDTO.setDateCordinate("가능");
        matchingDTO.setCity("서울");
        matchingDTO.setLocalCity("강남구");
        matchingDTO.setLocalCityDetail("역삼역");
        matchingDTO.setMatchingStatus("매칭중");

        matchingService.write(matchingDTO);

        log.info("{}","매칭글이 작성되었습니다.");
    }
}
