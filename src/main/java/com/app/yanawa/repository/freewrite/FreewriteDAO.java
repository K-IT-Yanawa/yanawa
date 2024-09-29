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
    private final FreewriteVO freewriteVO;

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

    public FreewriteDTO findById(Long id) {
        return freewriteMapper.selectById(id);
    }


    public void increaseReadCount(Long id){freewriteMapper.increaseReadCount(id);}

    public void update(FreewriteDTO freewriteDTO) {
        freewriteMapper.update(freewriteDTO.getId(), freewriteDTO.getPostTitle(), freewriteDTO.getPostContent());
    }
    public void delete(Long id) {
        freewriteMapper.deleteById(id);
    }

}
