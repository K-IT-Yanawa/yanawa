package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewriteVO;

import com.app.yanawa.domain.freewrite.Pagination;

import java.util.List;

public interface FreewriteService {
     Long write(FreewriteVO freewriteVO);

    public List<FreewriteDTO> getList(Pagination pagination, String order);
    public int getTotal();
}
