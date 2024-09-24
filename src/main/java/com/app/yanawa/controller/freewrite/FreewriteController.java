package com.app.yanawa.controller.freewrite;

import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.user.UserVO;
import com.app.yanawa.repository.freewrite.FreewriteDAO;
import com.app.yanawa.service.freewrite.FreewriteService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freewrite/*")
@Slf4j
public class FreewriteController {
    private final FreewriteService freewriteService;
    private final HttpSession session;

    @GetMapping("write")
    public void goToWriteForm(FreewriteDTO freewriteDTO) {
        ;
    }

    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO) {
        freewriteDTO.setUserId(((UserVO) session.getAttribute("user")).getId());

        freewriteService.write(freewriteDTO.toVO());
        return "redirect:/freewrite/list";
    }

}
