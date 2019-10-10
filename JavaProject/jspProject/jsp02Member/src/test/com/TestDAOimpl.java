package test.com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public TestDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TestVO vo) {
		int flag = 0;

		System.out.println("insert start");
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "insert into member(num, id, pw, name, tel) values(seq_member_num.nextval, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert failed..");
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

		return flag;
	}

	@Override
	public int update(TestVO vo) {

		int flag = 0;

		System.out.println("update start");
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "update member set id = ?, pw = ?, name = ?, tel = ? where num = ?";
				
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setInt(5, vo.getNum());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update failed..");
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

		
		return flag;
	}

	@Override
	public int delete(TestVO vo) {
		
		int flag = 0;
		System.out.println("Delete Start");
		System.out.println(vo.getNum());
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "delete from member where num = ?";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete failed..");
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

		
		return flag;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		System.out.println("selectOne() start");
		System.out.println(vo.getNum());
		
		TestVO tvo = new TestVO();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn complete..");

			String sql = "select * from member where num = ?";				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				tvo.setNum(rs.getInt("num"));
				tvo.setId(rs.getString("id"));
				tvo.setPw(rs.getString("pw"));
				tvo.setName(rs.getString("name"));
				tvo.setTel(rs.getString("tel"));
			}
				

		} catch (SQLException e) {
			System.out.println("selectAll failed..");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return tvo;
		
	}

	@Override
	public List<TestVO> selectAll() {
		
		List<TestVO> list = new ArrayList<TestVO>();
		System.out.println("selectAll() start");
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn complete..");

			String sql = "select * from member";				
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// vo를 항상 새롭게 만들어줘야 list에 제대로 들어감
				TestVO vo = new TestVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				System.out.println(vo.getNum());
				System.out.println(vo.getName());
				list.add(vo);
			}
				

		} catch (SQLException e) {
			System.out.println("selectAll failed..");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
