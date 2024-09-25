package com.app.yanawa.domain.freewrite;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter


@NoArgsConstructor
@AllArgsConstructor
public class FreewriteVO {

    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
    private int freewriteReadCount;
    private int replyCount;
    private String memberNickname;
}