package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.service.freewrite.FreewriteService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    // 글쓰기 화면 이동
    @GetMapping("write")
    public void goToWriteForm(FreewriteDTO freewriteDTO) {
        // 세션에 사용자 정보를 미리 설정
        session.setAttribute("member", new MemberVO(
                3L,                        // ID
                "",              // memberName
                "",            // memberEmail
                "",            // memberNickName
                "",           // memberPhone
                "",                // memberPassword
                "",                    // memberGender (남성/여성)
                "",              // memberBirth (DATE)
                "",                        // createdDate
                ""                         // updatedDate
        ));
    }

    // 글 작성 후 처리
    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO) {
        // 세션에서 member 정보를 가져와 FreewriteDTO에 설정
        MemberVO member = (MemberVO) session.getAttribute("member");

        if (member != null) {
            freewriteDTO.setMemberId(member.getId());
            freewriteService.write(freewriteDTO);
        } else {
            // 만약 세션에 member 정보가 없을 경우 에러 처리 로직 추가 가능
            log.error("세션에 사용자 정보가 없습니다.");
            return "redirect:/freewrite/write";
        }

        return "redirect:/freewrite/list?page=1&order=recent";
    }

    // 게시글 목록 화면 이동
    @GetMapping("list")
    public void getList(Pagination pagination, String order, Model model) {
        if (order == null) {
            order = "recent";
        }
        pagination.setTotal(freewriteService.getTotal());
        pagination.progress();
        model.addAttribute("freewrites", freewriteService.getList(pagination, order));
    }
}
