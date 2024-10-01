package com.app.yanawa.mapper;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.mapper.member.MemberMapper;
import com.app.yanawa.mapper.team.TeamMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
@Slf4j
public class TeamMapperTests {
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private MemberMapper memberMapper;

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

    @Test
    public void testInsertAll(){
        TeamDTO teamDTO = null;
        Random random = new Random();
        int randidx = 0;
        List<MemberVO> members = teamMapper.selectAllMember();

        for(int i = 0; i < 15; i++){
            randidx = random.nextInt(members.size());
            teamDTO = new TeamDTO();
            teamDTO.setTeamName("테스트 팀명" + i + 1);
            teamDTO.setSportsKindRadioValue(i + 1);
            teamDTO.setCity("테스트 활동지역" + i + 1);
            teamDTO.setLocalCity("테스트 상세지역" + i + 1);
            teamDTO.setDetailedArea("테스트 상세주소" + i + 1);
            teamDTO.setTeamActivityTime("테스트 활동시간" + i + 1);
            teamDTO.setAgeRange("테스트 나이대" + i + 1);
            teamDTO.setMemberId(members.get(randidx).getId());
            teamMapper.insert(teamDTO.toVO());
        }
    }
}
