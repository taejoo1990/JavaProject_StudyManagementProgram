package mainPackage;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Setting1 extends JPanel implements I_Setting{
	
	//���� �г� ����Ʈ �ɼ� : �ڷΰ���, Ÿ��Ʋ   
	private JLabel lb_back = new JLabel();
	private JLabel lb_title = new JLabel();
	
	//���� ���α��� ������ - ���� 
	private JLabel lb_mainIcon1 = new JLabel();
	private JLabel lb_mainIcon2 = new JLabel();
	private JLabel lb_mainIcon3 = new JLabel();
	
	//���� ���α��� �ؽ�Ʈ 
	private JLabel lb_main1_txt = new JLabel();
	private JLabel lb_main2_txt = new JLabel();
	private JLabel lb_main3_txt = new JLabel();
	private JLabel lb_main4_txt = new JLabel();
	private JLabel lb_main5_txt = new JLabel();
	
	//���� ���� â ���� Ŭ����ư 
	private JLabel lb_clickBtn1 = new JLabel();
	private JLabel lb_clickBtn2 = new JLabel();
	private JLabel lb_clickBtn3 = new JLabel();

	//���� ���οɼ� �����ϴ� üũ�ڽ� 
	private JLabel lb_checkBox1 = new JLabel();
	private JLabel lb_checkBox2 = new JLabel();
	private JLabel lb_checkBox3 = new JLabel();
	private JLabel lb_checkBox4 = new JLabel();
	private JLabel lb_checkBox5 = new JLabel();
	
	//������
	private JLabel lb_hr1 = new JLabel();
	private JLabel lb_hr2 = new JLabel();
	private JLabel lb_hr3 = new JLabel();
	private JLabel lb_hr4 = new JLabel();
	private JLabel lb_hr5 = new JLabel();
	
	//�ΰ� 
	private JLabel lb_logo = new JLabel();
	
	//��׶��� ���� �̹���
	protected JLabel lb_subBg = new JLabel(); 
//	{
//		public void paintComponent(Graphics g) {
//			g.drawImage(lc_subBg.getImage(), 300, 106, 390, 454, null)
//		}
//	};
	
	//�г� ���� �� ����Ʈ �ɼ� ����. Create Panel w/ default options
	protected void setPanel(String title) {
		//back button 
		lb_back.setIcon(back);
		lb_back.setBounds(topX,topY,topIconSize,topIconSize);
		//title
		lb_title.setText(title);
		lb_title.setBounds(titleX,titleY, titleW, topIconSize);
		lb_title.setFont(fontStyle);
		//add on Panel
		add(lb_back);
		add(lb_title);
		//background color
		setBackground(color);
		//panel's layout, visibility, size, location
		setLayout(null);
		setVisible(false);
		setSize(panelW, panelH);
		setLocation(0, 0); 
	}
	//���� ������ ���� �� �ٿ ���� 
	protected void set_mainIcon(ImageIcon lc1, ImageIcon lc2, ImageIcon lc3) {
		lb_mainIcon1.setIcon(lc1);
		lb_mainIcon2.setIcon(lc2);
		lb_mainIcon3.setIcon(lc3);
		lb_mainIcon1.setBounds(mainIconX, mainIconY, mainIconSize, mainIconSize);
		lb_mainIcon2.setBounds(mainIconX, mainIconY +100, mainIconSize, mainIconSize);
		lb_mainIcon3.setBounds(mainIconX, mainIconY +200, mainIconSize, mainIconSize);
	}
	//���α��� �ؽ�Ʈ �� ����  
	protected void setLabelText(String s1, String s2, String s3, String s4, String s5) {
		lb_main1_txt.setText(s1);
		lb_main2_txt.setText(s2);
		lb_main3_txt.setText(s3);
		lb_main4_txt.setText(s4);
		lb_main5_txt.setText(s5);
	}
	//�ؽ�Ʈ �ٿ�� 1) set main page bound
	protected void setBound_mainTxt() { 
		lb_main1_txt.setBounds(mainTextX,mainTextY,mainW,mainH);
		lb_main2_txt.setBounds(mainTextX,mainTextY +100,mainW,mainH);
		lb_main3_txt.setBounds(mainTextX,mainTextY +200,mainW,mainH);
		lb_main4_txt.setBounds(mainTextX,mainTextY +300,mainW,mainH);
		lb_main5_txt.setBounds(mainTextX,mainTextY +400,mainW,mainH);
	}
	//�ؽ�Ʈ �ٿ�� 2) set sub pages bound
	protected void setBound_subTxt() {
		lb_main1_txt.setBounds(subTextX, subTextY, subW, subH);
		lb_main2_txt.setBounds(subTextX, subTextY +70, subW, subH);
		lb_main3_txt.setBounds(subTextX, subTextY +140, subW, subH);
		lb_main4_txt.setBounds(subTextX, subTextY +210, subW, subH);
		lb_main5_txt.setBounds(subTextX, subTextY +280, subW, subH);
	}
	//�ؽ�Ʈ ��Ʈ ���� 
	protected void setFontToMainTxt() {
		lb_main1_txt.setFont(fontStyle);
		lb_main2_txt.setFont(fontStyle);
		lb_main3_txt.setFont(fontStyle);
		lb_main4_txt.setFont(fontStyle);
		lb_main5_txt.setFont(fontStyle);
	}
	//Ŭ����ư ������ ���� �� �ٿ�� 
	protected void set_clickButton(ImageIcon lc1, ImageIcon lc2, ImageIcon lc3) {
		lb_clickBtn1.setIcon(lc1);
		lb_clickBtn2.setIcon(lc2);
		lb_clickBtn3.setIcon(lc3);
		lb_clickBtn1.setBounds(clickBtnX, clickBtnY, clickBtnW, clickBtnH);
		lb_clickBtn2.setBounds(clickBtnX, clickBtnY +100, clickBtnW, clickBtnH);
		lb_clickBtn3.setBounds(clickBtnX, clickBtnY +200, clickBtnW, clickBtnH);
	}
	//üũ�ڽ� ������ ���� �� �ٿ�� 
	protected void set_checkBox(ImageIcon lc1, ImageIcon lc2, ImageIcon lc3, ImageIcon lc4, ImageIcon lc5) {
		lb_checkBox1.setIcon(lc1);
		lb_checkBox2.setIcon(lc2);
		lb_checkBox3.setIcon(lc3);
		lb_checkBox4.setIcon(lc4);
		lb_checkBox5.setIcon(lc5);
		lb_checkBox1.setBounds(checkBtnX, checkBtnY, checkBtnW, checkBtnW);
		lb_checkBox2.setBounds(checkBtnX, checkBtnY+70, checkBtnW, checkBtnH);
		lb_checkBox3.setBounds(checkBtnX, checkBtnY+140, checkBtnW, checkBtnH);
		lb_checkBox4.setBounds(checkBtnX, checkBtnY+210, checkBtnW, checkBtnH);
		lb_checkBox5.setBounds(checkBtnX, checkBtnY+280, checkBtnW, checkBtnH);
	}
	
	//������ ����
	protected void set_mainHr(ImageIcon hr1, ImageIcon hr2, ImageIcon hr3, ImageIcon hr4) {
		lb_hr1.setIcon(hr1);
		lb_hr2.setIcon(hr2);
		lb_hr3.setIcon(hr3);
		lb_hr4.setIcon(hr4);
		lb_hr1.setBounds(hrX, hrY, hrW, hrH);
		lb_hr2.setBounds(hrX, hrY+100, hrW, hrH);
		lb_hr3.setBounds(hrX, hrY+200, hrW, hrH);
		lb_hr4.setBounds(hrX, hrY+300, hrW, hrH);
		add(lb_hr1);
		add(lb_hr2);
		add(lb_hr3);
		add(lb_hr4);
	}
	
	protected void set_subHr(ImageIcon hr1, ImageIcon hr2, ImageIcon hr3, ImageIcon hr4, ImageIcon hr5) {
		lb_hr1.setIcon(hr1);
		lb_hr2.setIcon(hr2);
		lb_hr3.setIcon(hr3);
		lb_hr4.setIcon(hr4);
		lb_hr5.setIcon(hr5);
		lb_hr1.setBounds(hrX_sub, hrY_sub, hrW_sub, hrH_sub);
		lb_hr2.setBounds(hrX_sub, hrY_sub+70, hrW_sub, hrH_sub);
		lb_hr3.setBounds(hrX_sub, hrY_sub+140, hrW_sub, hrH_sub);
		lb_hr4.setBounds(hrX_sub, hrY_sub+210, hrW_sub, hrH_sub);
		lb_hr5.setBounds(hrX_sub, hrY_sub+280, hrW_sub, hrH_sub);
		add(lb_hr1);
		add(lb_hr2);
		add(lb_hr3);
		add(lb_hr4);
		add(lb_hr5);
	}
	
	//�ΰ�
	protected void set_logo(ImageIcon logo) {
		lb_logo.setIcon(logo);
		lb_logo.setBounds(135, 580, 130, 60);
		add(lb_logo);
	}
	
	//���������� ��׶��� ���� �̹���
	protected void set_subBg(ImageIcon subBg) {
		lb_subBg.setIcon(lc_subBg);
		lb_subBg.setBounds(subBgX, subBgY, subBgW, subBgH);
//		add(lb_subBg);
	}
	
	//�гο� �ø��� : ���ξ����� 
	protected void addOnPanel_mainIcon() {
		add(lb_mainIcon1);
		add(lb_mainIcon2);
		add(lb_mainIcon3);
	}
	//�гο� �ø��� : �����ؽ�Ʈ 
	protected void addOnPanel_mainTxt() {
		add(lb_main1_txt);
		add(lb_main2_txt);
		add(lb_main3_txt);
		add(lb_main4_txt);
		add(lb_main5_txt);
	}
	//�гο� �ø��� : ���� Ŭ����ư 
	protected void addOnPanel_clickBtn() {
		add(lb_clickBtn1);
		add(lb_clickBtn2);
		add(lb_clickBtn3);
		
	}
	//�гο� �ø��� : �ɼ� ������ư   
	protected void addOnPanel_checkBox() {
		add(lb_checkBox1);
		add(lb_checkBox2);
		add(lb_checkBox3);
		add(lb_checkBox4);
		add(lb_checkBox5);
	}
	//���� ���� 
	public void setColor(Color c) {
		setBackground(c);
	}
	//���콺 ���ٴ�� ������ ���� ���� : �ڷΰ��� ������  
	protected void hover_backIcon(ImageIcon b) {
		lb_back.setIcon(b);
	}
	//���콺 ���ٴ�� ������ ���� ���� : ���� ������ 
	protected void hover_clickBtnIcon(ImageIcon i, String s) {
		if (i.equals(lc_clickBtn1)) {
			if(s.equals("on")) {
				lb_clickBtn1.setIcon(lc_clickBtnOn);				
			} else if (s.equals("off")) {
				lb_clickBtn1.setIcon(lc_clickBtn1);
			}
		}
		if (i.equals(lc_clickBtn2)) {
			if (s.equals("on")) {
				lb_clickBtn2.setIcon(lc_clickBtnOn);
			} else if (s.equals("off")){
				lb_clickBtn2.setIcon(lc_clickBtn2);
			}
		}
		if (i.equals(lc_clickBtn3)) {
			if(s.equals("on")) {
				lb_clickBtn3.setIcon(lc_clickBtnOn);
			} else if (s.equals("off")){
				lb_clickBtn3.setIcon(lc_clickBtn3);
			}
		}
	}
	
	//��ü ������ ���� ����Ʈ ������ �ǵ����� 
	protected void clickBtnOff() {
		hover_backIcon(back);
		lb_clickBtn1.setIcon(lc_clickBtn1);
		lb_clickBtn2.setIcon(lc_clickBtn2);
		lb_clickBtn3.setIcon(lc_clickBtn3);
	}
	
	//üũ�ڽ� ���� ���� 
	protected void checkBoxState(int num) {
		try {
		//������ �� ���� ������ 
		JLabel clicked = null;
		//������ �� Ȯ�� �� �����濡 �ֱ� 
		switch (num) {
		case 1:
			clicked =lb_checkBox1;
			break;
		case 2:
			clicked =lb_checkBox2;
			break;
		case 3:
			clicked =lb_checkBox3;
			break;
		case 4:
			clicked =lb_checkBox4;
			break;
		case 5:
			clicked =lb_checkBox5;
			break;
		}
		// ������� ��ġ�ϴ� �� Ȯ�� �� ���º��� 
		if (clicked.equals(lb_checkBox1) ) {
			System.out.println("button 1");
			lb_checkBox1.setIcon(new ImageIcon(on));
			lb_checkBox2.setIcon(new ImageIcon(off));
			lb_checkBox3.setIcon(new ImageIcon(off));
			lb_checkBox4.setIcon(new ImageIcon(off));
			lb_checkBox5.setIcon(new ImageIcon(off));
		} else if (clicked.equals(lb_checkBox2)) {
			System.out.println("button 2");
			lb_checkBox1.setIcon(new ImageIcon(off));
			lb_checkBox2.setIcon(new ImageIcon(on));
			lb_checkBox3.setIcon(new ImageIcon(off));
			lb_checkBox4.setIcon(new ImageIcon(off));
			lb_checkBox5.setIcon(new ImageIcon(off));
		} 
		else if (clicked.equals(lb_checkBox3)) {
			System.out.println("button 3");
			lb_checkBox1.setIcon(new ImageIcon(off));
			lb_checkBox2.setIcon(new ImageIcon(off));
			lb_checkBox3.setIcon(new ImageIcon(on));
			lb_checkBox4.setIcon(new ImageIcon(off));
			lb_checkBox5.setIcon(new ImageIcon(off));
		}
		else if (clicked.equals(lb_checkBox4)) {
			System.out.println("button 4");
			lb_checkBox1.setIcon(new ImageIcon(off));
			lb_checkBox2.setIcon(new ImageIcon(off));
			lb_checkBox3.setIcon(new ImageIcon(off));
			lb_checkBox4.setIcon(new ImageIcon(on));
			lb_checkBox5.setIcon(new ImageIcon(off));
		}
		else if (clicked.equals(lb_checkBox5)) {
			System.out.println("button 5");
			lb_checkBox1.setIcon(new ImageIcon(off));
			lb_checkBox2.setIcon(new ImageIcon(off));
			lb_checkBox3.setIcon(new ImageIcon(off));
			lb_checkBox4.setIcon(new ImageIcon(off));
			lb_checkBox5.setIcon(new ImageIcon(on));
		}
		
		} catch (NullPointerException e) {
			System.out.println("������ ���� ");
		}
	}
}
