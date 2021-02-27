package com.neuedu.entity;

public class OperatorInfo {
	private int operatorId;
	  private String operatorAccount;
	  private String operatorName;
	  private String operatorGender;
	  private String jobNumber;
	  private String operatorPwd;
	  
	public OperatorInfo() {
		super();
	}

	public OperatorInfo(int operatorId, String operatorAccount, String operatorName, String operatorGender,
			String jobNumber, String operatorPwd) {
		super();
		this.operatorId = operatorId;
		this.operatorAccount = operatorAccount;
		this.operatorName = operatorName;
		this.operatorGender = operatorGender;
		this.jobNumber = jobNumber;
		this.operatorPwd = operatorPwd;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorAccount() {
		return operatorAccount;
	}

	public void setOperatorAccount(String operatorAccount) {
		this.operatorAccount = operatorAccount;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorGender() {
		return operatorGender;
	}

	public void setOperatorGender(String operatorGender) {
		this.operatorGender = operatorGender;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getOperatorPwd() {
		return operatorPwd;
	}

	public void setOperatorPwd(String operatorPwd) {
		this.operatorPwd = operatorPwd;
	}
	  
	  
}
