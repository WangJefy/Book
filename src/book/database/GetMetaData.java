package book.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建人：     Jefy
 * 项目名：     Book	
 * 类名：         GetMetaData
 * 创建时间： 2018年1月23日上午11:16:25
 * 修改人：     Jefy
 * 类描述：     获取数据库和数据表的元数据
 *        使用DatabaseMetaData获得数据库的元数据
 *        使用ResultSetMetaData获得结果集元数据
 * MySQL已有数据库studentdb，含数据表student_basic
 */
public class GetMetaData {
	/**
	 * 获取数据库元数据
	 * @param con 连接的数据库
	 */
	public static void showDatabaseMetaData(Connection con) {
		try {
			DatabaseMetaData md = con.getMetaData();
			System.out.println("数据库" + md.getURL() + "的元数据如下：");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示数据表的元数据
	 * @param con 与数据库的连接
	 * @param tableName 数据表名
	 */
	public static void showTableMetaData(Connection con,String tableName) {
		String sql = "SELECT * FROM " + tableName;
		Statement sm = null;
		
		//首先获得数据表的所有数据
		try {
			sm = con.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			
			//得到结果集的元数据
			ResultSetMetaData md = rs.getMetaData();
			
			System.out.println("数据表" + tableName + "的元数据如下：");
			
			int columnCount = md.getColumnCount();
			System.out.println("column count:" + columnCount ); 
			System.out.println();
			StringBuffer sb = new StringBuffer("");
			sb.append("sn\tname\t\t").append("type\t\t");
			sb.append("scale\t").append("isNullable");
			System.out.println(sb);
			sb.delete(0, sb.length());
			
			//输出列的信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
