package project.control;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class InvSMS {
	public InvSMS() {
		String api_key = "NCSDLEWHHNHVKFLH";
		String api_secret = "Q3E82SRNUYEMHAF5LTODFTZ7FAYWPULH";
        Coolsms coolsms = new Coolsms(api_key, api_secret);
        
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("to", "01067065052"); // ���Ź�ȣ
        set.put("from", "01089604112"); // �߽Ź�ȣ 
        set.put("text", "�ǹ��� ħ�԰���!\n112�Ű� �� �溸��ġ�ϰڽ��ϴ�."); // ���ڳ���
        set.put("type", "sms"); // ���� Ÿ��
        
        JSONObject result = coolsms.send(set); // ������&���۰���ޱ�
      
        
        if ((Boolean)result.get("status") == true) {
            // �޽��� ������ ���� �� ���۰�� ���
            System.out.println("����");            
            System.out.println(result.get("group_id")); // �׷���̵�
            System.out.println(result.get("result_code")); // ����ڵ�
            System.out.println(result.get("result_message"));  // ��� �޽���
            System.out.println(result.get("success_count")); // �޽������̵�
            System.out.println(result.get("error_count"));  // ������ ������ ������ �޽��� ��
        } else {
            // �޽��� ������ ����
            System.out.println("����");
            System.out.println(result.get("code")); // REST API �����ڵ�
            System.out.println(result.get("message")); // �����޽���
        }
        
	}
}

