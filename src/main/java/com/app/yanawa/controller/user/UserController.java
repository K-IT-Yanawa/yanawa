package com.app.yanawa.controller.user;

import com.app.yanawa.domain.user.UserDTO;
import com.app.yanawa.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/yanawa/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

//    회원가입 페이지로 이동
    @GetMapping("signup")
    public String goToSignup(UserDTO userDTO, HttpSession session) {
        return "login_page/signup";
    }

//    회원가입 완료페이지로 이동
    @PostMapping("signup")
    public RedirectView signup(UserDTO userDTO) {
        userService.join(userDTO.toVO());
        log.info("로그인성공: {}", userDTO.getUserEmail());
        return new RedirectView("/yanawa/login");
    }
}
