package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.OperatorInfo;

public interface OperatorDao {
	OperatorInfo getByJobNumber(String jobNumber);
	boolean add(OperatorInfo operator);
	boolean modify(OperatorInfo operator);
	boolean modifyPwd(String jobNumber,String operatorPwd);
	List<OperatorInfo> qurryAll();
}
