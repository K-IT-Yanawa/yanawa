package com.app.yanawa.mapper.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FreewriteMapper {
    // 게시글 삽입
    void insert(FreewriteVO freewriteVO);

    // 전체 게시글 조회
    List<FreewriteDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);

    // 총 게시글 수 조회
    int selectTotal();

    // 게시글 ID로 게시글 조회
    FreewriteDTO selectById(@Param("id") Long id);

    // 시퀀스 값을 가져오는 메서드
    Long selectNextSeqVal();
}
