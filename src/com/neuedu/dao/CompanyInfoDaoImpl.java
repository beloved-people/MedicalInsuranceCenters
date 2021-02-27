package com.neuedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.entity.CompanyInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class CompanyInfoDaoImpl implements CompanyInfoDao{

	@Override
	public CompanyInfo selcom(long companyCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CompanyInfo z = null;
		
		try {
			conn = Dbutil.getConnection();
			String sql = "select * from company_info  where companyCode=? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, companyCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				z= new CompanyInfo();
				z.setCompanyCode(rs.getLong("companyCode"));//单位编码
				z.setCompanyName(rs.getString("companyName"));//单位名称
			}
			return z;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
}


}
