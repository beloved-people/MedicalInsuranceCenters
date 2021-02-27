package com.neuedu.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.PrescriptionDetailsDao1;
import com.neuedu.entity.PrescriptionDetails;
import com.neuedu.utils.dbutils.Dbutil;

public class PrescriptionDetailsDaoImpl2 implements PrescriptionDetailsDao1 {

	@Override
	public List<PrescriptionDetails> selin(long inpa) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PrescriptionDetails> z = null;
		
		try {
			conn = Dbutil.getConnection();
			String sql = "select * from prescription_details where inpatientNumber=? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, inpa);
			rs = ps.executeQuery();
			z=new ArrayList<PrescriptionDetails>();
			while (rs.next()) {
				long inpatientNumber=rs.getLong("inpatientNumber");//住院号
				int projectCode=rs.getInt("projectCode");//项目编码
				double unitPrice=rs.getDouble("unitPrice");//单价
				int  amount=rs.getInt("amount");//数量
				 double sumMoney=rs.getDouble("sumMoney");//金额
				 PrescriptionDetails uesr=new PrescriptionDetails(inpatientNumber,projectCode,unitPrice,amount,sumMoney);
				 z.add(uesr);
			}
			return z;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
}

}
