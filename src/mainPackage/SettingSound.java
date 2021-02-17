package mainPackage;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SettingSound extends Setting1 {
	MainGUI mGUI;

	//배경음 옵션
	private Clip clip;
	private String op1 = "src/mainPackage/res/Analog_Watch.wav";
	private String op2 = "src/mainPackage/res/DoorBell.wav";
	private String op3 = "src/mainPackage/res/airhorn.wav";
	private String op4 = "src/mainPackage/res/nooo.wav";
	private String op5 = "src/mainPackage/res/smb_stage_clear.wav"; 
	private int num ;
	
	//생성자
	public SettingSound(MainGUI mGUI){
		this.mGUI = mGUI;
		
		//마우스 갖다대면 아이콘 색상 변경.(on= red / off= default) 
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (e.getX() > topX && e.getX() < topX+topIconSize && e.getY() > topY && e.getY() < topY+topIconSize) {
					hover_backIcon(back_on);
				} else {
					hover_backIcon(back);
				}
			}
		});
		
		//마우스 클릭하면 화면전환 혹은 배경음 설정. sound changed
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				//뒤로가기: 셋팅패널
				if (e.getX() > topX && e.getX() < topX+topIconSize && e.getY() > topY && e.getY() < topY+topIconSize) {// 시작하기 이미지
					SettingSound.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					
					hover_backIcon(back);
					//기존에 재생중인 배경음이 있으면 멈춤. 
					stop();
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY && e.getY() < checkBtnY+checkBtnH) {
					//기존에 재생중인 배경음이 있으면 멈춤.
					stop();
					//선택한 배경음 재생
					mGUI.as.setAlramSound(op1);
					play(op1);
					num=1;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY +70 && e.getY() < checkBtnY+70+checkBtnH) {
					stop();
					mGUI.as.setAlramSound(op2);
					play(op2);
					num=2;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY +140 && e.getY() < checkBtnY+140+checkBtnH) {
					stop();
					mGUI.as.setAlramSound(op3);
					play(op3);
					num=3;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY +210 && e.getY() < checkBtnY+210+checkBtnH) {
					stop();
					mGUI.as.setAlramSound(op4);
					play(op4);
					num=4;
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY +280 && e.getY() < checkBtnY+280+checkBtnH) {
					stop();
					mGUI.as.setAlramSound(op5);
					play(op5);
					num=5;
				}
				//체크박스 이미지 상태 변경 
				checkBoxState(num);

			}
		});
		
		//패널생성 (with 기본 옵션).
		setPanel("Sounds");
		set_subHr(hr1, hr2, hr3, hr4, hr5);
//		set_subBg(lc_subBg); //가려짐 ㅠㅠ 
//		this.add(lb_subBg); //가려짐 ㅠㅠ 
		set_logo(lc_logo);
		
		//텍스트 라벨 생성 & 바운드 설정.
		setLabelText("Analog Watch", "Door Bell", "Airhorn", "Nooooooooo", "Stage Clear");
		setBound_subTxt( );
		setFontToMainTxt();
		
		//체크박스(라벨) 생성 & 바운드 설정.
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5); 
		
		//라벨들 패널에 올리기.
		addOnPanel_mainTxt();
		addOnPanel_checkBox();

	}
	
	//배경음 재생 메소드  
	public void play(String opt)
    {	
        try
        {
    		AudioInputStream ais = AudioSystem.getAudioInputStream(new File(opt));
            clip = AudioSystem.getClip();
            System.out.println("소리작동");
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
        	System.out.println("Error : 소리 못 불러옴");
        	e.getStackTrace();
        }
    }
	//배경음 멈춤 메소드 
	public void stop() {
		try{
			clip.stop();
		}catch(Exception error) {
			error.getMessage();
		}
	}
	
}
