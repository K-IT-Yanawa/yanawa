package com.app.yanawa.domain.notice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoticeDTO {
    private Long id;
    private String createdDate;
    private String updatedDate;
}
