package com.app.yanawa.domain.freewrite;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class FreewriteDTO {


    private Long id;
    private String postTitle;
    private String postContent;
    private Long userId;
    private String createdDate;
    private String updatedDate;
    private int postReadCount;
    private int replyCount;
    private String userNickname;

    public FreewriteVO toVO() {
        return new FreewriteVO(id, postTitle, postContent, userId, createdDate, updatedDate, postReadCount, replyCount);
    }
}
