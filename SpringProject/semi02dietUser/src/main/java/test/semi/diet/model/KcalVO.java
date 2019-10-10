package test.semi.diet.model;

import java.sql.*;

public class KcalVO {

	private String id;
	private String day;
	private Date sports_date;
	private double running;
	private double bicycle;
	private double rope;
	private double totalkcal;
	private double kcal;
	
	
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getSports_date() {
		return sports_date;
	}
	public void setSports_date(Date sports_date) {
		this.sports_date = sports_date;
	}
	public double getRunning() {
		return running;
	}
	public void setRunning(double running) {
		this.running = running;
	}
	public double getBicycle() {
		return bicycle;
	}
	public void setBicycle(double bicycle) {
		this.bicycle = bicycle;
	}
	public double getRope() {
		return rope;
	}
	public void setRope(double rope) {
		this.rope = rope;
	}
	public double getTotalkcal() {
		return totalkcal;
	}
	public void setTotalkcal(double totalkcal) {
		this.totalkcal = totalkcal;
	}
	
}
