package com.app.yanawa.service;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamMemberDTO;
import com.app.yanawa.service.team.TeamMemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TeamMemberServiceTests {
    @Autowired
    private TeamMemberService teamMemberService;

    // 팀 신청(지원)
    @Test
    public void testInsert() {
        TeamMemberDTO teamMemberDTO = new TeamMemberDTO();
        teamMemberDTO.setMemberId(6L);
        teamMemberDTO.setTeamId(7L);
        teamMemberDTO.setPathToContact(3);
        teamMemberDTO.setIntroduce("저는 축구를 잘합니다!");

        log.info(teamMemberDTO.toString());
        teamMemberService.join(teamMemberDTO.toVO());
    }
}
