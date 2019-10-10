package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test01DAOimpl implements Test01DAO {

	List<Test01VO> list = new ArrayList<Test01VO>();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Test01DAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Test01VO vo) {
		System.out.println("insert()");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		int flag = 0;
		try {
			// 1.커넥션객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "hi123456");
			System.out.println("conn succeeded..");

			// 2.디비 질의문 작성
			// insert into test(num, name) values('4', 'choi4');
			String sql = "insert into test(num, name) values(seq_test_num.nextval, ?)";
			
			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			// 좌측에서 ?가 있는 순서 인덱스 , 들어갈 값

			// 4.질의문 실행
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert failed..");
			e.printStackTrace();
		} finally {
			// 5.닫기
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

	// 숙제 : update 수정하고 닫기
	@Override
	public int update(Test01VO vo) {
		System.out.println("update()");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		int flag = 0;
		try {
			// 1.커넥션객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "hi123456");
			System.out.println("conn successed..");

			// 2.디비 질의문 작성
			String sql = "update test set name=? where num=?";

			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getNum());

			// 4.질의문 실행
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update failed..");
		} finally {
			// 5.닫기
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
	public int delete(Test01VO vo) {
		System.out.println("delete()");
		System.out.println(vo.getNum());
		int flag = 0;
		try {
			// 1.커넥션객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "hi123456");
			System.out.println("conn successed..");

			// 2.디비 질의문 작성
			String sql = "delete from test where num=?";

			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			// 4.질의문 실행
			flag = pstmt.executeUpdate();
			System.out.println("delete flag:" + flag);

		} catch (SQLException e) {
			System.out.println("delete failed..");
		} finally {
			// 5.닫기
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
	// select * from test; 와 같은 의미
	public List<Test01VO> selectAll() {
		System.out.println("selectAll()...");
		List<Test01VO> list = new ArrayList<Test01VO>();
		try {
			// 1.커넥션객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "hi123456");
			System.out.println("conn successed..");

			// 2.디비 질의문 작성
			String sql = "select * from test";

			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 4.질의문 실행
			// list를 반환해야 하므로
			rs = pstmt.executeQuery();
			System.out.println("selectAll rs:" + rs);
			// 주소가 생김 >> null이 아님 >> 점 찍을 수 있다.
			// System.out.println(rs.next()); // true 반환하면 반복문 만들 수 있음
			// 몇 개의 행이 있는지 모르니까 이걸로 쓰는 것임

			while (rs.next()) { // 읽고 또 읽어올 게 있으면 next
				// System.out.println(99); // db에 저장된 개수만큼 출력됨

				// 값을 받아서 list에 넘기는게 vo니까
				Test01VO vo = new Test01VO();
				// column이름과 맞춰줘서 거기에 있는 값을 vo로 보낸다
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				// list에 추가하기
				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("error");
		} finally {
			// 5.닫기
			
			// rs 닫기 추가
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

	@Override
	// selectOne은 All에 where만 쓴것
	public Test01VO selectOne(Test01VO vo) {
		System.out.println("selectOne()");
		System.out.println(vo.getNum());

		Test01VO vo2 = new Test01VO();

		try {
			// 1.커넥션객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "hi123456");
			System.out.println("conn succeeded..");

			// 2.디비 질의문 작성
			String sql = "select * from test where num=?";

			// 3.질의문 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			// 4.질의문 실행
			rs = pstmt.executeQuery();
			System.out.println("selectOne rs:" + rs);

			while (rs.next()) {
//				 System.out.println(rs.getInt("num"));
//				 System.out.println(rs.getString("name"));
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			System.out.println("selectAll failed..");
			e.printStackTrace();
		} finally {
			// 5.닫기
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

		return vo2;
	}

}
