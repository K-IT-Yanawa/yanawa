package com.app.yanawa.domain.freewrite;

import lombok.Data;
import java.util.Date;

@Data
public class Attachment {
    private Long id; // 첨부 파일의 ID
    private String attachmentPath; // 파일 경로
    private Long attachmentSize; // 파일 크기
    private Long postId; // 첨부된 게시물 ID
    private Date createdDate; // 생성일
    private Date updatedDate; // 수정일
}
