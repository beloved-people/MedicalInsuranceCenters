package com.neuedu.entity;

import java.util.List;

public class PageBean4<T> {	
	private int currentPage = 1;//当前页
	private int pageSize = 5;	//每页记录数
	private int totalCount = 0;	//总记录数
	private int totalPage = 0;	//总页数
	private int startNum = 0;	//开始行号：（当前页-1）*每页记录数
	private int endNum = 0;		//结束行号：当前页*每页记录数+1
	private List<T> pageDate;	//结果集
	
	
	public PageBean4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean4(int currentPage, int pageSize, int totalCount, int totalPage, int startNum, int endNum,
			List<T> pageDate) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.startNum = startNum;
		this.endNum = endNum;
		this.pageDate = pageDate;
	}
	public int getStartNum() {
		return (this.currentPage-1)*this.pageSize;
	}
	public int getEndNum() {
		return this.currentPage*this.pageSize+1;
	}
    public int getTotalPage() {
    	totalPage = totalCount / pageSize;
    	if(totalCount==0 || totalCount%pageSize!=0) {
    		totalPage++;
    	}
    	return totalPage;
    }
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getPageDate() {
		return pageDate;
	}
	public void setPageDate(List<T> pageDate) {
		this.pageDate = pageDate;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", startNum=" + startNum + ", endNum=" + endNum + ", pageDate="
				+ pageDate + "]";
	}
    
    
	

}
