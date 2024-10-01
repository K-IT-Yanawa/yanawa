package com.app.yanawa.pagination;


public class Pagination {
    protected Integer page;
    protected int startRow;
    protected int endRow;
    protected int rowCount;
    protected int pageCount;
    protected int startPage;
    protected int endPage;
    protected int realEnd;
    protected boolean prev, next;
    protected int total;

    public void progress() {
        this.page = page == null ? 1 : page;
        this.rowCount = 10;
        this.pageCount = 10;
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
