package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

	List<BoardVO> list = new ArrayList<>();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	////////////// driver connection
	public BoardDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver connected");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(BoardVO bvo) {
		System.out.println("insert()...");
		// test
		// System.out.println(bvo.getNum());
		// System.out.println(bvo.getTitle());

		int flag = 0;
		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded");

			// 2.孽府 累己
			String sql = "insert into board(num, title, content, writer) values(seq_board_num.nextval, ?, ?, ?)";

			// 3.孽府 贸府 按眉 积己
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setString(3, bvo.getWriter());

			// 4.龙狼巩 角青
			flag = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insert failed..");
			e.printStackTrace();
		} finally {
			// 5.摧扁
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
	public int update(BoardVO bvo) {
		System.out.println("update()...");
		// test
		// System.out.println(bvo.getTitle());
		// System.out.println(bvo.getContent());
		// System.out.println(bvo.getWriter());

		int flag = 0;
		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded");

			// 2.孽府 累己
			String sql = "update board set title = ?, content = ?, writer = ? where num = ?";

			// 3.孽府 贸府 按眉 积己
			pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, bvo.getTitle());
			 pstmt.setString(2, bvo.getContent());
			 pstmt.setString(3, bvo.getWriter());
			 pstmt.setInt(4, bvo.getNum());

			// 4.龙狼巩 角青
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update failed...");
			e.printStackTrace();
		} finally {
			// 5.摧扁
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
	public int delete(BoardVO bvo) {
		System.out.println("delete()...");
		int flag = 0;
		
		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded");

			// 2.孽府 累己
			String sql = "delete from board where num = ?";

			// 3.孽府 贸府 按眉 积己
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bvo.getNum());

			// 4.龙狼巩 角青
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			// 5.摧扁
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
	public BoardVO selectOne(BoardVO bvo) {
		System.out.println("selectOne()...");
		BoardVO vo2 = new BoardVO();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded..");
			
			String sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bvo.getNum());
			
			rs = pstmt.executeQuery();
			//System.out.println("selectOne rs:" + rs);
			
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				vo2.setNum(rs.getInt("num"));
				System.out.print(rs.getString("Title")+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getString("writer")+"\t");
				System.out.print(rs.getDate("reg_date")+"\n");
			}
		} catch(Exception e) {
			System.out.println("selectOne failed");
			e.printStackTrace();
		}
		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		// System.out.println("selectAll()...");
		List<BoardVO> list = new ArrayList<>();
		// 捞锭鳖瘤绰 list 府畔窍搁 0
		
		// 捞力 蔼阑 持绢林磊
		for(int i=9; i<10; i++) {
			BoardVO vo = new BoardVO();
			vo.setNum(i+1);
			vo.setTitle("title"+(i+1));
			vo.setContent("content"+(i+1));
			vo.setWriter("kim"+(i+1));
			vo.setRegDate(new Date());
			list.add(vo);
		}
		
//		try {
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
//			System.out.println("conn succeeded..");
//
//			String sql = "select * from board";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			//System.out.println("selectAll rs:" + rs);
//			
//			while(rs.next()) {
//				// System.out.println(99);
//				
//				BoardVO vo = new BoardVO();
//				vo.setNum(rs.getInt("num"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				vo.setRegDate(rs.getDate("reg_date"));
//				
//				list.add(vo);
//			}
//		} catch (Exception e) {
//			System.out.println("error");
//		} finally {
//			// 5.摧扁
//			// rs 摧扁 眠啊
//			if (rs != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return list;
	}

	

}
