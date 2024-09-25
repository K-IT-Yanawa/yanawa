package com.app.yanawa.mapper;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import com.app.yanawa.service.freewrite.FreewriteService;
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
    private FreewriteService freewriteService;



    @Test

    public void testInsert() {
        // 1. FreewriteDTO 객체 생성 및 필드 설정
        FreewriteDTO freewriteDTO = new FreewriteDTO();
        freewriteDTO.setPostTitle("테스트 글 제목");
        freewriteDTO.setPostContent("테스트 글 내용");
        freewriteDTO.setFreewriteReadCount(0);
        freewriteDTO.setReplyCount(0);
        freewriteDTO.setId(1L);
        freewriteDTO.setMemberId(1L);  // 적절한 MEMBER_ID 설정
        freewriteDTO.setPostType(1);  // FREEWRITE는 postType이 1이어야 함

        // DTO -> VO 변환
        FreewriteVO freewriteVO = freewriteDTO.toVO();

        // 변환된 VO 객체의 값 출력
        log.info("FreewriteVO Post Title: {}", freewriteVO.getPostTitle());
        log.info("FreewriteVO Post Content: {}", freewriteVO.getPostContent());

        // VO 객체가 제대로 변환되었는지 확인 후 서비스 호출
        freewriteService.write(freewriteVO);
    }


}



