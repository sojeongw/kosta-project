package test.semi.diet.model;

import java.sql.*;

public class KcalVO {

	private String id;
	private String day;
	private double totalkcal;
	
	
	

	public double getTotalkcal() {
		return totalkcal;
	}
	public void setTotalkcal(double total_kcal) {
		this.totalkcal = total_kcal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	
	
	
	
}
