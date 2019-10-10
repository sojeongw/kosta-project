package project.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomDAOimpl implements RoomDAO {
	//입력처리를 위한 객체 생성
	InputStream is = System.in;
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public RoomDAOimpl() {
		try {
			// DB Driver 연결
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("failed..");
			e.printStackTrace();
		}
		
	}

	@Override
	public int insert(RoomVO vo) {
		int flag = 0;
		try {
			
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			// 2.디비 질의문 작성
			String sql = "INSERT INTO OFFICE_TABLE(R_NUM,R_NAME,WINDOW_CNT,DOOR_CNT) VALUES(?,?,?,?)";

			// 3.질의문 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getR_num());
			pstmt.setString(2, vo.getR_name());
			pstmt.setInt(3, vo.getWindow_cnt());
			pstmt.setInt(4, vo.getDoor_cnt());

			// 4.질의문 실행
			flag = pstmt.executeUpdate();
			System.out.println("insert successed");
		} catch (SQLException e) { //삽입 실패시 오류출력(SQL)
			System.out.println("insert failed");
			e.printStackTrace();
		} finally { // 커넥션 해제
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
	public int update(RoomVO vo) {
		int flag = 0;
		
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("connection successed");
			// 2.디비 질의문 작성
			String sql = "UPDATE OFFICE_TABLE SET " + "R_NAME=?, WINDOW_CNT=?, DOOR_CNT=? " + "WHERE R_NUM = ?";
			// 3.질의문 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getR_name());
			pstmt.setInt(2, vo.getWindow_cnt());
			pstmt.setInt(3, vo.getDoor_cnt());
			pstmt.setInt(4, vo.getR_num());
			// 4.질의문 실행
			flag = pstmt.executeUpdate();
			
			System.out.println("update successed");
		} catch (SQLException e) { // 수정실패오류(SQL)
			System.out.println("update failed");
			e.printStackTrace();
		} finally { // 커넥션 해제
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
	public int delete(int num) {
		System.out.println("delete...");
		int flag = 0;
		
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			// 2.디비 질의문 작성
			String sql = "DELETE FROM OFFICE_TABLE WHERE R_NUM=?";
			// 3.질의문 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4.질의문 실행
			flag = pstmt.executeUpdate();

		} catch (SQLException e) { //삭제실패오류(SQL)
			System.out.println("Delete failed");
		} finally { //커넥션 해제
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
	public RoomVO selectOne(RoomVO vo) {
		RoomVO temp = new RoomVO();
		//int input_num = 0;
		
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("conn successed");
			// 2.디비 질의문 작성
			String sql = "SELECT * FROM OFFICE_TABLE WHERE R_NUM=?";
			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(vo.getR_num()));
			// 4.질의문 실행
			rs = pstmt.executeQuery();
			System.out.println("selectOne rs:" + rs);
			// rs.next => 순회하며 다음값 있는지 확인
			// DB에서 SELECT한 튜플을 받아옴
			while (rs.next()) {
				temp.setR_num(rs.getInt("R_NUM"));
				temp.setR_name(rs.getString("R_NAME"));
				temp.setWindow_cnt(rs.getInt("WINDOW_CNT"));
				temp.setDoor_cnt(rs.getInt("DOOR_CNT"));
				temp.setFire(rs.getInt("FIRE"));
				temp.setWindow_sce(rs.getInt("WINDOW_SCE"));
				temp.setDoor_sce(rs.getInt("DOOR_SCE"));
			}
		} catch (SQLException e) { // selectOne 실패 오류
			System.out.println("selectOne failed");
			e.printStackTrace();
		} finally { // 커넥션 해제
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
		return temp;
	}

	@Override
	public List<RoomVO> selectAll() { 
		System.out.println("selectAll()");
		List<RoomVO> list = new ArrayList<RoomVO>();
		try {
			// 1.커넥션
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOM", "hi123456");
			System.out.println("conn successed");
			// 2.디비 질의문 작성
			String sql = "SELECT * FROM OFFICE_TABLE ORDER BY R_NUM";
			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			// 4.질의문 실행
			rs = pstmt.executeQuery();
			System.out.println("selectAll rs:" + rs);

			// DB에서 SELECT한 튜플을 받아옴
			while (rs.next()) {
				RoomVO temp = new RoomVO();
				temp.setR_num(rs.getInt("R_NUM"));
				temp.setR_name(rs.getString("R_NAME"));
				temp.setWindow_cnt(rs.getInt("WINDOW_CNT"));
				temp.setDoor_cnt(rs.getInt("DOOR_CNT"));
				temp.setFire(rs.getInt("FIRE"));
				temp.setWindow_sce(rs.getInt("WINDOW_SCE"));
				temp.setDoor_sce(rs.getInt("DOOR_SCE"));
				list.add(temp);
			}
		} catch (SQLException e) { // selectAll 실패 오류
			System.out.println("selectAll failed");
			e.printStackTrace();
		} finally { // 커넥션 해제
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
		return list;
	}

}