package com.app.yanawa.repository.freewrite;

import com.app.yanawa.domain.freewrite.*;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FreewriteDAO {
    private final FreewriteMapper freewriteMapper;
    private final SqlSession sqlSession;

    public void save(FreewriteVO freewriteVO) {
        freewriteMapper.insert(freewriteVO);
    }

    public void insertAttachment(Attachment attachment) {
        sqlSession.insert("com.app.yanawa.mapper.freewrite.FreewriteMapper.insertAttachment", attachment);
    }

    // 전체 게시글 조회 메서드 - order 제거하고 Search 객체로 수정
    public List<FreewriteDTO> findAll(Pagination pagination, Search search) {
        return freewriteMapper.selectAll(pagination, search);
    }


    // 전체 게시물 수 조회
    public int getTotal() {
        return freewriteMapper.selectTotal();
    }

    // 특정 ID로 게시글 조회
    public FreewriteDTO findById(Long id) {
        return freewriteMapper.selectById(id);
    }

    // 조회수 증가
    public void increaseReadCount(Long id) {
        freewriteMapper.increaseReadCount(id);
    }

    // 게시글 수정
    public void updatePost(FreewriteVO freewriteVO) {
        freewriteMapper.updatePost(freewriteVO);  // TBL_POST 수정
    }

    public void updateFreewrite(FreewriteVO freewriteVO) {
        freewriteMapper.updateFreewrite(freewriteVO);  // TBL_FREEWRITE 수정
    }

    // 게시글 삭제
    public void delete(Long id) {
        freewriteMapper.deleteById(id);
    }

    // 검색어가 포함된 전체 게시물 수 조회
    public int getTotalWithSearch(Search search) {
        return freewriteMapper.selectTotalWithSearch(search);
    }
}
