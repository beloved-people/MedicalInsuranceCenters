package com.neuedu.service.implement;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.DiseaseDao;
import com.neuedu.dao.implement.DiseaseDaoImpl;
import com.neuedu.entity.DiseaseInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DiseaseService;

public class DiseaseServiceImpl implements DiseaseService{
	DiseaseDao dao = new DiseaseDaoImpl();
	@Override
	public boolean add(DiseaseInfo diseaseInfo) {
		if (dao.get(diseaseInfo.getDiseaseCode())!=null) {
			boolean isSuccess = dao.add(diseaseInfo);
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
	public PageBean<DiseaseInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition) {
		//��������ת��
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //����PageBean����
        PageBean<DiseaseInfo> pb = new PageBean<>();
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
        List<DiseaseInfo> list = dao.getAllByPage(start, newRows, condition);
        pb.setList(list);
        return pb;
	}

	@Override
	public boolean delete(String diseaseCode) {
		boolean isSuccess = dao.delete(diseaseCode);
		return isSuccess;
	}

	@Override
	public boolean update(DiseaseInfo diseaseInfo) {
		if (dao.get(diseaseInfo.getDiseaseCode())!=null) {
			boolean isSuccess = dao.update(diseaseInfo);
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
