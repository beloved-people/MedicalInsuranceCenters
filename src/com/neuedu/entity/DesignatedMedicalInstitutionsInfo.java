package com.neuedu.entity;

public class DesignatedMedicalInstitutionsInfo {
	private long designatedMedicalInstitutionCode;
	  private String serviceOrganizationName;
	  private int hospitalLevel;
	  private String medicalInstitutionTypeId;
	  private String postcode;
	  private String legalRepresentativeName;
	  private String legalRepresentativeCellphoneNumber;
	  private String concatName;
	  private String contactNumber;
	  private String concatCellphoneNumber;
	  private String address;
	  private String remarks;
	public DesignatedMedicalInstitutionsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DesignatedMedicalInstitutionsInfo(long designatedMedicalInstitutionCode, String serviceOrganizationName,
			int hospitalLevel, String medicalInstitutionTypeId, String postcode, String legalRepresentativeName,
			String legalRepresentativeCellphoneNumber, String concatName, String contactNumber,
			String concatCellphoneNumber, String address, String remarks) {
		super();
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
		this.serviceOrganizationName = serviceOrganizationName;
		this.hospitalLevel = hospitalLevel;
		this.medicalInstitutionTypeId = medicalInstitutionTypeId;
		this.postcode = postcode;
		this.legalRepresentativeName = legalRepresentativeName;
		this.legalRepresentativeCellphoneNumber = legalRepresentativeCellphoneNumber;
		this.concatName = concatName;
		this.contactNumber = contactNumber;
		this.concatCellphoneNumber = concatCellphoneNumber;
		this.address = address;
		this.remarks = remarks;
	}
	public long getDesignatedMedicalInstitutionCode() {
		return designatedMedicalInstitutionCode;
	}
	public void setDesignatedMedicalInstitutionCode(long designatedMedicalInstitutionCode) {
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}
	public String getServiceOrganizationName() {
		return serviceOrganizationName;
	}
	public void setServiceOrganizationName(String serviceOrganizationName) {
		this.serviceOrganizationName = serviceOrganizationName;
	}
	public int getHospitalLevel() {
		return hospitalLevel;
	}
	public void setHospitalLevel(int hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
	public String getMedicalInstitutionTypeId() {
		return medicalInstitutionTypeId;
	}
	public void setMedicalInstitutionTypeId(String medicalInstitutionTypeId) {
		this.medicalInstitutionTypeId = medicalInstitutionTypeId;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLegalRepresentativeName() {
		return legalRepresentativeName;
	}
	public void setLegalRepresentativeName(String legalRepresentativeName) {
		this.legalRepresentativeName = legalRepresentativeName;
	}
	public String getLegalRepresentativeCellphoneNumber() {
		return legalRepresentativeCellphoneNumber;
	}
	public void setLegalRepresentativeCellphoneNumber(String legalRepresentativeCellphoneNumber) {
		this.legalRepresentativeCellphoneNumber = legalRepresentativeCellphoneNumber;
	}
	public String getConcatName() {
		return concatName;
	}
	public void setConcatName(String concatName) {
		this.concatName = concatName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getConcatCellphoneNumber() {
		return concatCellphoneNumber;
	}
	public void setConcatCellphoneNumber(String concatCellphoneNumber) {
		this.concatCellphoneNumber = concatCellphoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	  
	  
	  
	  

}
