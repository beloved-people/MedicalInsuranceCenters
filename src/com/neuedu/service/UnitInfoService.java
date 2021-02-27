package com.neuedu.service;

import com.neuedu.entity.PageBean4;
import com.neuedu.entity.UnitInfo4;

public interface UnitInfoService {
	boolean add(UnitInfo4 ui);
	boolean del(long id);
	UnitInfo4 getByIdAndName(long id, String name);
	boolean modify(UnitInfo4 ui);
	int getTotalCount();
	void getAll(PageBean4<UnitInfo4> pageBean);
}
