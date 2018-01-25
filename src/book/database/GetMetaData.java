package book.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �����ˣ�     Jefy
 * ��Ŀ����     Book	
 * ������         GetMetaData
 * ����ʱ�䣺 2018��1��23������11:16:25
 * �޸��ˣ�     Jefy
 * ��������     ��ȡ���ݿ�����ݱ��Ԫ����
 *        ʹ��DatabaseMetaData������ݿ��Ԫ����
 *        ʹ��ResultSetMetaData��ý����Ԫ����
 * MySQL�������ݿ�studentdb�������ݱ�student_basic
 */
public class GetMetaData {
	/**
	 * ��ȡ���ݿ�Ԫ����
	 * @param con ���ӵ����ݿ�
	 */
	public static void showDatabaseMetaData(Connection con) {
		try {
			DatabaseMetaData md = con.getMetaData();
			System.out.println("���ݿ�" + md.getURL() + "��Ԫ�������£�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʾ���ݱ��Ԫ����
	 * @param con �����ݿ������
	 * @param tableName ���ݱ���
	 */
	public static void showTableMetaData(Connection con,String tableName) {
		String sql = "SELECT * FROM " + tableName;
		Statement sm = null;
		
		//���Ȼ�����ݱ����������
		try {
			sm = con.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			
			//�õ��������Ԫ����
			ResultSetMetaData md = rs.getMetaData();
			
			System.out.println("���ݱ�" + tableName + "��Ԫ�������£�");
			
			int columnCount = md.getColumnCount();
			System.out.println("column count:" + columnCount ); 
			System.out.println();
			StringBuffer sb = new StringBuffer("");
			sb.append("sn\tname\t\t").append("type\t\t");
			sb.append("scale\t").append("isNullable");
			System.out.println(sb);
			sb.delete(0, sb.length());
			
			//����е���Ϣ
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
