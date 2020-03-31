package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Conexion {
	
	static final String URL = "jdbc:postgresql://localhost:5432/locadora";
	static final String USER = "postgres";
	static final String PASSWORD = "samueljr875";
			
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static JdbcRowSet getRowSetConnection() {
	        try {
	            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
	            jdbcRowSet.setUrl(URL);
	            jdbcRowSet.setUsername(USER);
	            jdbcRowSet.setPassword(PASSWORD);
	            return jdbcRowSet;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	 
	public static CachedRowSet getRowSetConnectionCached() {
	        try {
	            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
	            cachedRowSet.setUrl(URL);
	            cachedRowSet.setUsername(USER);
	            cachedRowSet.setPassword(PASSWORD);
	            return cachedRowSet;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	public static void close(RowSet jrs) {
	        try {
	            if (jrs != null)
	                jrs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void close(Connection connection) {
	        try {
	            if (connection != null)
	                connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	public static void close(Connection connection, Statement stmt) {
	        close(connection);
	        try {
	            if (stmt != null)
	                stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	public static void close(Connection connection, Statement stmt, ResultSet rs) {
	        close(connection, stmt);
	        try {
	            if (rs != null)
	                rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
}
