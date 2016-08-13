package com.h.generate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author 黄海江
 * 2012-12-30
 * version 0.01
 */
public class DataBaseTools {
	static Logger logger = LoggerFactory.getLogger(DataBaseTools.class);
	
	Connection conn;

	public DataBaseTools(Connection conn) {
		this.conn = conn;
	}

	public Table getTable(String name, DbConfig dbConfig) {
		return null;
	}


	public static DataBaseTools getInstanc(String driverClass, String connectionURL, String userId, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionURL, userId, password);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new DataBaseTools(conn);
	}
}

class DbConfig {
	DbConfig(String url, String uid, String pwd) {
		this.url = url;
		this.uid = uid;
		this.pwd = pwd;
	}
	public String url = "db_url";
	public String uid = "user_name";
	public String pwd = "user_pass";
}
