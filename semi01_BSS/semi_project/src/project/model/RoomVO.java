package project.model;


public class RoomVO {

	private int r_num; // 방번호
	private String r_name; // 방이름
	private int window_cnt, door_cnt; // 창문의 수, 문의 수 
	private int window_sce, door_sce; // 창문의 열림 유무, 문의 열림 유무
	private int fire; // 화재의 유무

	// getter & setter
	public int getR_num() {
		return r_num;
	}

	public void setR_num(int num) {
		this.r_num = num;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String name) {
		this.r_name = name;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public int getFire() {
		return fire;
	}

	public int getDoor_cnt() {
		return door_cnt;
	}

	public void setDoor_cnt(int door_cnt) {
		this.door_cnt = door_cnt;
	}

	public int getWindow_cnt() {
		return window_cnt;
	}

	public void setWindow_cnt(int window_cnt) {
		this.window_cnt = window_cnt;
	}

	public int getDoor_sce() {
		return door_sce;
	}

	public void setDoor_sce(int door_sce) {
		this.door_sce = door_sce;
	}

	public int getWindow_sce() {
		return window_sce;
	}

	public void setWindow_sce(int window_sce) {
		this.window_sce = window_sce;
	}

	// 출력 메소드
	public void printRoom() {
		System.out.println(r_num + " : " + r_name + " : " + window_cnt + " : " + door_cnt + " : " + fire + " : " + window_sce + " : " + door_sce);
	}
}