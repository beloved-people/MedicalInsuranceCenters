package com.neuedu.service;

import java.util.Map;

import com.neuedu.entity.PageBean;
import com.neuedu.entity.ServiceFacilityInfo;

public interface ServiceFacilityService {
	boolean add(ServiceFacilityInfo serviceFacilityInfo);
	PageBean<ServiceFacilityInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition);
	boolean delete(long medicalServiceFacilityCode);
	boolean update(ServiceFacilityInfo serviceFacilityInfo);
}
