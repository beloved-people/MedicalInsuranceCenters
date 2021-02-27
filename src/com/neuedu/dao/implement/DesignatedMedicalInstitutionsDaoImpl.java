package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neuedu.dao.DesignatedMedicalInstitutionsDao;
import com.neuedu.entity.DesignatedMedicalInstitutionsInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class DesignatedMedicalInstitutionsDaoImpl implements DesignatedMedicalInstitutionsDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	{
		conn = Dbutil.getConnection();
	}
	@Override
	public boolean add(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo) {
		String sql = "insert into medical_insurance.designated_medical_institutions_info(designatedMedicalInstitutionCode, serviceOrganizationName, hospitalLevel, medicalInstitutionTypeID, postcode, legalRepresentativeName, legalRepresentativeCellphoneNumber, concatName, contactNumber, concatCellphoneNumber, address, remarks)\r\n" + 
				"                                                            values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, designatedMedicalInstitutionsInfo.getDesignatedMedicalInstitutionCode());
			ps.setString(2, designatedMedicalInstitutionsInfo.getServiceOrganizationName());
			ps.setInt(3, designatedMedicalInstitutionsInfo.getHospitalLevel());
			ps.setString(4, designatedMedicalInstitutionsInfo.getMedicalInstitutionTypeId());
			ps.setString(5, designatedMedicalInstitutionsInfo.getPostcode());
			ps.setString(6, designatedMedicalInstitutionsInfo.getLegalRepresentativeName());
			ps.setString(7, designatedMedicalInstitutionsInfo.getLegalRepresentativeCellphoneNumber());
			ps.setString(8, designatedMedicalInstitutionsInfo.getConcatName());
			ps.setString(9, designatedMedicalInstitutionsInfo.getConcatName());
			ps.setString(10, designatedMedicalInstitutionsInfo.getConcatCellphoneNumber());
			ps.setString(11, designatedMedicalInstitutionsInfo.getAddress());
			ps.setString(12, designatedMedicalInstitutionsInfo.getRemarks());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
	@Override
	public DesignatedMedicalInstitutionsInfo get(long designatedMedicalInstitutionCode) {
		String sql = "select designatedMedicalInstitutionCode, serviceOrganizationName, hospitalLevel, medicalInstitutionTypeID, postcode, legalRepresentativeName, legalRepresentativeCellphoneNumber, concatName, contactNumber, concatCellphoneNumber, address, remarks\r\n" + 
				"  from medical_insurance.designated_medical_institutions_info\r\n" + 
				" where designatedMedicalInstitutionCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, designatedMedicalInstitutionCode);
			rs = ps.executeQuery();
			DesignatedMedicalInstitutionsInfo d = new DesignatedMedicalInstitutionsInfo();
			while (rs.next()) {			
				d.setDesignatedMedicalInstitutionCode(rs.getLong("designatedMedicalInstitutionCode"));
			}
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
	}
	@Override
	public int getTotalCount(Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.designated_medical_institutions_info\r\n" + 
				" where 1=1 ";
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if(condition!=null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals(entry.getKey())) {
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
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<DesignatedMedicalInstitutionsInfo> getAllByPage(int start, int rows, Map<String, String[]> condition) {
		String sql = "select *\r\n" + 
				"  from medical_insurance.designated_medical_institutions_info\r\n" + 
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
			List<DesignatedMedicalInstitutionsInfo> listDesignatedMedical = new ArrayList<>();
			try {
				ps = conn.prepareStatement(sql);
				for (int i = 1; i <= list.size(); i++) {
					ps.setString(i, "%"+list.get(i-1)+"%");	
				}
				rs = ps.executeQuery();
				while (rs.next()) {
					DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo = new DesignatedMedicalInstitutionsInfo();
					designatedMedicalInstitutionsInfo.setDesignatedMedicalInstitutionCode(rs.getLong("designatedMedicalInstitutionCode"));
					designatedMedicalInstitutionsInfo.setServiceOrganizationName(rs.getString("serviceOrganizationName"));
					designatedMedicalInstitutionsInfo.setHospitalLevel(rs.getInt("hospitalLevel"));
					designatedMedicalInstitutionsInfo.setMedicalInstitutionTypeId(rs.getString("medicalInstitutionTypeID"));
					designatedMedicalInstitutionsInfo.setPostcode(rs.getString("postcode"));
					designatedMedicalInstitutionsInfo.setLegalRepresentativeName(rs.getString("legalRepresentativeName"));
					designatedMedicalInstitutionsInfo.setLegalRepresentativeCellphoneNumber(rs.getString("legalRepresentativeCellphoneNumber"));
					designatedMedicalInstitutionsInfo.setConcatName(rs.getString("concatName"));
					designatedMedicalInstitutionsInfo.setContactNumber(rs.getString("contactNumber"));
					designatedMedicalInstitutionsInfo.setConcatCellphoneNumber(rs.getString("concatCellphoneNumber"));
					designatedMedicalInstitutionsInfo.setAddress(rs.getString("address"));
					designatedMedicalInstitutionsInfo.setRemarks(rs.getString("remarks"));
					listDesignatedMedical.add(designatedMedicalInstitutionsInfo);
				}
				return listDesignatedMedical;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
	}
	@Override
	public boolean delete(long designatedMedicalInstitutionsInfo) {
		String sql = "delete\r\n" + 
				"  from medical_insurance.designated_medical_institutions_info\r\n" + 
				" where designatedMedicalInstitutionCode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, designatedMedicalInstitutionsInfo);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	@Override
	public boolean update(DesignatedMedicalInstitutionsInfo designatedMedicalInstitutionsInfo) {
		String sql = "update medical_insurance.designated_medical_institutions_info\r\n" + 
				"   set serviceOrganizationName = ?,\r\n" + 
				"       hospitalLevel = ?,\r\n" + 
				"       medicalInstitutionTypeID=?,\r\n" + 
				"       postcode=?,\r\n" + 
				"       legalRepresentativeName=?,\r\n" + 
				"       legalRepresentativeCellphoneNumber=?,\r\n" + 
				"       concatName=?,\r\n" + 
				"       contactNumber=?,\r\n" + 
				"       concatCellphoneNumber=?,\r\n" + 
				"       address=?,\r\n" + 
				"       remarks=?\r\n" + 
				" where designatedMedicalInstitutionCode=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, designatedMedicalInstitutionsInfo.getServiceOrganizationName());
			ps.setInt(2, designatedMedicalInstitutionsInfo.getHospitalLevel());
			ps.setString(3, designatedMedicalInstitutionsInfo.getMedicalInstitutionTypeId());
			ps.setString(4, designatedMedicalInstitutionsInfo.getPostcode());
			ps.setString(5, designatedMedicalInstitutionsInfo.getLegalRepresentativeName());
			ps.setString(6, designatedMedicalInstitutionsInfo.getLegalRepresentativeCellphoneNumber());
			ps.setString(7, designatedMedicalInstitutionsInfo.getConcatName());
			ps.setString(8, designatedMedicalInstitutionsInfo.getConcatName());
			ps.setString(9, designatedMedicalInstitutionsInfo.getConcatCellphoneNumber());
			ps.setString(10, designatedMedicalInstitutionsInfo.getAddress());
			ps.setString(11, designatedMedicalInstitutionsInfo.getRemarks());
			ps.setLong(12, designatedMedicalInstitutionsInfo.getDesignatedMedicalInstitutionCode());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public DesignatedMedicalInstitutionsInfo sel(long designatedMedicalInstitutionCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DesignatedMedicalInstitutionsInfo z = null;
		
		try {
			conn = Dbutil.getConnection();
			String sql = "select * from  designated_medical_institutions_info where designatedMedicalInstitutionCode=? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, designatedMedicalInstitutionCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				z= new DesignatedMedicalInstitutionsInfo();
				z.setServiceOrganizationName(rs.getString("serviceOrganizationName"));//Ò½ÔºÃû×Ö
			}
			return z;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
