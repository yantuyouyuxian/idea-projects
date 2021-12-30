package fx.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectionDM {
	
	private String request_url="";
	
	private String request_number="";
	
	private HttpURLConnection conn;
	
	public ConnectionDM() {
		
	}

	
	
	public String getRequest_url() {
		return request_url;
	}

	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}

	public String getRequest_number() {
		return request_number;
	}

	public void setRequest_number(String request_number) {
		this.request_number = request_number;
	}
	
	public boolean connection() {
		
		try {
			URL url = new URL(request_url);
			
			conn=(HttpURLConnection)url.openConnection();
			
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
//			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void disconnect() {
		if(conn != null) {
			conn.disconnect();
		}
	}
	
	public String getDMData() {
		
		try {
			
			OutputStreamWriter writer=new OutputStreamWriter(conn.getOutputStream());
		
			String post_value_1="roomid="+URLEncoder.encode(request_number,"UTF-8");
			
			String post_value_2="&csrf_token="+URLEncoder.encode("5b0ac7a32c57efa4cbc28245edd83e5b","UTF-8");
			
			String post_value_3="&csrf="+URLEncoder.encode("5b0ac7a32c57efa4cbc28245edd83e5b","UTF-8");
			
			String post_value_4="&visit_id="+URLEncoder.encode("","UTF-8");
			
			String post_value=post_value_1+post_value_2+post_value_3+post_value_4;
			
			writer.write(post_value);
			writer.flush();
			writer.close();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String rl="";
			String data="";
			
			while((rl=reader.readLine())!=null) {
				data=data+rl;
			}
			
			reader.close();
			
			return data;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	public static ObservableList<DMData> findData(String data){
		
		String str_value=data.replaceAll("vip", "\r\n");
		
		String pat="text(.*)isadmin";
		
		Pattern pattern=Pattern.compile(pat);
		
		ObservableList<DMData> list=FXCollections.observableArrayList();
		
		Matcher matcher=pattern.matcher(str_value);
		while(matcher.find()) {
			
			String temp_data=matcher.group();
			
			DMData dmd=new DMData();
			
			String pat_text="text(.*)nickname";
			
			Pattern pattern_text=Pattern.compile(pat_text);
			
			Matcher matcher_text=pattern_text.matcher(temp_data);
			
			while(matcher_text.find()) {
				String temp_str=matcher_text.group();
				
				String text=temp_str.substring(7, temp_str.length()-11);
				
				dmd.setText(text);
				
			}
			//---------------------------------
			
			String pat_nickname="nickname(.*)uname_color";
			
			Pattern pattern_nickname=Pattern.compile(pat_nickname);
			
			Matcher matcher_nickname=pattern_nickname.matcher(temp_data);
			
			while(matcher_nickname.find()) {
				String temp_str=matcher_nickname.group();
				
				String nickname=temp_str.substring(11, temp_str.length()-14);
				
				dmd.setNickname(nickname);
				
			}
			
			//-----------------------------------------
			String pat_timeline="timeline(.*)isadmin";
			
			Pattern pattern_timeline=Pattern.compile(pat_timeline);
			
			Matcher matcher_timeline=pattern_timeline.matcher(temp_data);
			
			while(matcher_timeline.find()) {
				String temp_str=matcher_timeline.group();
				
				String timeline=temp_str.substring(11, temp_str.length()-10);
				
				dmd.setTimeline(timeline);
			}
			
			list.add(dmd);
		}
		
		return list;
	}
	
	
}
