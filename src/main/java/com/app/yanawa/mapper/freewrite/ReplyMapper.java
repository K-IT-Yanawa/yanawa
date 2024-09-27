package com.app.yanawa.mapper.freewrite;

import com.app.yanawa.domain.freewrite.ReplyDTO;
import com.app.yanawa.domain.freewrite.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 작성
    void insert(ReplyVO replyVO);

    // 댓글 ID로 조회
    ReplyDTO selectById(@Param("id") Long id);

    // 특정 게시물에 대한 댓글 조회
    List<ReplyDTO> selectRepliesByPostId(@Param("postId") Long postId);

    // 댓글 수정
    void updateReply(ReplyVO replyVO);

    // 댓글 삭제
    void deleteReply(@Param("id") Long id);
}
