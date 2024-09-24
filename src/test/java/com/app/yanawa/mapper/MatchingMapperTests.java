package com.app.yanawa.mapper;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MatchingMapperTests {
    @Autowired
    private MatchingMapper matchingMapper;

    @Test
    public void testinsertMatching() {
        MatchingDTO matchingDTO = new MatchingDTO();
        matchingDTO.setType(2);
        matchingDTO.
    }
}
