package com.app.yanawa.domain.matching;

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

    public void progres() {
        this.page = page == null ? 1 : page; // 현재 페이지가 null이면 1페이지로 설정
        this.rowCount = 5; // 한 페이지에 보여줄 행의 수
        this.pageCount = 10; // 한 페이지에 보여줄 페이지 번호 개수
        this.pageSize = rowCount; // 페이지 크기를 행의 수와 동일하게 설정

        this.endRow = page * rowCount;
        this.startRow = (endRow - rowCount) + 1; // 1부터 시작하는 방식으로 수정
        this.endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지 계산

        // 페이지 수가 10보다 작을 때 다음 버튼이 마지막 페이지로 이동하도록 처리
        if (realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }

        // '이전'과 '다음' 버튼을 제어
        this.prev = startPage > 1; // 첫 번째 페이지보다 클 때만 이전 버튼 활성화
        this.next = endPage < realEnd; // 마지막 페이지보다 작을 때만 다음 버튼 활성화
    }


}
