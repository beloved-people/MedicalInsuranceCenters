package com.neuedu.entity;

public class MedicalPersonnelCategory {
	private String personnelCategoryId;
	  private String personnelCategoryName;
	public MedicalPersonnelCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalPersonnelCategory(String personnelCategoryId, String personnelCategoryName) {
		super();
		this.personnelCategoryId = personnelCategoryId;
		this.personnelCategoryName = personnelCategoryName;
	}
	public String getPersonnelCategoryId() {
		return personnelCategoryId;
	}
	public void setPersonnelCategoryId(String personnelCategoryId) {
		this.personnelCategoryId = personnelCategoryId;
	}
	public String getPersonnelCategoryName() {
		return personnelCategoryName;
	}
	public void setPersonnelCategoryName(String personnelCategoryName) {
		this.personnelCategoryName = personnelCategoryName;
	}
	  
	  

}
