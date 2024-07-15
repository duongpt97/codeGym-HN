package com.example.phongtro.dto;


public class PagingDto {
    private int totalRow;
    private int currentPage;
    private int totalPage;
    private boolean firstTab;
    private boolean lastTab;
    private int beginPage;
    private int endPage;

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isFirstTab() {
        return firstTab;
    }

    public void setFirstTab(boolean firstTab) {
        this.firstTab = firstTab;
    }

    public boolean isLastTab() {
        return lastTab;
    }

    public void setLastTab(boolean lastTab) {
        this.lastTab = lastTab;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
