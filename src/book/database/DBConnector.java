package book.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         DBConnector
 * 创建时间： 2018年1月23日上午9:42:47
 * 修改人：     Jefy
 * 类描述：     连接各类数据库的方法
 */
public class DBConnector {
	/**
	 * 获取连接对象
	 * @param driverClassName 连接数据库用到的驱动类类名
	 * @param dbURL 数据库的URL
	 * @param userName 用户名
	 * @param password 密码
	 * @return 返回一个连接对象
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection(String driverClassName,String dbURL,String userName,String password) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		//加载连接数据库的驱动类
		Class.forName(driverClassName);
		//通过 数据库URL、用户名、密码 连接数据库
		con = DriverManager.getConnection(dbURL,userName,password);
		
		return con;
	}
	
	/**
	 * 获得ORCLE数据库连接
	 * @param driverClassName
	 * @param serverHost
	 * @param serverPort
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return 返回一个数据库连接对象
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getOracleConnection(String driverClassName,String serverHost,String serverPort,String dbName,String userName,String password) throws ClassNotFoundException, SQLException {
		if(driverClassName == null) {
			driverClassName = "oracle.jdbc.driver.OracleDriver";
		}
		if(serverHost == null) {
			serverHost = "127.0.0.1";
		}
		if(serverPort == null) {
			serverPort = "1521";
		}
		
		//构建访问Oracle数据库的URL
		String dbURL = "jdbc:oracle:thin:@" + serverHost + ":" + serverPort + ":" + dbName;
		return getConnection(driverClassName,dbURL,userName,password);
	}
	
	/**
	 * 获得SQLServer数据库的连接
	 * @param driverClassName
	 * @param serverHost
	 * @param serverPort
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getSQLServerConnection(String driverClassName,String serverHost,String serverPort,String dbName,String userName,String password) throws ClassNotFoundException, SQLException {
		if(driverClassName == null) {
			driverClassName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		}
		if(serverHost == null) {
			serverHost ="127.0.0.1";
		}
		if(serverPort == null) {
			serverPort = "1433";
		}
		//构建访问SQLServer数据库的URL
		String dbURL = "jdbc:microsoft:sqlserver://" + serverHost + ":" + serverPort + "; DatabaseName=" + dbName;
		return getConnection(driverClassName,dbURL,userName,password);
	}
	
	public static Connection getMySQLConnection(String driverClassName,String serverHost,String serverPort,String dbName,String userName,String password) throws ClassNotFoundException, SQLException {
		if(driverClassName == null) {
			driverClassName = "com.mysql.jdbc.Driver";
		}
		if(serverHost == null) {
			serverHost = "127.0.0.1";
		}
		if(serverPort == null) {
			serverPort = "3306";
		}
		
		String dbURL = "jdbc:mysql://" + serverHost + ":" + serverPort + "/" + dbName;
		    
		return getConnection(driverClassName,dbURL,userName,password);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String mySQLDriver = "com.mysql.jdbc.Driver";
		String dbName = "test";
		String userName = "root";
		String password = "123456";
		
		Connection con = DBConnector.getMySQLConnection(mySQLDriver, null, null, dbName, userName, password);
		System.out.println("连接数据库" + dbName + "...成功");
		con.close();
		System.out.println("关闭数据库" + dbName + "...成功");
		
		String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
		con = DBConnector.getConnection(mySQLDriver, url, userName, password);
		System.out.println("连接数据库" + dbName + "...成功");
		con.close();
		System.out.println("关闭数据库" + dbName + "...成功");
	}
}
