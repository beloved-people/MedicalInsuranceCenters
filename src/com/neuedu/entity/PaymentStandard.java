package com.neuedu.entity;

public class PaymentStandard {
	private int medicalCategory;
	  private String personnelCategoryId;
	  private int hospitalLevel;
	  private int paymentStandard;
	public PaymentStandard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentStandard(int medicalCategory, String personnelCategoryId, int hospitalLevel, int paymentStandard) {
		super();
		this.medicalCategory = medicalCategory;
		this.personnelCategoryId = personnelCategoryId;
		this.hospitalLevel = hospitalLevel;
		this.paymentStandard = paymentStandard;
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
	public int getPaymentStandard() {
		return paymentStandard;
	}
	public void setPaymentStandard(int paymentStandard) {
		this.paymentStandard = paymentStandard;
	}
	  
	  
}
