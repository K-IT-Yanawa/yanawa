package com.app.yanawa.repository.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Attachment;
import com.app.yanawa.domain.freewrite.Pagination;
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

    public List<FreewriteDTO> findAll(Pagination pagination, String order) {
        return freewriteMapper.selectAll(pagination, order);
    }
    public int getTotal(){return freewriteMapper.selectTotal();}
}
