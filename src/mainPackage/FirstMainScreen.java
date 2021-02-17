package mainPackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstMainScreen extends JPanel {

	MainGUI mGUI;
	JPanel panel1 = new JPanel();
	ImageIcon backGround = new ImageIcon("image/startIcon/main_bgImg.png");
	ImageIcon logo = new ImageIcon("image/startIcon/logo.png");
	ImageIcon logo1 = new ImageIcon("image/startIcon/Icon_logo1.png");
	ImageIcon start_off = new ImageIcon("image/startIcon/startBtn.png");
	ImageIcon start_on = new ImageIcon("image/startIcon/startBtn_on.png");
	ImageIcon exit_off = new ImageIcon("image/startIcon/exitBtn.png");
	ImageIcon exit_on = new ImageIcon("image/startIcon/exitBtn_on.png");

	JLabel logoLabel = new JLabel();
	JLabel logoLabel1 = new JLabel();
	JButton startBtn = new JButton();
	JButton exitBtn = new JButton();

	public FirstMainScreen(MainGUI mGUI) {
		this.mGUI = mGUI;

//		// 로고
		logoLabel.setIcon(logo);
		logoLabel.setBounds(83, 126, 233, 143);
		
//		// devs 로고 
		logoLabel1.setIcon(logo1);
		logoLabel1.setBounds(148, 607, 118, 71);

		//시작하기 버튼
		MainGUI.perfectButton(startBtn, start_off, start_on);
		startBtn.setBounds(91, 355, 232, 61);
		//종료하기버튼
		MainGUI.perfectButton(exitBtn, exit_off, exit_on);
		exitBtn.setBounds(91, 410, 232, 71);
		
		//버튼 기능 추가
		ActionListener firstAl = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());

	
				if (e.getSource() == startBtn) {
					FirstMainScreen.this.setVisible(false);
					mGUI.secondScreen.setVisible(true);
					
					
				} else if (e.getSource() == exitBtn) {
					System.exit(0);
				}


			}
		};
		
		//버튼에 기능 추가2
		startBtn.addActionListener(firstAl);
		exitBtn.addActionListener(firstAl);
		startBtn.setFocusable(false);
		exitBtn.setFocusable(false);
		
		add(exitBtn);
		add(startBtn);
		add(logoLabel);
		add(logoLabel1);

		
		setLayout(null);
		setBounds(0, 0, 1280, 700);
		setVisible(true);

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(backGround.getImage(),0,0,this);

	}

}
