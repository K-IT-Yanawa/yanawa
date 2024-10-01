package com.app.yanawa.domain.team;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TeamPostPagination {
    private Integer page; // 사용자에게 전달받은 페이지번호
    private int startRow; // 한 페이지에서 첫번째 게시글
    private int endRow; // 한 페이지에서 마지막 게시글
    private int rowCount; // 한 페이지에 뿌려질 게시글 갯수
    private int pageCount; // 아래 페이지 번호들이 몇개씩 뿌려질 것이냐
    private int startPage; // 시작 페이지
    private int endPage; // 마지막 페이지
    private int realEnd; // 진짜 마지막 페이지
    private boolean prev, next; // 이전, 다음 버튼
    private int total;

    public void progress() {
        this.page = page == null ? 1 : page;
        this.rowCount = 5;
        this.pageCount = 5;
        this.endRow = page * rowCount;
        this.startRow = endRow - rowCount + 1;
        this.endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil(total / (double)rowCount);
        if(realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}