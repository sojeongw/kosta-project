package project.control;

public interface RoomCtrl {
	public void RandomFire();

	public void RandomInv();
	
	public int FireDetect();
	
	public int InvDetect();
	
	public int FireAction(int num);
	
	public int InvAction(int num);
	
}
