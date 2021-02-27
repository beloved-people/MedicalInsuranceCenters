package com.neuedu.entity;

public class DiagnosisAndTreatmentProjectInfo {
	 private long projectCode;
	  private String projectName;
	  private int chargeCategory;
	  private int chargingItemLevel;
	  private int hospitalLevel;
	  private String projectApprovalMarkRequired;
	  private String projectUnit;
	  private String restrictedProjectUsingScope;
	  private String remarks;
	  
	  
	public DiagnosisAndTreatmentProjectInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DiagnosisAndTreatmentProjectInfo(long projectCode, String projectName, int chargeCategory,
			int chargingItemLevel, int hospitalLevel, String projectApprovalMarkRequired, String projectUnit,
			String restrictedProjectUsingScope, String remarks) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.chargeCategory = chargeCategory;
		this.chargingItemLevel = chargingItemLevel;
		this.hospitalLevel = hospitalLevel;
		this.projectApprovalMarkRequired = projectApprovalMarkRequired;
		this.projectUnit = projectUnit;
		this.restrictedProjectUsingScope = restrictedProjectUsingScope;
		this.remarks = remarks;
	}


	public long getProjectCode() {
		return projectCode;
	}


	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public int getChargeCategory() {
		return chargeCategory;
	}


	public void setChargeCategory(int chargeCategory) {
		this.chargeCategory = chargeCategory;
	}


	public int getChargingItemLevel() {
		return chargingItemLevel;
	}


	public void setChargingItemLevel(int chargingItemLevel) {
		this.chargingItemLevel = chargingItemLevel;
	}


	public int getHospitalLevel() {
		return hospitalLevel;
	}


	public void setHospitalLevel(int hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}


	public String getProjectApprovalMarkRequired() {
		return projectApprovalMarkRequired;
	}


	public void setProjectApprovalMarkRequired(String projectApprovalMarkRequired) {
		this.projectApprovalMarkRequired = projectApprovalMarkRequired;
	}


	public String getProjectUnit() {
		return projectUnit;
	}


	public void setProjectUnit(String projectUnit) {
		this.projectUnit = projectUnit;
	}


	public String getRestrictedProjectUsingScope() {
		return restrictedProjectUsingScope;
	}


	public void setRestrictedProjectUsingScope(String restrictedProjectUsingScope) {
		this.restrictedProjectUsingScope = restrictedProjectUsingScope;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "DiagnosisAndTreatmentProjectInfo [projectCode=" + projectCode + ", projectName=" + projectName
				+ ", chargeCategory=" + chargeCategory + ", chargingItemLevel=" + chargingItemLevel + ", hospitalLevel="
				+ hospitalLevel + ", projectApprovalMarkRequired=" + projectApprovalMarkRequired + ", projectUnit="
				+ projectUnit + ", restrictedProjectUsingScope=" + restrictedProjectUsingScope + ", remarks=" + remarks
				+ "]";
	}
	  
	  

}
