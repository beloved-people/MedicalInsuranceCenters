package com.neuedu.entity;

public class OperationRecord {
	private int id;
	  private int operatorId;
	  private String loginDatetime;
	  private String logoutDatetime;
	  
	public OperationRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationRecord(int id, int operatorId, String loginDatetime, String logoutDatetime) {
		super();
		this.id = id;
		this.operatorId = operatorId;
		this.loginDatetime = loginDatetime;
		this.logoutDatetime = logoutDatetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getLoginDatetime() {
		return loginDatetime;
	}

	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}

	public String getLogoutDatetime() {
		return logoutDatetime;
	}

	public void setLogoutDatetime(String logoutDatetime) {
		this.logoutDatetime = logoutDatetime;
	}
	  
	  
	  
	  
}
