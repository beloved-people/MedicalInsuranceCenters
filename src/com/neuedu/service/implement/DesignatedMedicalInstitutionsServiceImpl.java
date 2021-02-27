package com.neuedu.service.implement;


import java.util.List;
import java.util.Map;

import com.neuedu.dao.DesignatedMedicalInstitutionsDao;
import com.neuedu.dao.implement.DesignatedMedicalInstitutionsDaoImpl;
import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DesignatedMedicalInstitutionsService;

public class DesignatedMedicalInstitutionsServiceImpl implements DesignatedMedicalInstitutionsService{
	DesignatedMedicalInstitutionsDao dao = new DesignatedMedicalInstitutionsDaoImpl();
	@Override
	public boolean add(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo) {
		if (dao.get(designatedMedicalInstitutionsInfo.getDesignatedMedicalInstitutionCode())!=null) {
			boolean isSuccess = dao.add(designatedMedicalInstitutionsInfo);
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
	public PageBean<DesignatedMedicalInstitutionsInfo> findByPageBean(String currentPage, String rows,
			Map<String, String[]> condition) {
		//��������ת��
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //����PageBean����
        PageBean<DesignatedMedicalInstitutionsInfo> pb = new PageBean<>();
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
        List<DesignatedMedicalInstitutionsInfo> list = dao.getAllByPage(start, newRows, condition);
        pb.setList(list);
        return pb;
	}
	@Override
	public boolean delete(long designatedMedicalInstitutionsInfo) {
		boolean isSuccess = dao.delete(designatedMedicalInstitutionsInfo);
		return isSuccess;
	}
	@Override
	public boolean update(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo) {
		if (dao.get(designatedMedicalInstitutionsInfo.getDesignatedMedicalInstitutionCode())!=null) {
			boolean isSuccess = dao.update(designatedMedicalInstitutionsInfo);
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
