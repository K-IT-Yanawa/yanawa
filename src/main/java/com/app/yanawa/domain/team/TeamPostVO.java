package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamPostVO {
    @EqualsAndHashCode.Include
    private Long postId;
    private Long teamId;
}
