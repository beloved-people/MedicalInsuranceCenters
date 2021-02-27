package com.neuedu.entity;

public class DrugInfo {
	  private long dc;
	  private String medicineName;
	  private String medicineEnglishName;
	  private int chargeCategory;
	  private int prescriptionDrugMark;
	  private int chargingItemLevel;
	  private int drugDosageUnit;
	  private double maximumPrice;
	  private int inHospitalPreparationMark;
	  private String approvalMarkRequired;
	  private int hospitalLevel;
	  private String dosageFormId;
	  private String usageFrequencyId;
	  private String usageId;
	  private int unit;
	  private String specification;
	  private int limitedDays;
	  private String drugTradeName;
	  private String pharmaceuticalFactory;
	  private String chineseMedicineQuasiCharacter;
	  private String remarks;
	  private String nationalCatalogCode;
	  private String restrictedUsingScope;
	  private String placeOfProduction;
	  
	public DrugInfo() {
		super();
	}

	public DrugInfo(long dc, String medicineName, String medicineEnglishName, int chargeCategory,
			int prescriptionDrugMark, int chargingItemLevel, int drugDosageUnit, double maximumPrice,
			int inHospitalPreparationMark, String approvalMarkRequired, int hospitalLevel, String dosageFormId,
			String usageFrequencyId, String usageId, int unit, String specification, int limitedDays,
			String drugTradeName, String pharmaceuticalFactory, String chineseMedicineQuasiCharacter, String remarks,
			String nationalCatalogCode, String restrictedUsingScope, String placeOfProduction) {
		super();
		this.dc = dc;
		this.medicineName = medicineName;
		this.medicineEnglishName = medicineEnglishName;
		this.chargeCategory = chargeCategory;
		this.prescriptionDrugMark = prescriptionDrugMark;
		this.chargingItemLevel = chargingItemLevel;
		this.drugDosageUnit = drugDosageUnit;
		this.maximumPrice = maximumPrice;
		this.inHospitalPreparationMark = inHospitalPreparationMark;
		this.approvalMarkRequired = approvalMarkRequired;
		this.hospitalLevel = hospitalLevel;
		this.dosageFormId = dosageFormId;
		this.usageFrequencyId = usageFrequencyId;
		this.usageId = usageId;
		this.unit = unit;
		this.specification = specification;
		this.limitedDays = limitedDays;
		this.drugTradeName = drugTradeName;
		this.pharmaceuticalFactory = pharmaceuticalFactory;
		this.chineseMedicineQuasiCharacter = chineseMedicineQuasiCharacter;
		this.remarks = remarks;
		this.nationalCatalogCode = nationalCatalogCode;
		this.restrictedUsingScope = restrictedUsingScope;
		this.placeOfProduction = placeOfProduction;
	}

	public long getDc() {
		return dc;
	}

	public void setDc(long dc) {
		this.dc = dc;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineEnglishName() {
		return medicineEnglishName;
	}

	public void setMedicineEnglishName(String medicineEnglishName) {
		this.medicineEnglishName = medicineEnglishName;
	}

	public int getChargeCategory() {
		return chargeCategory;
	}

	public void setChargeCategory(int chargeCategory) {
		this.chargeCategory = chargeCategory;
	}

	public int getPrescriptionDrugMark() {
		return prescriptionDrugMark;
	}

	public void setPrescriptionDrugMark(int prescriptionDrugMark) {
		this.prescriptionDrugMark = prescriptionDrugMark;
	}

	public int getChargingItemLevel() {
		return chargingItemLevel;
	}

	public void setChargingItemLevel(int chargingItemLevel) {
		this.chargingItemLevel = chargingItemLevel;
	}

	public int getDrugDosageUnit() {
		return drugDosageUnit;
	}

	public void setDrugDosageUnit(int drugDosageUnit) {
		this.drugDosageUnit = drugDosageUnit;
	}

	public double getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public int getInHospitalPreparationMark() {
		return inHospitalPreparationMark;
	}

	public void setInHospitalPreparationMark(int inHospitalPreparationMark) {
		this.inHospitalPreparationMark = inHospitalPreparationMark;
	}

	public String getApprovalMarkRequired() {
		return approvalMarkRequired;
	}

	public void setApprovalMarkRequired(String approvalMarkRequired) {
		this.approvalMarkRequired = approvalMarkRequired;
	}

	public int getHospitalLevel() {
		return hospitalLevel;
	}

	public void setHospitalLevel(int hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	public String getDosageFormId() {
		return dosageFormId;
	}

	public void setDosageFormId(String dosageFormId) {
		this.dosageFormId = dosageFormId;
	}

	public String getUsageFrequencyId() {
		return usageFrequencyId;
	}

	public void setUsageFrequencyId(String usageFrequencyId) {
		this.usageFrequencyId = usageFrequencyId;
	}

	public String getUsageId() {
		return usageId;
	}

	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getLimitedDays() {
		return limitedDays;
	}

	public void setLimitedDays(int limitedDays) {
		this.limitedDays = limitedDays;
	}

	public String getDrugTradeName() {
		return drugTradeName;
	}

	public void setDrugTradeName(String drugTradeName) {
		this.drugTradeName = drugTradeName;
	}

	public String getPharmaceuticalFactory() {
		return pharmaceuticalFactory;
	}

	public void setPharmaceuticalFactory(String pharmaceuticalFactory) {
		this.pharmaceuticalFactory = pharmaceuticalFactory;
	}

	public String getChineseMedicineQuasiCharacter() {
		return chineseMedicineQuasiCharacter;
	}

	public void setChineseMedicineQuasiCharacter(String chineseMedicineQuasiCharacter) {
		this.chineseMedicineQuasiCharacter = chineseMedicineQuasiCharacter;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getNationalCatalogCode() {
		return nationalCatalogCode;
	}

	public void setNationalCatalogCode(String nationalCatalogCode) {
		this.nationalCatalogCode = nationalCatalogCode;
	}

	public String getRestrictedUsingScope() {
		return restrictedUsingScope;
	}

	public void setRestrictedUsingScope(String restrictedUsingScope) {
		this.restrictedUsingScope = restrictedUsingScope;
	}

	public String getPlaceOfProduction() {
		return placeOfProduction;
	}

	public void setPlaceOfProduction(String placeOfProduction) {
		this.placeOfProduction = placeOfProduction;
	}

	@Override
	public String toString() {
		return "DrugInfo [dc=" + dc + ", medicineName=" + medicineName + ", medicineEnglishName=" + medicineEnglishName
				+ ", chargeCategory=" + chargeCategory + ", prescriptionDrugMark=" + prescriptionDrugMark
				+ ", chargingItemLevel=" + chargingItemLevel + ", drugDosageUnit=" + drugDosageUnit + ", maximumPrice="
				+ maximumPrice + ", inHospitalPreparationMark=" + inHospitalPreparationMark + ", approvalMarkRequired="
				+ approvalMarkRequired + ", hospitalLevel=" + hospitalLevel + ", dosageFormId=" + dosageFormId
				+ ", usageFrequencyId=" + usageFrequencyId + ", usageId=" + usageId + ", unit=" + unit
				+ ", specification=" + specification + ", limitedDays=" + limitedDays + ", drugTradeName="
				+ drugTradeName + ", pharmaceuticalFactory=" + pharmaceuticalFactory
				+ ", chineseMedicineQuasiCharacter=" + chineseMedicineQuasiCharacter + ", remarks=" + remarks
				+ ", nationalCatalogCode=" + nationalCatalogCode + ", restrictedUsingScope=" + restrictedUsingScope
				+ ", placeOfProduction=" + placeOfProduction + "]";
	}
	  
	  
	  
	  
	  

}
