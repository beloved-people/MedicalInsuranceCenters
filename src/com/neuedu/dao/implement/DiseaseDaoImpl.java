package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neuedu.dao.DiseaseDao;
import com.neuedu.entity.DiseaseInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class DiseaseDaoImpl implements DiseaseDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	{
		conn = Dbutil.getConnection();
	}
	@Override
	public boolean add(DiseaseInfo diseaseInfo) {
		String sql = "insert into medical_insurance.disease_info(diseaseCode, diseaseName, diseaseTypeID, diseaseReimbursementSign, remarks)\r\n" + 
				"                                    values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, diseaseInfo.getDiseaseCode());
			ps.setString(2, diseaseInfo.getDiseaseName());
			ps.setString(3, diseaseInfo.getDiseaseTypeId());
			ps.setInt(4, diseaseInfo.getDiseaseReimbursementSign());
			ps.setString(5, diseaseInfo.getRemarks());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}

	@Override
	public DiseaseInfo get(String diseaseCode) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.disease_info\r\n" + 
				"  where diseaseCode=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, diseaseCode);
			rs = ps.executeQuery();
			DiseaseInfo disease = new DiseaseInfo();
			while (rs.next()) {			
				disease.setDiseaseCode(rs.getString("diseaseCode"));
			}
			return disease;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public int getTotalCount(Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.disease_info\r\n" + 
				" where 1=1 ";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if(condition!=null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey())) {
					continue;
				}
				String value = entry.getValue()[0];
				if (value != null) {
					sb.append(" and "+entry.getKey()+" like ? ");
					list.add(value);
				}
			}
		}
		sql = sb.toString();		
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= list.size(); i++) {
				ps.setString(i, "%"+list.get(i-1)+"%");
			}
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} 
	}

	@Override
	public List<DiseaseInfo> getAllByPage(int start, int rows, Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.disease_info\r\n" + 
				" where 1=1 ";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if (condition != null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey())) {
					continue;
				}
				String value = entry.getValue()[0];
				if (value != null) {
					sb.append(" and "+entry.getKey()+" like ?");
					list.add(value);
				}
			}
		}
			sb.append(" limit "+start+","+rows+"");
			sql = sb.toString();
			List<DiseaseInfo> listDiseaseInfo = new ArrayList<DiseaseInfo>();
			try {
				ps = conn.prepareStatement(sql);
				for (int i = 1; i <= list.size(); i++) {
					ps.setString(i, "%"+list.get(i-1)+"%");	
				}
				rs = ps.executeQuery();
				while (rs.next()) {
					DiseaseInfo d = new DiseaseInfo();
					d.setDiseaseCode(rs.getString("diseaseCode"));
					d.setDiseaseName(rs.getString("diseaseName"));
					d.setDiseaseTypeId(rs.getString("diseaseTypeId"));
					d.setDiseaseReimbursementSign(rs.getInt("diseaseReimbursementSign"));
					d.setRemarks(rs.getString("remarks"));
					listDiseaseInfo.add(d);
				}
				return listDiseaseInfo;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
	}

	@Override
	public boolean delete(String diseaseCode) {
		String sql = "delete\r\n" + 
				"  from medical_insurance.disease_info\r\n" + 
				" where diseaseCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, diseaseCode);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public boolean update(DiseaseInfo diseaseInfo) {
		String sql = "update medical_insurance.disease_info\r\n" + 
				"   set diseaseName = ?,\r\n" + 
				"       diseaseTypeID = ?,\r\n" + 
				"diseaseReimbursementSign = ?,\r\n" + 
				"            remarks = ?\r\n" + 
				" where diseaseCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, diseaseInfo.getDiseaseName());
			ps.setString(2, diseaseInfo.getDiseaseTypeId());
			ps.setInt(3, diseaseInfo.getDiseaseReimbursementSign());
			ps.setString(4, diseaseInfo.getRemarks());
			ps.setString(5, diseaseInfo.getDiseaseCode());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

}
