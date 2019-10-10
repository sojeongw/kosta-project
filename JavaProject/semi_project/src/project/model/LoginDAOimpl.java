package project.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOimpl implements LoginDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public LoginDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc OracleDriver successed!");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed..");
			e.printStackTrace();
		} 
	}
	
	
	
	@Override
	public LoginVO selectOne(LoginVO lvo) {
		LoginVO temp = new LoginVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed!");
			String sql = "select * from login_table where id=? and pw=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lvo.getId());
			pstmt.setString(2, lvo.getPw());
		
			rs = pstmt.executeQuery();
			System.out.println("selectOne: "+rs);
			
			while (rs.next()) {
				temp.setNum(rs.getInt("NUM"));
				temp.setId(rs.getString("ID"));
				temp.setPw(rs.getString("PW"));
			}
		
		} catch (SQLException e) {
			System.out.println("connection failed..");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return temp;
	}



	@Override
	public List<LoginVO> selectAll() {
		 List<LoginVO> list = new ArrayList<>();
		 LoginVO temp = new LoginVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connnection successed!");
			
			String sql = "select * from login_table";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				temp.setId(rs.getString("ID"));
				temp.setPw(rs.getString("PW"));
			}
			
		} catch (SQLException e) {
			System.out.println("connecton failed..");
			e.printStackTrace();
		} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		}
		
		return list;
	}

}
