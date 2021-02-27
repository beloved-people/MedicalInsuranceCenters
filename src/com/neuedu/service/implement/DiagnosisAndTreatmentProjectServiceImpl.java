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
		//数据类型转换
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //创建PageBean对象
        PageBean<DiagnosisAndTreatmentProjectInfo> pb = new PageBean<>();
        //设置参数
        pb.setCurrentPage(newCurrentPage);
        pb.setRows(newRows);
        //调用dao查询总记录数
        int totalCount = dao.getTotalCount(condition);
        pb.setTotalCount(totalCount);
        //计算总页数
        int totalPage = totalCount % newRows == 0 ? totalCount / newRows : totalCount / newRows+ 1;
        pb.setTotalPage(totalPage);
        //调用dao查询List集合
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
