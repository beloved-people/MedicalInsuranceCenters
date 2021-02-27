package com.neuedu.utils.dbutils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Dbutil {
	public static Connection getConnection() {
			try {
				Properties pro = new Properties();
				pro.load(Dbutil.class.getClassLoader().getResourceAsStream("database.properties"));
				try {
					BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(pro);
					return dataSource.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	
	
}
