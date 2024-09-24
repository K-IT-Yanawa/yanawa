package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private String teamName;
    private int memberCount;
    private Long localCityId;
    private String detailedArea;
    private String ageRange;
    private int applicantNumber;
    private String information;
    private Long sportsKindRadioId;
    private String createdDate;
    private String updatedDate;
}
