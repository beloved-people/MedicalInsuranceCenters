package com.neuedu.dao.implement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OperatorDao;
import com.neuedu.entity.OperatorInfo;
import com.neuedu.utils.dbutils.Dbutil;

public class OperatorDaoImpl implements OperatorDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	{
		conn = Dbutil.getConnection();
	}
	@Override
	public boolean add(OperatorInfo operator) {
		try {
			String sql = "insert into operator_info(operatorName, operatorGender, operatorPwd, operatorAccount, jobNumber)\r\n" + 
					"                  values (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, operator.getOperatorName());
			ps.setString(2, operator.getOperatorGender());
			ps.setString(3, operator.getOperatorPwd());
			ps.setString(4, operator.getOperatorAccount());
			ps.setString(5, operator.getJobNumber());
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public OperatorInfo getByJobNumber(String jobNumber) {		
		try {
			String sql = "select operatorID,operatorName, operatorGender, operatorPwd, operatorAccount, jobNumber\r\n" + 
					"  from operator_info\r\n" + 
					" where jobNumber = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, jobNumber);
			rs = ps.executeQuery();
			OperatorInfo o = null;
			while (rs.next()) {
				o = new OperatorInfo();
				o.setOperatorId(rs.getInt("operatorID"));
				o.setOperatorName(rs.getString("operatorName"));
				o.setOperatorGender(rs.getString("operatorGender"));
				o.setOperatorPwd(rs.getString("operatorPwd"));
				o.setOperatorAccount(rs.getString("operatorAccount"));
				o.setJobNumber(rs.getString("jobNumber"));
			}
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		
	}

	@Override
	public boolean modify(OperatorInfo operator) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn=Dbutil.getConnection();
			String sql = "update medical_insurance.operator_info\r\n" + 
					"set operatorAccount = ?,\r\n" + 
					"    operatorName = ?,\r\n" + 
					"    operatorGender = ?,\r\n" + 
					"    operatorPwd = ?\r\n" + 
					"where operatorID=?\r\n" + 
					"  and jobNumber=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, operator.getOperatorAccount());
			pstm.setString(2, operator.getOperatorName());
			pstm.setString(3, operator.getOperatorGender());
			pstm.setString(4, operator.getOperatorPwd());
			pstm.setInt(5, operator.getOperatorId());			
			pstm.setString(6, operator.getJobNumber());			
			return pstm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<OperatorInfo> qurryAll() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<OperatorInfo> oper = new ArrayList<>();
		try {
			conn=Dbutil.getConnection();
			String sql = "select operatorId,operatorName, operatorGender, operatorPwd, operatorAccount, jobNumber\r\n" + 
					"  from operator_info" ;
			pstm= conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int operatorId = rs.getInt("operatorId") ;
				String operatorAccount = rs.getString("operatorAccount");
				String operatorName = rs.getString("operatorName");
				String operatorGender = rs.getString("operatorGender");
				String jobNumber = rs.getString("jobNumber");
				String operatorPwd = rs.getString("operatorPwd");
				OperatorInfo oper1 = new OperatorInfo(operatorId,operatorAccount,operatorName,operatorGender,jobNumber,operatorPwd);
			    oper.add(oper1);
			}
			return oper;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public boolean modifyPwd(String jobNumber, String operatorPwd) {
		String sql = "update medical_insurance.operator_info\r\n" + 
				"set operatorPwd = ?\r\n" + 
				"where jobNumber=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, operatorPwd);
			ps.setString(2, jobNumber);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	

}
