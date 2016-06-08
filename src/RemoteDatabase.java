//test the new branch

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RemoteDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		jdbc();
	}

	private static void jdbc() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String urlRemote = "jdbc:mysql://10.107.33.36:3306/jdbctest";
		String urlLocal = "jdbc:mysql://localhost:3306/newtest";
		String user = "root";
		String password = "root";

		String sql = "select * from student";

		try {
			//注册驱动，加载想要连接的数据库的驱动到JVM
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlRemote, user, password);
			
			stmt = conn.createStatement();
			// 这两种也可以获取Statement实例
			// PreparedStatement pstmt = conn.prepareStatement(sql) ;
			// CallableStatement cstmt = conn.prepareCall("{CALL demoSp(? , ?)}")；

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getObject(1) + "\t");
				System.out.print(rs.getObject(2) + "\t");
				// System.out.print(rs.getObject(3)+"\t");
				// System.out.print(rs.getObject(4)+"\t");
				System.out.println();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
