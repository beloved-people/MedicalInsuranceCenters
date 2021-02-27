package com.neuedu.service;

import java.util.Map;

import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;
import com.neuedu.entity.PageBean;

public interface DesignatedMedicalInstitutionsService {
	boolean add(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo);
	PageBean<DesignatedMedicalInstitutionsInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition);
	boolean delete(long designatedMedicalInstitutionsInfo);
	boolean update(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo);
}
