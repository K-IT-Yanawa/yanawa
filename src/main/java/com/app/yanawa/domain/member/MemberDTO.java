package com.app.yanawa.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String userName;
    private String userEmail;
    private String userNickName;
    private String userPhone;
    private String userPassword;
    private String userGender;
    private int userPoint;
    private String userIntroduce;
    private String userSportKind;
    private String userPositionKind;
    private String userSportHistory;
    private String userBirth;
    private String createdDate;
    private String updatedDate;

    public MemberVO toVO() {
        return new MemberVO(id, userName,userEmail,userNickName,
                userPhone,userPassword,userGender,userPoint,userIntroduce,
                userSportKind,userPositionKind,userSportHistory,userBirth,
                createdDate,updatedDate);
    }
}