package com.neuedu.entity;

public class Nation {
	private String nationId;
	  private String nationName;
	public Nation(String nationId, String nationName) {
		super();
		this.nationId = nationId;
		this.nationName = nationName;
	}
	public Nation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNationId() {
		return nationId;
	}
	public void setNationId(String nationId) {
		this.nationId = nationId;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	  
	  
}
