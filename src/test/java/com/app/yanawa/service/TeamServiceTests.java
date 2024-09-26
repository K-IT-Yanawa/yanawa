package com.app.yanawa.service;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.mapper.team.TeamMapper;
import com.app.yanawa.service.team.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TeamServiceTests {
    @Autowired
    private TeamService teamService;

    //    팀 생성하기
    @Test
    public void testInsert() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setMemberId(2L);
        teamDTO.setTeamName("팀Test2");
        teamDTO.setSportsKindRadioValue(2);
        teamDTO.setCity("경기도");
        teamDTO.setLocalCity("하남시");
        teamDTO.setDetailedArea("석촌동 250-2");
        teamDTO.setTeamActivityTime("오후2시~8시");
        teamDTO.setAgeRange("20대 초반");

        log.info("{}", "팀 생성 성공");
        teamService.join(teamDTO.toVO());
    }
}
