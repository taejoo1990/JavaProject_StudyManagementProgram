package mainPackage;

public class AlramSetting implements Runnable {

	private String alSetTime;// ���� ������ �˶��ð�, �����ڸ� ���� �ʱ�ȭ,GUI���� �Է����� �޾ƿð���
	private boolean alLoop;
	private int alLoopPeriod;// �ݺ��ֱ� 1->30�� 2-> 1�ð� 3-> 1:30��....
	private int hash;
	private boolean qrAltrue;// qr �˶����� ����
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
			// qr�˶��϶� �ð�üũ
			if (qrAltrue == true && alSetTime.equals(realtimeCheck.curTime.substring(11, 19))) {
				qrDialog qrCode = new qrDialog(this);
				as.mGUI.settingSound.play(as.getAlramSound());
				if (alLoop == true) {
					// �ݺ��ɼ� Ȱ��
					loopAlSetting(alLoopPeriod);

				} else {
					alramOn = false;
				}
				
				// �ð� ǥ�� ������Ʈ
				for (int i = 0; i < as.getAsList().length; i++) {
					if (as.getAsList()[i] == null) {
						continue;
					} else if (this.hashCode() == as.getAsList()[i].hashCode()) {
						System.out.println(alSetTime);
						as.getAsList_Icon()[i].setText(alSetTime+"�� �˶��� �︳�ϴ�.");
						break;
					}
				}
				
			}

			// �׳� �˶��϶� �ð�üũ
			else if (qrAltrue == false && alSetTime.equals(realtimeCheck.curTime.substring(11, 19))) {

				qrDialog qrCode = new qrDialog(this);
				as.mGUI.settingSound.play(as.getAlramSound());
				if (alLoop == true) {
					loopAlSetting(alLoopPeriod);
					
				} else {
					alramOn = false;
				}

				// �ð� ǥ�� ������Ʈ
				for (int i = 0; i < as.getAsList().length; i++) {
					if (as.getAsList()[i] == null) {
						continue;
					} else if (this.hashCode() == as.getAsList()[i].hashCode()) {
						System.out.println(alSetTime);
						as.getAsList_Icon()[i].setText(alSetTime+"�� �˶��� �︳�ϴ�.");
						break;
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				alramOn = false;
			}
		} // while ��

		System.out.println("������ ������");

		// �˶������� �˶�����迭���� �ؽ��ڵ尪 ã�Ƽ� �ڵ�����
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
//			minute += second / 60; // 60�� �ѱ�� 1�� �߰�
//			second %= 60; // 60�� �ѱ�� �� �ٽ� ����
//			
//		}

		minute += 30 * alLoopPeriod;// ���� �ֱ�� 30�� ������ �����ϴ�

		if (minute >= 60) {
			hours += minute / 60;// 60�� �ѱ�� 1�ð� �߰�
			minute %= 60; // 60�� �ѱ�� �� �ٽ� 0���� ����
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
		// alSetTime = hours + ":" + minute + ":" + second;// ����� �ϴ� ���ļ� ���� �˶� ����

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
