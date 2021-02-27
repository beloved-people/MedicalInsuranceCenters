package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.DrugInfo;

public interface DrugInfoDao 
{
	boolean add(DrugInfo drug);
	boolean del(long dc);
	boolean modify(DrugInfo drug);
	List<DrugInfo> qurryAll();
	DrugInfo getbydc(long dc);
	int getTotalCount (Map<String, String[]> condition);
	List<DrugInfo> getAllByPage(int start, int rows, Map<String, String[]> condition);
}
