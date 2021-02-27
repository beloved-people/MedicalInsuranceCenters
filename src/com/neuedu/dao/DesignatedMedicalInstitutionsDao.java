package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;


public interface DesignatedMedicalInstitutionsDao {
	boolean add(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo);
	DesignatedMedicalInstitutionsInfo get(long designatedMedicalInstitutionCode);
	int getTotalCount(Map<String, String[]> condition);
	List<DesignatedMedicalInstitutionsInfo> getAllByPage(int start, int rows, Map<String, String[]> condition);
	boolean delete(long designatedMedicalInstitutionsInfo);
	boolean update(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo);
	DesignatedMedicalInstitutionsInfo sel(long designatedMedicalInstitutionCode);
}
