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
					z.setPersonId(rs.getString("personID"));//��ԱID
					z.setInpatientNumber(rs.getLong("inpatientNumber"));//סԺ��
					z.setDesignatedMedicalInstitutionCode(rs.getLong("designatedMedicalInstitutionCode"));
					z.setMedicalCategory(rs.getInt("medicalCategory"));//ҽ������
					z.setAdmissionDate(rs.getString("admissionDate"));//��Ժ����
					z.setDischargeDate(rs.getString("dischargeDate"));//��Ժ��ǰ
					z.setHospitalLevel(rs.getInt("hospitalLevel"));//ҽԺ�ȼ�
				}
				return z;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

}
