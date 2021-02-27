package com.neuedu.service.implement;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.DiagnosisAndTreatmentProjectDao;
import com.neuedu.dao.implement.DiagnosisAndTreatmentProjectDaoImpl;
import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DiagnosisAndTreatmentProjectService;

public class DiagnosisAndTreatmentProjectServiceImpl implements DiagnosisAndTreatmentProjectService{
	DiagnosisAndTreatmentProjectDao dao = new DiagnosisAndTreatmentProjectDaoImpl();
	@Override
	public PageBean<DiagnosisAndTreatmentProjectInfo> findDiagnosisAndTreatmentProjectByPage(String currentPage,
			String rows, Map<String, String[]> condition) {
		//��������ת��
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //����PageBean����
        PageBean<DiagnosisAndTreatmentProjectInfo> pb = new PageBean<>();
        //���ò���
        pb.setCurrentPage(newCurrentPage);
        pb.setRows(newRows);
        //����dao��ѯ�ܼ�¼��
        int totalCount = dao.getTotalCount(condition);
        pb.setTotalCount(totalCount);
        //������ҳ��
        int totalPage = totalCount % newRows == 0 ? totalCount / newRows : totalCount / newRows+ 1;
        pb.setTotalPage(totalPage);
        //����dao��ѯList����
        int start = (newCurrentPage - 1) * newRows;
        List<DiagnosisAndTreatmentProjectInfo> list = dao.getAllByPage(start, newRows, condition);
        pb.setList(list);
        return pb;
	}
	@Override
	public boolean delete(long projectCode) {
		boolean isSuccess = dao.delete(projectCode);
		return isSuccess;
	}
	@Override
	public boolean add(DiagnosisAndTreatmentProjectInfo dtp) {
		if (dao.get(dtp.getProjectCode())!=null) {
			boolean isSuccess = dao.add(dtp);
			if (isSuccess) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		
	}
	@Override
	public boolean update(DiagnosisAndTreatmentProjectInfo dtp) {
		if (dao.get(dtp.getProjectCode())!=null) {
			boolean isSuccess = dao.update(dtp);
			if (isSuccess) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
