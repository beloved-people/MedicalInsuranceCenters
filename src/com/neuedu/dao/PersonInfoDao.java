package com.neuedu.dao;


import com.neuedu.entity.PageBean4;
import com.neuedu.entity.PersonInfo;
import com.neuedu.entity.PersonInfo4;

public interface PersonInfoDao {
	boolean add(PersonInfo4 pi);
	boolean del(int id);
	PersonInfo4 getByIdAndName(String id, String name);
	boolean modify(PersonInfo4 pi);
	int getTotalCount();
	void getAll(PageBean4<PersonInfo4> pageBean);
	PersonInfo selName(String person);
}
