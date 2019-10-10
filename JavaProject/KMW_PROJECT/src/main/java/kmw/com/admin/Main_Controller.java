package kmw.com.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kmw.com.admin.model.Calc_VO;
import kmw.com.admin.model.Ctrl_VO;
import kmw.com.admin.model.Elec_VO;
import kmw.com.admin.service.Calc_Service;
import kmw.com.admin.service.Ctrl_Service;
import kmw.com.admin.service.Elec_Service;
import kmw.com.admin.service.Login_Service;

@Controller
public class Main_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Main_Controller.class);

	@Autowired
	Calc_Service Calcservice;
	
	@Autowired
	Ctrl_Service CtrlService;
	
	@Autowired
	Elec_Service ElecService;
	
	@Autowired
	Login_Service LoginService;
	
	///////////////////	sojeong	///////////////////
	
	@RequestMapping(value = { "/sensorValue.do" }, method = RequestMethod.GET)
	public String sensorValue(Locale locale, Model model) {
		logger.info("sensorValue.do()..");
		
		return "sensorValuePage";
	}


	///////////////////	end	///////////////////
	
	

	@RequestMapping(value = { "/test.do" }, method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("test.do()..");

		return "testPage";
	}

	@RequestMapping(value = { "/testOK.do" }, method = RequestMethod.POST)
	public String testOK(Locale locale, Model model, HttpServletRequest request) {
		logger.info("testOK()..");
		String goal_string = request.getParameter("goal");
		String priority = request.getParameter("priority");
		int goal = Integer.parseInt(goal_string);

		if ((goal > 0) && (priority != null)) {
			return "resultPage";
		} else {
			return "redirect:test.do";

		}
	}

	// case1 -> night only -> for문에서 나머지 부분 주석
	@RequestMapping(value = { "/calc_case1.do" }, method = RequestMethod.GET)
	public String calc_case1(Model model, Calc_VO calcvo, Elec_VO elecvo, Ctrl_VO ctrlvo) 
			throws ParseException {
		logger.info("calc_case1.do");

		// COST
		int norm_cost[] = { 9, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		int peak_cost[] = { 10, 11 };
		int night_cost[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 23 };
		
		// IDEAL VALUES(ENERGY) CALC. /line별 1개 생산기준/
		double ideal_en_L1 = 10 * 7; // (kw/h * h = kw)
		double ideal_en_L2 = 10 * 6;
		double ideal_en_L3 = 10 * 6;
		double ideal_en_total = ideal_en_L1 + ideal_en_L2 + ideal_en_L3;
		calcvo.setIdeal_en(ideal_en_total);
		
		// test또는 testOK.do에서 goal insert, 
		// 지원이 언니가 한 crtl에서 case update히고, 
		// 여기서  line이랑 line별 ideal value update
			
	// LINE 1 CALCULATION////////////////////////////////////////

		// LINE 1 TIME TOTAL COST
		double norm_sum_L1 = 0;
		double peak_sum_L1 = 0;
		double night_sum_L1 = 0;
		
		// LINE 1 START/END TIME
		int e_hour_L1 = 14;
		
		// LINE 1 TOTAL TAKING TIME
		int gap_L1 = e_hour_L1; // 실행시간
		int[] hours_L1 = new int[gap_L1]; // 실행시간을 넣어주는 배열
		int size_L1 = hours_L1.length; // 몇시간?
		final double standard_en = 10;
	
		// LINE 1 VOLTAGE & CURRENT
			// jselectAll에서 라즈베리에서 보내준 데이터를 받아서 set해줬으니까 여기서 get
		System.out.println("volt_Sensor_L1: " + elecvo.getVolt_Sensor_L1());
		double volt_L1 = elecvo.getVolt_Sensor_L1();
		System.out.println("amp_Sensor_L1: " + elecvo.getAmp_Sensor_L1());
		double amp_L1 = elecvo.getAmp_Sensor_L1();
		
		// LINE 1 POWER & ENERGY
		System.out.println("power 1 : " + (volt_L1 * amp_L1));
		double power_L1 = volt_L1 * amp_L1;
		double energy_L1 = power_L1 * gap_L1;
		
		// LINE 1 ERROR RATE & NEED
		double error_rate_L1 = energy_L1;
			// ideal values랑 비교해야하는데 그것도 그럼 vo에 변수가 있어야하나?
			// db에 그 라인에서 1개 생산하는데 필요힌 ideal energy가 있으니까 (그 값 * goal) = ideal energy 
		
		// LINE 1 TOTAL COST
		int count1_L1 = 0;
		int count2_L1 = 0;
		int count3_L1 = 0;
		
		for (int i = 0; i < size_L1; i++) {
			hours_L1[i] = i;

			/*for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L1[i] == norm_cost[j]) {
					count1_L1++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L1);
			double ratio1_L1 = (double) count1_L1 / (double) gap_L1;
			norm_sum_L1 = 5550 + ((ratio1_L1 * (energy_L1 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L1);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L1 * (energy_L1 - standard_en)) * 48);

			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L1++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L1);
			double ratio2_L1 = (double) count2_L1 / (double) gap_L1;
			peak_sum_L1 = 7470 + ((ratio2_L1 * (energy_L1 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L1);*/

			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L1++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L1);
			double ratio3_L1 = (double) count3_L1 / (double) gap_L1;
			night_sum_L1 = 3490 + ((ratio3_L1 * (energy_L1 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L1);

		} // 마지막for문

		System.out.println(norm_sum_L1 + " L1 NORM COST!");
		System.out.println(peak_sum_L1 + " L1 PEAK COST!");
		System.out.println(night_sum_L1 + " L1 NIGHT COST!");
		System.out.println(norm_sum_L1 + peak_sum_L1 + night_sum_L1 + " L1 TOTAL COST");

		
	// LINE 2 CALCULATION//////////////////////////////////
		
		// LINE 2 TIME TOTAL COST
		double norm_sum_L2 = 0;
		double peak_sum_L2 = 0;
		double night_sum_L2 = 0;

		// LINE 2 START/END TIME
		int e_hour_L2 = 3;

		// LINE 2 TOTAL TAKING TIME
		int gap_L2 = e_hour_L2 ; // 실행시간
		int[] hours_L2 = new int[gap_L2]; // 실행시간을 넣어주는 배열
		int size_L2 = hours_L2.length; // 몇시간?

		// LINE 2 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L2: " + elecvo.getVolt_Sensor_L2());
		double volt_L2 = elecvo.getVolt_Sensor_L2();
		System.out.println("amp_Sensor_L2: " + elecvo.getAmp_Sensor_L2());
		double amp_L2 = elecvo.getAmp_Sensor_L2();
		
		// LINE 2 POWER & ENERGY
		System.out.println("power 2 : " + (volt_L2 * amp_L2));
		double power_L2 = volt_L2 * amp_L2;
		double energy_L2 = power_L2 * gap_L2;
		
		// LINE 2 TOTAL COST
		int count1_L2 = 0;
		int count2_L2 = 0;
		int count3_L2 = 0;
		
		for (int i = 0; i < size_L2; i++) {
			hours_L2[i] = i;

			/*for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L2);
			double ratio1_L2 = (double) count1_L2 / (double) gap_L2;
			norm_sum_L2 = 5550 + ((ratio1_L2 * (energy_L2 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L2);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L2 * (energy_L2 - standard_en)) * 48);

			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L2++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L2);
			double ratio2_L2 = (double) count2_L2 / (double) gap_L2;
			peak_sum_L2 = 7470 + ((ratio2_L2 * (energy_L2 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L2);*/

			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L2++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L2 = (double) count3_L2 / (double) gap_L2;
			night_sum_L2 = 3490 + ((ratio3_L2 * (energy_L2 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L2);

		} // 마지막for문

		System.out.println(norm_sum_L2 + " L2 NORM COST!");
		System.out.println(peak_sum_L2 + " L2 PEAK COST!");
		System.out.println(night_sum_L2 + " L2 NIGHT COST!");
		System.out.println(norm_sum_L2 + peak_sum_L2 + night_sum_L2 + " L2 TOTAL COST");
		
	// LINE 3 CALCULATION////////////////////////////////////////
		
		// LINE 3 TIME TOTAL COST
		double norm_sum_L3 = 0;
		double peak_sum_L3 = 0;
		double night_sum_L3 = 0;

		// LINE 3 START/END TIME
		int e_hour_L3 = 4;

		// LINE 3 TOTAL TAKING TIME
		int gap_L3 = e_hour_L3 ; // 실행시간
		int[] hours_L3 = new int[gap_L3]; // 실행시간을 넣어주는 배열
		int size_L3 = hours_L3.length; // 몇시간?

		// LINE 3 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L3: " + elecvo.getVolt_Sensor_L3());
		double volt_L3 = elecvo.getVolt_Sensor_L3();
		System.out.println("amp_Sensor_L3: " + elecvo.getAmp_Sensor_L3());
		double amp_L3 = elecvo.getAmp_Sensor_L3();

		// LINE 3 POWER & ENERGY
		System.out.println("power 3 : " + (volt_L3 * amp_L3));
		double power_L3 = volt_L3 * amp_L3;
		double energy_L3 = power_L3 * gap_L3 ;
		
		// LINE 3 TOTAL COST
		int count1_L3 = 0;
		int count2_L3 = 0;
		int count3_L3 = 0;
		
		for (int i = 0; i < size_L3; i++) {
			hours_L3[i] = i;

			/*for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L3);
			double ratio1_L3 = (double) count1_L3 / (double) gap_L3;
			norm_sum_L3 = 5550 + ((ratio1_L3 * (energy_L3 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L3);
			System.out.println("ratio1 * (energy_L3 - standard_en)" + (ratio1_L3 * (energy_L3 - standard_en)) * 48);

			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L3[i] == peak_cost[k]) {
					count2_L3++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L3);
			double ratio2_L3 = (double) count2_L3 / (double) gap_L3;
			peak_sum_L3 = 7470 + ((ratio2_L3 * (energy_L3 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L3);*/

			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L3++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L3 = (double) count3_L3 / (double) gap_L3;
			night_sum_L3 = 3490 + ((ratio3_L3 * (energy_L3 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L3);

		} // 마지막for문

		System.out.println(norm_sum_L3 + " L3 NORM COST!");
		System.out.println(peak_sum_L3 + " L3 PEAK COST!");
		System.out.println(night_sum_L3 + " L3 NIGHT COST!");
		System.out.println(norm_sum_L3 + peak_sum_L3 + night_sum_L3 + " L3 TOTAL COST");
		
		
		
		return "resultPage";
	}// end calc_case1.do
	
	// case2 -> 시간 무시 -> for문 전체 사용
	@RequestMapping(value = { "/calc_case2.do" }, method = RequestMethod.GET)
	public String calc_case2(Model model, Calc_VO calcvo, Elec_VO elecvo, Ctrl_VO ctrlvo) 
			throws ParseException {
		logger.info("calc_case2.do");
		
		// COST
		int norm_cost[] = { 9, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		int peak_cost[] = { 10, 11 };
		int night_cost[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 23 };
		
		// IDEAL VALUES(ENERGY) CALC. /line별 1개 생산기준/
		double ideal_en_L1 = 10 * 7; // (kw/h * h = kw)
		double ideal_en_L2 = 10 * 6;
		double ideal_en_L3 = 10 * 6;
		double ideal_en_total = ideal_en_L1 + ideal_en_L2 + ideal_en_L3;
		calcvo.setIdeal_en(ideal_en_total);
		
		// update ideal set where
		
		// LINE 1 CALCULATION////////////////////////////////////////
		
		// LINE 1 TIME TOTAL COST
		double norm_sum_L1 = 0;
		double peak_sum_L1 = 0;
		double night_sum_L1 = 0;
		
		// LINE 1 START/END TIME
		int e_hour_L1 = 14;
		
		// LINE 1 TOTAL TAKING TIME
		int gap_L1 = e_hour_L1; // 실행시간
		int[] hours_L1 = new int[gap_L1]; // 실행시간을 넣어주는 배열
		int size_L1 = hours_L1.length; // 몇시간?
		final double standard_en = 10;
		
		// LINE 1 VOLTAGE & CURRENT
		// jselectAll에서 라즈베리에서 보내준 데이터를 받아서 set해줬으니까 여기서 get
		System.out.println("volt_Sensor_L1: " + elecvo.getVolt_Sensor_L1());
		double volt_L1 = elecvo.getVolt_Sensor_L1();
		System.out.println("amp_Sensor_L1: " + elecvo.getAmp_Sensor_L1());
		double amp_L1 = elecvo.getAmp_Sensor_L1();
		
		// LINE 1 POWER & ENERGY
		System.out.println("power 1 : " + (volt_L1 * amp_L1));
		double power_L1 = volt_L1 * amp_L1;
		double energy_L1 = power_L1 * gap_L1;
		
		// LINE 1 ERROR RATE & NEED
		double error_rate_L1 = energy_L1;
		// ideal values랑 비교해야하는데 그것도 그럼 vo에 변수가 있어야하나?
		// db에 그 라인에서 1개 생산하는데 필요힌 ideal energy가 있으니까 (그 값 * goal) = ideal energy 
		
		// LINE 1 TOTAL COST
		int count1_L1 = 0;
		int count2_L1 = 0;
		int count3_L1 = 0;
		
		for (int i = 0; i < size_L1; i++) {
			hours_L1[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L1[i] == norm_cost[j]) {
					count1_L1++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L1);
			double ratio1_L1 = (double) count1_L1 / (double) gap_L1;
			norm_sum_L1 = 5550 + ((ratio1_L1 * (energy_L1 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L1);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L1 * (energy_L1 - standard_en)) * 48);
			
			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L1++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L1);
			double ratio2_L1 = (double) count2_L1 / (double) gap_L1;
			peak_sum_L1 = 7470 + ((ratio2_L1 * (energy_L1 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L1);
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L1++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L1);
			double ratio3_L1 = (double) count3_L1 / (double) gap_L1;
			night_sum_L1 = 3490 + ((ratio3_L1 * (energy_L1 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L1);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L1 + " L1 NORM COST!");
		System.out.println(peak_sum_L1 + " L1 PEAK COST!");
		System.out.println(night_sum_L1 + " L1 NIGHT COST!");
		System.out.println(norm_sum_L1 + peak_sum_L1 + night_sum_L1 + " L1 TOTAL COST");
		
		
		// LINE 2 CALCULATION//////////////////////////////////
		
		// LINE 2 TIME TOTAL COST
		double norm_sum_L2 = 0;
		double peak_sum_L2 = 0;
		double night_sum_L2 = 0;
		
		// LINE 2 START/END TIME
		int e_hour_L2 = 3;
		
		// LINE 2 TOTAL TAKING TIME
		int gap_L2 = e_hour_L2 ; // 실행시간
		int[] hours_L2 = new int[gap_L2]; // 실행시간을 넣어주는 배열
		int size_L2 = hours_L2.length; // 몇시간?
		
		// LINE 2 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L2: " + elecvo.getVolt_Sensor_L2());
		double volt_L2 = elecvo.getVolt_Sensor_L2();
		System.out.println("amp_Sensor_L2: " + elecvo.getAmp_Sensor_L2());
		double amp_L2 = elecvo.getAmp_Sensor_L2();
		
		// LINE 2 POWER & ENERGY
		System.out.println("power 2 : " + (volt_L2 * amp_L2));
		double power_L2 = volt_L2 * amp_L2;
		double energy_L2 = power_L2 * gap_L2;
		
		// LINE 2 TOTAL COST
		int count1_L2 = 0;
		int count2_L2 = 0;
		int count3_L2 = 0;
		
		for (int i = 0; i < size_L2; i++) {
			hours_L2[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L2);
			double ratio1_L2 = (double) count1_L2 / (double) gap_L2;
			norm_sum_L2 = 5550 + ((ratio1_L2 * (energy_L2 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L2);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L2 * (energy_L2 - standard_en)) * 48);
			
			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L2++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L2);
			double ratio2_L2 = (double) count2_L2 / (double) gap_L2;
			peak_sum_L2 = 7470 + ((ratio2_L2 * (energy_L2 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L2);
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L2++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L2 = (double) count3_L2 / (double) gap_L2;
			night_sum_L2 = 3490 + ((ratio3_L2 * (energy_L2 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L2);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L2 + " L2 NORM COST!");
		System.out.println(peak_sum_L2 + " L2 PEAK COST!");
		System.out.println(night_sum_L2 + " L2 NIGHT COST!");
		System.out.println(norm_sum_L2 + peak_sum_L2 + night_sum_L2 + " L2 TOTAL COST");
		
		// LINE 3 CALCULATION////////////////////////////////////////
		
		// LINE 3 TIME TOTAL COST
		double norm_sum_L3 = 0;
		double peak_sum_L3 = 0;
		double night_sum_L3 = 0;
		
		// LINE 3 START/END TIME
		int e_hour_L3 = 4;
		
		// LINE 3 TOTAL TAKING TIME
		int gap_L3 = e_hour_L3; // 실행시간
		int[] hours_L3 = new int[gap_L3]; // 실행시간을 넣어주는 배열
		int size_L3 = hours_L3.length; // 몇시간?
		
		// LINE 3 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L3: " + elecvo.getVolt_Sensor_L3());
		double volt_L3 = elecvo.getVolt_Sensor_L3();
		System.out.println("amp_Sensor_L3: " + elecvo.getAmp_Sensor_L3());
		double amp_L3 = elecvo.getAmp_Sensor_L3();
		
		// LINE 3 POWER & ENERGY
		System.out.println("power 3 : " + (volt_L3 * amp_L3));
		double power_L3 = volt_L3 * amp_L3;
		double energy_L3 = power_L3 * gap_L3 ;
		
		// LINE 3 TOTAL COST
		int count1_L3 = 0;
		int count2_L3 = 0;
		int count3_L3 = 0;
		
		for (int i = 0; i < size_L3; i++) {
			hours_L3[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L3);
			double ratio1_L3 = (double) count1_L3 / (double) gap_L3;
			norm_sum_L3 = 5550 + ((ratio1_L3 * (energy_L3 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L3);
			System.out.println("ratio1 * (energy_L3 - standard_en)" + (ratio1_L3 * (energy_L3 - standard_en)) * 48);
			
			for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L3[i] == peak_cost[k]) {
					count2_L3++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L3);
			double ratio2_L3 = (double) count2_L3 / (double) gap_L3;
			peak_sum_L3 = 7470 + ((ratio2_L3 * (energy_L3 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L3);
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L3++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L3 = (double) count3_L3 / (double) gap_L3;
			night_sum_L3 = 3490 + ((ratio3_L3 * (energy_L3 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L3);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L3 + " L3 NORM COST!");
		System.out.println(peak_sum_L3 + " L3 PEAK COST!");
		System.out.println(night_sum_L3 + " L3 NIGHT COST!");
		System.out.println(norm_sum_L3 + peak_sum_L3 + night_sum_L3 + " L3 TOTAL COST");
		
		
		
		return "resultPage";
	}// end calc_case2.do
	
	// case3 -> not peak -> for문에서 peak for문 주석
	@RequestMapping(value = { "/calc_case3.do" }, method = RequestMethod.GET)
	public String calc_case3(Model model, Calc_VO calcvo, Elec_VO elecvo, Ctrl_VO ctrlvo) 
			throws ParseException {
		logger.info("calc_case3.do");
		
		// COST
		int norm_cost[] = { 9, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
		int peak_cost[] = { 10, 11 };
		int night_cost[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 23 };
		
		// IDEAL VALUES(ENERGY) CALC. /line별 1개 생산기준/
		double ideal_en_L1 = 10 * 7; // (kw/h * h = kw)
		double ideal_en_L2 = 10 * 6;
		double ideal_en_L3 = 10 * 6;
		double ideal_en_total = ideal_en_L1 + ideal_en_L2 + ideal_en_L3;
		calcvo.setIdeal_en(ideal_en_total);
		
		// update ideal set where
		
		// LINE 1 CALCULATION////////////////////////////////////////
		
		// LINE 1 TIME TOTAL COST
		double norm_sum_L1 = 0;
		double peak_sum_L1 = 0;
		double night_sum_L1 = 0;
		
		// LINE 1 START/END TIME
		int e_hour_L1 = 14;
		
		// LINE 1 TOTAL TAKING TIME
		int gap_L1 = e_hour_L1; // 실행시간
		int[] hours_L1 = new int[gap_L1]; // 실행시간을 넣어주는 배열
		int size_L1 = hours_L1.length; // 몇시간?
		final double standard_en = 10;
		
		// LINE 1 VOLTAGE & CURRENT
		// jselectAll에서 라즈베리에서 보내준 데이터를 받아서 set해줬으니까 여기서 get
		System.out.println("volt_Sensor_L1: " + elecvo.getVolt_Sensor_L1());
		double volt_L1 = elecvo.getVolt_Sensor_L1();
		System.out.println("amp_Sensor_L1: " + elecvo.getAmp_Sensor_L1());
		double amp_L1 = elecvo.getAmp_Sensor_L1();
		
		// LINE 1 POWER & ENERGY
		System.out.println("power 1 : " + (volt_L1 * amp_L1));
		double power_L1 = volt_L1 * amp_L1;
		double energy_L1 = power_L1 * gap_L1;
		
		// LINE 1 ERROR RATE & NEED
		double error_rate_L1 = energy_L1;
		// ideal values랑 비교해야하는데 그것도 그럼 vo에 변수가 있어야하나?
		// db에 그 라인에서 1개 생산하는데 필요힌 ideal energy가 있으니까 (그 값 * goal) = ideal energy 
		
		// LINE 1 TOTAL COST
		int count1_L1 = 0;
		int count2_L1 = 0;
		int count3_L1 = 0;
		
		for (int i = 0; i < size_L1; i++) {
			hours_L1[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L1[i] == norm_cost[j]) {
					count1_L1++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L1);
			double ratio1_L1 = (double) count1_L1 / (double) gap_L1;
			norm_sum_L1 = 5550 + ((ratio1_L1 * (energy_L1 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L1);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L1 * (energy_L1 - standard_en)) * 48);
			
			/*for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L1++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L1);
			double ratio2_L1 = (double) count2_L1 / (double) gap_L1;
			peak_sum_L1 = 7470 + ((ratio2_L1 * (energy_L1 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L1);*/
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L1++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L1);
			double ratio3_L1 = (double) count3_L1 / (double) gap_L1;
			night_sum_L1 = 3490 + ((ratio3_L1 * (energy_L1 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L1);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L1 + " L1 NORM COST!");
		System.out.println(peak_sum_L1 + " L1 PEAK COST!");
		System.out.println(night_sum_L1 + " L1 NIGHT COST!");
		System.out.println(norm_sum_L1 + peak_sum_L1 + night_sum_L1 + " L1 TOTAL COST");
		
		
		// LINE 2 CALCULATION//////////////////////////////////
		
		// LINE 2 TIME TOTAL COST
		double norm_sum_L2 = 0;
		double peak_sum_L2 = 0;
		double night_sum_L2 = 0;
		
		// LINE 2 START/END TIME
		int e_hour_L2 = 3;
		
		// LINE 2 TOTAL TAKING TIME
		int gap_L2 = e_hour_L2 ; // 실행시간
		int[] hours_L2 = new int[gap_L2]; // 실행시간을 넣어주는 배열
		int size_L2 = hours_L2.length; // 몇시간?
		
		// LINE 2 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L2: " + elecvo.getVolt_Sensor_L2());
		double volt_L2 = elecvo.getVolt_Sensor_L2();
		System.out.println("amp_Sensor_L2: " + elecvo.getAmp_Sensor_L2());
		double amp_L2 = elecvo.getAmp_Sensor_L2();
		
		// LINE 2 POWER & ENERGY
		System.out.println("power 2 : " + (volt_L2 * amp_L2));
		double power_L2 = volt_L2 * amp_L2;
		double energy_L2 = power_L2 * gap_L2;
		
		// LINE 2 TOTAL COST
		int count1_L2 = 0;
		int count2_L2 = 0;
		int count3_L2 = 0;
		
		for (int i = 0; i < size_L2; i++) {
			hours_L2[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L2);
			double ratio1_L2 = (double) count1_L2 / (double) gap_L2;
			norm_sum_L2 = 5550 + ((ratio1_L2 * (energy_L2 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L2);
			System.out.println("ratio1 * (energy_L1 - standard_en)" + (ratio1_L2 * (energy_L2 - standard_en)) * 48);
			
			/*for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L1[i] == peak_cost[k]) {
					count2_L2++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L2);
			double ratio2_L2 = (double) count2_L2 / (double) gap_L2;
			peak_sum_L2 = 7470 + ((ratio2_L2 * (energy_L2 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L2);*/
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L2++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L2 = (double) count3_L2 / (double) gap_L2;
			night_sum_L2 = 3490 + ((ratio3_L2 * (energy_L2 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L2);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L2 + " L2 NORM COST!");
		System.out.println(peak_sum_L2 + " L2 PEAK COST!");
		System.out.println(night_sum_L2 + " L2 NIGHT COST!");
		System.out.println(norm_sum_L2 + peak_sum_L2 + night_sum_L2 + " L2 TOTAL COST");
		
		// LINE 3 CALCULATION////////////////////////////////////////
		
		// LINE 3 TIME TOTAL COST
		double norm_sum_L3 = 0;
		double peak_sum_L3 = 0;
		double night_sum_L3 = 0;
		
		// LINE 3 START/END TIME
		int e_hour_L3 = 4;
		
		// LINE 3 TOTAL TAKING TIME
		int gap_L3 = e_hour_L3 ; // 실행시간
		int[] hours_L3 = new int[gap_L3]; // 실행시간을 넣어주는 배열
		int size_L3 = hours_L3.length; // 몇시간?
		
		// LINE 3 VOLTAGE & CURRENT
		System.out.println("volt_Sensor_L3: " + elecvo.getVolt_Sensor_L3());
		double volt_L3 = elecvo.getVolt_Sensor_L3();
		System.out.println("amp_Sensor_L3: " + elecvo.getAmp_Sensor_L3());
		double amp_L3 = elecvo.getAmp_Sensor_L3();
		
		// LINE 3 POWER & ENERGY
		System.out.println("power 3 : " + (volt_L3 * amp_L3));
		double power_L3 = volt_L3 * amp_L3;
		double energy_L3 = power_L3 * gap_L3 ;
		
		// LINE 3 TOTAL COST
		int count1_L3 = 0;
		int count2_L3 = 0;
		int count3_L3 = 0;
		
		for (int i = 0; i < size_L3; i++) {
			hours_L3[i] = i;
			
			for (int j = 0; j < norm_cost.length; j++) {
				if (hours_L2[i] == norm_cost[j]) {
					count1_L2++;
				} // if1
			} // for1
			System.out.println("count1: " + count1_L3);
			double ratio1_L3 = (double) count1_L3 / (double) gap_L3;
			norm_sum_L3 = 5550 + ((ratio1_L3 * (energy_L3 - standard_en)) * 48);
			System.out.println("ratio1: " + ratio1_L3);
			System.out.println("ratio1 * (energy_L3 - standard_en)" + (ratio1_L3 * (energy_L3 - standard_en)) * 48);
			
		/*	for (int k = 0; k < peak_cost.length; k++) {
				if (hours_L3[i] == peak_cost[k]) {
					count2_L3++;
				} // end if2
			} // end for2
			System.out.println("count2: " + count2_L3);
			double ratio2_L3 = (double) count2_L3 / (double) gap_L3;
			peak_sum_L3 = 7470 + ((ratio2_L3 * (energy_L3 - standard_en)) * 60);
			System.out.println("ratio2: " + ratio2_L3);*/
			
			for (int h = 0; h < night_cost.length; h++) {
				if (hours_L1[i] == night_cost[h]) {
					count3_L3++;
				} // end if3
			} // for3
			System.out.println("count3: " + count3_L2);
			double ratio3_L3 = (double) count3_L3 / (double) gap_L3;
			night_sum_L3 = 3490 + ((ratio3_L3 * (energy_L3 - standard_en)) * 40);
			System.out.println("ratio3: " + ratio3_L3);
			
		} // 마지막for문
		
		System.out.println(norm_sum_L3 + " L3 NORM COST!");
		System.out.println(peak_sum_L3 + " L3 PEAK COST!");
		System.out.println(night_sum_L3 + " L3 NIGHT COST!");
		System.out.println(norm_sum_L3 + peak_sum_L3 + night_sum_L3 + " L3 TOTAL COST");
		
		
		
		return "resultPage";
	}// end calc_case3.do



	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("selectAll.do");
		List<Calc_VO> list = Calcservice.selectAllCalc();
		model.addAttribute("list", list);

		return "listPage";
	}

	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne(Model model) {
		logger.info("selectOne.do");
		/*
		 * List<Calc_VO> list = Calcservice.selectAllCalc(); model.addAttribute("list",
		 * list);
		 */

		return "listPage";
	}

	@RequestMapping(value = "/jselectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Calc_VO>> jselectAll(Model model) {
		logger.info("jselectAll.do");

		// List<BoardVO> list = bservice.selectAll();
		Map<String, List<Calc_VO>> map = new HashMap<String, List<Calc_VO>>();
		// map.put("list", list);

		return map;
	}

	@RequestMapping(value = "/jselectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public Calc_VO jselectOne(Calc_VO vo) {
		logger.info("jselectOne.do");

		// BoardVO bvo = bservice.selectOne(vo);

		return vo;
	}

}
