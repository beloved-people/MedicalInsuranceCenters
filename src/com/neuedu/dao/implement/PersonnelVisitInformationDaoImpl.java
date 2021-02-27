package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.neuedu.dao.PersonnelVisitInformationDao1;
import com.neuedu.entity.PersonnelVisitInformation;
import com.neuedu.utils.dbutils.Dbutil;

public class PersonnelVisitInformationDaoImpl implements PersonnelVisitInformationDao1{

	@Override
	public PersonnelVisitInformation selperID(String personID) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			PersonnelVisitInformation z = null;
			
			try {
				conn = Dbutil.getConnection();
				String sql = "select * from  personnel_visit_information where personID=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, personID);
				rs = ps.executeQuery();
				while (rs.next()) {
					z= new PersonnelVisitInformation();
					z.setPersonId(rs.getString("personID"));//人员ID
					z.setInpatientNumber(rs.getLong("inpatientNumber"));//住院号
					z.setDesignatedMedicalInstitutionCode(rs.getLong("designatedMedicalInstitutionCode"));
					z.setMedicalCategory(rs.getInt("medicalCategory"));//医疗类型
					z.setAdmissionDate(rs.getString("admissionDate"));//入院日期
					z.setDischargeDate(rs.getString("dischargeDate"));//出院日前
					z.setHospitalLevel(rs.getInt("hospitalLevel"));//医院等级
				}
				return z;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

}
