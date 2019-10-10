package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestJson {
	
	// address만 받으면 string을 리턴해주겠다
	public String getJson(String address) {
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
			
		}
		return sb.toString();
	}

}
