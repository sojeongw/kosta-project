package project.control;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class InvSMS {
	public InvSMS() {
		String api_key = "NCSDLEWHHNHVKFLH";
		String api_secret = "Q3E82SRNUYEMHAF5LTODFTZ7FAYWPULH";
        Coolsms coolsms = new Coolsms(api_key, api_secret);
        
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("to", "01067065052"); // 수신번호
        set.put("from", "01089604112"); // 발신번호 
        set.put("text", "건물내 침입감지!\n112신고 및 경보조치하겠습니다."); // 문자내용
        set.put("type", "sms"); // 문자 타입
        
        JSONObject result = coolsms.send(set); // 보내기&전송결과받기
      
        
        if ((Boolean)result.get("status") == true) {
            // 메시지 보내기 성공 및 전송결과 출력
            System.out.println("성공");            
            System.out.println(result.get("group_id")); // 그룹아이디
            System.out.println(result.get("result_code")); // 결과코드
            System.out.println(result.get("result_message"));  // 결과 메시지
            System.out.println(result.get("success_count")); // 메시지아이디
            System.out.println(result.get("error_count"));  // 여러개 보낼시 오류난 메시지 수
        } else {
            // 메시지 보내기 실패
            System.out.println("실패");
            System.out.println(result.get("code")); // REST API 에러코드
            System.out.println(result.get("message")); // 에러메시지
        }
        
	}
}

