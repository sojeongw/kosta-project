//package assignment.lotto;
//
//import java.util.*;
//
//public class lotto {
//
//	public static void main(String[] args) {
//
//		Set<Integer> set = new HashSet<Integer>();
//
//		Random r = new Random();
//
//		// ���� �������� �ְ�
//		while (set.size() != 6) {
//			int index = r.nextInt(45);
//			if (index == 0)
//				continue;
//			else {
//				set.add(index);
//			}
//		}
//		System.out.println("�εε�!!!!!!!");
//		Iterator<Integer> it = set.iterator();
//		// 7���� ���
//
//		List<Integer> list = new ArrayList<Integer>();
//
//		for (int i = 0; i < set.size(); i++) {
//
//			if (set.get() > list.get(i + 1)) {
//				list.add(list.get(i + 1));
//			} else {
//				list.add(list.get(i));
//			}
//		} // end of while
//
//		for (Integer data : list) {
//			System.out.println(data);
//		}
//
//	}
//
//}
