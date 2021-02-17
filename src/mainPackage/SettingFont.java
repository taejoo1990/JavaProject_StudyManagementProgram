package mainPackage;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class SettingFont extends Setting1 {
	MainGUI mGUI;

	// 폰트 옵션
	private String op1 = "Serif";
	private String op2 = "GungSeo";
	private String op2_r = "궁서";
	private String op3 = "Cochin";
	private String op4 = "Helvetica";
	private String op5 = "Monospaced";
	private int num;

	// 생성자
	public SettingFont(MainGUI mGUI) {
		this.mGUI = mGUI;

		// 마우스 갖다대면 아이콘 색상 변경. (on= red / off= default)
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

		// 마우스 클릭하면 화면전환 혹은 폰트 설정. font changed
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				// 뒤로가기: 셋팅패널
				if (e.getX() > topX && e.getX() < topX + topIconSize && e.getY() > topY
						&& e.getY() < topY + topIconSize) {
					SettingFont.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					hover_backIcon(back);
				}
				// 선택한 폰트로 변경
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
				// 체크박스 이미지 상태 변경
				checkBoxState(num);
			}
		});

		// 패널생성 (with 기본 옵션)
		setPanel("Fonts");
		set_subHr(hr1, hr2, hr3, hr4, hr5);
//		set_subBg(lc_subBg); //가려짐 ㅠㅠ 
//		this.add(lb_subBg); //가려짐 ㅠㅠ 
		set_logo(lc_logo);

		// 텍스트 라벨 생성 & 바운드 설정
		setLabelText(op1, op2, op3, op4, op5);
		setBound_subTxt();
		setFontToMainTxt();

		// 체크박스(라벨) 생성 & 바운드 설정
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5);

		// 라벨들 패널에 올리기. Add labels on Panel
		addOnPanel_mainTxt();
		addOnPanel_checkBox();
	}

	// 폰트 변경 메소드
	void setFont(String opt) {
		MainGUI.font = opt;
		Font font = new Font(MainGUI.font, Font.BOLD, 24);

		// 추후 다른 스크린 패널 변수 넣기(각각 패널 저장)
		Component[] panels = { mGUI.secondScreen, mGUI.settingScreen, mGUI.settingSound, mGUI.settingColor,
				mGUI.settingFont, mGUI.as };
		for (int i = 0; i < panels.length; i++) {
			
			//패널별 폰트사이즈 설정
			if (panels[i].getClass().getName().equals("mainPackage.SecondScreen")) {
				font = new Font(MainGUI.font, Font.BOLD, 15);
			}
			if (panels[i].getClass().getName().equals("mainPackage.AlramScreen")) {
				font = new Font(MainGUI.font, Font.BOLD, 12);
			}
			// 폰트 설정창 폰트 크기 설정
			if (panels[i].getClass().getName().equals("mainPackage.SettingFont")){
				font = new Font(MainGUI.font, Font.BOLD, 20);
			}
			// 사운드 설정창 폰트 크기 설정
			if (panels[i].getClass().getName().equals("mainPackage.SettingFont")){
				font = new Font(MainGUI.font, Font.BOLD, 20);
			}
			
			
			//그 내부 패널들의 각 요소들에 적용
			Component[] comps = ((Container) panels[i]).getComponents();
			for (Component comp : comps) {
				System.out.println(comp.getY() + " , " + comp.getClass().toString());
				
				//디지털 시계 폰트 변경 방지
				if (panels[i].getClass().getName().equals("mainPackage.SecondScreen") 
						&& comp.getY() == 10
						&& comp.getX() == 0) {
					//디지털 시계 폰트 변경 방지
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
				
				//기본 세팅값으로 설정
				else {
					comp.setFont(font);
					this.validate();
					this.repaint();
				}

			}
			
			//폰트 기본 세팅값으로 초기화
			font = new Font(MainGUI.font, Font.BOLD, 24);
		}
	}

	// 프레임용
	void setFont(String opt, JFrame c) {
		MainGUI.font = opt;
		Font font = new Font(MainGUI.font, Font.BOLD, 24);

		
		// 스케쥴러일경우 폰트 크기 설정
		if (c.getClass().getName().equals("mainPackage.MemoScheduler")) {
			font = new Font(MainGUI.font, Font.BOLD, 14);
		}

		// 메모장일경우 폰트 크기 설정
		if (c.getClass().getName().equals("mainPackage.Memo")) {
			font = new Font(MainGUI.font, Font.BOLD, 12);
		}

		Component[] comps = ((Container) c.getContentPane()).getComponents();
		for (int i = 0; i < comps.length; i++) {
			Component[] panels = ((Container) comps[i]).getComponents();
			for (Component panel : panels) {
				System.out.println(panel.getY() + " , " + panel.getClass().toString());
				
				//메모장 맨위 제목부분만 특수 설정
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
