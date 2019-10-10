//package test.com;
//
//import java.util.Date;
//
//public class Test03MainBoardDAO {
//	
//	
//		// 다시 call 하면 없어지니까 전역 변수로
//		Test03MainBoardVO[] bArr;
//
//		// count 변수를 이용해 계속 플러스 되게 한다.
//		int count;
//
//		// 전역 변수의 초기화는 생성자에서 한다.
//		public Test03MainBoardDAO() {
//			count = 0;
//			bArr = new Test03MainBoardVO[3];
//			Test03MainBoardVO b01 = new Test03MainBoardVO();
//			Test03MainBoardVO b02 = new Test03MainBoardVO();
//			Test03MainBoardVO b03 = new Test03MainBoardVO();
//
//			bArr[0] = b01;
//			bArr[1] = b02;
//			bArr[2] = b03;
//			
//			
//		}
//
//		// 1. insert
//		public void insert(Test03MainBoardVO bVO) {
//			// System.out.println("insert");
//			bVO.setNum(count);
//			
//			System.out.println();
//			System.out.print(bVO.getNum() + "  ");
//			System.out.print(bVO.getTitle() + "\t");
//			System.out.print(bVO.getContent() + "\t");
//			System.out.print(bVO.getName());
//			System.out.println("\t" + bVO.getDate());
//			System.out.println();
//			
//			bArr[count] = bVO;		// 하나 쓸 때마다 한 칸에 들어가기 위해
//			count ++;		// 1번방, 2번방...진행하기 위해서
//			
//			
//		}
//
//		// 2. update
//		public void update(Test03MainBoardVO bVO) {
//			System.out.println();
//			System.out.print(bVO.getNum() + "  ");
//			System.out.print(bVO.getTitle() + "\t");
//			System.out.print(bVO.getContent() + "\t");
//			System.out.print(bVO.getName());
//			System.out.println("\t" + bVO.getDate());
//			System.out.println();
//		}
//
//		// 3. delete
//		public void delete(Test03MainBoardVO bVO) {
//			System.out.println();
//			System.out.print(bVO.getNum() + "  ");
//			System.out.println();
//			System.out.println();
//		}
//
//		// 4. selectAll
//		public Test03MainBoardVO[] selectAll() {
//			return bArr;
//		}
//
//		// 5. selectOne
//		public void selectOne(Test03MainBoardVO bVO) {
//			System.out.println(bVO.getNum());
//		}
//	
//	
//
//}
