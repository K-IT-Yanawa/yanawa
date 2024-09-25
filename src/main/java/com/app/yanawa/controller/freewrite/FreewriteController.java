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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freewrite/*")
@Slf4j
public class FreewriteController {
    private final FreewriteService freewriteService;
    private final HttpSession session;

    @GetMapping("write")
    public void goToWriteForm(FreewriteDTO freewriteDTO) {;}

    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO) {
//        session.setAttribute("member", new MemberVO(
//                1L,                        // ID
//                "사용자이름",              // memberName
//                "사용자이메일",            // memberEmail
//                "사용자닉네임",            // memberNickName
//                "010-1234-5678",           // memberPhone
//                "비밀번호",                // memberPassword
//                "남성",                    // memberGender (남성/여성)
//                Date.valueOf("1990-01-01") // memberBirth (DATE)
//                // 나머지 필드는 default나 nullable로 제외
//        ));


        // 미리 로그인 됐다고 가정함.
        // 사용자 정보 설정
        freewriteDTO.setMemberId(((MemberVO) session.getAttribute("member")).getId());
        freewriteService.write(freewriteDTO);



        return "redirect:/freewrite/list";
    }

    // 파일 업로드 처리
//        if (!file.isEmpty()) {
//            String filePath = saveFile(file);  // 파일 저장 메소드 호출
//            Attachment attachment = new Attachment();
//            attachment.setAttachmentPath(filePath);
//            attachment.setAttachmentSize(file.getSize());
//            attachment.setPostId(postId);
//
//            // 첨부파일 정보 저장
//            freewriteService.saveAttachment(attachment);
//        }
//
//    // 파일 저장 로직
//    private String saveFile(MultipartFile file) {
//        // 파일 저장 경로 설정 (ex: /uploads/)
//        String uploadDir = "C:/uploads/"; // 실제 서버의 저장 경로
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        String filePath = uploadDir + fileName;
//
//        try {
//            // 파일을 해당 경로에 저장
//            File saveFile = new File(filePath);
//            file.transferTo(saveFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            // 예외 처리 로직 추가 가능
//        }
//
//        return filePath;  // 저장된 파일 경로 반환
//    }

    @GetMapping("list")
    public void getList(Pagination pagination, String order, Model model) {
        if(order == null){
            order = "recent";
        }
        pagination.setTotal(freewriteService.getTotal());
        pagination.progress();
        model.addAttribute("freewrites", freewriteService.getList(pagination, order));

    }

}



