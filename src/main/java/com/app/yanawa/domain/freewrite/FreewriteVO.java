package com.app.yanawa.domain.freewrite;

<<<<<<< HEAD:Yanawa/src/main/java/com/app/yanawa/domain/freewrite/FreewriteVO.java



=======
>>>>>>> 53396ea86cb2df84f5d3c4d839a345573296c2b4:src/main/java/com/app/yanawa/domain/freewrite/FreewriteVO.java
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