package com.neuedu.entity;

public class MedicalInstitutionType {
	private String medicalInstitutionTypeId;
	  private String medicalInstitutionTypeName;
	public MedicalInstitutionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalInstitutionType(String medicalInstitutionTypeId, String medicalInstitutionTypeName) {
		super();
		this.medicalInstitutionTypeId = medicalInstitutionTypeId;
		this.medicalInstitutionTypeName = medicalInstitutionTypeName;
	}
	public String getMedicalInstitutionTypeId() {
		return medicalInstitutionTypeId;
	}
	public void setMedicalInstitutionTypeId(String medicalInstitutionTypeId) {
		this.medicalInstitutionTypeId = medicalInstitutionTypeId;
	}
	public String getMedicalInstitutionTypeName() {
		return medicalInstitutionTypeName;
	}
	public void setMedicalInstitutionTypeName(String medicalInstitutionTypeName) {
		this.medicalInstitutionTypeName = medicalInstitutionTypeName;
	}
	  
	  
}
