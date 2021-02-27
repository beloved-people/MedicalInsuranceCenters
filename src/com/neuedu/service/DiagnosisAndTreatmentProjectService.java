package com.neuedu.service;

import java.util.Map;

import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;
import com.neuedu.entity.PageBean;

public interface DiagnosisAndTreatmentProjectService {
	PageBean<DiagnosisAndTreatmentProjectInfo> findDiagnosisAndTreatmentProjectByPage(String currentPage, String rows, Map<String, String[]> condition);
	boolean delete(long projectCode);
	boolean add(DiagnosisAndTreatmentProjectInfo dtp);//Ìí¼Ó
	boolean update(DiagnosisAndTreatmentProjectInfo dtp);//¸üÐÂ
}
