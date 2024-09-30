package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.freewrite.Search;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.freewrite.FreewriteMapper;
import com.app.yanawa.service.freewrite.FreewriteService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

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
                // 기존 글 수정 - 두 개의 서비스 메서드로 분리 호출
                freewriteService.updatePost(freewriteDTO);  // TBL_POST 수정
                freewriteService.updateFreewrite(freewriteDTO);  // TBL_FREEWRITE 수정
            }
        } else {
            log.error("세션에 사용자 정보가 없습니다.");
            return "redirect:/freewrite/write";
        }

        return "redirect:/freewrite/list?page=1&order=recent";
    }



    // 게시글 목록 화면 이동
    @GetMapping("list")
    public String list(Pagination pagination, @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "order", required = false) String order, Model model) {
        if (order == null) {
            order = "recent"; // 기본값 설정
        }

        Search search = new Search();
        search.setKeyword(keyword);
        search.setOrder(order);

        pagination.setTotal(freewriteService.getTotalWithSearch(search));
        pagination.progress();

        List<FreewriteDTO> freewrites = freewriteService.getList(pagination, search);

        model.addAttribute("freewrites", freewrites);
        model.addAttribute("pagination", pagination);
        model.addAttribute("keyword", keyword);
        model.addAttribute("order", order); // 정렬 기준 유지

        return "freewrite/list";
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
