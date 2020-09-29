package monk.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class MonkConnection implements MonkLogin {

	static Connection con = null;

	public static Connection getCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connUrl, userName, password);
		} catch (Exception e) {
			System.out.println(e);
			//e.printStackTrace();
		}
		return con;
	}

}
