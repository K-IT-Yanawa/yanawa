package com.app.yanawa.domain.matching;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MatchingVO {
    @EqualsAndHashCode.Include
    private Long postId;
    private String matchStatus;
    private Long timeId;
    private Long teamId;
    private Long sportKindId;
    private String timeCordinate;
    private String dateCordinate;
    private Long localCityId;
    private String localCityDetail;
    private String createDate;
    private String updateDate;

    public MatchingDTO toDTO() {
        MatchingDTO matchingDTO = new MatchingDTO();
        matchingDTO.setPostId(postId);
        matchingDTO.setMatchStatus(matchStatus);
        matchingDTO.setTimeId(timeId);
        matchingDTO.setTeamId(teamId);
        matchingDTO.setSportKindId(sportKindId);
        matchingDTO.setTimeCordinate(timeCordinate);
        matchingDTO.setDateCordinate(dateCordinate);
        matchingDTO.setLocalCityId(localCityId);
        matchingDTO.setLocalCityDetail(localCityDetail);
        matchingDTO.setCreateDate(createDate);
        matchingDTO.setUpdateDate(updateDate);
        return matchingDTO;
    }
}
