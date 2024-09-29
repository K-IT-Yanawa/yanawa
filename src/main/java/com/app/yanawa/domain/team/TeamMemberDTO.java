package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class TeamMemberDTO {
    private Long id;
    private Long memberId;
    private Long teamId;
    private int pathToContact;
    private String introduce;
    private String createdDate;
    private String updatedDate;

    public TeamMemberVO toVO() {
        return new TeamMemberVO(id, memberId, teamId, pathToContact, introduce, createdDate, updatedDate);
    }
}

