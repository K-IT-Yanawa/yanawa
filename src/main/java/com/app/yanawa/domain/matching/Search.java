package com.app.yanawa.domain.matching;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
@ToString
public class Search {
    private String keyword;

}
