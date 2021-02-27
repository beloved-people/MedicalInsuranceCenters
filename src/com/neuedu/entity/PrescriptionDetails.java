package com.neuedu.entity;

public class PrescriptionDetails {
	private long inpatientNumber;
	  private long projectCode;
	  private double unitPrice;
	  private int amount;
	  private double sumMoney;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrescriptionDetails [inpatientNumber=" + inpatientNumber + ", projectCode=" + projectCode
				+ ", unitPrice=" + unitPrice + ", amount=" + amount + ", sumMoney=" + sumMoney + "]";
	}
	public PrescriptionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrescriptionDetails(long inpatientNumber, long projectCode, double unitPrice, int amount, double sumMoney) {
		super();
		this.inpatientNumber = inpatientNumber;
		this.projectCode = projectCode;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.sumMoney = sumMoney;
	}
	public long getInpatientNumber() {
		return inpatientNumber;
	}
	public void setInpatientNumber(long inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}
	public long getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	  
	  
}
