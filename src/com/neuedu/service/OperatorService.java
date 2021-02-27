package com.neuedu.service;


import com.neuedu.entity.OperatorInfo;

public interface OperatorService {
	boolean login(OperatorInfo operator);
	boolean register(OperatorInfo operator);
	boolean modify(OperatorInfo operator);
	boolean modifyPwd(String jobNumber,String operatorPwd);
	OperatorInfo get(String jobNumber);
	boolean qurryAll();
}
