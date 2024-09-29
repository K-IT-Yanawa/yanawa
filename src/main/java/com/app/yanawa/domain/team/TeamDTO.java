package com.app.yanawa.domain.team;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class TeamDTO {
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
    private String memberName;
    private String memberEmail;
    private String memberNickName;
    private String memberPhone;
    private String memberPassword;
    private String memberGender;
    private int memberPoint;
    private String memberIntroduce;
    private String memberSportKind;
    private String memberPositionKind;
    private String memberSportHistory;
    private String memberBirth;

    public TeamVO toVO() {
        return new TeamVO(id, memberId, teamName, sportsKindRadioValue, city, localCity, detailedArea, teamActivityTime, ageRange, createdDate, updatedDate);}
}

