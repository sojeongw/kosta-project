package assignment.student;

public class StudentDAOimpl implements StudentDAO {
	
	// 1. insert
			public void insert(StudentVO vo) {
				//System.out.println("insert ���������������");
				System.out.println();
				System.out.print(vo.getNum() + "  ");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.print(vo.getMath() + "\t");
				System.out.print(vo.getTotal() + "\t1");
				System.out.print(vo.getAvg() + "\t");
				System.out.println("\t" + vo.getGrade());
				System.out.println();
				
			}
			
			
			
			// 2. update
			public void update(StudentVO vo) {
				System.out.println();
				System.out.print(vo.getNum() + "  ");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.print(vo.getMath() + "\t");
				System.out.print(vo.getTotal() + "\t");
				System.out.print(vo.getAvg() + "\t");
				System.out.println("\t" + vo.getGrade());
				System.out.println();
			}
			
			
			
			// 3. delete
			public void delete(StudentVO vo) {
				System.out.println();
				System.out.print(vo.getNum() + "  ");
				System.out.println();
				System.out.println();
			}
			
			
			
			// 4. selectAll
			public StudentVO[] selectAll() {
				
				StudentVO s01 = new StudentVO();
				StudentVO s02 = new StudentVO();
				StudentVO s03 = new StudentVO();
				StudentVO[] sArr = new StudentVO[] {s01, s02, s03};
				
				sArr[0] = s01;
				sArr[1] = s02;
				sArr[2] = s03;
				
				//	s01
				s01.setNum(1);
				s01.setName("왕소정");
				s01.setKor(100);
				s01.setEng(100);
				s01.setMath(100);
				s01.setTotal(s01.getKor() + s01.getEng() + s01.getMath());
				s01.setAvg((double) s01.getTotal() / 3);
				
				String grade = "";
				if (s01.getAvg() >= 90) {
					grade = "A";
				} else if (s01.getAvg() >= 80) {
					grade = "B";
				} else if (s01.getAvg() >= 70) {
					grade = "C";
				} else {
					grade = "D";
				}
				s01.setGrade(grade);
				
				
				//	s02
				s02.setNum(2);
				s02.setName("서강준");
				s02.setKor(50);
				s02.setEng(70);
				s02.setMath(90);
				s02.setTotal(s02.getKor() + s02.getEng() + s02.getMath());
				s02.setAvg((double) s02.getTotal() / 3);
				
				String grade2 = "";
				if (s02.getAvg() >= 90) {
					grade2 = "A";
				} else if (s02.getAvg() >= 80) {
					grade2 = "B";
				} else if (s02.getAvg() >= 70) {
					grade2 = "C";
				} else {
					grade2 = "D";
				}
				s02.setGrade(grade2);
				
				//	s03
				s03.setNum(3);
				s03.setName("유승호");
				s03.setKor(95);
				s03.setEng(60);
				s03.setMath(80);
				s03.setTotal(s03.getKor() + s03.getEng() + s03.getMath());
				s03.setAvg((double) s03.getTotal() / 3);
				
				String grade3 = "";
				if (s03.getAvg() >= 90) {
					grade3 = "A";
				} else if (s03.getAvg() >= 80) {
					grade3 = "B";
				} else if (s03.getAvg() >= 70) {
					grade3 = "C";
				} else {
					grade3 = "D";
				}
				s03.setGrade(grade3);
				
				
				return sArr;
			}
			
			
			
			// 5. selectOne
			public void selectOne(StudentVO vo) {
				System.out.println(vo.getNum());
				System.out.println();
			}


}
