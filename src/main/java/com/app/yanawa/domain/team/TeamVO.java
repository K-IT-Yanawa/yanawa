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
    private int memberCount;
    private int applicantCount;
    private String teamName;
    private String cityName;
    private String localCityName;
    private String detailedArea;
    private String teamActivityTime;
    private String ageRange;
    private int sportsKindRadioId;
    private String createdDate;
    private String updatedDate;
}
