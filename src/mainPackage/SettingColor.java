package mainPackage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingColor extends Setting1 {
	MainGUI mGUI;

	// �÷��ɼ�
	
	private Color op1 = new Color(255,128,0);
	private Color op2 = Color.LIGHT_GRAY;
	private Color op3 = Color.white;
	private Color op4 = Color.yellow;
	private Color op5 = Color.green;
	private int num;

	// ������
	public SettingColor(MainGUI mGUI) {
		this.mGUI = mGUI;

		// ���콺 ���ٴ�� ������ ���� ����. (on= red / off= default)
		addMouseMotionListener(new MouseAdapter() { // �͸��� Ŭ��
			@Override
			public void mouseMoved(MouseEvent e) {
				if (e.getX() > topX && e.getX() < topX + topIconSize && e.getY() > topY
						&& e.getY() < topY + topIconSize) {
					hover_backIcon(back_on);
				} else {
					hover_backIcon(back);
				}
			}
		});

		// ���콺 Ŭ���ϸ� ȭ����ȯ Ȥ�� ���� ����. background color changed
		addMouseListener(new MouseAdapter() { // �͸��� Ŭ��
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				// �ڷΰ���: �����г�. Move to SettingScreen
				if (e.getX() > topX && e.getX() < topX + topIconSize && e.getY() > topY
						&& e.getY() < topY + topIconSize) {
					SettingColor.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					hover_backIcon(back);
				}
				// ���� ����. set new background color.
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY
						&& e.getY() < checkBtnY + checkBtnH) {
					setBackgroundColor(op1);
					num = 1;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 70
						&& e.getY() < checkBtnY + 70 + checkBtnH) {
					setBackgroundColor(op2);
					num = 2;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 140
						&& e.getY() < checkBtnY + 140 + checkBtnH) {
					setBackgroundColor(op3);
					num = 3;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 210
						&& e.getY() < checkBtnY + 210 + checkBtnH) {
					setBackgroundColor(op4);
					num = 4;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 280
						&& e.getY() < checkBtnY + 280 + checkBtnH) {
					setBackgroundColor(op5);
					num = 5;
				}
				// üũ�ڽ� �̹��� ���� ����
				checkBoxState(num);

			}
		});

		// �гλ��� (with �⺻ �ɼ�)
		setPanel("Colors");
//		set_subBg(lc_subBg); //������ �Ф� 
//		this.add(lb_subBg); //������ �Ф� 
		set_subHr(hr1, hr2, hr3, hr4, hr5);
		set_logo(lc_logo);

		// �ؽ�Ʈ �� ���� & �ٿ�� ����
		setLabelText("Default", "Gray", "White", "Yellow", "Green");
		setBound_subTxt();
		setFontToMainTxt();

		// üũ�ڽ�(��) ���� & �ٿ�� ����
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5);

		// �󺧵� �гο� �ø���. Add labels on Panel
		addOnPanel_mainTxt();
		addOnPanel_checkBox();
	}

	// ���� ���� �޼ҵ�
	void setBackgroundColor(Color color) {
		MainGUI.color = color;
		try {

			mGUI.secondScreen.setBackground(color);
			mGUI.settingScreen.setBackground(color);
			mGUI.settingSound.setBackground(color);
			mGUI.settingColor.setBackground(color);
			mGUI.settingFont.setBackground(color);
			mGUI.as.setBackground(color);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
//			System.out.println("���ȭ�� ���󺯰� ����");
		}
	}

	// �����ٷ�, �޸� �����ӿ�
//	void setBackgroundColor(Color color, JFrame c) {
//
//		if (c.getClass().getName().equals("mainPackage.MemoScheduler")) {
//			mGUI.msd.panWest.setBackground(color);
//			mGUI.msd.panNorth.setBackground(color);
//			mGUI.msd.panEast.setBackground(color);
//		}
//		
//	}

}
