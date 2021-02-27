package com.neuedu.entity;

public class LimitLine {
	  private String personnelCategoryId;
	  private int limitLine;
	  
	  


	  public LimitLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LimitLine(String personnelCategoryId, int limitLine) {
		super();
		this.personnelCategoryId = personnelCategoryId;
		this.limitLine = limitLine;
	}

	public String getPersonnelCategoryId() {
	    return personnelCategoryId;
	  }

	  public void setPersonnelCategoryId(String personnelCategoryId) {
	    this.personnelCategoryId = personnelCategoryId;
	  }


	  public int getLimitLine() {
	    return limitLine;
	  }

	  public void setLimitLine(int limitLine) {
	    this.limitLine = limitLine;
	  }
}
