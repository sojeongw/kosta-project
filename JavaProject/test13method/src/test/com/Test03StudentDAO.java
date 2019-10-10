package test.com;

public class Test03StudentDAO {

	// insert
	public int insert(Test03StudentVO vo) {	// 1.얘가 온대
		// 2.제대로 오는지 확인
		System.out.println("insert");
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		System.out.println(vo.getTotal());
		System.out.println(vo.getAvg());
		System.out.println(vo.getGrade());
		
		return 1;
	}

	// update
	public int update(Test03StudentVO vo2) {
		System.out.println("update");
		System.out.println(vo2.getKor());
		System.out.println(vo2.getEng());
		System.out.println(vo2.getMath());
		System.out.println(vo2.getTotal());
		System.out.println(vo2.getAvg());
		System.out.println(vo2.getGrade());
		return 2;
	}

	// delete
	public int delete(Test03StudentVO vo3) {
		System.out.println("delete");
		System.out.println(vo3.getKor());
		System.out.println(vo3.getEng());
		System.out.println(vo3.getMath());
		System.out.println(vo3.getTotal());
		System.out.println(vo3.getAvg());
		System.out.println(vo3.getGrade());
		return 3;
	}

	// selectOne
	public int selectOne(Test03StudentVO vo4) {
		System.out.println("selectOne");
		System.out.println(vo4.getKor());
		System.out.println(vo4.getEng());
		System.out.println(vo4.getMath());
		System.out.println(vo4.getTotal());
		System.out.println(vo4.getAvg());
		System.out.println(vo4.getGrade());
		
		Test03StudentVO vo5= new Test03StudentVO();
		vo5.setNum(4);
		vo5.setName("kim4");
		vo5.setKor(4);
		vo5.setEng(4);
		vo5.setMath(4);
		vo5.setNum(4);
		vo5.setTotal(vo5.getKor() + vo5.getEng() + vo5.getMath());
		vo5.setAvg((double) vo5.getTotal() / 3);
		String grade5 = "";
		if (vo5.getAvg() >= 90) {
			grade5 = "A";
		} else if (vo5.getAvg() >= 80) {
			grade5 = "B";
		} else if (vo5.getAvg() >= 70) {
			grade5 = "C";
		} else {
			grade5 = "D";
		}
		vo5.setGrade(grade5);
		
		return 4;
	}

	// selectAll
	public Test03StudentVO[] selectAll() {
		Test03StudentVO svo6 = new Test03StudentVO();
		Test03StudentVO svo7 = new Test03StudentVO();
		
		Test03StudentVO[] svoArr = new Test03StudentVO[] {svo6, svo7};
//		System.out.println(svoArr);	// 주소가 나왔고
//		System.out.println(svoArr.length);	// 길이
//		for(int i=0; i<svoArr.length; i++) {		// null null인 것도 확인
//		System.out.println(svoArr[i]);
//		}
		System.out.println("svo6 : " + svo6);
		
		svoArr[0] = svo6;
		svoArr[1] = svo7;
		
		svo6.setNum(6);
		svo6.setName("kim6");
		svo6.setKor(6);
		svo6.setEng(6);
		svo6.setMath(6);
		svo6.setNum(6);
		svo6.setTotal(svo6.getKor() + svo6.getEng() + svo6.getMath());
		svo6.setAvg((double) svo6.getTotal() / 3);
		String grade6 = "";
		if (svo6.getAvg() >= 90) {
			grade6 = "A";
		} else if (svo6.getAvg() >= 80) {
			grade6 = "B";
		} else if (svo6.getAvg() >= 70) {
			grade6 = "C";
		} else {
			grade6 = "D";
		}
		svo6.setGrade(grade6);
		
		
		
		svo7.setNum(7);
		svo7.setName("kim7");
		svo7.setKor(7);
		svo7.setEng(7);
		svo7.setMath(7);
		svo7.setNum(7);
		svo7.setTotal(svo7.getKor() + svo7.getEng() + svo7.getMath());
		svo7.setAvg((double) svo7.getTotal() / 3);
		String grade7 = "";
		if (svo7.getAvg() >= 90) {
			grade7 = "A";
		} else if (svo7.getAvg() >= 80) {
			grade7 = "B";
		} else if (svo7.getAvg() >= 70) {
			grade7 = "C";
		} else {
			grade7 = "D";
		}
		svo7.setGrade(grade7);
		
		
		return svoArr;
	}

}
