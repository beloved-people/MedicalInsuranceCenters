package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neuedu.dao.DrugInfoDao;
import com.neuedu.entity.DrugInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class DrugInfoDaoImpl implements DrugInfoDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	@Override
	public boolean add(DrugInfo drug) {
		try {
			conn = Dbutil.getConnection();
			String sql= "insert into drug_info(dc,medicineName,medicineEnglishName,chargeCategory,prescriptionDrugMark,chargingItemLevel,drugDosageUnit,"
					+ "maximumPrice,inHospitalPreparationMark,approvalMarkRequired,hospitalLevel,dosageFormID,usageFrequencyID,usageID,unit,specification,"
					+ "limitedDays,drugTradeName,pharmaceuticalFactory,ChineseMedicineQuasiCharacter,remarks,nationalCatalogCode,restrictedUsingScope,"
					+ "placeOfProduction)"
					+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, drug.getDc());
			pstm.setString(2, drug.getMedicineName());
			pstm.setString(3, drug.getMedicineEnglishName());
			pstm.setInt(4, drug.getChargeCategory());
			pstm.setInt(5, drug.getPrescriptionDrugMark());
			pstm.setInt(6, drug.getChargingItemLevel());
			pstm.setInt(7, drug.getDrugDosageUnit());
			pstm.setDouble(8, drug.getMaximumPrice());
			pstm.setInt(9, drug.getInHospitalPreparationMark());
			pstm.setString(10, drug.getApprovalMarkRequired());
			pstm.setInt(11, drug.getHospitalLevel());
			pstm.setString(12, drug.getDosageFormId());
			pstm.setString(13, drug.getUsageFrequencyId());
			pstm.setString(14, drug.getUsageId());
			pstm.setInt(15, drug.getUnit());
			pstm.setString(16,drug.getSpecification());
			pstm.setInt(17, drug.getLimitedDays());
			pstm.setString(18, drug.getDrugTradeName());
			pstm.setString(19, drug.getPharmaceuticalFactory());
			pstm.setString(20, drug.getChineseMedicineQuasiCharacter());
			pstm.setString(21, drug.getRemarks());
			pstm.setString(22, drug.getNationalCatalogCode());
			pstm.setString(23, drug.getRestrictedUsingScope());
			pstm.setString(24, drug.getPlaceOfProduction());
			
			return pstm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean del(long dc) {
		try {
			conn = Dbutil.getConnection();
			String sql = "delete from drug_info where dc=?";
			pstm=conn.prepareStatement(sql);
			pstm.setLong(1, dc);
			
			return pstm.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<DrugInfo> qurryAll() {
		List<DrugInfo> drug = new ArrayList<>();
		try {
			conn=Dbutil.getConnection();
			String sql = "select dc,medicineName,medicineEnglishName,chargeCategory,prescriptionDrugMark,chargingItemLevel,drugDosageUnit,"
					+ "maximumPrice,inHospitalPreparationMark,approvalMarkRequired,hospitalLevel,dosageFormID,usageFrequencyID,usageID,unit,specification,"
					+ "limitedDays,drugTradeName,pharmaceuticalFactory,ChineseMedicineQuasiCharacter,remarks,nationalCatalogCode,restrictedUsingScope,"
					+ "placeOfProduction "
					+ "from drug_info";
			pstm= conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				long dc = rs.getLong("dc");
				String medicineName = rs.getString("medicineName");
				String medicineEnglishName = rs.getString("medicineEnglishName");
				int chargeCategory = rs.getInt("chargeCategory");
				int prescriptionDrugMark = rs.getInt("prescriptionDrugMark");
				int chargingItemLevel = rs.getInt("chargingItemLevel");
				int drugDosageUnit = rs.getInt("drugDosageUnit");
				double maximumPrice = rs.getDouble("maximumPrice");
				int inHospitalPreparationMark = rs.getInt("inHospitalPreparationMark");
				String approvalMarkRequired = rs.getString("approvalMarkRequired");
				int hospitalLevel = rs.getInt("hospitalLevel");
				String dosageFormId = rs.getString("dosageFormId");
				String usageFrequencyId = rs.getString("usageFrequencyId");
				String usageId = rs.getString("usageId");
				int unit = rs.getInt("unit");
				String specification = rs.getString("specification");
				int limitedDays = rs.getInt("limitedDays");
				String drugTradeName = rs.getString("drugTradeName");
				String pharmaceuticalFactory = rs.getString("pharmaceuticalFactory");
				String chineseMedicineQuasiCharacter = rs.getString("chineseMedicineQuasiCharacter");
				String remarks = rs.getString("remarks");
				String nationalCatalogCode = rs.getString("nationalCatalogCode");
				String restrictedUsingScope = rs.getString("restrictedUsingScope");
				String placeOfProduction = rs.getString("placeOfProduction");
				DrugInfo drug1 = new DrugInfo(dc,medicineName,medicineEnglishName,chargeCategory,prescriptionDrugMark,chargingItemLevel,drugDosageUnit,
						maximumPrice,inHospitalPreparationMark,approvalMarkRequired,hospitalLevel,dosageFormId,usageFrequencyId,usageId,unit,specification,
			            limitedDays,drugTradeName,pharmaceuticalFactory,chineseMedicineQuasiCharacter,remarks,nationalCatalogCode,restrictedUsingScope,
						placeOfProduction );
				drug.add(drug1);	
			}
			return drug;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DrugInfo getbydc(long dc) {
		DrugInfo drug2 = null;
		try {
			conn=Dbutil.getConnection();
			String sql = "select dc,medicineName,medicineEnglishName,chargeCategory,prescriptionDrugMark,chargingItemLevel,drugDosageUnit,"
					+ "maximumPrice,inHospitalPreparationMark,approvalMarkRequired,hospitalLevel,dosageFormID,usageFrequencyID,usageID,unit,specification,"
					+ "limitedDays,drugTradeName,pharmaceuticalFactory,ChineseMedicineQuasiCharacter,remarks,nationalCatalogCode,restrictedUsingScope,"
					+ "placeOfProduction "
					+ "from drug_info where dc=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, dc);
			rs=pstm.executeQuery();
			while(rs.next())
			{			
				String medicineName = rs.getString("medicineName");
				String medicineEnglishName = rs.getString("medicineEnglishName");
				int chargeCategory = rs.getInt("chargeCategory");
				int prescriptionDrugMark = rs.getInt("prescriptionDrugMark");
				int chargingItemLevel = rs.getInt("chargingItemLevel");
				int drugDosageUnit = rs.getInt("drugDosageUnit");
				double maximumPrice = rs.getDouble("maximumPrice");
				int inHospitalPreparationMark = rs.getInt("inHospitalPreparationMark");
				String approvalMarkRequired = rs.getString("approvalMarkRequired");
				int hospitalLevel = rs.getInt("hospitalLevel");
				String dosageFormId = rs.getString("dosageFormId");
				String usageFrequencyId = rs.getString("usageFrequencyId");
				String usageId = rs.getString("usageId");
				int unit = rs.getInt("unit");
				String specification = rs.getString("specification");
				int limitedDays = rs.getInt("limitedDays");
				String drugTradeName = rs.getString("drugTradeName");
				String pharmaceuticalFactory = rs.getString("pharmaceuticalFactory");
				String chineseMedicineQuasiCharacter = rs.getString("chineseMedicineQuasiCharacter");
				String remarks = rs.getString("remarks");
				String nationalCatalogCode = rs.getString("nationalCatalogCode");
				String restrictedUsingScope = rs.getString("restrictedUsingScope");
				String placeOfProduction = rs.getString("placeOfProduction");
				drug2 = new DrugInfo(dc,medicineName,medicineEnglishName,chargeCategory,prescriptionDrugMark,chargingItemLevel,drugDosageUnit,
						maximumPrice,inHospitalPreparationMark,approvalMarkRequired,hospitalLevel,dosageFormId,usageFrequencyId,usageId,unit,specification,
			            limitedDays,drugTradeName,pharmaceuticalFactory,chineseMedicineQuasiCharacter,remarks,nationalCatalogCode,restrictedUsingScope,
						placeOfProduction );
			}
			return drug2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modify(DrugInfo drug) {
		try {
			conn=Dbutil.getConnection();
			String sql = " update drug_info set medicineName=?,medicineEnglishName=?,chargeCategory=?,prescriptionDrugMark=?,chargingItemLevel=?,drugDosageUnit=?," 
					+ " maximumPrice=?,inHospitalPreparationMark=?,approvalMarkRequired=?,hospitalLevel=?,dosageFormID=?,usageFrequencyID=?,usageID=?,unit=?,specification=?," 
					+ " limitedDays=?,drugTradeName=?,pharmaceuticalFactory=?,ChineseMedicineQuasiCharacter=?,remarks=?,nationalCatalogCode=?,restrictedUsingScope=?," 
					+ " placeOfProduction=? "
					+ " where dc=? ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, drug.getMedicineName());
			pstm.setString(2, drug.getMedicineEnglishName());
			pstm.setInt(3, drug.getChargeCategory());
			pstm.setInt(4, drug.getPrescriptionDrugMark());
			pstm.setInt(5, drug.getChargingItemLevel());
			pstm.setInt(6, drug.getDrugDosageUnit());
			pstm.setDouble(7, drug.getMaximumPrice());
			pstm.setInt(8, drug.getInHospitalPreparationMark());
			pstm.setString(9, drug.getApprovalMarkRequired());
			pstm.setInt(10, drug.getHospitalLevel());
			pstm.setString(11, drug.getDosageFormId());
			pstm.setString(12, drug.getUsageFrequencyId());
			pstm.setString(13, drug.getUsageId());
			pstm.setInt(14, drug.getUnit());
			pstm.setString(15,drug.getSpecification());
			pstm.setInt(16, drug.getLimitedDays());
			pstm.setString(17, drug.getDrugTradeName());
			pstm.setString(18, drug.getPharmaceuticalFactory());
			pstm.setString(19, drug.getChineseMedicineQuasiCharacter());
			pstm.setString(20, drug.getRemarks());
			pstm.setString(21, drug.getNationalCatalogCode());
			pstm.setString(22, drug.getRestrictedUsingScope());
			pstm.setString(23, drug.getPlaceOfProduction());
			pstm.setLong(24, drug.getDc());
			
			return pstm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getTotalCount(Map<String, String[]> condition) {
		conn=Dbutil.getConnection();
		String sql = "select *\r\n"+
	               "from medical_insurance.drug_info\r\n"+
				   "where 1=1 "   ;
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if(condition!=null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey()) || "restrictedProjectUsingScope".equals(entry.getKey())) {
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
			pstm = conn.prepareStatement(sql);
			for (int i = 1; i <= list.size(); i++) {
				pstm.setString(i, "%"+list.get(i-1)+"%");
			}
			rs = pstm.executeQuery();
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
	public List<DrugInfo> getAllByPage(int start, int rows, Map<String, String[]> condition) {
		conn=Dbutil.getConnection();
		
		String sql = "select *\r\n"+
	               "from medical_insurance.drug_info\r\n"+
				   "where 1=1 "   ;
		StringBuilder sb = new StringBuilder();
		sb.append(sql);
		List<String> list = new ArrayList<String>();
		if (condition != null) {
			Set<Map.Entry<String, String[]>> entires = condition.entrySet();
			for (Map.Entry<String, String[]> entry : entires) {
				if ("currentPage".equals(entry.getKey()) || "rows".equals(entry.getKey()) || "id".equals((entry).getKey()) || "restrictedProjectUsingScope".equals(entry.getKey())) {
					continue;
				}
				String value = entry.getValue()[0];
				if (value != null) {
					sb.append(" and "+entry.getKey()+" like ? ");
					list.add(value);
				}
			}
		}
		sb.append(" limit "+start+","+rows+"");
		sql = sb.toString();
		List<DrugInfo> listDrugInfo = new ArrayList<DrugInfo>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 1; i <= list.size(); i++) {
				pstm.setString(i, "%"+list.get(i-1)+"%");	
			}
			rs = pstm.executeQuery();
			while(rs.next()) {
				DrugInfo druginfo = new DrugInfo();
				druginfo.setDc(rs.getLong("dc"));
				druginfo.setMedicineName(rs.getString("medicineName"));
				druginfo.setMedicineEnglishName(rs.getString("medicineEnglishName"));
				druginfo.setChargeCategory(rs.getInt("chargeCategory"));
				druginfo.setPrescriptionDrugMark(rs.getInt("prescriptionDrugMark"));
				druginfo.setChargingItemLevel(rs.getInt("chargingItemLevel"));
				druginfo.setDrugDosageUnit(rs.getInt("drugDosageUnit"));
				druginfo.setMaximumPrice(rs.getDouble("maximumPrice"));
				druginfo.setInHospitalPreparationMark(rs.getInt("inHospitalPreparationMark"));
				druginfo.setApprovalMarkRequired(rs.getString("approvalMarkRequired"));
				druginfo.setHospitalLevel(rs.getInt("hospitalLevel"));
				druginfo.setDosageFormId(rs.getString("dosageFormId"));
				druginfo.setUsageFrequencyId(rs.getString("usageFrequencyId"));
				druginfo.setUsageId(rs.getString("usageId"));
				druginfo.setUnit(rs.getInt("unit"));
				druginfo.setSpecification(rs.getString("specification"));
				druginfo.setLimitedDays(rs.getInt("limitedDays"));
				druginfo.setDrugTradeName(rs.getString("drugTradeName"));
				druginfo.setPharmaceuticalFactory(rs.getString("pharmaceuticalFactory"));
				druginfo.setChineseMedicineQuasiCharacter(rs.getString("chineseMedicineQuasiCharacter"));
				druginfo.setRemarks(rs.getString("remarks"));
				druginfo.setNationalCatalogCode(rs.getString("nationalCatalogCode"));
				druginfo.setRestrictedUsingScope(rs.getString("restrictedUsingScope"));
				druginfo.setPlaceOfProduction(rs.getString("placeOfProduction"));
				listDrugInfo.add(druginfo);
			}
			  return listDrugInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

	
}














