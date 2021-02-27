package com.neuedu.service.implement;



import com.neuedu.dao.PersonInfoDao;
import com.neuedu.dao.implement.PersonInfoDaoImpl4;
import com.neuedu.entity.PageBean4;
import com.neuedu.entity.PersonInfo4;
import com.neuedu.service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {

	@Override
	public boolean add(PersonInfo4 pi) {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		if(pid.add(pi))
			return true;
		else
			return false;
	}

	@Override
	public boolean del(int id) {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		if(pid.del(id))
			return true;
		else
			return false;
	}

	@Override
	public PersonInfo4 getByIdAndName(String id, String name) {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		return pid.getByIdAndName(id, name);
	}

	@Override
	public boolean modify(PersonInfo4 pi) {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		if(pid.modify(pi))
			return true;
		else
			return false;
	}

	@Override
	public int getTotalCount() {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		
		return pid.getTotalCount();
	}

	@Override
	public void getAll(PageBean4<PersonInfo4> pageBean) {
		PersonInfoDao pid = new PersonInfoDaoImpl4();
		pid.getAll(pageBean);
	}

}
