package kmw.com.admin.model;

import org.springframework.core.Constants;

public class Calc_VO {

	int cases;
	int choose_case;
	int final_case;

	int goal;
	double ideal_en;
	double elec_en;
	double error_rate;
	int real_get; // = goal*(1-error_rate)
	double elec_time; // 실제로 전기를 쓴 시간 -> pwr, energy 게산에 사용

	double total_cost;
	double total_time; // = end_time

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getChoose_case() {
		return choose_case;
	}

	public void setChoose_case(int choose_case) {
		this.choose_case = choose_case;
	}

	public int getFinal_case() {
		return final_case;
	}

	public void setFinal_case(int final_case) {
		this.final_case = final_case;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public double getIdeal_en() {
		return ideal_en;
	}

	public void setIdeal_en(double ideal_en) {
		this.ideal_en = ideal_en;
	}

	public double getElec_en() {
		return elec_en;
	}

	public void setElec_en(double elec_en) {
		this.elec_en = elec_en;
	}

	public double getError_rate() {
		return error_rate;
	}

	public void setError_rate(double error_rate) {
		this.error_rate = error_rate;
	}

	public int getReal_get() {
		return real_get;
	}

	public void setReal_get(int real_get) {
		this.real_get = real_get;
	}

	public double getElec_time() {
		return elec_time;
	}

	public void setElec_time(double elec_time) {
		this.elec_time = elec_time;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public double getTotal_time() {
		return total_time;
	}

	public void setTotal_time(double total_time) {
		this.total_time = total_time;
	}

}
