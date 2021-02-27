package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neuedu.dao.ServiceFacilityDao;
import com.neuedu.entity.ServiceFacilityInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class ServiceFacilityDaoImpl implements ServiceFacilityDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	{
		conn = Dbutil.getConnection();
	}
	@Override
	public boolean add(ServiceFacilityInfo serviceFacilityInfo) {
		
		try {
			String sql = "insert into medical_insurance.service_facility_info(medicalServiceFacilityCode, serviceFacilitiesName, remarks, restrictedUsingScope)\r\n" + 
					"                                             values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, serviceFacilityInfo.getMedicalServiceFacilityCode());
			ps.setString(2, serviceFacilityInfo.getServiceFacilitiesName());
			ps.setString(3, serviceFacilityInfo.getRemarks());
			ps.setString(4, serviceFacilityInfo.getRestrictedUsingScope());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
	@Override
	public ServiceFacilityInfo get(long medicalServiceFacilityCode) {
		String sql = "select medicalServiceFacilityCode, serviceFacilitiesName, chargeCategory, remarks, restrictedUsingScope\r\n" + 
				"  from medical_insurance.service_facility_info\r\n" + 
				" where medicalServiceFacilityCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, medicalServiceFacilityCode);
			rs = ps.executeQuery();
			ServiceFacilityInfo sf = new ServiceFacilityInfo();
			while (rs.next()) {
				sf.setMedicalServiceFacilityCode(rs.getLong("medicalServiceFacilityCode"));
				sf.setServiceFacilitiesName(rs.getString("serviceFacilitiesName"));
				sf.setChargeCategory(rs.getString("chargeCategory"));
				sf.setRemarks(rs.getString("remarks"));
				sf.setRestrictedUsingScope(rs.getString("restrictedUsingScope"));
			}
			return sf;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public int getTotalCount(Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.service_facility_info\r\n" + 
				" where 1=1 ";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if(condition!=null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey()) || "operatorAccount".equals(entry.getKey())) {
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
	public List<ServiceFacilityInfo> getAllByPage(int start, int rows, Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.service_facility_info\r\n" + 
				" where 1=1 ";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if (condition != null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey()) || "operatorAccount".equals(entry.getKey())) {
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
			List<ServiceFacilityInfo> listServiceFacility = new ArrayList<ServiceFacilityInfo>();
			try {
				ps = conn.prepareStatement(sql);
				for (int i = 1; i <= list.size(); i++) {
					ps.setString(i, "%"+list.get(i-1)+"%");	
				}
				rs = ps.executeQuery();
				while (rs.next()) {
					ServiceFacilityInfo serviceFacilityInfo = new ServiceFacilityInfo();
					serviceFacilityInfo.setMedicalServiceFacilityCode(rs.getLong("medicalServiceFacilityCode"));
					serviceFacilityInfo.setServiceFacilitiesName(rs.getString("serviceFacilitiesName"));
					serviceFacilityInfo.setChargeCategory(rs.getString("chargeCategory"));
					serviceFacilityInfo.setRemarks(rs.getString("remarks"));
					serviceFacilityInfo.setRestrictedUsingScope(rs.getString("restrictedUsingScope"));
					listServiceFacility.add(serviceFacilityInfo);
				}
				return listServiceFacility;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	@Override
	public boolean delete(long medicalServiceFacilityCode) {
		String sql = "delete\r\n" + 
				"  from medical_insurance.service_facility_info\r\n" + 
				" where medicalServiceFacilityCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, medicalServiceFacilityCode);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean update(ServiceFacilityInfo serviceFacilityInfo) {
		String sql = "update medical_insurance.service_facility_info\r\n" + 
				"   set serviceFacilitiesName = ?,\r\n" + 
				"       remarks = ?,\r\n" + 
				"       restrictedUsingScope = ?\r\n" + 
				" where medicalServiceFacilityCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, serviceFacilityInfo.getServiceFacilitiesName());
			ps.setString(2, serviceFacilityInfo.getRemarks());
			ps.setString(3, serviceFacilityInfo.getRestrictedUsingScope());
			ps.setLong(4, serviceFacilityInfo.getMedicalServiceFacilityCode());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
