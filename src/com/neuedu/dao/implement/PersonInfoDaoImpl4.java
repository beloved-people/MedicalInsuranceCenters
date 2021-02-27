package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.PersonInfoDao;
import com.neuedu.entity.PageBean4;
import com.neuedu.entity.PersonInfo;
import com.neuedu.entity.PersonInfo4;
import com.neuedu.utils.dbutils.*;

public class PersonInfoDaoImpl4 implements PersonInfoDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet re = null;
	@Override
	public boolean add(PersonInfo4 pi) {
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " insert into person_info(personID,certificateID,certificateNumber,name, "
					+ " gender,nationID,birthdate,participationDate,retirementDate,retirementStatus, "
					+ " accountNature,accountLocation,degreeID,outlookID,identity,employmentForm, "
					+ " specializedTechnicalJob,NVQL,maritalStatus,dutyID,remarks,companyCode,personnelCategoryID, "
					+ " healthStatus,lamorSign,cadreSign,civilServantSign,establishmentSign,residentSign, "
					+ " flexibleEmploymentSign, migrantWorkerSign,employerSign,militaryPersonnelSign, "
					+ " socialSecurityNumber,designatedMedicalInstitutionCode) " + 
					" values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, pi.getId());
			pstm.setString(1, pi.getPersonId());
			pstm.setString(2, pi.getCertificateId());
			pstm.setString(3, pi.getCertificateNumber());
			pstm.setString(4, pi.getName());
			pstm.setString(5, pi.getGender());
			pstm.setString(6, pi.getNationId());
			pstm.setString(7, pi.getBirthdate());
			pstm.setString(8, pi.getParticipationDate());
			pstm.setString(9, pi.getRetirementDate());
			pstm.setInt(10, pi.getRetirementStatus());
			pstm.setInt(11, pi.getAccountNature());
			pstm.setString(12, pi.getAccountLocation());
			pstm.setString(13, pi.getDegreeId());
			pstm.setString(14, pi.getOutlookId());
			pstm.setInt(15, pi.getIdentity());
			pstm.setInt(16, pi.getEmploymentForm());
			pstm.setInt(17, pi.getSpecializedTechnicalJob());
			pstm.setInt(18, pi.getNvql());
			pstm.setInt(19, pi.getMaritalStatus());
			pstm.setString(20, pi.getDutyId());
			pstm.setString(21, pi.getRemarks());
			pstm.setLong(22, pi.getCompanyCode());
			pstm.setString(23, pi.getPersonnelCategoryId());
			pstm.setInt(24, pi.getHealthStatus());
			pstm.setInt(25, pi.getLamorSign());
			pstm.setInt(26, pi.getCadreSign());
			pstm.setInt(27, pi.getCivilServantSign());
			pstm.setInt(28, pi.getEstablishmentSign());
			pstm.setInt(29, pi.getResidentSign());
			pstm.setInt(30, pi.getFlexibleEmploymentSign());
			pstm.setInt(31, pi.getMigrantWorkerSign());
			pstm.setInt(32, pi.getEmployerSign());
			pstm.setInt(33, pi.getMilitaryPersonnelSign());
			pstm.setString(34,pi.getSocialSecurityNumber());
			pstm.setLong(35, pi.getDesignatedMedicalInstitutionCode());
			
			
			return pstm.executeUpdate()>0;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean del(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " delete from person_info where id=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			
			return pstm.executeUpdate()>0;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PersonInfo4 getByIdAndName(String presonId,String name) {	
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " select * " + 
					"from person_info pe " + 
					"join certificate_type ce on pe.certificateID=ce.certificateID " + 
					"join nation n on n.nationID=pe.nationID " + 
					"join education_degree ed on pe.degreeID = ed.degreeID " + 
					"join political_outlook po on pe.outlookID = po.outlookID " + 
					"join administrative_duties ad on pe.dutyID = ad.dutyID " + 
					"join medical_personnel_category mpc on pe.personnelCategoryID = mpc.personnelCategoryID " + 
					"where 1=1 ";
			StringBuffer sb = new StringBuffer();
			sb.append(sql);
			List<String> list = new ArrayList<>();
			if (presonId != null) {
				sb.append("and personID like ? ");
				list.add(presonId);
			}
			if (name != null) {
				sb.append("and name like ? ");
				list.add(name);
			}
			sql = sb.toString();
			pstm = conn.prepareStatement(sql);	
			System.out.println(list.size());
			for (int i = 1; i <= list.size(); i++) {
				pstm.setString(i, "%"+list.get(i-1)+"%");
			}
			re = pstm.executeQuery();
			
			PersonInfo4 pi = new PersonInfo4();
			while(re.next())
			{				
				pi.setId(re.getInt("id"));
				pi.setPersonId(re.getString("personId"));
				pi.setCertificateId(re.getString("certificateId"));
				pi.setCertificateName(re.getString("certificateName"));
				pi.setCertificateNumber(re.getString("certificateNumber"));
				pi.setName(re.getString("name"));
				pi.setGender(re.getString("gender"));
				pi.setNationId(re.getString("nationID"));
				pi.setNationName(re.getString("nationName"));
				pi.setBirthdate(re.getString("birthdate"));
				pi.setParticipationDate(re.getString("participationDate"));
				pi.setRetirementDate(re.getString("retirementDate"));
				pi.setRetirementStatus(re.getInt("retirementStatus"));
				pi.setAccountNature(re.getInt("accountNature"));
				pi.setAccountLocation(re.getString("accountLocation"));
				pi.setDegreeId(re.getString("degreeID"));
				pi.setDegreeName(re.getString("degreeName"));
				pi.setOutlookId(re.getString("outlookID"));
				pi.setOutlookName(re.getString("outlookName"));
				pi.setIdentity(re.getInt("identity"));
				pi.setEmploymentForm(re.getInt("employmentForm"));
				pi.setSpecializedTechnicalJob(re.getInt("specializedTechnicalJob"));
				pi.setNvql(re.getInt("NVQL"));
				pi.setMaritalStatus(re.getInt("maritalStatus"));
				pi.setDutyId(re.getString("dutyID"));
				pi.setDutyName(re.getString("dutyName"));
				pi.setRemarks(re.getString("remarks"));
				pi.setCompanyCode(re.getLong("companyCode"));
				pi.setPersonnelCategoryId(re.getString("personnelCategoryID"));
				pi.setPersonnelCategoryName(re.getString("personnelCategoryName"));
				pi.setHealthStatus(re.getInt("healthStatus"));
				pi.setLamorSign(re.getInt("lamorSign"));
				pi.setCadreSign(re.getInt("cadreSign"));
				pi.setCivilServantSign(re.getInt("civilServantSign"));
				pi.setEstablishmentSign(re.getInt("establishmentSign"));
				pi.setResidentSign(re.getInt("residentSign"));
				pi.setFlexibleEmploymentSign(re.getInt("flexibleEmploymentSign"));
				pi.setMigrantWorkerSign(re.getInt("migrantWorkerSign"));
				pi.setEmployerSign(re.getInt("employerSign"));
				pi.setMilitaryPersonnelSign(re.getInt("militaryPersonnelSign"));
				pi.setSocialSecurityNumber(re.getString("socialSecurityNumber"));
				pi.setDesignatedMedicalInstitutionCode(re.getLong("designatedMedicalInstitutionCode"));			
				
			}
			return pi;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
	}


	@Override
	public boolean modify(PersonInfo4 pi) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " update person_info " + 
					" set certificateId=?,certificateNumber=?, name=?, " + 
					" gender=?, nationId=?, birthdate=?, participationDate=?, retirementDate=?, " + 
					" retirementStatus=?, accountNature=?, accountLocation=?, degreeId=?, outlookId=?, " + 
					" identity=?, employmentForm=?, specializedTechnicalJob=?, nvql=?, maritalStatus=?, dutyId=?, " + 
					" remarks=?, companyCode=?, personnelCategoryId=?, healthStatus=?, lamorSign=?, " + 
					" cadreSign=?, civilServantSign=?, establishmentSign=?, residentSign=?, flexibleEmploymentSign=?, " + 
					" migrantWorkerSign=?, employerSign=?, militaryPersonnelSign=?, socialSecurityNumber=?, " + 
					" designatedMedicalInstitutionCode=? " + 
					" where id=? ";
			pstm = conn.prepareStatement(sql);
//			pstm.setString(1, pi.getPersonId());
			pstm.setString(1, pi.getCertificateId());
			pstm.setString(2, pi.getCertificateNumber());
			pstm.setString(3, pi.getName());
			pstm.setString(4, pi.getGender());
			pstm.setString(5, pi.getNationId());
			pstm.setString(6, pi.getBirthdate());
			pstm.setString(7, pi.getParticipationDate());
			pstm.setString(8, pi.getRetirementDate());
			pstm.setInt(9, pi.getRetirementStatus());
			pstm.setInt(10, pi.getAccountNature());
			pstm.setString(11, pi.getAccountLocation());
			pstm.setString(12, pi.getDegreeId());
			pstm.setString(13, pi.getOutlookId());
			pstm.setInt(14, pi.getIdentity());
			pstm.setInt(15, pi.getEmploymentForm());
			pstm.setInt(16, pi.getSpecializedTechnicalJob());
			pstm.setInt(17, pi.getNvql());
			pstm.setInt(18, pi.getMaritalStatus());
			pstm.setString(19, pi.getDutyId());
			pstm.setString(20, pi.getRemarks());
			pstm.setLong(21, pi.getCompanyCode());
			pstm.setString(22, pi.getPersonnelCategoryId());
			pstm.setInt(23, pi.getHealthStatus());
			pstm.setInt(24, pi.getLamorSign());
			pstm.setInt(25, pi.getCadreSign());
			pstm.setInt(26, pi.getCivilServantSign());
			pstm.setInt(27, pi.getEstablishmentSign());
			pstm.setInt(28, pi.getResidentSign());
			pstm.setInt(29, pi.getFlexibleEmploymentSign());
			pstm.setInt(30, pi.getMigrantWorkerSign());
			pstm.setInt(31, pi.getEmployerSign());
			pstm.setInt(32, pi.getMilitaryPersonnelSign());
			pstm.setString(33,pi.getSocialSecurityNumber());
			pstm.setLong(34, pi.getDesignatedMedicalInstitutionCode());
			pstm.setInt(35, pi.getId());
			return pstm.executeUpdate()>0;
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getTotalCount() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet re = null;
		int x=-1;
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " select count(*) from person_info where 1=1 ";
			pstm = conn.prepareStatement(sql);
			re = pstm.executeQuery();
			while(re.next()) {
				x = re.getInt(1);
			}
			return x;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public void getAll(PageBean4<PersonInfo4> pageBean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet re = null;
		List<PersonInfo4> lt = new ArrayList<PersonInfo4>();		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " select * " + 
					"from person_info pe " + 
					"join certificate_type ce on pe.certificateID=ce.certificateID " + 
					"join nation n on n.nationID=pe.nationID " + 
					"join education_degree ed on pe.degreeID = ed.degreeID " + 
					"join political_outlook po on pe.outlookID = po.outlookID " + 
					"join administrative_duties ad on pe.dutyID = ad.dutyID " + 
					"join medical_personnel_category mpc on pe.personnelCategoryID = mpc.personnelCategoryID " + 
					" limit ?,5 ";
			pstm = conn.prepareStatement(sql);
			if (pageBean.getStartNum()>0) {
				pstm.setInt(1,pageBean.getStartNum());
			}else {
				pstm.setInt(1,0);
			}
			
			re = pstm.executeQuery();
			while(re.next())
			{
				PersonInfo4 pi = new PersonInfo4();
				pi.setId(re.getInt("id"));
				pi.setPersonId(re.getString("personId"));
				pi.setCertificateId(re.getString("certificateId"));
				pi.setCertificateName(re.getString("certificateName"));
				pi.setCertificateNumber(re.getString("certificateNumber"));
				pi.setName(re.getString("name"));
				pi.setGender(re.getString("gender"));
				pi.setNationId(re.getString("nationID"));
				pi.setNationName(re.getString("nationName"));
				pi.setBirthdate(re.getString("birthdate"));
				pi.setParticipationDate(re.getString("participationDate"));
				pi.setRetirementDate(re.getString("retirementDate"));
				pi.setRetirementStatus(re.getInt("retirementStatus"));
				pi.setAccountNature(re.getInt("accountNature"));
				pi.setAccountLocation(re.getString("accountLocation"));
				pi.setDegreeId(re.getString("degreeID"));
				pi.setDegreeName(re.getString("degreeName"));
				pi.setOutlookId(re.getString("outlookID"));
				pi.setOutlookName(re.getString("outlookName"));
				pi.setIdentity(re.getInt("identity"));
				pi.setEmploymentForm(re.getInt("employmentForm"));
				pi.setSpecializedTechnicalJob(re.getInt("specializedTechnicalJob"));
				pi.setNvql(re.getInt("NVQL"));
				pi.setMaritalStatus(re.getInt("maritalStatus"));
				pi.setDutyId(re.getString("dutyID"));
				pi.setDutyName(re.getString("dutyName"));
				pi.setRemarks(re.getString("remarks"));
				pi.setCompanyCode(re.getLong("companyCode"));
				pi.setPersonnelCategoryId(re.getString("personnelCategoryID"));
				pi.setPersonnelCategoryName(re.getString("personnelCategoryName"));
				pi.setHealthStatus(re.getInt("healthStatus"));
				pi.setLamorSign(re.getInt("lamorSign"));
				pi.setCadreSign(re.getInt("cadreSign"));
				pi.setCivilServantSign(re.getInt("civilServantSign"));
				pi.setEstablishmentSign(re.getInt("establishmentSign"));
				pi.setResidentSign(re.getInt("residentSign"));
				pi.setFlexibleEmploymentSign(re.getInt("flexibleEmploymentSign"));
				pi.setMigrantWorkerSign(re.getInt("migrantWorkerSign"));
				pi.setEmployerSign(re.getInt("employerSign"));
				pi.setMilitaryPersonnelSign(re.getInt("militaryPersonnelSign"));
				pi.setSocialSecurityNumber(re.getString("socialSecurityNumber"));
				pi.setDesignatedMedicalInstitutionCode(re.getLong("designatedMedicalInstitutionCode"));	
				lt.add(pi);
			}
			pageBean.setPageDate(lt);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public PersonInfo selName(String person) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			PersonInfo z = null;
			
			try {
				conn = Dbutil.getConnection();
				String sql = "select * from  person_info where personID=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1,person);
				rs = ps.executeQuery();
				while (rs.next()) {
					z= new PersonInfo();
					z.setPersonId(rs.getString("personID"));//人员id
					z.setName(rs.getString("name"));//名字
					z.setGender(rs.getString("gender"));//性别
					z.setCompanyCode(rs.getInt("companyCode"));//单位编码
					z.setCertificateId(rs.getString("certificateID"));//编号			
				}
				return z;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}	

}
