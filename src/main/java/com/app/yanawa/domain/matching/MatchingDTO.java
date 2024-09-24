package com.app.yanawa.domain.matching;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MatchingDTO {
    @EqualsAndHashCode.Include
    private Long postId;
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;

    private Long sportKindId;
    private int sportKindValue;

    private Long timeId;


    private Long teamId;
    private String teamName;

    private String timeCordinate;
    private String dateCordinate;

    private Long localCityId;
    private String localCityName;
    private String cityName;
    private String localCityDetail;

    private String matchStatus;
    private String createDate;
    private String updateDate;

    public MatchingVO toVO(){
        return new MatchingVO(postId, matchStatus, timeId, teamId, sportKindId, timeCordinate, dateCordinate,
                localCityId, localCityDetail, createDate, updateDate );
    }
}
