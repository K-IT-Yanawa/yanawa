package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class TeamPostDTO {
    private Long id;
    private Long teamId;
    private String endDate;
    private String information;
    private String createdDate;
    private String updatedDate;
    private int postReadCount;
    private Long memberId;
    private String teamName;
    private int sportsKindRadioValue;
    private String city;
    private String localCity;
    private String detailedArea;
    private String teamActivityTime;
    private String ageRange;

    public TeamPostVO toVO() {
        return new TeamPostVO(id, teamId, endDate, information, createdDate, updatedDate, postReadCount);
    }
}
