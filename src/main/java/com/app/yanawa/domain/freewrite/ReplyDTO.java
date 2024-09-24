package com.app.yanawa.domain.freewrite;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class ReplyDTO {


    private Long id;
    private String replyContent;
    private Long userId;
    private Long postId;
    private String createdDate;
    private String updatedDate;

    public ReplyVO toVO(){
        return new ReplyVO(id, replyContent, userId, postId, createdDate, updatedDate);
    }
}
