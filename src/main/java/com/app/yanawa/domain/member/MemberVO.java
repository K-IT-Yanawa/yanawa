package com.app.yanawa.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long userId;
    private String createdDate;
    private String updatedDate;
}
