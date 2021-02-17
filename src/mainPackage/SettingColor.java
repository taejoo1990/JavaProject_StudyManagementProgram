package mainPackage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingColor extends Setting1 {
	MainGUI mGUI;

	// 컬러옵션
	
	private Color op1 = new Color(255,128,0);
	private Color op2 = Color.LIGHT_GRAY;
	private Color op3 = Color.white;
	private Color op4 = Color.yellow;
	private Color op5 = Color.green;
	private int num;

	// 생성자
	public SettingColor(MainGUI mGUI) {
		this.mGUI = mGUI;

		// 마우스 갖다대면 아이콘 색상 변경. (on= red / off= default)
		addMouseMotionListener(new MouseAdapter() { // 익명의 클라스
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

		// 마우스 클릭하면 화면전환 혹은 배경색 설정. background color changed
		addMouseListener(new MouseAdapter() { // 익명의 클라스
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				// 뒤로가기: 셋팅패널. Move to SettingScreen
				if (e.getX() > topX && e.getX() < topX + topIconSize && e.getY() > topY
						&& e.getY() < topY + topIconSize) {
					SettingColor.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					hover_backIcon(back);
				}
				// 배경색 설정. set new background color.
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
				// 체크박스 이미지 상태 변경
				checkBoxState(num);

			}
		});

		// 패널생성 (with 기본 옵션)
		setPanel("Colors");
//		set_subBg(lc_subBg); //가려짐 ㅠㅠ 
//		this.add(lb_subBg); //가려짐 ㅠㅠ 
		set_subHr(hr1, hr2, hr3, hr4, hr5);
		set_logo(lc_logo);

		// 텍스트 라벨 생성 & 바운드 설정
		setLabelText("Default", "Gray", "White", "Yellow", "Green");
		setBound_subTxt();
		setFontToMainTxt();

		// 체크박스(라벨) 생성 & 바운드 설정
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5);

		// 라벨들 패널에 올리기. Add labels on Panel
		addOnPanel_mainTxt();
		addOnPanel_checkBox();
	}

	// 배경색 설정 메소드
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
//			System.out.println("배경화면 색상변경 오류");
		}
	}

	// 스케줄러, 메모 프레임용
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
