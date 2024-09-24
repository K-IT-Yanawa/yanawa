package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private Long teamId;
}
