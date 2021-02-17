package mainPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class realtimeCheck implements Runnable{
	
	public static String curTime = "";
	public static double hour; 
	public static double minute;
	public static double second; 
	
	public void run() {
		SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //데이터 형식
		Date curTimeDate;//현재시간을 받아올 Date객체
		Calendar ci;//현재시간을 세부적으로 가져올 객체
		while(true) {
			ci = Calendar.getInstance();
			hour = ci.get(Calendar.HOUR);
			minute = ci.get(Calendar.MINUTE);
			second = ci.get(Calendar.SECOND);
			
			curTimeDate = new Date();
			curTime = timeFormat.format(curTimeDate);//현재 시간을 받아와서 String으로 저장-->이용시 이걸씁니다
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//nothing
			}
		}	
	}
}
