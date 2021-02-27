package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neuedu.dao.DiagnosisAndTreatmentProjectDao;
import com.neuedu.entity.DiagnosisAndTreatmentProjectInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class DiagnosisAndTreatmentProjectDaoImpl implements DiagnosisAndTreatmentProjectDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	{
		conn = Dbutil.getConnection();
	}

	@Override
	public boolean add(DiagnosisAndTreatmentProjectInfo dtp) {
		String sql = "insert into medical_insurance.diagnosis_and_treatment_project_info(projectCode,projectName,chargeCategory,chargingItemLevel,hospitalLevel,projectUnit,restrictedProjectUsingScope,remarks)\r\n" + 
				"                                                            values(?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, dtp.getProjectCode());
			ps.setString(2, dtp.getProjectName());
			ps.setInt(3, dtp.getChargeCategory());
			ps.setInt(4, dtp.getChargingItemLevel());
			ps.setInt(5, dtp.getHospitalLevel());
			ps.setString(6, dtp.getProjectUnit());
			ps.setString(7, dtp.getRestrictedProjectUsingScope());
			ps.setString(8, dtp.getRemarks());
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(long projectCode) {
		try {
			String sql = "delete from diagnosis_and_treatment_project_info where projectCode=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, projectCode);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public int getTotalCount(Map<String, String[]> condition) {
			String sql = "select *  "  
			         +" from diagnosis_and_treatment_project_info "  
			         +" where 1=1 ";
	   StringBuilder sb = new StringBuilder(sql);
	   List<String> list1 = new ArrayList<String>();
	   if(condition!=null) {
		   //遍历map
		   Set<Map.Entry<String, String[]>> entries = condition.entrySet();	   
		   for (Map.Entry<String, String[]> entry : entries) {
		       //排除分页条件
		       if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey())||"ids".equals(entry.getKey())) {
		           continue;
		       }
		       String value = entry.getValue()[0];
		       if (value != null) {
		           sb.append(" and " + entry.getKey() + " like ? ");
		           list1.add(value);
		       }
		   }
	   }
	   sql = sb.toString();	
	   try {
			ps = conn.prepareStatement(sql);
			
			for(int i=1;i<=list1.size();i++) {
				ps.setString(i, "%"+list1.get(i-1)+"%");
			}			
			rs = ps.executeQuery();
			int count=0;
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
	public List<DiagnosisAndTreatmentProjectInfo> getAllByPage(int start, int rows, Map<String, String[]> condition) {
		String sql = "select *  "  
		         +" from diagnosis_and_treatment_project_info "  
		         +" where 1=1 ";
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
	        //遍历map
        List<String> list = new ArrayList<String>();
        if (condition!=null) {
	    Set<Map.Entry<String, String[]>> entries = condition.entrySet();	        	    
	    for (Map.Entry<String, String[]> entry : entries) {
	            //排除分页条件
	            if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey())||"ids".equals(entry.getKey())) {
	                continue;
	            }
	            String value = entry.getValue()[0];
	            if (value != null) {
	                sb.append(" and " + entry.getKey() + " like ? ");
	                list.add(value);
	            }
	      }
	    }
	        sb.append(" limit "+start+","+rows+"");
	        sql = sb.toString();
	        List<DiagnosisAndTreatmentProjectInfo> listDtp = new ArrayList<>();
	        try {
				ps = conn.prepareStatement(sql);
				for(int i=1;i<=list.size();i++) {
					ps.setString(i,"%" +list.get(i-1)+"%");
				}
				rs = ps.executeQuery();
				while (rs.next()) {
					DiagnosisAndTreatmentProjectInfo dtp = new DiagnosisAndTreatmentProjectInfo();
					dtp.setProjectCode(rs.getLong("projectCode"));
					dtp.setProjectName(rs.getString("projectName"));
					dtp.setChargeCategory(rs.getInt("chargeCategory"));
					dtp.setChargingItemLevel(rs.getInt("chargingItemLevel"));
					dtp.setHospitalLevel(rs.getInt("hospitalLevel"));
					dtp.setProjectApprovalMarkRequired(rs.getString("projectApprovalMarkRequired"));
					dtp.setProjectUnit(rs.getString("projectUnit"));
					dtp.setRestrictedProjectUsingScope(rs.getString("restrictedProjectUsingScope"));
					dtp.setRemarks(rs.getString("remarks"));
					listDtp.add(dtp);
				}
				return listDtp;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

	}

	@Override
	public DiagnosisAndTreatmentProjectInfo get(long projectCode) {
		String sql = "select projectCode from medical_insurance.diagnosis_and_treatment_project_info where projectCode=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, projectCode);
			rs = ps.executeQuery();
			DiagnosisAndTreatmentProjectInfo d = new DiagnosisAndTreatmentProjectInfo();
			while (rs.next()) {
				d.setProjectCode(rs.getLong("projectCode"));
			}
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean update(DiagnosisAndTreatmentProjectInfo dtp) {
		try {
			String sql = "update medical_insurance.diagnosis_and_treatment_project_info\r\n" + 
					"   set projectName = ?,\r\n" + 
					"       chargeCategory = ?,\r\n" + 
					"       chargingItemLevel = ?,\r\n" + 
					"       hospitalLevel = ?,\r\n" + 
					"       projectUnit = ?,\r\n" + 
					"       restrictedProjectUsingScope = ?,\r\n" + 
					"       remarks = ?\r\n" + 
					" where projectCode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dtp.getProjectName());
			ps.setInt(2, dtp.getChargeCategory());
			ps.setInt(3, dtp.getChargingItemLevel());
			ps.setInt(4, dtp.getHospitalLevel());
			ps.setString(5, dtp.getProjectUnit());
			ps.setString(6, dtp.getRestrictedProjectUsingScope());
			ps.setString(7, dtp.getRemarks());
			ps.setLong(8, dtp.getProjectCode());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public DiagnosisAndTreatmentProjectInfo seldia(long projectCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DiagnosisAndTreatmentProjectInfo z = null;
		
		try {
			conn = Dbutil.getConnection();
			String sql = "select * from  diagnosis_and_treatment_project_info where projectCode=? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1,projectCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				z= new DiagnosisAndTreatmentProjectInfo();
				z.setProjectCode(rs.getInt("projectCode"));//项目编码
				z.setProjectName(rs.getString("projectName"));//项目名称
				z.setChargeCategory(rs.getInt("chargeCategory"));//项目类别
				z.setHospitalLevel(rs.getInt("hospitalLevel"));//医院等级
		
			}
			return z;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}	
}
