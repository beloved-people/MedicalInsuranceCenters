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
		//数据类型转换
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        //创建PageBean对象
        PageBean<DesignatedMedicalInstitutionsInfo> pb = new PageBean<>();
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
