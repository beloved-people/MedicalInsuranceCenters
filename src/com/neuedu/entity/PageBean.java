package com.neuedu.entity;

import java.util.List;

public class PageBean<T> {
	 /**
     * �ܼ�¼��
     */
    private int totalCount;
    /**
     * ��ҳ��
     */
    private int totalPage;
    /**
     * ÿҳ������
     */
    private List<T> list;
    /**
     * ��ǰҳ��
     */
    private int currentPage;
    /**
     * ÿҳ��ʾ�ļ�¼��
     */
    private int rows;
    
    
	public PageBean() {
		super();
	}

	public PageBean(int totalCount, int totalPage, List<T> list, int currentPage, int rows) {
		super();
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.list = list;
		this.currentPage = currentPage;
		this.rows = rows;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("PageBean{");
        sb.append("totalCount=").append(totalCount);
        sb.append(", totalPage=").append(totalPage);
        sb.append(", list=").append(list);
        sb.append(", currentPage=").append(currentPage);
        sb.append(", rows=").append(rows);
        sb.append('}');
        return sb.toString();
	}
    
    
    
    
	

}
