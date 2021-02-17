package mainPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainGUI extends JFrame {
	 
	FirstMainScreen firstMainScreen;
	
	public SecondScreen secondScreen;
	AlramScreen as;
	MemoScheduler msd;
	Memo mm;
	
	SettingScreen settingScreen;
	SettingSound settingSound;
	SettingColor settingColor;
	SettingFont settingFont;
	
	
	static String font = "Serif";
	static Color color = Color.WHITE;
	
	
	
	
	public MainGUI() {
		super("솔데스크 학습도우미");
		Thread realtimeCheck=new Thread(new realtimeCheck());
		realtimeCheck.start();
		
		
		//첫 시작시 폰트설정
		try {
		    GraphicsEnvironment ge = 
		    GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ds_digital/DS-DIGIT.TTF")));
		} catch (IOException|FontFormatException e) {

		}
		
		
		firstMainScreen=new FirstMainScreen(this);
		secondScreen=new SecondScreen(this);
		as = new AlramScreen(this);
		
		
		
		settingScreen = new SettingScreen(this);
		settingSound = new SettingSound(this);
		settingColor = new SettingColor(this);
		settingFont = new SettingFont(this);
		
		//font 
		settingFont.setFont(font);
		settingColor.setBackgroundColor(new Color(255,128,0));
//		settingColor.setBackgroundColor(Color.LIGHT_GRAY);
		
		add(firstMainScreen);
		add(secondScreen);
		
		//설정 프레임 
		add(settingScreen);
		add(settingSound);
		add(settingColor);
		add(settingFont);
				
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if(e.getKeyCode()==KeyEvent.VK_UP) {

				}
			}
		});
		
		
		
		

		add(as);
		add(secondScreen);
		add(firstMainScreen);
		add(settingScreen);
		//add(clt);
		//clt.setBounds(0, 0, 400, 700);
		setSize(400, 700);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		
		
	}	
	
	public static void perfectButton(JButton btn, ImageIcon stateIcon, ImageIcon overIcon) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setOpaque(false);
		btn.setBorder(null);
		btn.setIcon(stateIcon);
		btn.setRolloverIcon(overIcon);
		btn.setPressedIcon(overIcon);
		btn.setFocusPainted(false);	
	}
}
