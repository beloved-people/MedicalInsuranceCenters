package com.neuedu.entity;

public class Usages {
	private String usageId;
	  private String usageName;
	public Usages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usages(String usageId, String usageName) {
		super();
		this.usageId = usageId;
		this.usageName = usageName;
	}
	public String getUsageId() {
		return usageId;
	}
	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}
	public String getUsageName() {
		return usageName;
	}
	public void setUsageName(String usageName) {
		this.usageName = usageName;
	}
	  
	  
}
