package com.app.yanawa.mapper.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.freewrite.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FreewriteMapper {
    // 게시글 삽입
    void insert(FreewriteVO freewriteVO);

    // 전체 게시글 조회 (검색 포함)
    List<FreewriteDTO> selectAll(@Param("pagination") Pagination pagination, @Param("search") Search search);


    // 검색어가 포함된 총 게시물 수 조회
    int selectTotalWithSearch(@Param("search") Search search);

    // 전체 게시물 수 조회
    int selectTotal();

    // 게시글 ID로 게시글 조회
    FreewriteDTO selectById(@Param("id") Long id);

    // 조회수 증가
    void increaseReadCount(Long id);

    // 글 수정
    void updatePost(FreewriteVO freewriteVO);  // TBL_POST 수정 메서드
    void updateFreewrite(FreewriteVO freewriteVO);  // TBL_FREEWRITE 수정 메서드

    // 게시글 삭제
    void deleteById(@Param("id") Long id);

    // 통합 검색 메서드
    List<FreewriteDTO> searchPosts(@Param("search") Search search);
}
