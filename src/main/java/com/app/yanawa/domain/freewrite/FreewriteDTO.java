package com.app.yanawa.domain.freewrite;

import com.app.yanawa.domain.post.PostVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class FreewriteDTO {


    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
    private int freewriteReadCount;
    private int replyCount;
    private String memberNickname;
    private int postType;

    public PostVO toPostVO() {return new PostVO(id, postTitle, postContent, createdDate, updatedDate, postType);}

    public FreewriteVO toVO() {
        return new FreewriteVO(id, postTitle, postContent, memberId, createdDate, updatedDate, freewriteReadCount, replyCount, memberNickname);
    }
}
