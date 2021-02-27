package com.neuedu.entity;

public class Chufang {
	  private long dc;//药品编码 
	  private String medicineName;//药品名称
	  private long inpatientNumber;//住院号
	  private long projectCode;//项目编码
	  private double unitPrice;//单价
	  private int amount;//数量
	  private double sumMoney;//金额
	/**
	 * @return the dc
	 */
	public long getDc() {
		return dc;
	}
	/**
	 * @param dc the dc to set
	 */
	public void setDc(long dc) {
		this.dc = dc;
	}
	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * @param medicineName the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	/**
	 * @return the inpatientNumber
	 */
	public long getInpatientNumber() {
		return inpatientNumber;
	}
	/**
	 * @param inpatientNumber the inpatientNumber to set
	 */
	public void setInpatientNumber(long inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}
	/**
	 * @return the projectCode
	 */
	public long getProjectCode() {
		return projectCode;
	}
	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the sumMoney
	 */
	public double getSumMoney() {
		return sumMoney;
	}
	/**
	 * @param sumMoney the sumMoney to set
	 */
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public Chufang(long dc, String medicineName, long inpatientNumber, long projectCode, double unitPrice, int amount,
			double sumMoney) {
		super();
		this.dc = dc;
		this.medicineName = medicineName;
		this.inpatientNumber = inpatientNumber;
		this.projectCode = projectCode;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.sumMoney = sumMoney;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chufang [dc=" + dc + ", medicineName=" + medicineName + ", inpatientNumber=" + inpatientNumber
				+ ", projectCode=" + projectCode + ", unitPrice=" + unitPrice + ", amount=" + amount + ", sumMoney="
				+ sumMoney + "]";
	}
	  
}
