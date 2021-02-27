package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.ServiceFacilityInfo;

public interface ServiceFacilityDao {
	boolean add(ServiceFacilityInfo serviceFacilityInfo);
	ServiceFacilityInfo get(long medicalServiceFacilityCode);
	int getTotalCount(Map<String, String[]> condition);
	List<ServiceFacilityInfo> getAllByPage(int start, int rows, Map<String, String[]> condition);
	boolean delete(long medicalServiceFacilityCode);
	boolean update(ServiceFacilityInfo serviceFacilityInfo);
}