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
    private String createdDate;
    private String updatedDate;

    public MemberVO toVO() {
        return new MemberVO(id, memberName,memberEmail,memberNickName,
                memberPhone,memberPassword,memberGender,memberBirth,
                createdDate,updatedDate);
    }
}