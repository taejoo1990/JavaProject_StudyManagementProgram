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
		SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss"); //������ ����
		Date curTimeDate;//����ð��� �޾ƿ� Date��ü
		Calendar ci;//����ð��� ���������� ������ ��ü
		while(true) {
			ci = Calendar.getInstance();
			hour = ci.get(Calendar.HOUR);
			minute = ci.get(Calendar.MINUTE);
			second = ci.get(Calendar.SECOND);
			
			curTimeDate = new Date();
			curTime = timeFormat.format(curTimeDate);//���� �ð��� �޾ƿͼ� String���� ����-->�̿�� �̰ɾ��ϴ�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//nothing
			}
		}	
	}
}
