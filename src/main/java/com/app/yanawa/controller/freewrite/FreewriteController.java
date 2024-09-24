package com.app.yanawa.controller.freewrite;


import com.app.yanawa.domain.freewrite.FreewriteDTO;
import com.app.yanawa.domain.freewrite.Attachment;
import com.app.yanawa.domain.freewrite.Pagination;
import com.app.yanawa.domain.user.UserVO;
import com.app.yanawa.service.freewrite.FreewriteService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String goToWriteForm(FreewriteDTO freewriteDTO) {
        return "freewrite/write";  // 명시적으로 "freewrite/write" 템플릿 반환
    }

    @PostMapping("write")
    public String write(FreewriteDTO freewriteDTO, @RequestParam("attachment") MultipartFile file) {
        // 사용자 정보 설정
        freewriteDTO.setUserId(((UserVO) session.getAttribute("user")).getId());

        // 글 작성 처리 후 작성된 글의 ID 반환
        Long postId = freewriteService.write(freewriteDTO.toVO());

        // 파일 업로드 처리
        if (!file.isEmpty()) {
            String filePath = saveFile(file);  // 파일 저장 메소드 호출
            Attachment attachment = new Attachment();
            attachment.setAttachmentPath(filePath);
            attachment.setAttachmentSize(file.getSize());
            attachment.setPostId(postId);

            // 첨부파일 정보 저장
            freewriteService.saveAttachment(attachment);
        }

        return "redirect:/freewrite/list";
    }

    // 파일 저장 로직
    private String saveFile(MultipartFile file) {
        // 파일 저장 경로 설정 (ex: /uploads/)
        String uploadDir = "C:/uploads/"; // 실제 서버의 저장 경로
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + fileName;

        try {
            // 파일을 해당 경로에 저장
            File saveFile = new File(filePath);
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리 로직 추가 가능
        }

        return filePath;  // 저장된 파일 경로 반환
    }


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
