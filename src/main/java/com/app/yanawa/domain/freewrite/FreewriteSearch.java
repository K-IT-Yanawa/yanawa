package com.app.yanawa.domain.freewrite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreewriteSearch {
    private String keyword;  // 통합 검색어
    private String order;    // 정렬 방식 (ex. recent, popular)

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
