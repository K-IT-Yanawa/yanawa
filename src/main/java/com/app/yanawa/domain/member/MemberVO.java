package com.app.yanawa.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;
    private String memberEmail;
    private String memberNickName;
    private String memberPhone;
    private String memberPassword;
    private String memberGender;
    private String memberBirth;
    private String createdDate;
    private String updatedDate;
}
