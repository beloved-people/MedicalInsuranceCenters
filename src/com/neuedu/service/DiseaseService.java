package com.neuedu.service;

import java.util.Map;

import com.neuedu.entity.DiseaseInfo;
import com.neuedu.entity.PageBean;

public interface DiseaseService {
	boolean add(DiseaseInfo diseaseInfo);
	PageBean<DiseaseInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition);
	boolean delete(String diseaseCode);
	boolean update(DiseaseInfo diseaseInfo);
}	
