package com.app.yanawa.domain.team;


import com.app.yanawa.pagination.Pagination;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TeamPostPagination extends Pagination {
    private String order;

    @Override
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