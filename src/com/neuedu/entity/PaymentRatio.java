package com.neuedu.entity;

public class PaymentRatio {
	private int medicalCategory;
	  private String personnelCategoryId;
	  private int hospitalLevel;
	  private int upperLimitAmount;
	  private int lowerLimitAmount;
	  private double reimbursementRatio;
	  
	public PaymentRatio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentRatio(int medicalCategory, String personnelCategoryId, int hospitalLevel, int upperLimitAmount,
			int lowerLimitAmount, double reimbursementRatio) {
		super();
		this.medicalCategory = medicalCategory;
		this.personnelCategoryId = personnelCategoryId;
		this.hospitalLevel = hospitalLevel;
		this.upperLimitAmount = upperLimitAmount;
		this.lowerLimitAmount = lowerLimitAmount;
		this.reimbursementRatio = reimbursementRatio;
	}

	public int getMedicalCategory() {
		return medicalCategory;
	}

	public void setMedicalCategory(int medicalCategory) {
		this.medicalCategory = medicalCategory;
	}

	public String getPersonnelCategoryId() {
		return personnelCategoryId;
	}

	public void setPersonnelCategoryId(String personnelCategoryId) {
		this.personnelCategoryId = personnelCategoryId;
	}

	public int getHospitalLevel() {
		return hospitalLevel;
	}

	public void setHospitalLevel(int hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	public int getUpperLimitAmount() {
		return upperLimitAmount;
	}

	public void setUpperLimitAmount(int upperLimitAmount) {
		this.upperLimitAmount = upperLimitAmount;
	}

	public int getLowerLimitAmount() {
		return lowerLimitAmount;
	}

	public void setLowerLimitAmount(int lowerLimitAmount) {
		this.lowerLimitAmount = lowerLimitAmount;
	}

	public double getReimbursementRatio() {
		return reimbursementRatio;
	}

	public void setReimbursementRatio(double reimbursementRatio) {
		this.reimbursementRatio = reimbursementRatio;
	}
	  
	  
	  
	  
	  
}
