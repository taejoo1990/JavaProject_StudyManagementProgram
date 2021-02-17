package mainPackage;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SettingSound extends Setting1 {
	MainGUI mGUI;

	//����� �ɼ�
	private Clip clip;
	private String op1 = "src/mainPackage/res/Analog_Watch.wav";
	private String op2 = "src/mainPackage/res/DoorBell.wav";
	private String op3 = "src/mainPackage/res/airhorn.wav";
	private String op4 = "src/mainPackage/res/nooo.wav";
	private String op5 = "src/mainPackage/res/smb_stage_clear.wav"; 
	private int num ;
	
	//������
	public SettingSound(MainGUI mGUI){
		this.mGUI = mGUI;
		
		//���콺 ���ٴ�� ������ ���� ����.(on= red / off= default) 
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
		
		//���콺 Ŭ���ϸ� ȭ����ȯ Ȥ�� ����� ����. sound changed
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseMoved(e);
				//�ڷΰ���: �����г�
				if (e.getX() > topX && e.getX() < topX+topIconSize && e.getY() > topY && e.getY() < topY+topIconSize) {// �����ϱ� �̹���
					SettingSound.this.setVisible(false);
					mGUI.settingScreen.setVisible(true);
					
					hover_backIcon(back);
					//������ ������� ������� ������ ����. 
					stop();
				}
				if (e.getX() > checkBtnX && e.getX() < checkBtnX+checkBtnW && e.getY() > checkBtnY && e.getY() < checkBtnY+checkBtnH) {
					//������ ������� ������� ������ ����.
					stop();
					//������ ����� ���
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
				//üũ�ڽ� �̹��� ���� ���� 
				checkBoxState(num);

			}
		});
		
		//�гλ��� (with �⺻ �ɼ�).
		setPanel("Sounds");
		set_subHr(hr1, hr2, hr3, hr4, hr5);
//		set_subBg(lc_subBg); //������ �Ф� 
//		this.add(lb_subBg); //������ �Ф� 
		set_logo(lc_logo);
		
		//�ؽ�Ʈ �� ���� & �ٿ�� ����.
		setLabelText("Analog Watch", "Door Bell", "Airhorn", "Nooooooooo", "Stage Clear");
		setBound_subTxt( );
		setFontToMainTxt();
		
		//üũ�ڽ�(��) ���� & �ٿ�� ����.
		set_checkBox(lc_checkBox1, lc_checkBox2, lc_checkBox3, lc_checkBox4, lc_checkBox5); 
		
		//�󺧵� �гο� �ø���.
		addOnPanel_mainTxt();
		addOnPanel_checkBox();

	}
	
	//����� ��� �޼ҵ�  
	public void play(String opt)
    {	
        try
        {
    		AudioInputStream ais = AudioSystem.getAudioInputStream(new File(opt));
            clip = AudioSystem.getClip();
            System.out.println("�Ҹ��۵�");
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception e){
        	System.out.println(e.getMessage());
        	System.out.println("Error : �Ҹ� �� �ҷ���");
        	e.getStackTrace();
        }
    }
	//����� ���� �޼ҵ� 
	public void stop() {
		try{
			clip.stop();
		}catch(Exception error) {
			error.getMessage();
		}
	}
	
}
