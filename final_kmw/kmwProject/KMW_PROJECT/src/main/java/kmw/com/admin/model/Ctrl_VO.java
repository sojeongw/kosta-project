package kmw.com.admin.model;

import java.sql.Date;

public class Ctrl_VO {

	/*
	 * int color_R; int color_G; int color_B; int s_Motor; int dc_Motor;
	 */
	String line;
	String motion;
	Date end_time; // = total_time;


	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

}
