package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;

public interface DiagnosisAndTreatmentProjectDao {
	int getTotalCount(Map<String, String[]> condition);
	List<DiagnosisAndTreatmentProjectInfo> getAllByPage(int start, int rows, Map<String, String[]> condition);
	boolean add(DiagnosisAndTreatmentProjectInfo dtp);//���
	boolean delete(long projectCode);//ɾ��
	DiagnosisAndTreatmentProjectInfo get(long projectCode);
	boolean update(DiagnosisAndTreatmentProjectInfo dtp);
	DiagnosisAndTreatmentProjectInfo seldia(long projectCode);
}
