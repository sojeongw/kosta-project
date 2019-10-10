package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MemberDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert(MemberVO vo)");

		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Member", "hi123456");
			System.out.println("conn complete..");

			String sql = "insert into Member(num, id, pw, name, tel) values(seq_Member_num.nextval, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getId());
			System.out.println(vo.getPw());
			System.out.println(vo.getName());
			System.out.println(vo.getTel());

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
	public int update(MemberVO vo) {
		System.out.println("update(MemberVO vo)");
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Member", "hi123456");
			System.out.println("conn complete..");

			String sql = "update Member set id = ?, pw = ?, name = ?, tel = ? where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setInt(5, vo.getNum());

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getId());
			System.out.println(vo.getPw());
			System.out.println(vo.getName());
			System.out.println(vo.getTel());

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
	public int delete(MemberVO vo) {
		System.out.println("delete(MemberVO vo)");
		int flag = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Member", "hi123456");
			System.out.println("conn complete");

			String sql = "delete from Member where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete failed...");
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
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne(MemberVO vo)");
		MemberVO mvo = new MemberVO();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Member", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from Member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			// System.out.println("selectOne rs:" + rs);

			while (rs.next()) {
				mvo.setNum(rs.getInt("num"));
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("pw"));
				mvo.setName(rs.getString("name"));
				mvo.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			System.out.println("selectOne failed");
			e.printStackTrace();
		}
		return mvo;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()");
		List<MemberVO> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Member", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from Member order by num";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// System.out.println("selectAll rs:" + rs);

			while (rs.next()) {
				// System.out.println(99);

				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("error");
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
