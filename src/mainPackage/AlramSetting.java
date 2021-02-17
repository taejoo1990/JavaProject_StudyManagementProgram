package mainPackage;

public class AlramSetting implements Runnable {

	private String alSetTime;// 내가 설정할 알람시각, 생성자를 통해 초기화,GUI에서 입력으로 받아올것임
	private boolean alLoop;
	private int alLoopPeriod;// 반복주기 1->30분 2-> 1시간 3-> 1:30분....
	private int hash;
	private boolean qrAltrue;// qr 알람인지 여부
	private boolean alramOn = true;
	private boolean removeClick = false;
	private AlramScreen as;

	public AlramSetting(String alSetTime, boolean alLoop, boolean qrAltrue, int alLoopPeriod, AlramScreen as,
			int hash) {
		this.as = as;
		this.alSetTime = alSetTime;
		this.alLoop = alLoop;
		this.qrAltrue = qrAltrue;
		this.alLoopPeriod = alLoopPeriod;
		this.hash = hash;
	}

	public void run() {
		while (alramOn) {
			// qr알람일때 시간체크
			if (qrAltrue == true && alSetTime.equals(realtimeCheck.curTime.substring(11, 19))) {
				qrDialog qrCode = new qrDialog(this);
				as.mGUI.settingSound.play(as.getAlramSound());
				if (alLoop == true) {
					// 반복옵션 활성
					loopAlSetting(alLoopPeriod);

				} else {
					alramOn = false;
				}
				
				// 시간 표시 업데이트
				for (int i = 0; i < as.getAsList().length; i++) {
					if (as.getAsList()[i] == null) {
						continue;
					} else if (this.hashCode() == as.getAsList()[i].hashCode()) {
						System.out.println(alSetTime);
						as.getAsList_Icon()[i].setText(alSetTime+"에 알람이 울립니다.");
						break;
					}
				}
				
			}

			// 그냥 알람일때 시간체크
			else if (qrAltrue == false && alSetTime.equals(realtimeCheck.curTime.substring(11, 19))) {

				qrDialog qrCode = new qrDialog(this);
				as.mGUI.settingSound.play(as.getAlramSound());
				if (alLoop == true) {
					loopAlSetting(alLoopPeriod);
					
				} else {
					alramOn = false;
				}

				// 시간 표시 업데이트
				for (int i = 0; i < as.getAsList().length; i++) {
					if (as.getAsList()[i] == null) {
						continue;
					} else if (this.hashCode() == as.getAsList()[i].hashCode()) {
						System.out.println(alSetTime);
						as.getAsList_Icon()[i].setText(alSetTime+"에 알람이 울립니다.");
						break;
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				alramOn = false;
			}
		} // while 끝

		System.out.println("스레드 종료중");

		// 알람끝나면 알람저장배열에서 해쉬코드값 찾아서 자동제거
		for (int i = 0; i < as.getAsList().length; i++) {
			if (as.getAsList()[i] != null && this.hashCode() == as.getAsList()[i].hashCode()) {
				as.getAsList()[i] = null;
				as.remove(as.getAsList_Icon()[i]);
				as.getAsList_Icon()[i] = null;
				as.getAsList_T()[i] = null;
				as.remove(as.getAsList_button()[i]);
				as.getAsList_button()[i] = null;

				if (as.getAsList()[i] == null) {
					System.out.println("null ok1");
				}
				if (as.getAsList_Icon()[i] == null) {
					System.out.println("null ok2");
				}
				if (as.getAsList_T()[i] == null) {
					System.out.println("null ok3");
				}
				if (as.getAsList_button()[i] == null) {
					System.out.println("null ok4");
				}
				as.repaint();
				break;
			}
		}

	}

	public void loopAlSetting(int alLoopPeriod) {

		StringBuffer tempAlSetTime = new StringBuffer();
		int hours = Integer.parseInt(alSetTime.substring(0, 2));
		int minute = Integer.parseInt(alSetTime.substring(3, 5));
		int second = Integer.parseInt(alSetTime.substring(6, 8));

//		if (second >= 60) {
//			minute += second / 60; // 60분 넘길시 1분 추가
//			second %= 60; // 60초 넘길시 초 다시 시작
//			
//		}

		minute += 30 * alLoopPeriod;// 루프 주기는 30분 단위로 가능하다

		if (minute >= 60) {
			hours += minute / 60;// 60분 넘길시 1시간 추가
			minute %= 60; // 60초 넘길시 분 다시 0부터 시작
		}

		if (hours >= 24) {
			hours %= 24;
		}

		if (hours < 10) {
			tempAlSetTime.append('0');
			tempAlSetTime.append(hours);
			tempAlSetTime.append(':');

		} else {
			tempAlSetTime.append(hours);
			tempAlSetTime.append(':');
		}

		if (minute < 10) {
			tempAlSetTime.append('0');
			tempAlSetTime.append(minute);
			tempAlSetTime.append(':');
		} else {
			tempAlSetTime.append(minute);
			tempAlSetTime.append(':');
		}

		if (second < 10) {
			tempAlSetTime.append('0');
			tempAlSetTime.append(second);
		} else {
			tempAlSetTime.append(second);
		}

		alSetTime = tempAlSetTime.toString();
		// alSetTime = hours + ":" + minute + ":" + second;// 계산후 싹다 합쳐서 다음 알람 설정

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.hash;
	}

	public boolean getRemoveClick() {
		return this.removeClick;
	}

	public void setRemoveClick(boolean removeClick) {
		this.removeClick = removeClick;
	}

	public String getAlSetTime() {
		return this.alSetTime;
	}

	public void setAlSetTime(boolean removeClick) {
		this.alSetTime = alSetTime;
	}

	public boolean getqrBool() {
		return this.qrAltrue;
	}

}
