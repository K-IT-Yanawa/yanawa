package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;
import com.app.yanawa.domain.freewrite.Attachment;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.repository.freewrite.FreewriteDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreewriteServiceImpl implements FreewriteService {
    private final FreewriteDAO freewriteDAO;

    @Override
    public Long write(FreewriteVO freewriteVO) {
        freewriteDAO.save(freewriteVO);
        return freewriteVO.getId();
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
