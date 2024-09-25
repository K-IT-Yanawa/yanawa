package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Attachment;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.repository.freewrite.FreewriteDAO;
import com.app.yanawa.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreewriteServiceImpl implements FreewriteService {
    private final FreewriteDAO freewriteDAO;
    private final FreewriteDTO freewriteDTO;
    private final PostDAO postDAO;

    @Override
    public void write(FreewriteVO freewriteVO) {
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
    public List<FreewriteDTO> getList(Pagination pagination, String order){
        return freewriteDAO.findAll(pagination, order);
    }

    @Override
    public int getTotal(){return freewriteDAO.getTotal();}
}
