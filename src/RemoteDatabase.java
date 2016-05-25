import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RemoteDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		try {
			jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void jdbc() throws SQLException  {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String urlRemote = "jdbc:mysql://10.107.33.36:3306/jdbctest";
		String urlLocal = "jdbc:mysql://localhost:3306/newtest";
		String user = "root";
		String password = "root";
		
		String sql = "select * from student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlRemote, user,	password);
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getObject(1) + "\t");
				System.out.print(rs.getObject(2) + "\t");
				// System.out.print(rs.getObject(3)+"\t");
				// System.out.print(rs.getObject(4)+"\t");
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}

	}

}
