package kmw.com.admin.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
		
//////////////////////////////////LINE 1 CALCULATION///////////////////////////////////////		
		String s_time_L1 = "2017-12-25 08:00:00";
		String e_time_L1 = "2017-12-25 19:00:00";
		
		Date s_date_L1 = sdf.parse(s_time_L1);
		Date e_date_L1 = sdf.parse(e_time_L1);
		
		System.out.println("s_date_L1 : "+s_date_L1);
		System.out.println("e_date_L1 : "+e_date_L1);
		
		// LINE 1 TOTAL TAKING TIME 시간차(ms 단위)
			/*System.out.println(e_date_L1.getTime()-s_date_L1.getTime()+"ms");
			System.out.println((e_date_L1.getTime()-s_date_L1.getTime())/3600000+"h");*/
		
		// LINE 1 VOLTAGE & CURRENT
			
			
		// LINE 1 POWER & ENERGY
		
		// LINE 1 TOTAL COST
		
		
		/*int i = 1;
		int result_stime = 0;
		
		switch(i) {
			case 1 :
				System.out.println(s_date_L1.before(e_night_date1));
				if(s_date_L1.before(e_night_date1) == true) {
					result_stime = 1;
					break;
				}
			case 2 :
				System.out.println(s_date_L1.before(s_peak_date1));
				if(s_date_L1.before(s_peak_date1) == true) 	break;
			case 3 :
				System.out.println(s_date_L1.before(e_peak_date1));
				if(s_date_L1.before(e_peak_date1) == true) 	break;
			case 4 :
				System.out.println(s_date_L1.before(s_night_date2));
				if(s_date_L1.before(s_night_date2) == true) break;
			case 5 :
				System.out.println(s_date_L1.before(e_night_date2));
				if(s_date_L1.before(e_night_date2) == true) break;
			case 6 :
				System.out.println(s_date_L1.before(s_peak_date2));
				if(s_date_L1.before(s_peak_date2) == true) 	break;
			case 7 :
				System.out.println(s_date_L1.before(e_peak_date2));
				if(s_date_L1.before(e_peak_date2) == true) 	break;
			case 8 :
				System.out.println(s_date_L1.before(s_night_date3));
				if(s_date_L1.before(s_night_date3) == true) break;
			case 9 :
				System.out.println(s_date_L1.before(e_night_date3));
				if(s_date_L1.before(e_night_date3) == true) break;
		}*/
		
		/*int j = 1;
		int result_etime = 0;
		switch(j) {
		case 1 :
			System.out.println(e_date_L1.before(e_night_date1));
			if(e_date_L1.before(e_night_date1) == true) break;
		case 2 :
			System.out.println(e_date_L1.before(s_peak_date1));
			if(e_date_L1.before(s_peak_date1) == true) 	break;
		case 3 :
			System.out.println(e_date_L1.before(e_peak_date1));
			if(e_date_L1.before(e_peak_date1) == true) 	break;
		case 4 :
			System.out.println(e_date_L1.before(s_night_date2));
			if(e_date_L1.before(s_night_date2) == true) {
				result_etime = 4;
				break;
			}
		case 5 :
			System.out.println(e_date_L1.before(e_night_date2));
			if(e_date_L1.before(e_night_date2) == true) break;
		case 6 :
			System.out.println(e_date_L1.before(s_peak_date2));
			if(e_date_L1.before(s_peak_date2) == true) 	break;
		case 7 :
			System.out.println(e_date_L1.before(e_peak_date2));
			if(e_date_L1.before(e_peak_date2) == true) 	break;
		case 8 :
			System.out.println(e_date_L1.before(s_night_date3));
			if(e_date_L1.before(s_night_date3) == true) break;
		case 9 :
			System.out.println(e_date_L1.before(e_night_date3));
			if(e_date_L1.before(e_night_date3) == true) break;
		}*/
		
			/*////////////////////////////////// LINE 1 CALCULATION//////////////////////////////
			
			int i = 0;
			int j = 0;

			switch (i) {
			case 1:
				System.out.println(s_date_L1.before(e_night_date1));
				if (s_date_L1.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(s_date_L1.before(s_peak_date1));
				if (s_date_L1.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(s_date_L1.before(e_peak_date1));
				if (s_date_L1.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(s_date_L1.before(s_night_date2));
				if (s_date_L1.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(s_date_L1.before(e_night_date2));
				if (s_date_L1.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(s_date_L1.before(s_peak_date2));
				if (s_date_L1.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(s_date_L1.before(e_peak_date2));
				if (s_date_L1.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(s_date_L1.before(s_night_date3));
				if (s_date_L1.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(s_date_L1.before(e_night_date3));
				if (s_date_L1.before(e_night_date3) == true)
					break;
			}

			switch (i) {
			case 1:
				System.out.println(e_date_L1.before(e_night_date1));
				if (e_date_L1.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(e_date_L1.before(s_peak_date1));
				if (e_date_L1.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(e_date_L1.before(e_peak_date1));
				if (e_date_L1.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(e_date_L1.before(s_night_date2));
				if (e_date_L1.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(e_date_L1.before(e_night_date2));
				if (e_date_L1.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(e_date_L1.before(s_peak_date2));
				if (e_date_L1.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(e_date_L1.before(e_peak_date2));
				if (e_date_L1.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(e_date_L1.before(s_night_date3));
				if (e_date_L1.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(e_date_L1.before(e_night_date3));
				if (e_date_L1.before(e_night_date3) == true)
					break;
			}

			////////////////////////////////// LINE 2
			////////////////////////////////// CALCULATION///////////////////////////////////////
			String s_time_L2 = "2017-12-26 01:00:00";
			String e_time_L2 = "2017-12-26 11:00:00";

			Date s_date_L2 = sdf.parse(s_time_L2);
			Date e_date_L2 = sdf.parse(e_time_L2);

			switch (i) {
			case 1:
				System.out.println(s_date_L2.before(e_night_date1));
				if (s_date_L2.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(s_date_L2.before(s_peak_date1));
				if (s_date_L2.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(s_date_L2.before(e_peak_date1));
				if (s_date_L2.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(s_date_L2.before(s_night_date2));
				if (s_date_L2.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(s_date_L2.before(e_night_date2));
				if (s_date_L2.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(s_date_L2.before(s_peak_date2));
				if (s_date_L2.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(s_date_L2.before(e_peak_date2));
				if (s_date_L2.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(s_date_L2.before(s_night_date3));
				if (s_date_L2.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(s_date_L2.before(e_night_date3));
				if (s_date_L2.before(e_night_date3) == true)
					break;
			}

			switch (j) {
			case 1:
				System.out.println(e_date_L2.before(e_night_date1));
				if (e_date_L2.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(e_date_L2.before(s_peak_date1));
				if (e_date_L2.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(e_date_L2.before(e_peak_date1));
				if (e_date_L2.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(e_date_L2.before(s_night_date2));
				if (e_date_L2.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(e_date_L2.before(e_night_date2));
				if (e_date_L2.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(e_date_L2.before(s_peak_date2));
				if (e_date_L2.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(e_date_L2.before(e_peak_date2));
				if (e_date_L2.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(e_date_L2.before(s_night_date3));
				if (e_date_L2.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(e_date_L2.before(e_night_date3));
				if (e_date_L2.before(e_night_date3) == true)
					break;
			}

			////////////////////////////////// LINE 3
			////////////////////////////////// CALCULATION///////////////////////////////////////
			String s_time_L3 = "2017-12-26 01:00:00";
			String e_time_L3 = "2017-12-26 11:00:00";

			Date s_date_L3 = sdf.parse(s_time_L3);
			Date e_date_L3 = sdf.parse(e_time_L3);

			switch (i) {
			case 1:
				System.out.println(s_date_L3.before(e_night_date1));
				if (s_date_L3.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(s_date_L3.before(s_peak_date1));
				if (s_date_L3.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(s_date_L3.before(e_peak_date1));
				if (s_date_L3.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(s_date_L3.before(s_night_date2));
				if (s_date_L3.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(s_date_L3.before(e_night_date2));
				if (s_date_L3.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(s_date_L3.before(s_peak_date2));
				if (s_date_L3.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(s_date_L3.before(e_peak_date2));
				if (s_date_L3.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(s_date_L3.before(s_night_date3));
				if (s_date_L3.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(s_date_L3.before(e_night_date3));
				if (s_date_L3.before(e_night_date3) == true)
					break;
			}

			switch (j) {
			case 1:
				System.out.println(e_date_L3.before(e_night_date1));
				if (e_date_L3.before(e_night_date1) == true)
					break;
			case 2:
				System.out.println(e_date_L3.before(s_peak_date1));
				if (e_date_L3.before(s_peak_date1) == true)
					break;
			case 3:
				System.out.println(e_date_L3.before(e_peak_date1));
				if (e_date_L3.before(e_peak_date1) == true)
					break;
			case 4:
				System.out.println(e_date_L3.before(s_night_date2));
				if (e_date_L3.before(s_night_date2) == true)
					break;
			case 5:
				System.out.println(e_date_L3.before(e_night_date2));
				if (e_date_L3.before(e_night_date2) == true)
					break;
			case 6:
				System.out.println(e_date_L3.before(s_peak_date2));
				if (e_date_L3.before(s_peak_date2) == true)
					break;
			case 7:
				System.out.println(e_date_L3.before(e_peak_date2));
				if (e_date_L3.before(e_peak_date2) == true)
					break;
			case 8:
				System.out.println(e_date_L3.before(s_night_date3));
				if (e_date_L3.before(s_night_date3) == true)
					break;
			case 9:
				System.out.println(e_date_L3.before(e_night_date3));
				if (e_date_L3.before(e_night_date3) == true)
					break;
			}*/
			
			/*
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); Date
			 * e_night_date1 = sdf.parse(e_night_time1); Date s_peak_date1 =
			 * sdf.parse(s_peak_time1); Date e_peak_date1 = sdf.parse(e_night_time1); Date
			 * s_night_date2 = sdf.parse(s_peak_time1); Date e_night_date2 =
			 * sdf.parse(e_night_time1); Date s_peak_date2 = sdf.parse(s_peak_time1); Date
			 * e_peak_date2 = sdf.parse(e_night_time1); Date s_night_date3 =
			 * sdf.parse(s_peak_time1); Date e_night_date3 = sdf.parse(e_night_time1);
			 */	
			
			/*String s_time_L1 = "2017-12-25 08:00:00";
			String e_time_L1 = "2017-12-25 19:00:00";
	
			Date s_date_L1 = sdf.parse(s_time_L1);
			Date e_date_L1 = sdf.parse(e_time_L1);
	
			System.out.println("s_date_L1 : " + s_date_L1);
			System.out.println("e_date_L1 : " + e_date_L1);
			System.out.println(e_date_L1.getTime() - s_date_L1.getTime() + "ms");
			System.out.println((e_date_L1.getTime() - s_date_L1.getTime()) / 3600000 + "h");*/
			
////////////////////////////////////////////////////////////////////////////////////////////////////////			
			  // 가격들
		      int norm_cost[] = { 9, 12, 13, 14,15, 16, 17, 18,19, 20,21, 22};
		      int peak_cost[] = { 10, 11 };
		      int night_cost[] = { 0, 1, 2, 3, 4, 5, 6 , 7, 8, 23 };

		      // 가격별 합
		      double norm_sum_L1 = 0;
		      double peak_sum_L1 = 0;
		      double night_sum_L1 = 0;
		      int norm_sum_L2 = 0;
		      int peak_sum_L2 = 0;
		      int night_sum_L2 = 0;
		      int norm_sum_L3 = 0;
		      int peak_sum_L3 = 0;
		      int night_sum_L3 = 0;

		      // 라인별 시작,끝 시각
		      int s_hour_L1 = 8;
		      int e_hour_L1 = 14;
		      int s_hour_L2 = 2;
		      int e_hour_L2 = 3;
		      int s_hour_L3 = 3;
		      int e_hour_L3 = 4;

		      
/////////////////////11111111111111111111111		  
		      int gap_L1 = e_hour_L1 - s_hour_L1; // 실행시간
		      int[] hours_L1 = new int[gap_L1]; // 실행시간을 넣어주는 배열
		      int size_L1 = hours_L1.length; // 몇시간?
		      final double standard_en = 10; 
				
		      int count1_L1 = 0;
		      int count2_L2 = 0;
		      int count3_L3 = 0;
		      double energy_L1 = 100;
		      for (int i = 0; i < size_L1; i++) {
			         hours_L1[i] = s_hour_L1 + i;
			         
			         for (int j = 0; j < norm_cost.length; j++) {
			            if (hours_L1[i] == norm_cost[j]) {
			            	count1_L1 ++ ;
			            } // if1
			         } // for1
			         System.out.println("count1: "+count1_L1);
			         double ratio1 = (double)count1_L1/(double)gap_L1 ;
			         norm_sum_L1 = 5550 + ((ratio1 * (energy_L1 - standard_en)) * 48);
			       	System.out.println("ratio1: " + ratio1);
	               	System.out.println("ratio1 * (energy_L1 - standard_en)" +(ratio1 * (energy_L1 - standard_en)) * 48);

	               	for (int k = 0; k < peak_cost.length; k++) {
			            if (hours_L1[i] == peak_cost[k]) {
			            	count2_L2 ++ ;  
			            }// end if2
			         }// end for2
	               	System.out.println("count2: "+count2_L2);
	               	double ratio2 = (double)count2_L2/(double)gap_L1 ;
	               	peak_sum_L1 =  7470 +((ratio2 * (energy_L1 - standard_en)) * 60);
	               	System.out.println("ratio2: " + ratio2);
	               	
			         for (int h = 0; h < night_cost.length; h++) {
			            if (hours_L1[i] == night_cost[h]) {
			            	count3_L3 ++ ;
			            }// end if3
			         } // for3
			         System.out.println("count3: "+count3_L3);
			         double ratio3 = (double)count3_L3/(double)gap_L1;
			         night_sum_L1 =  3490 + ((ratio3 * (energy_L1 - standard_en)) * 40);
			         System.out.println("ratio3: "+ratio3);

			      } // 마지막for문
		      
		     
		      System.out.println(norm_sum_L1 + " L1 NORM COST!");
		      System.out.println(peak_sum_L1 + " L1 PEAK COST!");
		      System.out.println(night_sum_L1 + " L1 NIGHT COST!");
		      System.out.println(norm_sum_L1+peak_sum_L1+night_sum_L1+" L1 TOTAL COST");
		      
		      
///////////////////////////2222222222222222222222		      
		     /* int gap_L2 = e_hour_L2 - s_hour_L2; // 실행시간
		      int[] hours_L2 = new int[gap_L2]; // 실행시간을 넣어주는 배열
		      int size_L2 = hours_L2.length; // 몇시간?

		      for (int i = 0; i < size_L2; i++) {
			         hours_L2[i] = s_hour_L2 + i;
			         for (int j = 0; j < norm_cost.length; j++) {
			            if (hours_L2[i] == norm_cost[j][0]) {
			               norm_sum_L2 += norm_cost[j][1];
			            } // if문
			         } // for문
			         for (int k = 0; k < peak_cost.length; k++) {
			            if (hours_L2[i] == peak_cost[k][0]) {
			               peak_sum_L2 +=  peak_cost[k][1];
			            }
			         }
			         for (int h = 0; h < night_cost.length; h++) {
			            if (hours_L2[i] == night_cost[h][0]) {
			               night_sum_L2 += night_cost[h][1];
			            }

			         } // for문

			      } // 마지막for문
		      System.out.println(norm_sum_L2 + " L2 정상시간가격!");
		      System.out.println(peak_sum_L2 + " L2피크시간가격!");
		      System.out.println(night_sum_L2 + " L2 밤시간가격!");
		      System.out.println(norm_sum_L2+peak_sum_L2+night_sum_L2+" L2 가격합계");
		      
		      
//////////////////////////////3333333333333333333333333		      
		      int gap_L3 = e_hour_L3 - s_hour_L3; // 실행시간
		      int[] hours_L3 = new int[gap_L3]; // 실행시간을 넣어주는 배열
		      int size_L3 = hours_L3.length; // 몇시간?

		      for (int i = 0; i < size_L3; i++) {
		         hours_L3[i] = s_hour_L3 + i;
		         for (int j = 0; j < norm_cost.length; j++) {
		            if (hours_L3[i] == norm_cost[j][0]) {
		               norm_sum_L3 += norm_cost[j][1];
		            } // if문
		         } // for문
		         for (int k = 0; k < peak_cost.length; k++) {
		            if (hours_L3[i] == peak_cost[k][0]) {
		               peak_sum_L3 += peak_cost[k][1];
		            }
		         }
		         for (int h = 0; h < night_cost.length; h++) {
		            if (hours_L3[i] == night_cost[h][0]) {
		               night_sum_L3 += night_cost[h][1];
		            }

		         } // for문

		      } // 마지막for문

		      System.out.println(norm_sum_L3 + " L3 정상시간가격!");
		      System.out.println(peak_sum_L3 + " L3 피크시간가격!");
		      System.out.println(night_sum_L3 + " L3 밤시간가격!");
		      System.out.println(norm_sum_L3+peak_sum_L3+night_sum_L3+" L3 가격합계");

		
			*/
			
	}// end main

}// end class
