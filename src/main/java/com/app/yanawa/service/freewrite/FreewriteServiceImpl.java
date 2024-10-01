package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.*;
import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import com.app.yanawa.repository.freewrite.FreewriteDAO;
import com.app.yanawa.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class FreewriteServiceImpl implements FreewriteService {
    private final FreewriteDAO freewriteDAO;
    private final PostDAO postDAO;
    private final FreewriteMapper freewriteMapper;
    private final FreewriteVO freewriteVO;

    @Override
    public void write(FreewriteDTO freewriteDTO) {
        PostVO postVO = freewriteDTO.toPostVO();

        postDAO.save(postVO);
        freewriteDTO.setId(postVO.getId());
        freewriteDAO.save(freewriteDTO.toVO());

    }

    @Override
    public void saveAttachment(Attachment attachment) {
        freewriteDAO.insertAttachment(attachment);
    }

    @Override
    public List<FreewriteDTO> getList(FreewritePagination freewritePagination, FreewriteSearch freewriteSearch) {
        return freewriteDAO.findAll(freewritePagination, freewriteSearch);
    }


    @Override
    public int getTotal(){return freewriteDAO.getTotal();}
    @Override
    public FreewriteDTO getDetail(Long id) {
        return freewriteDAO.findById(id);
    }

    @Override
    public void increaseReadCount(Long id) {
        freewriteDAO.increaseReadCount(id);
    }


    @Override
    public void updatePost(FreewriteDTO freewriteDTO) {
        FreewriteVO freewriteVO = freewriteDTO.toVO();
        freewriteDAO.updatePost(freewriteVO);  // TBL_POST 수정
    }

    @Override
    public void updateFreewrite(FreewriteDTO freewriteDTO) {
        FreewriteVO freewriteVO = freewriteDTO.toVO();
        freewriteDAO.updateFreewrite(freewriteVO);  // TBL_FREEWRITE 수정
    }

    @Override
    public void delete(Long id) {
        freewriteDAO.delete(id);
    }
    @Override
    public int getTotalWithSearch(FreewriteSearch freewriteSearch){
        return freewriteDAO.getTotalWithSearch(freewriteSearch);
    }


}
