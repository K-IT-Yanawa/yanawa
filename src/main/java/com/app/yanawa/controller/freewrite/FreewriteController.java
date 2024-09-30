package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import com.app.yanawa.service.freewrite.FreewriteService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freewrite/*")
@Slf4j
public class FreewriteController {

    private final FreewriteService freewriteService;
    private final HttpSession session;
    private final FreewriteMapper freewriteMapper;

    // 모든 요청 전 세션에 테스트용 사용자 정보 설정
    @ModelAttribute
    public void setTestMember(HttpSession session) {
        if (session.getAttribute("member") == null) {
            session.setAttribute("member", new MemberVO(
                    2L,
                    "",      // memberName
                     "",         // memberEmail
                    "",              // memberNickName
                    "",          // memberPhone
                    "",      // memberPassword
                    "",      // memberGender
                    "",      // memberBirth
                    "",      // createdDate
                    ""       // updatedDate
            ));
        }
    }

    // 글쓰기 화면 이동
    @GetMapping("write")
    public String goToWriteForm(Long id, Model model) {
        log.info("세션에 설정된 memberId: " + ((MemberVO) session.getAttribute("member")).getId());

        if (id != null) {
            FreewriteDTO freewriteDTO = freewriteMapper.selectById(id);
            model.addAttribute("freewrite", freewriteDTO);
        }
        return "freewrite/write";
    }

    // 글 작성 후 처리
    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO) {
        MemberVO member = (MemberVO) session.getAttribute("member");

        if (member != null) {
            freewriteDTO.setMemberId(member.getId());
            if (freewriteDTO.getId() == null) {
                // 새 글 작성
                freewriteService.write(freewriteDTO);
            } else {
                // 기존 글 수정
                freewriteService.update(freewriteDTO);
            }
        } else {
            log.error("세션에 사용자 정보가 없습니다.");
            return "redirect:/freewrite/write";
        }

        return "redirect:/freewrite/list?page=1&order=recent";
    }

    // 게시글 목록 화면 이동
    @GetMapping("list")
    public void getList(Pagination pagination, String order, Model model) {
        log.info("세션에 설정된 memberId: " + ((MemberVO) session.getAttribute("member")).getId());
        if (order == null) {
            order = "recent";
        }
        pagination.setTotal(freewriteService.getTotal());
        pagination.progress();
        model.addAttribute("freewrites", freewriteService.getList(pagination, order));
    }

    // 게시글 상세 조회
    @GetMapping("detail")
    public void detail(Long id, Model model) {
        log.info("세션에 설정된 memberId: " + ((MemberVO) session.getAttribute("member")).getId());
        FreewriteDTO freewrite = freewriteMapper.selectById(id);
        freewriteMapper.increaseReadCount(id);

        // 세션의 memberId와 글 작성자의 memberId가 일치하는지 확인
        MemberVO member = (MemberVO) session.getAttribute("member");
        if (member != null && freewrite.getMemberId().equals(member.getId())) {
            model.addAttribute("isOwner", true); // 글 작성자와 세션 사용자 ID가 같다면 수정, 삭제 버튼 활성화
        } else {
            model.addAttribute("isOwner", false);
        }

        model.addAttribute("freewrite", freewrite);
    }

    // 게시글 삭제
    @GetMapping("delete")
    public String delete(Long id) {
        MemberVO member = (MemberVO) session.getAttribute("member");
        FreewriteDTO freewrite = freewriteMapper.selectById(id);

        // 세션의 memberId와 글 작성자의 memberId가 일치할 때만 삭제 가능
        if (member != null && freewrite.getMemberId().equals(member.getId())) {
            freewriteService.delete(id);
            return "redirect:/freewrite/list?page=1&order=recent";
        } else {
            log.error("권한이 없는 사용자입니다.");
            return "redirect:/freewrite/detail?id=" + id;
        }
    }

}
