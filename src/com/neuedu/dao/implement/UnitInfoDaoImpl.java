package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.UnitInfoDao;
import com.neuedu.entity.PageBean4;
import com.neuedu.entity.UnitInfo4;
import com.neuedu.utils.dbutils.Dbutil;

public class UnitInfoDaoImpl implements UnitInfoDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	@Override
	public boolean add(UnitInfo4 ui) {
		
		
		try 
		{
			
			conn = Dbutil.getConnection();
			String sql = " insert into company_info " + 
					" values (?,?,?,?,?,?) ";
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1,ui.getCompanyCode());
			pstm.setString(2,ui.getCompanyName());
			pstm.setInt(3,ui.getCompanyType());
			pstm.setString(4,ui.getCompanyAddress());
			pstm.setString(5,ui.getCompanyPostcode());
			pstm.setString(6,ui.getCompanyContactNumber());
			return pstm.executeUpdate()>0;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public boolean del(long id) {
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " delete from company_info where companyCode=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1,id);
			
			return pstm.executeUpdate()>0;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public UnitInfo4 getByIdAndName(long id, String name) {
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " select * from company_info " + 
					" where companyCode=? " + 
					" and companyName=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1,id);
			pstm.setString(2, name);
			
			rs = pstm.executeQuery();
			while(rs.next())
			{
				long companyCode = rs.getLong("companyCode");
				String companyName = rs.getString("companyName");
				int companyType = rs.getInt("companyType");
				String companyAddress = rs.getString("companyAddress");
				String companyPostcode = rs.getString("companyPostcode");
				String companyContactNumber = rs.getString("companyContactNumber");
				
				UnitInfo4 ui = new UnitInfo4(companyCode,companyName,companyType,
						companyAddress,companyPostcode,companyContactNumber);
				return ui;
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		return null;
	}

	@Override
	public boolean modify(UnitInfo4 ui) {
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " update company_info " + 
					" set companyName=?,companyType=?,companyAddress=?,companyPostcode=?,companyContactNumber=? " + 
					" where companyCode=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,ui.getCompanyName());
			pstm.setInt(2,ui.getCompanyType());
			pstm.setString(3,ui.getCompanyAddress());
			pstm.setString(4,ui.getCompanyPostcode());
			pstm.setString(5,ui.getCompanyContactNumber());
			pstm.setLong(6, ui.getCompanyCode());
			
			return pstm.executeUpdate()>0;
			
		} 
		catch (SQLException e) 
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
			String sql = " select count(*) from company_info where 1=1 ";
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
	public void getAll(PageBean4<UnitInfo4> pageBean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet re = null;
		List<UnitInfo4> lt = new ArrayList<UnitInfo4>();
		
		try 
		{
			conn = Dbutil.getConnection();
			String sql = " select * from company_info " + 
					" limit ?,5 ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,pageBean.getStartNum());
			
			re = pstm.executeQuery();
			while(re.next())
			{
				long companyCode = re.getLong("companyCode");
				String companyName = re.getString("companyName");
				int companyType = re.getInt("companyType");
				String companyAddress = re.getString("companyAddress");
				String companyPostcode = re.getString("companyPostcode");
				String companyContactNumber = re.getString("companyContactNumber");
				
				UnitInfo4 ui = new UnitInfo4(companyCode,companyName,companyType,
						companyAddress,companyPostcode,companyContactNumber);
				lt.add(ui);
				
			}
			pageBean.setPageDate(lt);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
