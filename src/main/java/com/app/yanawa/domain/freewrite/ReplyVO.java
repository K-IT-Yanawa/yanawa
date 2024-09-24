package com.app.yanawa.domain.freewrite;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {

    @EqualsAndHashCode.Include
    private Long id;
    private String replyContent;
    private Long userId;
    private Long postId;
    private String createdDate;
    private String updatedDate;


}


