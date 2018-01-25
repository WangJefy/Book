package book.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         DBConnector
 * ����ʱ�䣺 2018��1��23������9:42:47
 * �޸��ˣ�     Jefy
 * ��������     ���Ӹ������ݿ�ķ���
 */
public class DBConnector {
	/**
	 * ��ȡ���Ӷ���
	 * @param driverClassName �������ݿ��õ�������������
	 * @param dbURL ���ݿ��URL
	 * @param userName �û���
	 * @param password ����
	 * @return ����һ�����Ӷ���
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection(String driverClassName,String dbURL,String userName,String password) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		//�����������ݿ��������
		Class.forName(driverClassName);
		//ͨ�� ���ݿ�URL���û��������� �������ݿ�
		con = DriverManager.getConnection(dbURL,userName,password);
		
		return con;
	}
	
	/**
	 * ���ORCLE���ݿ�����
	 * @param driverClassName
	 * @param serverHost
	 * @param serverPort
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return ����һ�����ݿ����Ӷ���
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
		
		//��������Oracle���ݿ��URL
		String dbURL = "jdbc:oracle:thin:@" + serverHost + ":" + serverPort + ":" + dbName;
		return getConnection(driverClassName,dbURL,userName,password);
	}
	
	/**
	 * ���SQLServer���ݿ������
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
		//��������SQLServer���ݿ��URL
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
		System.out.println("�������ݿ�" + dbName + "...�ɹ�");
		con.close();
		System.out.println("�ر����ݿ�" + dbName + "...�ɹ�");
		
		String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
		con = DBConnector.getConnection(mySQLDriver, url, userName, password);
		System.out.println("�������ݿ�" + dbName + "...�ɹ�");
		con.close();
		System.out.println("�ر����ݿ�" + dbName + "...�ɹ�");
	}
}
