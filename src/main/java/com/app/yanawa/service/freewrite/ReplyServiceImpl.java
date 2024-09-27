package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.ReplyDTO;
import com.app.yanawa.domain.freewrite.ReplyVO;
import com.app.yanawa.repository.freewrite.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyDAO replyDAO;

    @Override
    public void write(ReplyVO replyVO) {
        replyDAO.save(replyVO);
    }

    @Override
    public List<ReplyDTO> getRepliesByPostId(Long postId) {
        return replyDAO.findRepliesByPostId(postId);
    }

    @Override
    public void update(ReplyVO replyVO) {
        replyDAO.update(replyVO);
    }

    @Override
    public void delete(Long id) {
        replyDAO.delete(id);
    }
}
