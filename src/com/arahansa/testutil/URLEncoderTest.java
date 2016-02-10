package com.arahansa.testutil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class URLEncoderTest {

	public static void main(String[] args) throws Exception {
		String encode = URLEncoder.encode("아프리카", "EUC-KR");
		System.out.println("인코드 : " + encode);
		// sendGet(encode);
	}

	// HTTP GET request
	private static void sendGet(String query) throws Exception {

		// File
		File file = new File("filename.html");
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		// Network
		String url = "http://news.naver.com/main/search/search.nhn?query="+query;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		System.out.println("contentType :"+con.getContentType());
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "EUC-KR"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			// System.out.println(inputLine);
			byte[] bytes = inputLine.getBytes("ISO-8859-1");
			if(inputLine.indexOf("<meta charset=\"euc-kr\">") != -1){
				System.out.println("발견됨");
				inputLine = inputLine.replace("euc-kr", "utf-8");
			}
			bw.write(inputLine);
			bw.write("\n");
		}
		in.close();
		bw.close();

		// print result
		// System.out.println(response.toString());
	}

}
