package com.jntuh.librayproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.swing.JOptionPane;
 
@SuppressWarnings("unused")
public class OtpClass {
	public static int otp=98765;
	public void sendSms(String name,String phone) {
		try {
			// Construct data	NmE2MjRmNDU0YTY2MzgzMTQxNzM0MzYxNjc0OTM4NTE=
			String apiKey = "apikey=" + "NmE2MjRmNDU0YTY2MzgzMTQxNzM0MzYxNjc0OTM4NTE=";
			String message = "&message=" + "Hi "+name+" Your OTP is "+otp;
			String sender = "&sender=" + "UG LIBRARY LIMITED";
			String numbers = "&numbers=" + phone;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			JOptionPane.showMessageDialog(null, "OTP sent Sucessfully");
			//return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		}
	}
}