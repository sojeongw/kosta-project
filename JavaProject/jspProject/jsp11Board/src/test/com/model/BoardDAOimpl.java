package test.com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(BoardVO vo) {
		System.out.println("insert(boardVO vo)");

		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete..");

			String sql = "insert into board values(seq_board_num.nextval, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getWriter());

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
	public int update(BoardVO vo) {
		System.out.println("update(boardVO vo)");
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete..");

			String sql = "update board set title = ?, content = ?, writer = ? where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());
			

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getWriter());
			System.out.println(vo.getReg_date());

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
	public int delete(BoardVO vo) {
		System.out.println("delete(boardVO vo)");
		int flag = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete");

			String sql = "delete from board where num = ?";

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
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne(boardVO vo)");
		BoardVO bvo = new BoardVO();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			// System.out.println("selectOne rs:" + rs);
			
			while (rs.next()) {
				bvo.setNum(rs.getInt("num"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setReg_date(rs.getDate("reg_date"));
			}
		} catch (Exception e) {
			System.out.println("selectOne failed");
			e.printStackTrace();
		}
		return bvo;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("selectAll()");
		List<BoardVO> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from board order by num desc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// System.out.println("selectAll rs:" + rs);

			while (rs.next()) {
				// System.out.println(99);

				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReg_date(rs.getDate("reg_date"));

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
