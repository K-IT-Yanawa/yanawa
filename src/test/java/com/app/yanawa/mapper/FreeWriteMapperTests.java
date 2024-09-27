package com.app.yanawa.mapper;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.post.PostVO;
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
    private PostVO postVO;



    @Test
    public void testInsert() {
        // 1. FreewriteDTO 객체를 생성하여 필요한 필드를 설정
        FreewriteDTO freewriteDTO = new FreewriteDTO();
        freewriteDTO.setPostTitle("테스트 글 제목1");  // POST_TITLE 설정
        freewriteDTO.setPostContent("테스트 글 내용1");  // POST_CONTENT 설정
        freewriteDTO.setMemberId(1L);  // 적절한 MEMBER_ID 설정
        freewriteDTO.setPostType(1);  // FREEWRITE는 postType이 1이어야 함

        freewriteService.write(freewriteDTO);


    }




}
