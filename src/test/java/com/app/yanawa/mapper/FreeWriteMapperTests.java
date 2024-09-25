package com.app.yanawa.mapper;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class FreeWriteMapperTests {
    @Autowired
    private FreewriteMapper freewriteMapper;



    @Test

    public void freewriteInsertTest() {
        FreewriteDTO freewriteDTO = new FreewriteDTO();

        // 시퀀스 값을 가져와 ID로 설정
        Long nextPostId = freewriteMapper.selectNextSeqVal();
        freewriteDTO.setId(nextPostId);

        freewriteDTO.setPostTitle("게시글 제목 테스트 6");
        freewriteDTO.setPostContent("테스트다 글 내용 6");
        freewriteDTO.setPostReadCount(0);
        freewriteDTO.setReplyCount(0);
        freewriteDTO.setUserId(1L);  // 유효한 USER_ID 설정

        log.info("삽입할 데이터: {}", freewriteDTO);
        freewriteMapper.insert(freewriteDTO.toVO());  // 데이터 삽입
        log.info("게시글 삽입 완료, ID = {}", freewriteDTO.getId());
    }


}
