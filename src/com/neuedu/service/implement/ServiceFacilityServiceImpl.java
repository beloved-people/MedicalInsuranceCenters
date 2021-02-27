package com.neuedu.service.implement;


import java.util.List;
import java.util.Map;

import com.neuedu.dao.ServiceFacilityDao;
import com.neuedu.dao.implement.ServiceFacilityDaoImpl;
import com.neuedu.entity.PageBean;
import com.neuedu.entity.ServiceFacilityInfo;
import com.neuedu.service.ServiceFacilityService;

public class ServiceFacilityServiceImpl implements ServiceFacilityService{
	ServiceFacilityDao dao = new ServiceFacilityDaoImpl();
	@Override
	public boolean add(ServiceFacilityInfo serviceFacilityInfo) {
		if (dao.get(serviceFacilityInfo.getMedicalServiceFacilityCode())!=null) {
			boolean isSuccess = dao.add(serviceFacilityInfo);
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
	public PageBean<ServiceFacilityInfo> findByPageBean(String currentPage, String rows,
			Map<String, String[]> condition) {
		//��������ת��
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //����PageBean����
        PageBean<ServiceFacilityInfo> pb = new PageBean<>();
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
        List<ServiceFacilityInfo> list = dao.getAllByPage(start, newRows, condition);
        pb.setList(list);
        return pb;
	}
	@Override
	public boolean delete(long medicalServiceFacilityCode) {
		boolean isSuccess = dao.delete(medicalServiceFacilityCode);
		return isSuccess;
	}
	@Override
	public boolean update(ServiceFacilityInfo serviceFacilityInfo) {
		if (dao.get(serviceFacilityInfo.getMedicalServiceFacilityCode())!=null) {
			boolean isSuccess = dao.update(serviceFacilityInfo);
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
