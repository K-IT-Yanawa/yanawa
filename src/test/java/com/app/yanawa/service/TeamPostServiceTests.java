package com.app.yanawa.service;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.service.team.TeamPostService;
import com.app.yanawa.service.team.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TeamPostServiceTests {
    @Autowired
    private TeamPostService teamPostService;

    //    팀 생성하기
    @Test
    public void testInsert() {
        TeamPostDTO teamPostDTO = new TeamPostDTO();
        teamPostDTO.setTeamId(5L);
        teamPostDTO.setEndDate("2024-09-09");
        teamPostDTO.setInformation("추가정보test");

        log.info(teamPostDTO.toString());
        teamPostService.write(teamPostDTO.toVO());
    }
}
