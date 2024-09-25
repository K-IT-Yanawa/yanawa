package com.app.yanawa.domain.post;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {

    private Long id;
    private String postTitle;
    private String postContent;
    private String createDate;
    private String updateDate;
    private int postType;

}
