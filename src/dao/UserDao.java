package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDao {
	
//	public boolean userLogin(User user) {
//		return true;
//		
//	}
	
	public boolean userLogin(User user) {
		boolean status = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			System.out.println(user.getEmail());
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
}
