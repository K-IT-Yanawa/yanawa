package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.*;

import java.util.List;

public interface FreewriteService {
     public void write(FreewriteDTO freewriteDTO);
    void saveAttachment(Attachment attachment);
    List<FreewriteDTO> getList(Pagination pagination, Search search);

    public int getTotal();
    public FreewriteDTO getDetail(Long id);
    public void increaseReadCount(Long id);
    // 게시글 제목 및 내용 수정 (TBL_POST)
    void updatePost(FreewriteDTO freewriteDTO);

    // 게시글 기타 정보 수정 (TBL_FREEWRITE)
    void updateFreewrite(FreewriteDTO freewriteDTO);
    void delete(Long id);
    public int getTotalWithSearch(Search search);
}
