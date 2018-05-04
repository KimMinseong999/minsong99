package ex0503.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DB���� �ε�, ����, �ݱ⸦ ���� Ŭ����
 * */
public class DbUtil {
	static DataSource ds;
  /**
   * �ε�
   * */
	static {
		try {
		  Context  context = new InitialContext();
		  ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
		 
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
  /**
   * ����
   * */
	public static Connection getConnection()throws SQLException{
		return  ds.getConnection();
		 
	}
	
  /**
   * �ݱ�
   * insert, update, delete�ΰ��
   * */
	public static void dbClose(Connection con , Statement st){
		try {
		 if(st!=null) st.close();
		 if(con!=null)con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * select�ΰ�� �ݱ�
	 * */
	public static void dbClose(Connection con , Statement st , ResultSet rs) {
		try {
		 if(rs!=null)rs.close();
		 dbClose(con, st);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}











