package test.com;

public abstract class Test01Bus extends Test01Car {
	// 일반 메소드와 추상 메소드 둘 다 가질 수 있다.

	// 재정의를 해야하므로 블럭 반드시 필요
	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	
// 	이렇게 추상메소드로 하려면 추상 클래스여야 한다.
// 	이때는 블럭이 필요 없다.
//	@Override
//	public abstract void move();
	// 서브가 꼭 메소드를 재정의 하도록 하기 위해 수퍼에서 abstract 메소드를 쓴다.
	
	
	
	
}
