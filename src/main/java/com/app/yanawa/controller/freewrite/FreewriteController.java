package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.FreewritePagination;
import com.app.yanawa.domain.freewrite.FreewriteSearch;
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
@RequestMapping("/freewrite_page/*")
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
                    "",
                    "",
                    true,
                    "",
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
        return "/freewrite_page/write";  // 절대 경로로 설정하여 템플릿 위치 강제 지정
    }

    // 글 작성 후 처리
    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO) {
        MemberVO member = (MemberVO) session.getAttribute("member");

        if (member != null) {
            freewriteDTO.setMemberId(member.getId());

            if (freewriteDTO.getId() == null) {
                freewriteService.write(freewriteDTO);
            } else {
                freewriteService.updatePost(freewriteDTO);
                freewriteService.updateFreewrite(freewriteDTO);
            }
        } else {
            log.error("세션에 사용자 정보가 없습니다.");
            return "redirect:/freewrite_page/write";
        }

        return "redirect:/freewrite_page/list?page=1&order=recent";
    }

    // 게시글 목록 화면 이동
    @GetMapping("list")
    public String list(FreewritePagination freewritePagination, @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "order", required = false) String order, Model model) {
        if (order == null) {
            order = "recent";
        }

        FreewriteSearch freewriteSearch = new FreewriteSearch();
        freewriteSearch.setKeyword(keyword);
        freewriteSearch.setOrder(order);

        freewritePagination.setTotal(freewriteService.getTotalWithSearch(freewriteSearch));
        freewritePagination.progress();

        List<FreewriteDTO> freewrites = freewriteService.getList(freewritePagination, freewriteSearch);

        model.addAttribute("freewrites", freewrites);
        model.addAttribute("pagination", freewritePagination);
        model.addAttribute("keyword", keyword);
        model.addAttribute("order", order);

        return "/freewrite_page/list";  // 절대 경로로 설정하여 템플릿 위치 강제 지정
    }

    // 게시글 상세 조회
    @GetMapping("detail")
    public String detail(Long id, Model model) {
        log.info("세션에 설정된 memberId: " + ((MemberVO) session.getAttribute("member")).getId());
        FreewriteDTO freewrite = freewriteMapper.selectById(id);
        freewriteMapper.increaseReadCount(id);

        MemberVO member = (MemberVO) session.getAttribute("member");
        if (member != null && freewrite.getMemberId().equals(member.getId())) {
            model.addAttribute("isOwner", true);
        } else {
            model.addAttribute("isOwner", false);
        }

        model.addAttribute("freewrite", freewrite);

        return "/freewrite_page/detail";  // 절대 경로로 설정하여 템플릿 위치 강제 지정
    }

    // 게시글 삭제
    @GetMapping("delete")
    public String delete(Long id) {
        MemberVO member = (MemberVO) session.getAttribute("member");
        FreewriteDTO freewrite = freewriteMapper.selectById(id);

        if (member != null && freewrite.getMemberId().equals(member.getId())) {
            freewriteService.delete(id);
            return "redirect:/freewrite_page/list?page=1&order=recent";
        } else {
            log.error("권한이 없는 사용자입니다.");
            return "redirect:/freewrite_page/detail?id=" + id;
        }
    }
}