package com.app.yanawa.mapper;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.mapper.team.TeamMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class TeamMapperTests {
    @Autowired
    private TeamMapper teamMapper;

    //    팀 생성하기
    @Test
    public void testInsert() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setMemberId(1L);
        teamDTO.setTeamName("팀Test");
        teamDTO.setSportsKindRadioValue(3);
        teamDTO.setCity("서울특별시");
        teamDTO.setLocalCity("송파구");
        teamDTO.setDetailedArea("석촌동 250-1");
        teamDTO.setTeamActivityTime("오후2시~7시");
        teamDTO.setAgeRange("20대");

        log.info("{}", "팀 생성 성공");
        teamMapper.insert(teamDTO.toVO());
    }
}
