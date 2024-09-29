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
    private int sportsKindRadioValue;
    private String city;
    private String localCity;
    private String detailedArea;
    private String teamActivityTime;
    private String ageRange;
    private String createdDate;
    private String updatedDate;
}
