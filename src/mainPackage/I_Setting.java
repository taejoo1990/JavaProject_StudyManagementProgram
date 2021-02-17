package mainPackage;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public  interface I_Setting {
	
	//top label
	ImageIcon back = new ImageIcon("src/mainPackage/res/Icon_back.png");
	ImageIcon back_on = new ImageIcon("src/mainPackage/res/Icon_back_on.png");
	ImageIcon save = new ImageIcon("src/mainPackage/res/Icon_save.png");
	
	//Main Icon
	ImageIcon lc_mainIcon1 = new ImageIcon("src/mainPackage/res/Icon_alram.png");
	ImageIcon lc_mainIcon2 = new ImageIcon("src/mainPackage/res/Icon_color.png");
	ImageIcon lc_mainIcon3 = new ImageIcon("src/mainPackage/res/Icon_font.png");
	
	//Main Click Button
	String clickIconImg = "src/mainPackage/res/Icon_main_into.png";
	String clickIconImg_on = "src/mainPackage/res/Icon_main_into_on.png";
	ImageIcon lc_clickBtn1 = new ImageIcon(clickIconImg);
	ImageIcon lc_clickBtn2 = new ImageIcon(clickIconImg);
	ImageIcon lc_clickBtn3 = new ImageIcon(clickIconImg);
	ImageIcon lc_clickBtnOn = new ImageIcon(clickIconImg_on);
	
	//checkBox
	String on = "src/mainPackage/res/Icon_on.png";
	String off = "src/mainPackage/res/Icon_off.png";
	ImageIcon lc_checkBox1 = new ImageIcon(on);
	ImageIcon lc_checkBox2 = new ImageIcon(off);
	ImageIcon lc_checkBox3 = new ImageIcon(off);
	ImageIcon lc_checkBox4 = new ImageIcon(off);
	ImageIcon lc_checkBox5 = new ImageIcon(off);
	
	//horizontal line
	String hr = "src/mainPackage/res/Icon_hr.png";
	ImageIcon hr1 = new ImageIcon(hr);
	ImageIcon hr2 = new ImageIcon(hr);
	ImageIcon hr3 = new ImageIcon(hr);
	ImageIcon hr4 = new ImageIcon(hr);
	ImageIcon hr5 = new ImageIcon(hr);
	
	//logo
	String logo = "src/mainPackage/res/Icon_logo_150x70.png";
	ImageIcon lc_logo = new ImageIcon(logo);
	
	//subpage background 
	String subBg = "src/mainPackage/res/Icon_SubBg.png";
	ImageIcon lc_subBg = new ImageIcon(subBg);
	
	//Panel Size
	int panelW=400;
	int panelH=700;
	
	//==== Label Position ====
	
	// back button
	int topX =20;
	int topY =30;
	int topIconSize = 60;  
	
	// save button
	int saveX = 150;
	int saveY = 520;
	int saveW=150;
	int saveH=45;
	
	// title 
	int titleX=80;
	int titleY=30;
	int titleW=150;
	int titleH=40;
	
	// main Icon - left 
	int mainIconX = 50;
	int mainIconY = 245;
	int mainIconSize =40;
	
	// main text - center (setting main page)
	int mainTextX = 125;
	int mainTextY = 250;
	int mainW=200;
	int mainH=40;
	
	// sub text - center (setting sub pages)
	int subTextX = 80;
	int subTextY = 150;
	int subW=150;
	int subH=40;
	
	// click button -right (move into sub setting panels) 
	int clickBtnX = 335;
	int clickBtnY = 250;
	int clickBtnW = 30;
	int clickBtnH =30;
	
	// checkBox  -right (option set button)
	int checkBtnX = 265;
	int checkBtnY = 135;
	int checkBtnW = 70;
	int checkBtnH =70;
	
	// hr main
	int hrX = 0;
	int hrY = 210;
	int hrW = 400;
	int hrH = 2;

	// hr sub
	int hrX_sub = 30;
	int hrY_sub = 205;
	int hrW_sub = 340;
	int hrH_sub = 2;
	
	//sub round bg img
	int subBgX =30;
	int subBgY =106;
	int subBgW =240;
	int subBgH =454;
	
	//Background color : default 
	//static Color color = Color.green;
	static Color color = Color.white;
	
	//Font : default
	static Font fontStyle = new Font(MainGUI.font,Font.BOLD,30);
	
//	void setColor(Color c);
	
}
