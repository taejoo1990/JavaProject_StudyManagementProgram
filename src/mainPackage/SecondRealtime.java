package mainPackage;

public class SecondRealtime implements Runnable {

	SecondScreen secondScreen;
	AlramScreen as;
	int i = 0;
	String a;

	public SecondRealtime(SecondScreen secondScreen,AlramScreen as) {
		this.as = as;
		this.secondScreen = secondScreen;
		secondScreen.curTime.setText(realtimeCheck.curTime);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secondScreen.curTime.setText(realtimeCheck.curTime);
		}
	}
}
