package test.com;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("network...");

		/*// http://192.168.0.105/jsp15Json/json_selectOneAPI.do
		String address = "http://192.168.0.105:8090/jsp15Json/json_selectOneAPI.do";
		HttpURLConnection conn = null;

		try {
			// 커넥션 맺음 >> http 커넥션
			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			// 커넥션 잘 됐는지 확인
			System.out.println("conn.getResponseCode() : " + conn.getResponseCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (conn != null)
				conn.disconnect();
		}*/
		
		
		
		// http://localhost:8090/jsp16MenuJson/selectAll.do
	/*	String address = "http://192.168.0.105:8090/jsp16MenuJson/selectAll.do";
		HttpURLConnection conn = null;
		
		// conn한테 정보 요청
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			// 커넥션 맺음 >> http 커넥션
			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			// 커넥션 잘 됐는지 확인
			System.out.println("conn.getResponseCode() : " + conn.getResponseCode());
			
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String str = "";
			
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null)
				conn.disconnect();
			
		}*/
		
		
		
		
		
		int flag = 3;
		if(flag == 0) {
			String address = "http://192.168.0.105:8090/jsp15Json/json_selectOneAPI.do?num=6";
			String responseText = new TestJson().getJson(address);
			System.out.println("responseText : "+responseText);
			
			JSONObject obj = new JSONObject(responseText);
			System.out.println(obj.getString("name"));
			System.out.println(obj.getInt("age"));
		} else if(flag == 1) {
			String address = "http://192.168.0.105:8090/jsp16MenuJson/selectAll.do";
			String responseText = new TestJson().getJson(address);
			System.out.println("responseText : "+responseText);
			
			JSONArray array = new JSONArray(responseText);
			// length 메소드임을 주의
			for(int i=0; i<array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				System.out.println(obj.getString("menu"));
				System.out.println(obj.getInt("price"));
				System.out.println(obj.getString("store"));
				System.out.println(obj.getInt("kcal"));
			}
		} else if(flag == 2) {
			String address = "http://192.168.0.105:8090/jsp16MenuJson/selectOne.do?num=6";
			String responseText = new TestJson().getJson(address);
			System.out.println("responseText : " + responseText);
			
			JSONObject obj = new JSONObject(responseText);
			System.out.println(obj.getString("menu"));
			System.out.println(obj.getInt("price"));
			System.out.println(obj.getString("store"));
			System.out.println(obj.getInt("kcal"));
		} else if(flag == 3) {
			String address = "http://192.168.0.105:8090/jsp12Member/MemberSelectAll.do";
			String responseText = new TestJson().getJson(address);
			System.out.println("responseText : " + responseText);
			
			JSONArray array = new JSONArray(responseText);
			for(int i=0; i<array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				System.out.println(obj.getInt("num"));
				System.out.println(obj.getString("id"));
				System.out.println(obj.getString("pw"));
				System.out.println(obj.getString("name"));
				System.out.println(obj.getString("tel"));
			}
		} else if(flag == 4) {
			String address = "http://192.168.0.105:8090/jsp12Member/MemberSelectOne.do?num=41";
			String responseText = new TestJson().getJson(address);
			System.out.println("responseText : " + responseText);
			
			JSONObject obj = new JSONObject(responseText);
			System.out.println(obj.getInt("num"));
			System.out.println(obj.getString("id"));
			System.out.println(obj.getString("pw"));
			System.out.println(obj.getString("name"));
			System.out.println(obj.getString("tel"));
		}
		
		
		
		
	}

}
