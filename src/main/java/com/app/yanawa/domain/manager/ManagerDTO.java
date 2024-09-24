package com.app.yanawa.domain.manager;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ManagerDTO {
    private Long id;
    private Long userId;
    private Long postId;
    private String createdDate;
    private String updatedDate;
}
