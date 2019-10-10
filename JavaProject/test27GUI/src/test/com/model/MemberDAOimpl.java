package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAOimpl implements MemberDAO {

	List<MemberVO> list = new ArrayList<>();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	/////// 초기화
	public MemberDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver connected");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}
	////////////////////////////////////

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert(MemberVO vo)...");
		int flag = 0;

		try {
			// 1.커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			// System.out.println("insert conn succeeded");

			// 2.쿼리 작성
			String sql = "insert into member(num, id, pw, name, tel) values(seq_member_num.nextval, ?, ?, ?, ?)";

			// 3.쿼리를 처리할 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			
			list.add(vo);

			// 4.쿼리 실행
			flag = pstmt.executeUpdate();
			
			// test
			//System.out.println(vo.getId());

		} catch (Exception e) {
			System.out.println("insert failed");
			e.printStackTrace();
		} finally {
			// 5.닫기
			if (pstmt != null) {
				try {
					pstmt.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
			if (conn != null) {
				try {
					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
		}	// end of finally
		return flag;
	} // end of insert

	@Override
	public int update(MemberVO vo) {
		int flag = 0;
		
		try {
			// 1.커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("update conn succeeded");
			
			// 2.쿼리 작성
			String sql = "update member set id = ?, pw = ?, name = ?, tel = ? where num = ?";
			
			// 3.쿼리를 실행할 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setInt(5, vo.getNum());
			
			// 3.쿼리 실행
			flag = pstmt.executeUpdate();
			
			//list.set(vo.getNum(), vo);
			
			// test
			// System.out.println(vo.getId());
			
		} catch(Exception e) {
			System.out.println("update failed");
			e.printStackTrace();
			
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
		}	// end of finally
		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete(MemberVO vo)...");
		int flag = 0;
		
		try {
			// 1.커넥션 객체 설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded");
			
			// 2.쿼리 작성
			String sql = "delete from member where num = ?";
			
			// 3.쿼리 처리 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			// 4.쿼리 실행
			flag = pstmt.executeUpdate();
			
			list.remove(vo.getNum());
			
			// test
			
		} catch(Exception e) {
			System.out.println("delete failed");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	// end of if
		}	// end of finally
		return flag;
	}
	
	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne(MemberVO vo)...");
		
		try {
			// 1.커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded...");
			
			// 2.쿼리 작성
			String sql = "select * from member where num = ?";
			
			// 3.쿼리를 실행할 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			// 4.쿼리 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("id" + "\t"));
				System.out.print(rs.getString("pw" + "\t"));
				System.out.print(rs.getString("name" + "\t"));
				System.out.print(rs.getString("tel" + "\n"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
		return vo;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("List<MemberVO> selectAll()");
		MemberVO vo = new MemberVO();
		
		try {
			// 1.커넥션 객체 설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "hi123456");
			System.out.println("conn succeeded..");
			
			// 2.쿼리
			String sql = "select * from member";
			
			// 3.쿼리를 실행할 객체 설정
			pstmt = conn.prepareStatement(sql);
			
			// 4.쿼리 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setNum(rs.getInt("NUM"));
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PW"));
				vo.setName(rs.getString("NAME"));
				vo.setTel(rs.getString("TEL"));
				
				list.add(vo);
			}
			
			return list;
			//System.out.println(rs.getObject(1));
		}catch(Exception e) {
			System.out.println("selectAll failed");
			e.printStackTrace();
		}finally {
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

	

} // end of class

// int flag = 0;
// vo.setNum(count);
// try {
// System.out.print(vo.getNum() + " ");
// System.out.print(vo.getId() + "\t");
// System.out.print(vo.getPw() + "\t");
// System.out.print(vo.getName() + "\t");
// System.out.println("\t" + vo.getTel()+"\n");
// flag = 1;
// count++;
// } catch(Exception e) {
// flag = 0;
// }
// return flag;
// }
//
//
// // 2. update
// public int update(MemberVO vo) {
// System.out.println("update-------------");
// list.set(vo.getNum()-1, vo);
// int flag = 0;
//
// try {
// System.out.print(vo.getNum() + " ");
// System.out.print(vo.getId() + "\t");
// System.out.print(vo.getPw() + "\t");
// System.out.print(vo.getName() + "\t");
// System.out.println("\t" + vo.getTel()+ "\n");
// flag = 1;
//
// } catch (Exception e) {
// flag = 0;
// }
//
// return flag;
// }
//
// // 3. delete
// public int delete(MemberVO vo) {
// System.out.println("delete-------------");
// list.remove(vo.getNum()-1);
// int flag = 0;
//
// try {
// // delete 하고나서 글 번호가 +1 되는 문제 발생
// System.out.print("삭제가 완료되었습니다.");
// System.out.println();
//
// flag = 1;
//
// } catch(Exception e) {
// flag = 0;
// }
//
// return flag;
// }
//
// // 4. selectAll
// public List<MemberVO> selectAll() {
// System.out.println("selectAll-------------");
// try {
//// System.out.println(list.get(0));
//// System.out.println(list.get(1));
//// System.out.println(list.get(2));
// return list;
// } catch(Exception e) {
// System.out.println("목록을 불러올 수 없습니다.\n");
// return null;
// }
//
// }
//
// // 5. selectOne
// public List<MemberVO> selectOne(MemberVO vo) {
// MemberVO mvo = list.get(vo.getNum()-1);
// try {
// System.out.println("selectOne-------------");
// System.out.print(mvo.getNum() + " ");
// System.out.print(mvo.getId() + "\t");
// System.out.print(mvo.getPw() + "\t");
// System.out.print(mvo.getName() + "\t");
// System.out.println("\t" + mvo.getTel()+ "\n");
// return list;
// } catch(Exception e) {
// System.out.println("목록을 불러올 수 없습니다.\n");
// return null;
// }
//
// }
