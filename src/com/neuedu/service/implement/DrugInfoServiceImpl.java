package com.neuedu.service.implement;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.implement.DrugInfoDaoImpl;
import com.neuedu.entity.DrugInfo;
import com.neuedu.entity.PageBean;
import com.neuedu.service.DrugInfoService;

public class DrugInfoServiceImpl implements DrugInfoService {
	
	@Override
	public boolean add(DrugInfo drug) {
		DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
		if(ddi.getbydc(drug.getDc()) == null) {
			return ddi.add(drug);
		}
		else
		{
			return false;
		}	
	}

	@Override
	public boolean delete(long dc) {
		DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
		return ddi.del(dc);
		
	}

	@Override
	public boolean inquire() {
		DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
		List<DrugInfo> drug1 = ddi.qurryAll();
		return drug1 != null;
	}

	@Override
	public boolean modify(DrugInfo drug) {
		DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
		ddi.modify(drug);
		return false;
	}

	@Override
	public PageBean<DrugInfo> findByPageBean(String currentPage, String rows, Map<String, String[]> condition) {
		DrugInfoDaoImpl ddi = new DrugInfoDaoImpl();
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        PageBean<DrugInfo> pb = new PageBean<>();
        pb.setCurrentPage(newCurrentPage);
        pb.setRows(newRows);
        int totalCount = ddi.getTotalCount(condition);
        pb.setTotalCount(totalCount);
        int totalPage = totalCount % newRows == 0 ? totalCount / newRows : totalCount / newRows+ 1;
        pb.setTotalPage(totalPage);
        int start = (newCurrentPage - 1) * newRows;
        List<DrugInfo> list = ddi.getAllByPage(start, newRows, condition);
        pb.setList(list);
        
		return pb;
	}

}
