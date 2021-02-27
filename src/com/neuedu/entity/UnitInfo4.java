package com.neuedu.entity;

public class UnitInfo4 {
	private long companyCode;
	private String companyName;
	private int companyType;
	private String companyAddress;
	private String companyPostcode;
	private String companyContactNumber;
	public UnitInfo4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnitInfo4(long companyCode, String companyName, int companyType, String companyAddress,
			String companyPostcode, String companyContactNumber) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyType = companyType;
		this.companyAddress = companyAddress;
		this.companyPostcode = companyPostcode;
		this.companyContactNumber = companyContactNumber;
	}
	public long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyType() {
		return companyType;
	}
	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPostcode() {
		return companyPostcode;
	}
	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
	}
	public String getCompanyContactNumber() {
		return companyContactNumber;
	}
	public void setCompanyContactNumber(String companyContactNumber) {
		this.companyContactNumber = companyContactNumber;
	}
	@Override
	public String toString() {
		return "UnitInfo [companyCode=" + companyCode + ", companyName=" + companyName + ", companyType=" + companyType
				+ ", companyAddress=" + companyAddress + ", companyPostcode=" + companyPostcode
				+ ", companyContactNumber=" + companyContactNumber + "]";
	}
	
	
}
