package test.com;

public class Test03MainStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Test03StudentVO
		Test03StudentVO vo = new Test03StudentVO();
		// vo.num = 10;
		vo.setNum(10);
		int num = vo.getNum();
		System.out.println(num);
		// System.out.println(vo.num);
		// vo.name = "kim";
		vo.setName("kim");
		System.out.println(vo.getName());
		// System.out.println(vo.name);
		vo.setKor(99);
		vo.setEng(88);
		vo.setMath(77);
		vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
		vo.setAvg((double) vo.getTotal() / 3);
		String grade = "";
		if (vo.getAvg() >= 90) {
			grade = "A";
		} else if (vo.getAvg() >= 80) {
			grade = "B";
		} else if (vo.getAvg() >= 70) {
			grade = "C";
		} else {
			grade = "D";
		}
		vo.setGrade(grade);

		System.out.println("============================");

		// 3. DAO의 메소드를 사용하기 위해 객체를 만들고
		Test03StudentDAO dao = new Test03StudentDAO();

		// 4. DAO 메소드를 콜 해본다
		int result = dao.insert(vo);
		System.out.println(result);

		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());

		System.out.println("============================");

		//////////////////////////////////////////////

		Test03StudentVO vo2 = new Test03StudentVO();
		// vo.num = 10;
		vo2.setNum(2);
		int num2 = vo2.getNum();
		System.out.println(num2);
		// System.out.println(vo.num);
		// vo.name = "kim";
		vo2.setName("kim2");
		System.out.println(vo2.getName());
		// System.out.println(vo.name);
		vo2.setKor(2);
		vo2.setEng(2);
		vo2.setMath(2);
		vo2.setTotal(vo2.getKor() + vo2.getEng() + vo2.getMath());
		vo2.setAvg((double) vo2.getTotal() / 3);
		String grade2 = "";
		if (vo2.getAvg() >= 90) {
			grade2 = "A";
		} else if (vo2.getAvg() >= 80) {
			grade2 = "B";
		} else if (vo2.getAvg() >= 70) {
			grade2 = "C";
		} else {
			grade2 = "D";
		}
		vo2.setGrade(grade2);

		System.out.println("============================");

		int result2 = dao.update(vo2);
		System.out.println(result2);

		System.out.println(vo2.getKor());
		System.out.println(vo2.getEng());
		System.out.println(vo2.getMath());
		System.out.println(vo2.getTotal());
		System.out.println(vo2.getAvg());
		System.out.println(vo2.getGrade());

		//////////////////////////////////////////////

		Test03StudentVO vo3 = new Test03StudentVO();
		// vo.num = 10;
		vo3.setNum(3);
		int num3 = vo3.getNum();
		System.out.println(num3);
		// System.out.println(vo.num);
		// vo.name = "kim";
		vo3.setName("kim3");
		System.out.println(vo3.getName());
		// System.out.println(vo.name);
		vo3.setKor(3);
		vo3.setEng(3);
		vo3.setMath(3);
		vo3.setTotal(vo3.getKor() + vo3.getEng() + vo3.getMath());
		vo3.setAvg((double) vo3.getTotal() / 3);
		String grade3 = "";
		if (vo3.getAvg() >= 90) {
			grade3 = "A";
		} else if (vo3.getAvg() >= 80) {
			grade3 = "B";
		} else if (vo3.getAvg() >= 70) {
			grade3 = "C";
		} else {
			grade3 = "D";
		}
		vo3.setGrade(grade3);

		System.out.println("============================");

		int result3 = dao.delete(vo3);
		System.out.println(result3);
		System.out.println(vo3.getKor());
		System.out.println(vo3.getEng());
		System.out.println(vo3.getMath());
		System.out.println(vo3.getTotal());
		System.out.println(vo3.getAvg());
		System.out.println(vo3.getGrade());
		
		//////////////////////////////////////////////

		Test03StudentVO vo4 = new Test03StudentVO();
		// vo.num = 10;
		vo4.setNum(4);
		int num4 = vo4.getNum();
		System.out.println(num4);
		// System.out.println(vo.num);
		// vo.name = "kim";
		vo4.setName("kim4");
		System.out.println(vo4.getName());
		// System.out.println(vo.name);
		vo4.setKor(4);
		vo4.setEng(4);
		vo4.setMath(4);
		vo4.setTotal(vo4.getKor() + vo4.getEng() + vo4.getMath());
		vo4.setAvg((double) vo4.getTotal() / 3);
		String grade4 = "";
		if (vo4.getAvg() >= 90) {
			grade4 = "A";
		} else if (vo4.getAvg() >= 80) {
			grade4 = "B";
		} else if (vo4.getAvg() >= 70) {
			grade4 = "C";
		} else {
			grade4 = "D";
		}
		vo4.setGrade(grade4);

		System.out.println("============================");

		int result4 = dao.selectOne(vo4);
		System.out.println(result4);
		System.out.println(vo4.getKor());
		System.out.println(vo4.getEng());
		System.out.println(vo4.getMath());
		System.out.println(vo4.getTotal());
		System.out.println(vo4.getAvg());
		System.out.println(vo4.getGrade());

		System.out.println("============================");

		Test03StudentVO[] svoArr = dao.selectAll();

		for (int i = 0; i < svoArr.length; i++) {
			System.out.println("배열" + i + "=============");
			System.out.println(svoArr[i].getNum());
			System.out.println(svoArr[i].getName());
			System.out.println(svoArr[i].getKor());
			System.out.println(svoArr[i].getEng());
			System.out.println(svoArr[i].getMath());
			System.out.println(svoArr[i].getTotal());
			System.out.println(svoArr[i].getAvg());
			System.out.println(svoArr[i].getGrade());
			System.out.println("배열" + i + "=============");
		}

		

	}

}
