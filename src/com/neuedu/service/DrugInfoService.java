package com.neuedu.service;

import java.util.Map;

import com.neuedu.entity.DrugInfo;
import com.neuedu.entity.PageBean;

public interface DrugInfoService {
	boolean add(DrugInfo drug);
	boolean delete(long dc);
	boolean inquire();
	boolean modify(DrugInfo drug);
	PageBean<DrugInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition);
}
