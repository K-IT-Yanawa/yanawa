package com.app.yanawa.domain.freewrite;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Pagination {
    private Integer page;
    private int startRow;
    private int endRow;
    private int rowCount;
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private int pageSize;  // 페이지 크기 필드 추가

    // 페이지 계산 로직
    public void progress() {
        this.page = page == null ? 1 : page;
        this.rowCount = 10; // 한 페이지에 보여줄 행의 수
        this.pageCount = 10; // 한 페이지에 보여줄 페이지 번호 개수
        this.pageSize = rowCount; // 페이지 크기를 행의 수와 동일하게 설정

        this.endRow = page * rowCount;
        this.startRow = (endRow - rowCount); // 0부터 시작하도록 변경
        this.endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int) Math.ceil(total / (double) rowCount);

        if (realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
