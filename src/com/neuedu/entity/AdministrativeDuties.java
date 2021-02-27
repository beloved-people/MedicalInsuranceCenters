package com.neuedu.entity;

public class AdministrativeDuties {
	private String dutyId;
	  private String dutyName;
	public AdministrativeDuties(String dutyId, String dutyName) {
		super();
		this.dutyId = dutyId;
		this.dutyName = dutyName;
	}
	public AdministrativeDuties() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDutyId() {
		return dutyId;
	}
	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	  
	  
}
