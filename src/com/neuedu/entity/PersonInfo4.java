package com.neuedu.entity;

public class PersonInfo4 {
	private int id;
	private String personId;
	private String certificateId;
	private String certificateName;
	private String certificateNumber;
	private String name;
	private String gender;
	private String nationId;
	private String nationName;
	private String birthdate;
	private String participationDate;
	private String retirementDate;
	private int retirementStatus;
	private int accountNature;
	private String accountLocation;
	private String degreeId;
	private String degreeName;
	private String outlookId;
	private String outlookName;
	private int identity;
	private int employmentForm;
	private int specializedTechnicalJob;
	private int nvql;
	private int maritalStatus;
	private String dutyId;
	private String dutyName;
	private String remarks;
	private long companyCode;
	private String personnelCategoryId;
	private String personnelCategoryName;
	private int healthStatus;
	private int lamorSign;
	private int cadreSign;
	private int civilServantSign;
	private int establishmentSign;
	private int residentSign;
	private int flexibleEmploymentSign;
	private int migrantWorkerSign;
	private int employerSign;
	private int militaryPersonnelSign;
	private String socialSecurityNumber;
	private long designatedMedicalInstitutionCode;//

	public PersonInfo4() {
		super();
		// TODO Auto-generated constructor stub
	}

	// ·ÖÒ³
	public PersonInfo4(int id, String personId, String certificateId, String certificateName, String certificateNumber,
			String name, String gender) {
		super();
		this.id = id;
		this.personId = personId;
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.certificateNumber = certificateNumber;
		this.name = name;
		this.gender = gender;
	}

	// ËÑË÷
	public PersonInfo4(int id, String personId, String certificateId, String certificateName, String certificateNumber,
			String name, String gender, String nationId, String nationName, String birthdate, String participationDate,
			String retirementDate, int retirementStatus, int accountNature, String accountLocation, String degreeId,
			String degreeName, String outlookId, String outlookName, int identity, int employmentForm,
			int specializedTechnicalJob, int nvql, int maritalStatus, String dutyId, String dutyName, String remarks,
			long companyCode, String personnelCategoryId, String personnelCategoryName, int healthStatus, int lamorSign,
			int cadreSign, int civilServantSign, int establishmentSign, int residentSign, int flexibleEmploymentSign,
			int migrantWorkerSign, int employerSign, int militaryPersonnelSign, String socialSecurityNumber,
			long designatedMedicalInstitutionCode) {
		super();
		this.id = id;
		this.personId = personId;
		this.certificateId = certificateId;
		this.certificateNumber = certificateNumber;
		this.name = name;
		this.gender = gender;
		this.nationId = nationId;
		this.nationName = nationName;
		this.birthdate = birthdate;
		this.participationDate = participationDate;
		this.retirementDate = retirementDate;
		this.retirementStatus = retirementStatus;
		this.accountNature = accountNature;
		this.accountLocation = accountLocation;
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.outlookId = outlookId;
		this.outlookName = outlookName;
		this.identity = identity;
		this.employmentForm = employmentForm;
		this.specializedTechnicalJob = specializedTechnicalJob;
		this.nvql = nvql;
		this.maritalStatus = maritalStatus;
		this.dutyId = dutyId;
		this.dutyName = dutyName;
		this.remarks = remarks;
		this.companyCode = companyCode;
		this.personnelCategoryId = personnelCategoryId;
		this.personnelCategoryName = personnelCategoryName;
		this.healthStatus = healthStatus;
		this.lamorSign = lamorSign;
		this.cadreSign = cadreSign;
		this.civilServantSign = civilServantSign;
		this.establishmentSign = establishmentSign;
		this.residentSign = residentSign;
		this.flexibleEmploymentSign = flexibleEmploymentSign;
		this.migrantWorkerSign = migrantWorkerSign;
		this.employerSign = employerSign;
		this.militaryPersonnelSign = militaryPersonnelSign;
		this.socialSecurityNumber = socialSecurityNumber;
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}

	// Ìí¼Ó
	public PersonInfo4(String personId, String certificateId, String certificateNumber, String name, String gender,
			String nationId, String birthdate, String participationDate, String retirementDate, int retirementStatus,
			int accountNature, String accountLocation, String degreeId, String outlookId, int identity,
			int employmentForm, int specializedTechnicalJob, int nvql, int maritalStatus, String dutyId, String remarks,
			long companyCode, String personnelCategoryId, int healthStatus, int lamorSign, int cadreSign,
			int civilServantSign, int establishmentSign, int residentSign, int flexibleEmploymentSign,
			int migrantWorkerSign, int employerSign, int militaryPersonnelSign, String socialSecurityNumber,
			long designatedMedicalInstitutionCode) {
		super();

		this.personId = personId;
		this.certificateId = certificateId;
		this.certificateNumber = certificateNumber;
		this.name = name;
		this.gender = gender;
		this.nationId = nationId;
		this.birthdate = birthdate;
		this.participationDate = participationDate;
		this.retirementDate = retirementDate;
		this.retirementStatus = retirementStatus;
		this.accountNature = accountNature;
		this.accountLocation = accountLocation;
		this.degreeId = degreeId;
		this.outlookId = outlookId;
		this.identity = identity;
		this.employmentForm = employmentForm;
		this.specializedTechnicalJob = specializedTechnicalJob;
		this.nvql = nvql;
		this.maritalStatus = maritalStatus;
		this.dutyId = dutyId;
		this.remarks = remarks;
		this.companyCode = companyCode;
		this.personnelCategoryId = personnelCategoryId;
		this.healthStatus = healthStatus;
		this.lamorSign = lamorSign;
		this.cadreSign = cadreSign;
		this.civilServantSign = civilServantSign;
		this.establishmentSign = establishmentSign;
		this.residentSign = residentSign;
		this.flexibleEmploymentSign = flexibleEmploymentSign;
		this.migrantWorkerSign = migrantWorkerSign;
		this.employerSign = employerSign;
		this.militaryPersonnelSign = militaryPersonnelSign;
		this.socialSecurityNumber = socialSecurityNumber;
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}

	// ÐÞ¸Ä
	public PersonInfo4(int id, String personID, String certificateId, String certificateNumber, String name,
			String gender, String nationId, String birthdate, String participationDate, String retirementDate,
			int retirementStatus, int accountNature, String accountLocation, String degreeId, String outlookId,
			int identity, int employmentForm, int specializedTechnicalJob, int nvql, int maritalStatus, String dutyId,
			String remarks, long companyCode, String personnelCategoryId, int healthStatus, int lamorSign,
			int cadreSign, int civilServantSign, int establishmentSign, int residentSign, int flexibleEmploymentSign,
			int migrantWorkerSign, int employerSign, int militaryPersonnelSign, String socialSecurityNumber,
			long designatedMedicalInstitutionCode) {
		super();
		this.id = id;
		this.personId = personID;
		this.certificateId = certificateId;
		this.certificateNumber = certificateNumber;
		this.name = name;
		this.gender = gender;
		this.nationId = nationId;
		this.birthdate = birthdate;
		this.participationDate = participationDate;
		this.retirementDate = retirementDate;
		this.retirementStatus = retirementStatus;
		this.accountNature = accountNature;
		this.accountLocation = accountLocation;
		this.degreeId = degreeId;
		this.outlookId = outlookId;
		this.identity = identity;
		this.employmentForm = employmentForm;
		this.specializedTechnicalJob = specializedTechnicalJob;
		this.nvql = nvql;
		this.maritalStatus = maritalStatus;
		this.dutyId = dutyId;
		this.remarks = remarks;
		this.companyCode = companyCode;
		this.personnelCategoryId = personnelCategoryId;
		this.healthStatus = healthStatus;
		this.lamorSign = lamorSign;
		this.cadreSign = cadreSign;
		this.civilServantSign = civilServantSign;
		this.establishmentSign = establishmentSign;
		this.residentSign = residentSign;
		this.flexibleEmploymentSign = flexibleEmploymentSign;
		this.migrantWorkerSign = migrantWorkerSign;
		this.employerSign = employerSign;
		this.militaryPersonnelSign = militaryPersonnelSign;
		this.socialSecurityNumber = socialSecurityNumber;
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
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

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getParticipationDate() {
		return participationDate;
	}

	public void setParticipationDate(String participationDate) {
		this.participationDate = participationDate;
	}

	public String getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	public int getRetirementStatus() {
		return retirementStatus;
	}

	public void setRetirementStatus(int retirementStatus) {
		this.retirementStatus = retirementStatus;
	}

	public int getAccountNature() {
		return accountNature;
	}

	public void setAccountNature(int accountNature) {
		this.accountNature = accountNature;
	}

	public String getAccountLocation() {
		return accountLocation;
	}

	public void setAccountLocation(String accountLocation) {
		this.accountLocation = accountLocation;
	}

	public String getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	public String getOutlookId() {
		return outlookId;
	}

	public void setOutlookId(String outlookId) {
		this.outlookId = outlookId;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public int getEmploymentForm() {
		return employmentForm;
	}

	public void setEmploymentForm(int employmentForm) {
		this.employmentForm = employmentForm;
	}

	public int getSpecializedTechnicalJob() {
		return specializedTechnicalJob;
	}

	public void setSpecializedTechnicalJob(int specializedTechnicalJob) {
		this.specializedTechnicalJob = specializedTechnicalJob;
	}

	public int getNvql() {
		return nvql;
	}

	public void setNvql(int nvql) {
		this.nvql = nvql;
	}

	public int getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}

	public String getPersonnelCategoryId() {
		return personnelCategoryId;
	}

	public void setPersonnelCategoryId(String personnelCategoryId) {
		this.personnelCategoryId = personnelCategoryId;
	}

	public int getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(int healthStatus) {
		this.healthStatus = healthStatus;
	}

	public int getLamorSign() {
		return lamorSign;
	}

	public void setLamorSign(int lamorSign) {
		this.lamorSign = lamorSign;
	}

	public int getCadreSign() {
		return cadreSign;
	}

	public void setCadreSign(int cadreSign) {
		this.cadreSign = cadreSign;
	}

	public int getCivilServantSign() {
		return civilServantSign;
	}

	public void setCivilServantSign(int civilServantSign) {
		this.civilServantSign = civilServantSign;
	}

	public int getEstablishmentSign() {
		return establishmentSign;
	}

	public void setEstablishmentSign(int establishmentSign) {
		this.establishmentSign = establishmentSign;
	}

	public int getResidentSign() {
		return residentSign;
	}

	public void setResidentSign(int residentSign) {
		this.residentSign = residentSign;
	}

	public int getFlexibleEmploymentSign() {
		return flexibleEmploymentSign;
	}

	public void setFlexibleEmploymentSign(int flexibleEmploymentSign) {
		this.flexibleEmploymentSign = flexibleEmploymentSign;
	}

	public int getMigrantWorkerSign() {
		return migrantWorkerSign;
	}

	public void setMigrantWorkerSign(int migrantWorkerSign) {
		this.migrantWorkerSign = migrantWorkerSign;
	}

	public int getEmployerSign() {
		return employerSign;
	}

	public void setEmployerSign(int employerSign) {
		this.employerSign = employerSign;
	}

	public int getMilitaryPersonnelSign() {
		return militaryPersonnelSign;
	}

	public void setMilitaryPersonnelSign(int militaryPersonnelSign) {
		this.militaryPersonnelSign = militaryPersonnelSign;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public long getDesignatedMedicalInstitutionCode() {
		return designatedMedicalInstitutionCode;
	}

	public void setDesignatedMedicalInstitutionCode(long designatedMedicalInstitutionCode) {
		this.designatedMedicalInstitutionCode = designatedMedicalInstitutionCode;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getOutlookName() {
		return outlookName;
	}

	public void setOutlookName(String outlookName) {
		this.outlookName = outlookName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getPersonnelCategoryName() {
		return personnelCategoryName;
	}

	public void setPersonnelCategoryName(String personnelCategoryName) {
		this.personnelCategoryName = personnelCategoryName;
	}

	@Override
	public String toString() {
		return "PersonInfo4 [id=" + id + ", personId=" + personId + ", certificateId=" + certificateId
				+ ", certificateNumber=" + certificateNumber + ", name=" + name + ", gender=" + gender + ", nationId="
				+ nationId + ", nationName=" + nationName + ", birthdate=" + birthdate + ", participationDate="
				+ participationDate + ", retirementDate=" + retirementDate + ", retirementStatus=" + retirementStatus
				+ ", accountNature=" + accountNature + ", accountLocation=" + accountLocation + ", degreeId=" + degreeId
				+ ", degreeName=" + degreeName + ", outlookId=" + outlookId + ", outlookName=" + outlookName
				+ ", identity=" + identity + ", employmentForm=" + employmentForm + ", specializedTechnicalJob="
				+ specializedTechnicalJob + ", nvql=" + nvql + ", maritalStatus=" + maritalStatus + ", dutyId=" + dutyId
				+ ", dutyName=" + dutyName + ", remarks=" + remarks + ", companyCode=" + companyCode
				+ ", personnelCategoryId=" + personnelCategoryId + ", personnelCategoryName=" + personnelCategoryName
				+ ", healthStatus=" + healthStatus + ", lamorSign=" + lamorSign + ", cadreSign=" + cadreSign
				+ ", civilServantSign=" + civilServantSign + ", establishmentSign=" + establishmentSign
				+ ", residentSign=" + residentSign + ", flexibleEmploymentSign=" + flexibleEmploymentSign
				+ ", migrantWorkerSign=" + migrantWorkerSign + ", employerSign=" + employerSign
				+ ", militaryPersonnelSign=" + militaryPersonnelSign + ", socialSecurityNumber=" + socialSecurityNumber
				+ ", designatedMedicalInstitutionCode=" + designatedMedicalInstitutionCode + "]";
	}

}
