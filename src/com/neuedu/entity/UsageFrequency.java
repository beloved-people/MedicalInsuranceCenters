package com.neuedu.entity;

public class UsageFrequency {
	private String usageFrequencyId;
	  private String usageFrequencyName;

	  
	  public UsageFrequency() {
		super();
		// TODO Auto-generated constructor stub
	}

	  
	public UsageFrequency(String usageFrequencyId, String usageFrequencyName) {
		super();
		this.usageFrequencyId = usageFrequencyId;
		this.usageFrequencyName = usageFrequencyName;
	}

	public String getUsageFrequencyId() {
	    return usageFrequencyId;
	  }

	  public void setUsageFrequencyId(String usageFrequencyId) {
	    this.usageFrequencyId = usageFrequencyId;
	  }


	  public String getUsageFrequencyName() {
	    return usageFrequencyName;
	  }

	  public void setUsageFrequencyName(String usageFrequencyName) {
	    this.usageFrequencyName = usageFrequencyName;
	  }
}
