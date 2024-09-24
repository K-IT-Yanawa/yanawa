package com.app.yanawa.mapper;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FreeWriteMapperTests {
    @Autowired
    private FreewriteMapper freewriteMapper;

    @Test
    public void freewriteInsertTest() {
        FreewriteDTO freewriteDTO = new FreewriteDTO();
        freewriteDTO.setPostTitle("게시글 제목 테스트");
    }
}
