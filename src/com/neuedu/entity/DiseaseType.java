package com.neuedu.entity;

public class DiseaseType {
	  private String diseaseTypeId;
	  private String diseaseTypeName;
	  
	  

	  public DiseaseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	  

	public DiseaseType(String diseaseTypeId, String diseaseTypeName) {
		super();
		this.diseaseTypeId = diseaseTypeId;
		this.diseaseTypeName = diseaseTypeName;
	}


	public String getDiseaseTypeId() {
	    return diseaseTypeId;
	  }

	  public void setDiseaseTypeId(String diseaseTypeId) {
	    this.diseaseTypeId = diseaseTypeId;
	  }


	  public String getDiseaseTypeName() {
	    return diseaseTypeName;
	  }

	  public void setDiseaseTypeName(String diseaseTypeName) {
	    this.diseaseTypeName = diseaseTypeName;
	  }
}
