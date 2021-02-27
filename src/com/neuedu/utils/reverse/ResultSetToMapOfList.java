package com.neuedu.utils.reverse;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultSetToMapOfList {
	public static List<Map<String, Object>> ConvertToList(ResultSet rs) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSetMetaData rsm;
		try {
			rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(rsm.getColumnLabel(i), rs.getObject(i));
				}
				list.add(rowData);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
		
	}
}
