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
    private String confirmPassword;
    private String memberGender;
    private int memberPoint;
    private String memberIntroduce;
    private String memberSportKind;
    private String memberPositionKind;
    private String memberSportHistory;
    private String memberBirth;
    private String createdDate;
    private String updatedDate;

//    회원가입, 로그인 화면에 사용되는 정보만 뺴놓은 메소드
    public MemberVO toVO() {
        return new MemberVO(id, memberName,memberEmail,memberNickName,
                memberPhone,memberPassword,memberGender,memberBirth,
                createdDate,updatedDate);
    }
}