package monk.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAOImpl implements ClientDAO {

	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertClient(Client c) {
		int status = 0;
		try {
			con = MonkConnection.getCon();
			ps = con.prepareStatement("insert into client values(?,?");
			ps.setString(1, c.getUserName());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
		return status;
	}

	@Override
	public Client getClient(String userId, String pass) {
		Client c = new Client();

		try {
			con = MonkConnection.getCon();
			ps = con.prepareStatement("select * from client where userid=? and password= ?");
			ps.setString(1, userId);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setUserName(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return c; 
	}

}
