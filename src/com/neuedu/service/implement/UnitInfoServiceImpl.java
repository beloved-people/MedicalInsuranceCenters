package com.neuedu.service.implement;


import com.neuedu.dao.UnitInfoDao;
import com.neuedu.dao.implement.UnitInfoDaoImpl;
import com.neuedu.entity.PageBean4;
import com.neuedu.entity.UnitInfo4;
import com.neuedu.service.UnitInfoService;

public class UnitInfoServiceImpl implements UnitInfoService {

	@Override
	public boolean add(UnitInfo4 ui) {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		if(uid.add(ui))
			return true;
		else
			return false;
		
	}

	@Override
	public boolean del(long id) {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		if(uid.del(id))
			return true;
		else
			return false;
	}

	@Override
	public UnitInfo4 getByIdAndName(long id, String name) {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		UnitInfo4 ui = new UnitInfo4();
		ui = uid.getByIdAndName(id, name);
		if(ui!=null)
			return ui;
		else 
			return null;
	}

	@Override
	public boolean modify(UnitInfo4 ui) {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		if(uid.modify(ui))
			return true;
		else
			return false;
	}

	@Override
	public int getTotalCount() {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		
		return uid.getTotalCount();
	}

	@Override
	public void getAll(PageBean4<UnitInfo4> pageBean) {
		UnitInfoDao uid = new UnitInfoDaoImpl();
		uid.getAll(pageBean);
	}

}
