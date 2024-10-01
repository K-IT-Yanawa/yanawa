package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.ReplyDTO;
import com.app.yanawa.domain.freewrite.ReplyVO;
import com.app.yanawa.service.freewrite.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 작성
    @PostMapping("/write")
    public String writeReply(@ModelAttribute ReplyVO replyVO) {
        replyService.write(replyVO);
        // 댓글 작성 후, 해당 게시글의 상세 페이지로 리다이렉트
        return "redirect:/freewrite_page/detail?id=" + replyVO.getPostId();
    }



    // 특정 게시물의 댓글 목록 조회
    @GetMapping("/list/{postId}")
    public String getRepliesByPostId(@PathVariable Long postId, Model model) {
        List<ReplyDTO> replies = replyService.getRepliesByPostId(postId);
        model.addAttribute("replies", replies);
        return "reply/replyList";  // 이 부분은 댓글 목록을 표시할 HTML 페이지로 연결
    }

    // 댓글 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReply(@PathVariable Long id, @ModelAttribute ReplyVO replyVO) {
        replyVO.setId(id);
        replyService.update(replyVO);
        return ResponseEntity.ok("댓글이 수정되었습니다.");
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReply(@PathVariable Long id) {
        replyService.delete(id);
        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }
}
