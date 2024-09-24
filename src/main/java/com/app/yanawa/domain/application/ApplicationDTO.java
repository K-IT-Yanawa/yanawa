package com.app.yanawa.domain.application;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ApplicationDTO {
    private Long id;
    private Long userId;
    private Long teamPostId;
    private String introduce;
    private String createdDate;
    private String updatedDate;

    public ApplicationVO toVO() {
        return new ApplicationVO(id, userId, teamPostId, introduce, createdDate, updatedDate);
    }
}
