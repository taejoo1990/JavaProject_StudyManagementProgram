package mainPackage;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class SettingFont extends Setting1 {
	MainGUI mGUI;

	// ��Ʈ �ɼ�
	private String op1 = "Serif";
	private String op2 = "GungSeo";
	private String op2_r = "�ü�";
	private String op3 = "Cochin";
	private String op4 = "Helvetica";
	private String op5 = "Monospaced";
	private int num;

	// ������
	public SettingFont(MainGUI mGUI) {
		this.mGUI = mGUI;

		// ���콺 ���ٴ�� ������ ���� ����. (on= red / off= default)
		addMouseMotionListener(new MouseAdapter() {
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

		// ���콺 Ŭ���ϸ� ȭ����ȯ Ȥ�� ��Ʈ ����. font changed
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				// �ڷΰ���: �����г�
				if (e.getX() > topX && e.getX() < topX + topIconSize && e.getY() > topY
						&& e.getY() < topY + topIconSize) {
					SettingFont.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					hover_backIcon(back);
				}
				// ������ ��Ʈ�� ����
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY
						&& e.getY() < checkBtnY + checkBtnH) {
					setFont(op1);
					num = 1;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 70
						&& e.getY() < checkBtnY + 70 + checkBtnH) {
					setFont(op2_r);
					num = 2;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 140
						&& e.getY() < checkBtnY + 140 + checkBtnH) {
					setFont(op3);
					num = 3;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 210
						&& e.getY() < checkBtnY + 210 + checkBtnH) {
					setFont(op4);
					num = 4;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX + checkBtnW && e.getY() > checkBtnY + 280
						&& e.getY() < checkBtnY + 280 + checkBtnH) {
					setFont(op5);
					num = 5;
				}
				// üũ�ڽ� �̹��� ���� ����
				checkBoxState(num);
			}
		});

		// �гλ��� (with �⺻ �ɼ�)
		setPanel("Fonts");
		set_subHr(hr1, hr2, hr3, hr4, hr5);
//		set_subBg(lc_subBg); //������ �Ф� 
//		this.add(lb_subBg); //������ �Ф� 
		set_logo(lc_logo);

		// �ؽ�Ʈ �� ���� & �ٿ�� ����
		setLabelText(op1, op2, op3, op4, op5);
		setBound_subTxt();
		setFontToMainTxt();

		// üũ�ڽ�(��) ���� & �ٿ�� ����
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5);

		// �󺧵� �гο� �ø���. Add labels on Panel
		addOnPanel_mainTxt();
		addOnPanel_checkBox();
	}

	// ��Ʈ ���� �޼ҵ�
	void setFont(String opt) {
		MainGUI.font = opt;
		Font font = new Font(MainGUI.font, Font.BOLD, 24);

		// ���� �ٸ� ��ũ�� �г� ���� �ֱ�(���� �г� ����)
		Component[] panels = { mGUI.secondScreen, mGUI.settingScreen, mGUI.settingSound, mGUI.settingColor,
				mGUI.settingFont, mGUI.as };
		for (int i = 0; i < panels.length; i++) {
			
			//�гκ� ��Ʈ������ ����
			if (panels[i].getClass().getName().equals("mainPackage.SecondScreen")) {
				font = new Font(MainGUI.font, Font.BOLD, 15);
			}
			if (panels[i].getClass().getName().equals("mainPackage.AlramScreen")) {
				font = new Font(MainGUI.font, Font.BOLD, 12);
			}
			// ��Ʈ ����â ��Ʈ ũ�� ����
			if (panels[i].getClass().getName().equals("mainPackage.SettingFont")){
				font = new Font(MainGUI.font, Font.BOLD, 20);
			}
			// ���� ����â ��Ʈ ũ�� ����
			if (panels[i].getClass().getName().equals("mainPackage.SettingFont")){
				font = new Font(MainGUI.font, Font.BOLD, 20);
			}
			
			
			//�� ���� �гε��� �� ��ҵ鿡 ����
			Component[] comps = ((Container) panels[i]).getComponents();
			for (Component comp : comps) {
				System.out.println(comp.getY() + " , " + comp.getClass().toString());
				
				//������ �ð� ��Ʈ ���� ����
				if (panels[i].getClass().getName().equals("mainPackage.SecondScreen") 
						&& comp.getY() == 10
						&& comp.getX() == 0) {
					//������ �ð� ��Ʈ ���� ����
				}
				else if(panels[i].getClass().getName().equals("mainPackage.AlramScreen")
						&& comp.getY() == 200 
						&& comp.getX() == 53 ) {
					
				}
				else if(panels[i].getClass().getName().equals("mainPackage.AlramScreen")
						&& comp.getY() == 200 
						&& comp.getX() == 133 ) {
					
				}
				else if(panels[i].getClass().getName().equals("mainPackage.AlramScreen")
						&& comp.getY() == 200 
						&& comp.getX() == 163 ) {
					
				}
				else if(panels[i].getClass().getName().equals("mainPackage.AlramScreen")
						&& comp.getY() == 200 
						&& comp.getX() == 243 ) {
					
				}
				else if(panels[i].getClass().getName().equals("mainPackage.AlramScreen")
						&& comp.getY() == 200 
						&& comp.getX() == 273 ) {
					
				}
				
				//�⺻ ���ð����� ����
				else {
					comp.setFont(font);
					this.validate();
					this.repaint();
				}

			}
			
			//��Ʈ �⺻ ���ð����� �ʱ�ȭ
			font = new Font(MainGUI.font, Font.BOLD, 24);
		}
	}

	// �����ӿ�
	void setFont(String opt, JFrame c) {
		MainGUI.font = opt;
		Font font = new Font(MainGUI.font, Font.BOLD, 24);

		
		// �����췯�ϰ�� ��Ʈ ũ�� ����
		if (c.getClass().getName().equals("mainPackage.MemoScheduler")) {
			font = new Font(MainGUI.font, Font.BOLD, 14);
		}

		// �޸����ϰ�� ��Ʈ ũ�� ����
		if (c.getClass().getName().equals("mainPackage.Memo")) {
			font = new Font(MainGUI.font, Font.BOLD, 12);
		}

		Component[] comps = ((Container) c.getContentPane()).getComponents();
		for (int i = 0; i < comps.length; i++) {
			Component[] panels = ((Container) comps[i]).getComponents();
			for (Component panel : panels) {
				System.out.println(panel.getY() + " , " + panel.getClass().toString());
				
				//�޸��� ���� ����κи� Ư�� ����
				if(c.getClass().getName().equals("mainPackage.Memo")
						&& panel.getY() == 5) {
					panel.setFont(new Font(MainGUI.font, Font.BOLD, 27));
				}
				else {
					panel.setFont(font);
					this.validate();
					this.repaint();
				}
			}
		}
	}
}
