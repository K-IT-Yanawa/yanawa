package com.app.yanawa.domain.matching;

import com.app.yanawa.domain.post.PostVO;
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
    private int postType;

    private String matchingStatus;

    private Long memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;

    private String sportKindValue;

    private Long teamId;
    private String teamName;

    private String choiceAmPm;
    private String timeRegister;
    private String dateRegister;
    private String timeCordinate;
    private String dateCordinate;

    private String city;
    private String localCity;
    private String localCityDetail;


    private String createDate;
    private String updateDate;


    public PostVO toPostVO() {
        return new PostVO(postId, postTitle, postContent, createDate, updateDate, postType);
    }

    public MatchingVO toVO() {
        return new MatchingVO(
                postId, matchingStatus, teamId, sportKindValue,
                dateRegister, choiceAmPm, timeRegister, dateCordinate, timeCordinate,
                city, localCity, localCityDetail, createDate, updateDate);
    }
}
