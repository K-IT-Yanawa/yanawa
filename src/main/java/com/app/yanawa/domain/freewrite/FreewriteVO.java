package com.app.yanawa.domain.freewrite;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class FreewriteVO {

    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private Long userId;
    private String createdDate;
    private String updatedDate;
    private int postReadCount;
    private int replyCount;
}