package com.neuedu.service.implement;

import java.util.List;

import com.neuedu.dao.OperatorDao;
import com.neuedu.dao.implement.OperatorDaoImpl;
import com.neuedu.entity.OperatorInfo;
import com.neuedu.service.OperatorService;

public class OperatorServiceImpl implements OperatorService {
	OperatorDao dao = new OperatorDaoImpl();
	
	@Override
	public boolean register(OperatorInfo operator) {
		if (dao.getByJobNumber(operator.getJobNumber()) == null) {
			return dao.add(operator);
		} else {
			return false;
		}
		
	}

	@Override
	public boolean login(OperatorInfo operator) {
		if (dao.getByJobNumber(operator.getJobNumber()) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modify(OperatorInfo operator) {
			boolean isSuccess = dao.modify(operator);
			if (isSuccess) {
				return true;
			}else {
				return false;
			}
	}

	@Override
	public boolean qurryAll() {
        List<OperatorInfo> oper = dao.qurryAll();
		
		return oper != null;
	}

	@Override
	public OperatorInfo get(String jobNumber) {
		return dao.getByJobNumber(jobNumber);
	}

	@Override
	public boolean modifyPwd(String jobNumber, String operatorPwd) {
		boolean isSuccess = dao.modifyPwd(jobNumber, operatorPwd);
		if (isSuccess) {
			return true;
		} else {
			return false;
		}
	}

}
