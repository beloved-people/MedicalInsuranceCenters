package com.neuedu.entity;

public class DosageForm {
	private String dosageFormId;
	  private String dosageFormName;


	  public DosageForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	  

	public DosageForm(String dosageFormId, String dosageFormName) {
		super();
		this.dosageFormId = dosageFormId;
		this.dosageFormName = dosageFormName;
	}


	public String getDosageFormId() {
	    return dosageFormId;
	  }

	  public void setDosageFormId(String dosageFormId) {
	    this.dosageFormId = dosageFormId;
	  }


	  public String getDosageFormName() {
	    return dosageFormName;
	  }

	  public void setDosageFormName(String dosageFormName) {
	    this.dosageFormName = dosageFormName;
	  }
}
