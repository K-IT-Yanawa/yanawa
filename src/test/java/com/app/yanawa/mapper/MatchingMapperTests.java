package com.app.yanawa.mapper;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.post.PostDTO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MatchingMapperTests {
    @Autowired
    private MatchingMapper matchingMapper;

    @Test
    public void testinsertMatching() {
        MatchingDTO matchingDTO = new MatchingDTO();
        matchingDTO.setPostTitle("test");
        matchingDTO.setPostContent("test내용");
        matchingDTO.setType(2);
        matchingDTO.setUserName("tester");
        matchingDTO.setUserEmail("test@test.com");
        matchingDTO.setUserPhone("123456789");
        matchingDTO.setSportKindValue(1);
        matchingDTO.setTeamId(1L);
        matchingDTO.setTeamName("test팀");
        matchingDTO.setDateRegister("2024-09-24");
        matchingDTO.setTimeRegister("2시");
        matchingDTO.setTimeCordinate(1);
        matchingDTO.setDateCordinate(1);
        matchingDTO.setCity("서울");
        matchingDTO.setLocalCity("강남구");
        matchingDTO.setLocalCityDetail("역삼역");
        matchingDTO.setMatchStatus("매칭중");

        // PostDTO 생성
        PostDTO postDTO = new PostDTO();
        postDTO.setPostTitle(matchingDTO.getPostTitle());
        postDTO.setPostContent(matchingDTO.getPostContent());
        postDTO.setType(matchingDTO.getType());

        log.info("{}","매칭글이 작성되었습니다.");
        matchingMapper.insertPostAndMatching(postDTO, matchingDTO);
    }
}
