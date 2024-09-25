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
    private String postTitle;
    private String postContent;
    private int type;

    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;

    private int sportKindValue;

    private Long teamId;
    private String teamName;

    private String timeRegister;
    private String dateRegister;
    private int timeCordinate;
    private int dateCordinate;


    private String city;
    private String localCity;
    private String localCityDetail;

    private String matchStatus;
    private String createDate;
    private String updateDate;

    public MatchingVO toVO() {
        return new MatchingVO(
                postId, matchStatus, teamId, sportKindValue,
                dateRegister, timeRegister, dateCordinate, timeCordinate,
                city, localCity, localCityDetail, createDate, updateDate);
    }
}
