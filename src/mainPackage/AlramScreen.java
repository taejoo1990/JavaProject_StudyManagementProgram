package mainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AlramScreen extends JPanel {
	
	private String AlramSound="src/mainPackage/res/Analog_Watch.wav";
	
	MainGUI mGUI;
	// �˶������� ����
	private AlramSetting[] asList = new AlramSetting[3];
	private Thread[] asList_T = new Thread[3];
	private JLabel[] asList_icon = new JLabel[3];
	private JButton[] asList_button = new JButton[3];
	private ImageIcon alramAddIcon_i = new ImageIcon("image/baseline_alarm_add_black_36dp.png");
	private ImageIcon alramDeleteIcon_On = new ImageIcon("image/alram/alramDelete_on.png");
	private ImageIcon alramDeleteIcon_Off = new ImageIcon("image/alram/alramDelete_off.png");
	private JLabel alramAddIcon = new JLabel();
	private boolean qrTrue=false;
	private boolean loopTrue=false;
	private int alLoopPeriod=0;
	
	//qr�˶�üũ ������
	private JCheckBox checkBox = new JCheckBox("QR�˶�");
	private ImageIcon checkBoxIcon_unchecked = new ImageIcon("Image/check_box_unchecked.png");
	private ImageIcon checkBoxIcon_checked = new ImageIcon("Image/check_box_checked.png");
	
	//�ݺ��ֱ� ����
	private JRadioButton[] loopRadioBtn = new JRadioButton[4];
	private JLabel loopInfo = new JLabel("�ݺ� �ֱ� ����");
	private String[] loopName = {"00:30", "01:00", "01:30", "�ݺ�����"};
	private ButtonGroup loopGroup = new ButtonGroup();
	private ImageIcon loopRadioBtnIcon_unchecked = new ImageIcon("Image/radiobutton_unchecked.png");
	private ImageIcon loopRadioBtnIcon_checked = new ImageIcon("Image/radiobutton_checked.png");
	
	// �ð�ǥ��
	private int hour = Integer.parseInt(realtimeCheck.curTime.substring(11, 13));
	private int minute = Integer.parseInt(realtimeCheck.curTime.substring(14, 16));
	private int second = Integer.parseInt(realtimeCheck.curTime.substring(17, 19));
	private JPanel timeSettingPanel = new JPanel();
	private JLabel hourSetting = new JLabel(Integer.toString(hour));
	private JLabel minuteSetting = new JLabel(Integer.toString(minute));
	private JLabel secondSetting = new JLabel(Integer.toString(second));
	private JLabel timeSemi1 = new JLabel(":");
	private JLabel timeSemi2 = new JLabel(":");
	private String tempSetTime;

	// �ð����� ȭ��ǥ
	private ImageIcon alSetArrowU_i = new ImageIcon("image/alramSetting_UpArrow_off.png");
	private ImageIcon alSetArrowD_i = new ImageIcon("image/alramSetting_DownArrow_off.png");
	private JLabel alSetArrowHU = new JLabel();
	private JLabel alSetArrowHD = new JLabel();
	private JLabel alSetArrowMU = new JLabel();
	private JLabel alSetArrowMD = new JLabel();
	private JLabel alSetArrowSU = new JLabel();
	private JLabel alSetArrowSD = new JLabel();

	private boolean alramDouble = false;

	
	//�ϴܾ�����
	private ImageIcon addAlramIcon_off = new ImageIcon("image/alram/alramAddIcon_off.png");
	private ImageIcon addAlramIcon_on = new ImageIcon("image/alram/alramAddIcon_on.png");
	private JButton addAlramIcon = new JButton();
	
	private ImageIcon backIcon_off = new ImageIcon("image/alram/returnIcon_off.png");
	private ImageIcon backIcon_on = new ImageIcon("image/alram/returnIcon_on.png");
	private JButton backIcon = new JButton();

	public AlramScreen(MainGUI mGUI) {

		this.mGUI = mGUI;
		
		// �ð��� �ϴ����϶� ���� ����
		if (hour < 10) {
			hourSetting.setText('0' + Integer.toString(hour));
		}
		if (minute < 10) {
			minuteSetting.setText('0' + Integer.toString(minute));
		}
		if (second < 10) {
			secondSetting.setText('0' + Integer.toString(second));
		}

		// --�ð������� ���� ���� ���� : 80,30,80,30,80
		hourSetting.setFont(new Font("DS-Digital", Font.BOLD, 70));
		hourSetting.setBounds(53, 200, 80, 50);
		timeSemi1.setFont(new Font("DS-Digital", Font.BOLD, 70));
		timeSemi1.setBounds(133, 200, 30, 50);
		minuteSetting.setFont(new Font("DS-Digital", Font.BOLD, 70));
		minuteSetting.setBounds(163, 200, 80, 50);
		timeSemi2.setFont(new Font("DS-Digital", Font.BOLD, 70));
		timeSemi2.setBounds(243, 200, 30, 50);
		secondSetting.setFont(new Font("DS-Digital", Font.BOLD, 70));
		secondSetting.setBounds(273, 200, 80, 50);
		add(hourSetting);
		add(timeSemi1);
		add(minuteSetting);
		add(timeSemi2);
		add(secondSetting);

		MainGUI.perfectButton(addAlramIcon, addAlramIcon_off, addAlramIcon_on);
		addAlramIcon.setBounds(0, 500, 200, 100);
		add(addAlramIcon);


		// �˶� ���� ȭ��ǥ
		alSetArrowHU.setIcon(alSetArrowU_i);
		alSetArrowHU.setBounds(53, 150, 72, 72);// 40~45 40+?
		add(alSetArrowHU);

		alSetArrowMU.setIcon(alSetArrowU_i);
		alSetArrowMU.setBounds(163, 150, 72, 72);// 40~45 40+?
		add(alSetArrowMU);

		alSetArrowSU.setIcon(alSetArrowU_i);
		alSetArrowSU.setBounds(273, 150, 72, 72);// 40~45 40+?
		add(alSetArrowSU);

		// ---�Ʒ�
		alSetArrowHD.setIcon(alSetArrowD_i);
		alSetArrowHD.setBounds(53, 233, 72, 72);// 40~45 40+?
		add(alSetArrowHD);

		alSetArrowMD.setIcon(alSetArrowD_i);
		alSetArrowMD.setBounds(163, 233, 72, 72);// 40~45 40+?
		add(alSetArrowMD);

		alSetArrowSD.setIcon(alSetArrowD_i);
		alSetArrowSD.setBounds(273, 233, 72, 72);// 40~45 40+?
		add(alSetArrowSD);
		
		
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				// �˶� �ð� ���� ��ư Ŭ��
				// ����ư
				if (e.getX() > 53 && e.getX() < 125 && e.getY() > 150 && e.getY() < 225) {
					hour++;
					if (hour >= 24) {
						hour = 0;
					}

					if (hour < 10) {
						hourSetting.setText('0' + Integer.toString(hour));
					} else {
						hourSetting.setText(Integer.toString(hour));
					}
				}

				if (e.getX() > 163 && e.getX() < 235 && e.getY() > 150 && e.getY() < 225) {
					minute++;
					if (minute >= 60) {
						minute = 0;
					}

					if (minute < 10) {
						minuteSetting.setText('0' + Integer.toString(minute));
					} else {
						minuteSetting.setText(Integer.toString(minute));
					}

				}

				if (e.getX() > 273 && e.getX() < 345 && e.getY() > 150 && e.getY() < 225) {
					second++;
					if (second >= 60) {
						second = 0;
					}

					if (second < 10) {
						secondSetting.setText('0' + Integer.toString(second));
					} else {
						secondSetting.setText(Integer.toString(second));
					}
				}

				// �Ʒ���ư
				if (e.getX() > 53 && e.getX() < 125 && e.getY() > 225 && e.getY() < 300) {
					hour--;
					if (hour < 0) {
						hour = 23;
					}
					if (hour < 10) {
						hourSetting.setText('0' + Integer.toString(hour));
					} else {
						hourSetting.setText(Integer.toString(hour));
					}
				}

				if (e.getX() > 163 && e.getX() < 235 && e.getY() > 225 && e.getY() < 300) {
					minute--;
					if (minute < 0) {
						minute = 59;
					}
					if (minute < 10) {
						minuteSetting.setText('0' + Integer.toString(minute));
					} else {
						minuteSetting.setText(Integer.toString(minute));
					}
				}

				if (e.getX() > 273 && e.getX() < 345 && e.getY() > 225 && e.getY() < 300) {
					second--;
					if (second < 0) {
						second = 59;
					}
					if (second < 10) {
						secondSetting.setText('0' + Integer.toString(second));
					} else {
						secondSetting.setText(Integer.toString(second));
					}
				}
			}

		});
		
		
		
		ActionListener checkButton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					checkBox.setIcon(checkBoxIcon_checked);
					qrTrue = true;
				}else {
					checkBox.setIcon(checkBoxIcon_unchecked);
					qrTrue = false;
				}
				
				if(loopRadioBtn[0].isSelected()) {
					loopRadioBtn[0].setIcon(loopRadioBtnIcon_checked);
					alLoopPeriod = 1;
					loopTrue = true;
				}else {
					loopRadioBtn[0].setIcon(loopRadioBtnIcon_unchecked);
				}
				if(loopRadioBtn[1].isSelected()) {
					loopRadioBtn[1].setIcon(loopRadioBtnIcon_checked);
					alLoopPeriod = 2;
					loopTrue = true;
				}else {
					loopRadioBtn[1].setIcon(loopRadioBtnIcon_unchecked);
				}
				if(loopRadioBtn[2].isSelected()) {
					loopRadioBtn[2].setIcon(loopRadioBtnIcon_checked);
					alLoopPeriod = 3;
					loopTrue = true;
				}else {
					loopRadioBtn[2].setIcon(loopRadioBtnIcon_unchecked);
				}
				
				if(loopRadioBtn[3].isSelected()) {
					loopRadioBtn[3].setIcon(loopRadioBtnIcon_checked);
					alLoopPeriod = 0;
					loopTrue = false;
				}else {
					loopRadioBtn[3].setIcon(loopRadioBtnIcon_unchecked);
				}
				
				
			}
			
		};
		
		
		
		
		
	
		ActionListener alramButton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addAlramIcon) {

					StringBuffer strs1 = new StringBuffer();
					
					if (Integer.parseInt(hourSetting.getText()) <= 9) {
						//strs1.append('0');
						strs1.append(hourSetting.getText());
						strs1.append(':');
					} else {
						strs1.append(hourSetting.getText());
						strs1.append(':');
					}

					if (Integer.parseInt(minuteSetting.getText()) <= 9) {
						//strs1.append('0');
						strs1.append(minuteSetting.getText());
						strs1.append(':');
					} else {
						strs1.append(minuteSetting.getText());
						strs1.append(':');
					}

					if (Integer.parseInt(secondSetting.getText()) <= 9) {
						//strs1.append('0');
						strs1.append(secondSetting.getText());
					} else {
						strs1.append(secondSetting.getText());
					}

					tempSetTime = strs1.toString();
//					JOptionPane.showMessageDialog(null, tempSetTime);

					// �ߺ��ð� �˶��� �ִ��� üũ

					for (int i = 0; i < asList.length; i++) {

						if (asList[i] != null && tempSetTime.equals(asList[i].getAlSetTime())) {
							
							JOptionPane.showMessageDialog(null, "�̹� ������ �˶� �Դϴ�.");
							// �ߺ��� �ð��� �ִ� üũ
							alramDouble = true;
							break;
						} else if (i == asList.length - 1) {
							// �ٵ��ƺôµ� �ߺ��ð��� ����.
							alramDouble = false;
						}
					}

					// �ߺ��� �ð��� ���ٸ�... �迭 ���ڸ��� �˶�����
					if (alramDouble == false) {
						for (int i = 0; i < asList.length; i++) {
							if (asList[i] == null) {
								
								
								asList[i] = new AlramSetting(tempSetTime, loopTrue, qrTrue, alLoopPeriod, AlramScreen.this, i);
								System.out.println(tempSetTime +'\\'+ loopTrue +'\\'+ qrTrue +'\\'+ alLoopPeriod);
								// �迭�� ���(�˶�,�˶����ེ����,�˶�ǥ�þ�����
								asList_T[i] = new Thread(asList[i]);
								asList_button[i] = new JButton();
								asList_icon[i] = new JLabel();

								// �˶�����
								asList_T[i].start();
								
								
								//�˶��ð��� ǥ��
								asList_icon[i].setText(asList[i].getAlSetTime()+" �� �˶��� �︳�ϴ�.");
								asList_icon[i].setBounds(130, 310+(i*48), 300, 48);
								
								//�˶������� ǥ��
								//MainGUI.perfectButton(asList_button[i], alramAddIcon_i, alramAddIcon_i);
								MainGUI.perfectButton(asList_button[i], alramDeleteIcon_Off,alramDeleteIcon_On );
								asList_button[i].setIcon(alramDeleteIcon_Off);
								asList_button[i].setBounds(60, 310+(i*48), 48, 48);
								asList_button[i].addActionListener(this);
								
								add(asList_button[i]);
								add(asList_icon[i]);
								repaint();
									
								break;
							}
						}
					}
					
				} // �˶� �ð� ���� ��ư Ŭ�� ��

				//�ڷΰ��� ������
				if(e.getSource()==backIcon) {
					AlramScreen.this.setVisible(false);
					mGUI.secondScreen.setVisible(true);
				}
				
				//�˶�����
				if(e.getSource()==asList_button[0]) {
					asList_T[0].interrupt();
				}
				
				if(e.getSource()==asList_button[1]) {
					asList_T[1].interrupt();
				}
				
				if(e.getSource()==asList_button[2]) {
					asList_T[2].interrupt();
				}
				
			}

		};
		
		
		//��ư�� ����ֱ�
		addAlramIcon.addActionListener(alramButton);
		backIcon.addActionListener(alramButton);
		checkBox.addActionListener(checkButton);
		
		//�ڷΰ��� ������
		MainGUI.perfectButton(backIcon, backIcon_off, backIcon_on);
		backIcon.setBounds(200, 500, 200, 100);
		backIcon.setIcon(backIcon_off);
		add(backIcon);
		
		//üũ�ڽ� ������
		checkBox.setIcon(checkBoxIcon_unchecked);
		checkBox.setOpaque(false);
		checkBox.setBounds(10, 40, 100, 30);
		add(checkBox);
		
		//�ݺ��ֱ� ����
		loopInfo.setBounds(15, 70, 100, 30);
		add(loopInfo);
		
		//�ݺ��ֱ� �����ڽ�
		for(int i=0; i<loopRadioBtn.length;i++) {
			loopRadioBtn[i] = new JRadioButton(loopName[i]);
			loopGroup.add(loopRadioBtn[i]);
			loopRadioBtn[i].setIcon(loopRadioBtnIcon_unchecked);
			loopRadioBtn[i].setBounds(10+(i*90), 100 , 90, 30);
			loopRadioBtn[i].setOpaque(false);
			loopRadioBtn[i].addActionListener(checkButton);
			add(loopRadioBtn[i]);
		}
		//�ݺ����� �⺻ ����
		loopRadioBtn[3].setSelected(true);
		loopRadioBtn[3].setIcon(loopRadioBtnIcon_checked);
		
		
		setBackground(Color.white);
		setLayout(null);
		setBounds(0, 0, 400, 700);
		setVisible(false);
	}

	public AlramSetting[] getAsList() {
		return this.asList;
	}
	public JLabel[] getAsList_Icon() {
		return this.asList_icon;
	}
	public Thread[] getAsList_T() {
		return this.asList_T;
	}
	public JButton[] getAsList_button() {
		return this.asList_button;
	}
	public String getAlramSound() {
		return this.AlramSound;
	}
	
	public void setAlramSound(String AlramSound) {
		this.AlramSound = AlramSound;
	}

	
}
