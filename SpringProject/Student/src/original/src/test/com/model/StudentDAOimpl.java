package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOimpl implements StudentDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public StudentDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(StudentVO vo) {
		System.out.println("insert(studentVO vo)");

		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn complete..");

			String sql = "insert into student(num, name, kor, eng, math, total, avg, grade) values(seq_student_num.nextval, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTotal());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setString(7, vo.getGrade());


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
	public int update(StudentVO vo) {
		System.out.println("update(studentVO vo)");
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println(vo.getKor());

			String sql = "update student set kor = ?, eng = ?, math = ?, total = ?, avg = ?, grade = ? where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMath());
			pstmt.setInt(4, vo.getTotal());
			pstmt.setDouble(5, vo.getAvg());
			pstmt.setString(6, vo.getGrade());
			pstmt.setInt(7, vo.getNum());

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
	public int delete(StudentVO vo) {
		System.out.println("delete(studentVO vo)");
		int flag = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn complete");

			String sql = "delete from student where num = ?";

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
	public StudentVO selectOne(StudentVO vo) {
		System.out.println("selectOne(studentVO vo)");
		StudentVO svo = new StudentVO();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from student where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			// System.out.println("selectOne rs:" + rs);

			while (rs.next()) {
				svo.setNum(rs.getInt("num"));
				svo.setName(rs.getString("name"));
				svo.setKor(rs.getInt("kor"));
				svo.setEng(rs.getInt("eng"));
				svo.setMath(rs.getInt("math"));
				svo.setTotal(rs.getInt("total"));
				svo.setAvg(rs.getDouble("avg"));
				svo.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			System.out.println("selectOne failed");
			e.printStackTrace();
		}
		return svo;
	}

	@Override
	public List<StudentVO> selectAll() {
		System.out.println("selectAll()");
		List<StudentVO> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from student";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// System.out.println("selectAll rs:" + rs);

			while (rs.next()) {
				// System.out.println(99);

				StudentVO vo = new StudentVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMath(rs.getInt("math"));
				vo.setTotal(rs.getInt("math"));
				vo.setAvg(rs.getDouble("avg"));
				vo.setGrade(rs.getString("grade"));

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
