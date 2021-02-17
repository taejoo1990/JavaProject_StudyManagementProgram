package mainPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingScreen extends Setting1{
	MainGUI mGUI;
	
	//������. Constructor
	public SettingScreen(MainGUI mGUI){

		this.mGUI = mGUI;
		
		//���콺 ���ٴ�� ������ ���� ����. if mouse hovered over icons : icon color will be changed (on= red / off= default) 
		addMouseMotionListener(new MouseAdapter() { //�͸��� Ŭ�� 
			@Override
			public void mouseMoved(MouseEvent e) {
				if (e.getX() > topX && e.getX() < topX+topIconSize && e.getY() > topY && e.getY() < topY+topIconSize) {
					hover_backIcon(back_on);
				} else {
					hover_backIcon(back);
				}
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY && e.getY() < clickBtnY+clickBtnH) {
					hover_clickBtnIcon(lc_clickBtn1, "on");
				} else {
					hover_clickBtnIcon(lc_clickBtn1, "off");
				}
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY +100 && e.getY() < clickBtnY+100+clickBtnH) {
					hover_clickBtnIcon(lc_clickBtn2, "on");
				} else {
					hover_clickBtnIcon(lc_clickBtn2, "off");
				}
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY +200 && e.getY() < clickBtnY+200+clickBtnH) {
					hover_clickBtnIcon(lc_clickBtn3, "on");
				} else {
					hover_clickBtnIcon(lc_clickBtn3, "off");
				}
			}
		});
		
		//���콺 Ŭ���ϸ� ȭ����ȯ. if mouse pressed icons : Screen(panels) will be changed 
		addMouseListener(new MouseAdapter() { //�͸��� Ŭ�� 
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				
				//Move to SecondScreen
				if (e.getX() > topX && e.getX() < topX+topIconSize && e.getY() > topY && e.getY() < topY+topIconSize) {
					SettingScreen.this.setVisible(false);
					mGUI.secondScreen.setVisible(true);
					mGUI.setSize(400,700);
				}
				//Move to SettingSound
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY && e.getY() < clickBtnY+clickBtnH) {
					SettingScreen.this.setVisible(false);
					mGUI.settingSound.setVisible(true);
				}
				//Move to SettingColor
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY +100 && e.getY() < clickBtnY+100+clickBtnH) {
					SettingScreen.this.setVisible(false);
					mGUI.settingColor.setVisible(true);
				}
				//Move to SettingFont
				if (e.getX() > clickBtnX && e.getX() < clickBtnX+clickBtnW && e.getY() > clickBtnY +200 && e.getY() < clickBtnY+200+clickBtnH) {
					SettingScreen.this.setVisible(false);
					mGUI.settingFont.setVisible(true);
				}
				//Ŭ����ư �̹��� ���� ���� 
				clickBtnOff();
			}
		});
		
		//�гλ��� (with �⺻ �ɼ�). Create Panel w/ default options
		setPanel("Settings");
		set_mainHr(hr1, hr2, hr3, hr4);
		set_logo(lc_logo);
		//���� ������ ���� �� �ٿ�� ����. Create mainIcons into mainLabels and set label bounds
		set_mainIcon(lc_mainIcon1, lc_mainIcon2, lc_mainIcon3);
		
		//�ؽ�Ʈ �� ���� & �ٿ�� ����. Create text labels, set mainTxt bounds
		setLabelText("Alram", "BG Color", "Font", null, null);
		setBound_mainTxt();
		setFontToMainTxt();
		
		//üũ�ڽ�(��) ���� & �ٿ�� ����. Create clickButton(label), set bounds
		set_clickButton(lc_clickBtn1, lc_clickBtn2, lc_clickBtn3);
		
		//�󺧵� �гο� �ø���. Add labels on Panel
		addOnPanel_mainIcon();
		addOnPanel_mainTxt();
		addOnPanel_clickBtn();
	}
}
