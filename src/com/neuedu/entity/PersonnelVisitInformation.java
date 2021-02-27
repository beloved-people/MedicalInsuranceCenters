package com.neuedu.entity;

public class PersonnelVisitInformation {
	 private int id;
	  private String personId;
	  private long inpatientNumber;
	  private long designatedMedicalInstitutionCode;
	  private int medicalCategory;
	  private String admissionDate;
	  private String dischargeDate;
	  private String diseaseCode;
	  private int hospitalLevel;
	  private String admissionDiagnosisCode;
	  private String admissionDiagnosisName;
	  private String dischargeReason;
	public PersonnelVisitInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonnelVisitInformation(int id, String personId, long inpatientNumber,
			long designatedMedicalInstitutionCode, int medicalCategory, String admissionDate, String dischargeDate,
			String diseaseCode, int hospitalLevel, String admissionDiagnosisCode, String admissionDiagnosisName,
			String dischargeReason) {
		super();
		this.id = id;
		this.personId = personId;
		this.inpatientNumber = inpatientNumber;
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
		this.medicalCategory = medicalCategory;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.diseaseCode = diseaseCode;
		this.hospitalLevel = hospitalLevel;
		this.admissionDiagnosisCode = admissionDiagnosisCode;
		this.admissionDiagnosisName = admissionDiagnosisName;
		this.dischargeReason = dischargeReason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public long getInpatientNumber() {
		return inpatientNumber;
	}
	public void setInpatientNumber(long inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}
	public long getDesignatedMedicalInstitutionCode() {
		return designatedMedicalInstitutionCode;
	}
	public void setDesignatedMedicalInstitutionCode(long designatedMedicalInstitutionCode) {
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}
	public int getMedicalCategory() {
		return medicalCategory;
	}
	public void setMedicalCategory(int medicalCategory) {
		this.medicalCategory = medicalCategory;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public int getHospitalLevel() {
		return hospitalLevel;
	}
	public void setHospitalLevel(int hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
	public String getAdmissionDiagnosisCode() {
		return admissionDiagnosisCode;
	}
	public void setAdmissionDiagnosisCode(String admissionDiagnosisCode) {
		this.admissionDiagnosisCode = admissionDiagnosisCode;
	}
	public String getAdmissionDiagnosisName() {
		return admissionDiagnosisName;
	}
	public void setAdmissionDiagnosisName(String admissionDiagnosisName) {
		this.admissionDiagnosisName = admissionDiagnosisName;
	}
	public String getDischargeReason() {
		return dischargeReason;
	}
	public void setDischargeReason(String dischargeReason) {
		this.dischargeReason = dischargeReason;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonnelVisitInformation [id=" + id + ", personId=" + personId + ", inpatientNumber=" + inpatientNumber
				+ ", designatedMedicalInstitutionCode=" + designatedMedicalInstitutionCode + ", medicalCategory="
				+ medicalCategory + ", admissionDate=" + admissionDate + ", dischargeDate=" + dischargeDate
				+ ", diseaseCode=" + diseaseCode + ", hospitalLevel=" + hospitalLevel + ", admissionDiagnosisCode="
				+ admissionDiagnosisCode + ", admissionDiagnosisName=" + admissionDiagnosisName + ", dischargeReason="
				+ dischargeReason + "]";
	}
	  
	  

}
