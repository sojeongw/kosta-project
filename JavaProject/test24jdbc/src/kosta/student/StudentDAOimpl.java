package kosta.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.board.Test03BoardVO;

public class StudentDAOimpl implements StudentDAO {

	List<StudentVO> list = new ArrayList<StudentVO>();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public StudentDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver connected");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	// 1. insert
	public int insert(StudentVO vo) {

		int flag = 0;

		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("insert...");

			// 2.孽府 累己
			String sql = "insert into student(num, name, kor, eng, math, total, avg, grade) values(seq_student_num.nextval, ?, ?, ?, ?, ?, ?, ?)";

			// 3.孽府 角青 按眉 积己
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTotal());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setString(7, vo.getGrade());

			// 4.孽府角青
			flag = pstmt.executeUpdate();

			flag = 1;

		} catch (Exception e) {
			System.out.println("insert failed...");
			e.printStackTrace();

			flag = 0;
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

	// 2. update
	public int update(StudentVO vo) {

		int flag = 0;
		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("update...");

			// 2.孽府 累己
			String sql = "update student set kor = ?, eng = ?, math = ?, total = ?, avg = ?, grade = ? where num = ?";

			// 3.孽府 角青 按眉 积己
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, vo.getName());
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMath());
			pstmt.setInt(4, vo.getTotal());
			pstmt.setDouble(5, vo.getAvg());
			pstmt.setString(6, vo.getGrade());
			pstmt.setInt(7, vo.getNum());

			// 4.孽府角青
			flag = pstmt.executeUpdate();

			flag = 1;
		} catch (Exception e) {
			System.out.println("update failed..");
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
	public int delete(StudentVO vo) {
		int flag = 0;
		try {
			// 1.目池记 按眉 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn succeeded");
			
			// 2.孽府
			String sql ="delete from student where num = ?";
			
			// 3.孽府 角青 按眉
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			// 4.孽府 角青
			flag = pstmt.executeUpdate();
			
			flag = 1;
		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
			flag = 0;
		}finally {
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

	// 4. selectAll
	public List<StudentVO> selectAll() {
		
		try {
			// 1.目池记 积己
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn succeeded..");
			
			// 2.孽府
			String sql = "select * from student";
			
			// 3.孽府 角青 按眉 积己
			pstmt = conn.prepareStatement(sql);
			
			// 4.孽府 角青
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("kor")+"\t");
				System.out.print(rs.getInt("eng")+"\t");
				System.out.print(rs.getInt("math")+"\t");
				System.out.print(rs.getInt("total")+"\t");
				System.out.print(rs.getDouble("avg")+"\t");
				System.out.print(rs.getString("grade")+"\n\n");
			}
			
			
		} catch (Exception e) {
			System.out.println("selectAll failed");
			e.printStackTrace();
			
		}finally {
			// 5.摧扁
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

	// 5. selectOne
	public StudentVO selectOne(StudentVO vo) {
		StudentVO vo2 = new StudentVO();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn succeeded..");
			
			String sql = "select * from student where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("kor")+"\t");
				System.out.print(rs.getInt("eng")+"\t");
				System.out.print(rs.getInt("math")+"\t");
				System.out.print(rs.getInt("total")+"\t");
				System.out.print(rs.getDouble("avg")+"\t");
				System.out.print(rs.getString("grade")+"\n\n");
			}
		} catch (Exception e) {
			return null;
		}finally {
			// 5.摧扁
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
		return vo2;
	}

}
