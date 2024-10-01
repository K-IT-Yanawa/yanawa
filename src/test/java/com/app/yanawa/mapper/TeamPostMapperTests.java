package com.app.yanawa.mapper;

import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.member.MemberMapper;
import com.app.yanawa.mapper.team.TeamMapper;
import com.app.yanawa.mapper.team.TeamPostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
public class TeamPostMapperTests {
    @Autowired
    private TeamPostMapper teamPostMapper;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testSelectAll(){
        TeamPostPagination teamPostPagination = new TeamPostPagination();
        teamPostPagination.setPage(2);
        teamPostPagination.setTotal(teamPostMapper.selectTotal());
        teamPostPagination.progress();
        String order = new String();
        List<TeamPostDTO> posts = teamPostMapper.selectAll(teamPostPagination);
        log.info("{}", posts.size());
        posts.stream().map(TeamPostDTO::toString).forEach(log::info);
    }

    @Test
    public void testInsertAll(){
        TeamPostDTO teamPostDTO = null;
        Random random = new Random();
        int randidx = 0;
        List<TeamVO> teams = teamMapper.selectAll();

        for(int i = 0; i < 15; i++){
            randidx = random.nextInt(teams.size());
            teamPostDTO = new TeamPostDTO();
            teamPostDTO.setEndDate("2024-10-10");
            teamPostDTO.setInformation("테스트 추가사항" + i + 1);
            teamPostDTO.setTeamId(teams.get(randidx).getId());
            teamPostDTO.setPostReadCount(i * randidx);
            log.info(teamPostDTO.toString());
            teamPostMapper.insert(teamPostDTO.toVO());
        }
    }

    @Test
    public void testSelectAllTeamPost(){
        TeamPostPagination teamPostPagination = new TeamPostPagination();
        teamPostPagination.setPage(1);
        teamPostPagination.setTotal(teamPostMapper.selectTotal());
        teamPostPagination.progress();
        List<TeamPostDTO> teamPosts = teamPostMapper.selectAll(teamPostPagination);
        log.info("{}", teamPosts.size());
        teamPosts.stream().map(TeamPostDTO::toString).forEach(log::info);
    }
}

















