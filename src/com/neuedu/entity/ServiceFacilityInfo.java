package com.neuedu.entity;

public class ServiceFacilityInfo {
	private long medicalServiceFacilityCode;
	  private String serviceFacilitiesName;
	  private String chargeCategory;
	  private String remarks;
	  private String restrictedUsingScope;
	public ServiceFacilityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceFacilityInfo(long medicalServiceFacilityCode, String serviceFacilitiesName, String chargeCategory,
			String remarks, String restrictedUsingScope) {
		super();
		this.medicalServiceFacilityCode = medicalServiceFacilityCode;
		this.serviceFacilitiesName = serviceFacilitiesName;
		this.chargeCategory = chargeCategory;
		this.remarks = remarks;
		this.restrictedUsingScope = restrictedUsingScope;
	}
	public long getMedicalServiceFacilityCode() {
		return medicalServiceFacilityCode;
	}
	public void setMedicalServiceFacilityCode(long medicalServiceFacilityCode) {
		this.medicalServiceFacilityCode = medicalServiceFacilityCode;
	}
	public String getServiceFacilitiesName() {
		return serviceFacilitiesName;
	}
	public void setServiceFacilitiesName(String serviceFacilitiesName) {
		this.serviceFacilitiesName = serviceFacilitiesName;
	}
	public String getChargeCategory() {
		return chargeCategory;
	}
	public void setChargeCategory(String chargeCategory) {
		this.chargeCategory = chargeCategory;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRestrictedUsingScope() {
		return restrictedUsingScope;
	}
	public void setRestrictedUsingScope(String restrictedUsingScope) {
		this.restrictedUsingScope = restrictedUsingScope;
	}
	@Override
	public String toString() {
		return "ServiceFacilityInfo [medicalServiceFacilityCode=" + medicalServiceFacilityCode
				+ ", serviceFacilitiesName=" + serviceFacilitiesName + ", chargeCategory=" + chargeCategory
				+ ", remarks=" + remarks + ", restrictedUsingScope=" + restrictedUsingScope + "]";
	}
	  
	  

}
