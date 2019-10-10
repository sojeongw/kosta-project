package project.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class RoomCtrlImpl implements RoomCtrl {
    Random r;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int max;

	public RoomCtrlImpl() {
		try {
			// DB Driver 연결
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("failed..");
			e.printStackTrace();
		}
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			// 2.디비질의문 작성
			String sql = "SELECT * FROM OFFICE_TABLE ORDER BY R_NUM ASC";
			// 3.질의처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			// 4.질의문 실행
			rs = pstmt.executeQuery();
			System.out.println(rs);
			System.out.println("errorS1");

			if (rs.next()) { // 마지막 넘버를 갖고와 랜덤을 생성하는데 사용한다.
				while (rs.next()) {
					max = rs.getInt("R_NUM");
				}
			} else {
				max = 0;
			}
			System.out.println("errorS2");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
	}

	@Override
	public void RandomFire() { // 난수를 사용해 임의의 방에 화재를 상정
		r = new Random();
		int ran = 1;
		if (max != 0) {
			ran = r.nextInt(max) + 1;
		}
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			// 2.디비질의문 작성
			String sql = "UPDATE OFFICE_TABLE SET " + "FIRE=1 " + "WHERE R_NUM = ?";
			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ran);
			// 4.질의문 실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	}

	@Override
	public void RandomInv() { // 난수를 사용해 임의의 방에 침임을 상정
		r = new Random();
		int ran = 1;
		if (max != 0) {
			ran = r.nextInt(max) + 1;
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			String sql = null;
			if (ran % 2 == 0) {
				sql = "UPDATE OFFICE_TABLE SET " + "WINDOW_SCE=1 " + "WHERE R_NUM = ?";
			} else {
				sql = "UPDATE OFFICE_TABLE SET " + "DOOR_SCE=1 " + "WHERE R_NUM = ?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ran);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	}

	@Override
	public int FireDetect() { // 화재가 난 방의 번호를 리턴해주는 메소드
		int detectNum = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			String sql = "SELECT R_NUM FROM OFFICE_TABLE WHERE FIRE=1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				detectNum = rs.getInt("R_NUM");
			}
			System.out.println(detectNum);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
		return detectNum;
	}

	@Override
	public int InvDetect() { // 침입이 일어난 방의 번호를 리턴해주는 메소드
		int detectNum = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			String sql = "SELECT R_NUM FROM OFFICE_TABLE WHERE WINDOW_SCE=1 OR DOOR_SCE=1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				detectNum = rs.getInt("R_NUM");
			}
			System.out.println(detectNum);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
		return detectNum;
	}

	@Override
	public int FireAction(int num) { // 불이난 방에 접근해 소화해주는 메소드
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			String sql = "UPDATE OFFICE_TABLE SET " + "FIRE = 0";
			pstmt = conn.prepareStatement(sql);

			flag = pstmt.executeUpdate();

			System.out.println("Extinguish successed");
		} catch (Exception e) {
			System.out.println("Extinguish failed");
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
	public int InvAction(int num) { // 침입에 대한 처리를 해주는 메소드
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			String sql = "UPDATE OFFICE_TABLE SET " + "WINDOW_SCE = 0, DOOR_SCE = 0";
			pstmt = conn.prepareStatement(sql);

			flag = pstmt.executeUpdate();

			System.out.println("Extinguish successed");
		} catch (Exception e) {
			System.out.println("Extinguish failed");
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

}
