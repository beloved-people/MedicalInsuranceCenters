package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.DiseaseInfo;

public interface DiseaseDao {
	boolean add(DiseaseInfo diseaseInfo);
	DiseaseInfo get(String diseaseCode);
	int getTotalCount(Map<String, String[]> condition);
	List<DiseaseInfo> getAllByPage(int start, int rows, Map<String, String[]> condition);
	boolean delete(String diseaseCode);
	boolean update(DiseaseInfo diseaseInfo);
}
