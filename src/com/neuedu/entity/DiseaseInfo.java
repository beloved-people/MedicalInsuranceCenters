package com.neuedu.entity;

public class DiseaseInfo {
	private String diseaseCode;
	  private String diseaseName;
	  private String diseaseTypeId;
	  private int diseaseReimbursementSign;
	  private String remarks;
	public DiseaseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiseaseInfo(String diseaseCode, String diseaseName, String diseaseTypeId, int diseaseReimbursementSign,
			String remarks) {
		super();
		this.diseaseCode = diseaseCode;
		this.diseaseName = diseaseName;
		this.diseaseTypeId = diseaseTypeId;
		this.diseaseReimbursementSign = diseaseReimbursementSign;
		this.remarks = remarks;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(String diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public int getDiseaseReimbursementSign() {
		return diseaseReimbursementSign;
	}
	public void setDiseaseReimbursementSign(int diseaseReimbursementSign) {
		this.diseaseReimbursementSign = diseaseReimbursementSign;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	  
	  
}
