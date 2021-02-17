package mainPackage;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SecondScreen extends JPanel {

	MainGUI mGUI;
	
	// 배경
	public ImageIcon backGroundImg = new ImageIcon("image/backGround.png");

	// 디지털시계
	JLabel curTime = new JLabel();
	JPanel hi = new JPanel();
	
	//시계클릭시 QR 버튼
	JButton clockQR = new JButton();
	

	// 하단 패널 아이콘
	ImageIcon alramIcon_off = new ImageIcon("image/alramIcon_off.png");
	ImageIcon alramIcon_on = new ImageIcon("image/alramIcon_on.png");
	JButton alramIcon = new JButton();
	
	ImageIcon calendarIcon_off = new ImageIcon("image/calendarIcon_off.png");
	ImageIcon calendarIcon_on = new ImageIcon("image/calendarIcon_on.png");
	JButton calendarIcon = new JButton();
	
	ImageIcon returnIcon_off = new ImageIcon("image/returnIcon_off.png");
	ImageIcon returnIcon_on = new ImageIcon("image/returnIcon_on.png");
	JButton returnIcon = new JButton();
	
	ImageIcon memoIcon_off = new ImageIcon("image/memoIcon_off.png");
	ImageIcon memoIcon_on = new ImageIcon("image/memoIcon_on.png");
	JButton memoIcon = new JButton();
	
	ImageIcon exerciseIcon_off = new ImageIcon("image/exerciseIcon_off.png");
	ImageIcon exerciseIcon_on = new ImageIcon("image/exerciseIcon_on.png");
	JButton exerciseIcon = new JButton();
	
	ImageIcon settingIcon_off = new ImageIcon("image/settingIcon_off.png");
	ImageIcon settingIcon_on = new ImageIcon("image/settingIcon_on.png");
	
	JButton settingIcon = new JButton();
	public JLabel qrInfo = new JLabel();

	// 아날로그 시계
	double i = realtimeCheck.hour * 30 + 30 * realtimeCheck.minute / 60;
	double j = realtimeCheck.minute * 6 + 6 * realtimeCheck.second / 60;
	BufferedImage ii8;
	BufferedImage ii9;
	BufferedImage ii10;
	BufferedImage ii11;
	BufferedImage ii12;
	public Timer analogClock = new Timer(100, new ActionListener() {
		
		Calendar ci = Calendar.getInstance();
		
		public void actionPerformed(ActionEvent e) {
		
			i += realtimeCheck.hour * 30 + 30 * realtimeCheck.minute / 60;
			j += realtimeCheck.minute * 6 + 6 * realtimeCheck.second / 60;
			
			ii9 = rotate(ii8, i);
			ii11 = rotate(ii10, j);
			
			i=0;
			j=0;
			repaint();
		}
	});

	public SecondScreen(MainGUI mGUI) {

		this.mGUI = mGUI;
		
		
		// 버튼의 아주 완벽한 설정
		MainGUI.perfectButton(clockQR, null, null);
		MainGUI.perfectButton(alramIcon, alramIcon_off, alramIcon_on);
		MainGUI.perfectButton(memoIcon, memoIcon_off, memoIcon_on);
		MainGUI.perfectButton(returnIcon, returnIcon_off, returnIcon_on);
		MainGUI.perfectButton(calendarIcon, calendarIcon_off, calendarIcon_on);
		MainGUI.perfectButton(exerciseIcon, exerciseIcon_off, exerciseIcon_on);
		MainGUI.perfectButton(settingIcon, settingIcon_off, settingIcon_on);
		
		
		// 버튼 기능 추가1
		ActionListener secondAl = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == clockQR) {
					new qrDialog();
				}
				if (e.getSource() == alramIcon) {
					SecondScreen.this.setVisible(false);
					mGUI.as.setVisible(true);
				}
				if (e.getSource() == calendarIcon) {
					mGUI.msd=new MemoScheduler(mGUI);
					mGUI.settingFont.setFont(MainGUI.font, mGUI.msd);
		
					
				}
				
				if (e.getSource() == memoIcon) {
					mGUI.mm=new Memo();
					mGUI.settingFont.setFont(MainGUI.font, mGUI.mm);
				
					
				}
				if (e.getSource() == exerciseIcon) {
					new CardLayoutTest1();
					//mGUI.clt.setVisible(true);
				}
				if (e.getSource() == settingIcon) {
					SecondScreen.this.setVisible(false);
//					mGUI.setSize(450, 620);
					mGUI.settingScreen.setVisible(true);
				}
				if (e.getSource() == returnIcon) {
					SecondScreen.this.setVisible(false);
					mGUI.firstMainScreen.setVisible(true);
				}
			}
		};
		

		clockQR.addActionListener(secondAl);
		alramIcon.addActionListener(secondAl);
		calendarIcon.addActionListener(secondAl);
		returnIcon.addActionListener(secondAl);
		memoIcon.addActionListener(secondAl);
		exerciseIcon.addActionListener(secondAl);
		settingIcon.addActionListener(secondAl);
		
		clockQR.setBounds(50, 100, 300, 300);
		add(clockQR);
		
		// 디지털 시계 설정, 작동
		curTime.setHorizontalAlignment(JLabel.CENTER);
		curTime.setBounds(0, 10, 400, 100);
		curTime.setFont(new Font("DS-Digital", Font.BOLD, 35));
		add(curTime);
		Thread realtimeLabel = new Thread(new SecondRealtime(this,mGUI.as));
		realtimeLabel.start();

		// 아날로그 시계 이미지 불러오기
		try {
			ii8 = ImageIO.read(new File("image/clock_hour.png"));
			ii9 = rotate(ii8, i);
			ii10 = ImageIO.read(new File("image/12clock_minute.png"));
			ii11 = rotate(ii10, j);
			ii12 = ImageIO.read(new File("image/analogClock_outter.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 아날로그 시계 작동
		
		analogClock.start();

		//안내텍스트
		qrInfo.setText("시계를 누르면 QR코드가 나타납니다.");
		//가운데 정렬
		qrInfo.setHorizontalAlignment(JLabel.CENTER);
		qrInfo.setBounds(0, 385, 400, 85);
		qrInfo.setFont(new Font(MainGUI.font, Font.BOLD, 15));
		add(qrInfo);

		// ----하단 아이콘 설정
		// 알람아이콘
		alramIcon.setIcon(alramIcon_off);
		alramIcon.setBounds(58, 450, 72, 72);
		add(alramIcon);

		// 스케쥴러 아이콘
		calendarIcon.setIcon(calendarIcon_off);
		calendarIcon.setBounds(164, 450, 72, 72);
		add(calendarIcon);

		// 메모
		memoIcon.setIcon(memoIcon_off);
		memoIcon.setBounds(270, 450, 72, 72);
		add(memoIcon);
		
		// 바른 척추 운동
		exerciseIcon.setIcon(exerciseIcon_off);
		exerciseIcon.setBounds(58, 552, 72, 72); // +82
		add(exerciseIcon);

		// 세팅 아이콘
		settingIcon.setIcon(settingIcon_off);
		settingIcon.setBounds(164, 552, 72, 72);
		add(settingIcon);
		
		// 돌아가기 아이콘
		returnIcon.setIcon(returnIcon_off);
		returnIcon.setBounds(270, 552, 72, 72);
		add(returnIcon);

		setFocusable(true);
		setLayout(null);
		setBounds(0, 0, 400, 700);
		setVisible(false);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

//		g.drawImage(backGroundImg.getImage(), 0, 0, this);

		int x = (40 - ii9.getWidth()) / 2;
		int y = (228 - ii9.getHeight()) / 2;
		int x_1 = (25 - ii11.getWidth()) / 2;
		int y_2 = (362 - ii11.getHeight()) / 2;

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(ii12, 50, 100, this);
		g2d.drawImage(ii9, x + 180, y + 136, this);
		g2d.drawImage(ii11, x_1 + 187, y_2 + 69, this);
		g2d.dispose();
	}

	// 회전 함수, 구글 참조, 이해한대로 주석달아봄
	public BufferedImage rotate(BufferedImage img, double angle) {

		double rads = Math.toRadians(angle); // 회전할 각도
		double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads)); // 좌표변환식에 맞춰 변경될 이미지 크기를 위한 삼각함수계산
		int w = img.getWidth();
		int h = img.getHeight();
		int newWidth = (int) Math.floor(w * cos + h * sin); // 좌표변환시 달라진 이미지 가로 크기(직사각형) 계산
		int newHeight = (int) Math.floor(h * cos + w * sin);// 좌표변환시 달라진 이미지 세로 크기(직사각형) 계산

		BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);// 변경된 크기로 이미지 생성
		Graphics2D g2d = rotated.createGraphics();
		AffineTransform at = new AffineTransform();// 원래 이미지를 원래 위치에 손상없이 가져오기위한 아핀변환
		at.translate((newWidth - w) / 2, (newHeight - h) / 2);// 가로,세로 둘다 증가 넓이의 반만큼 길이를 구해서 새로 만들어진 이미지의 맨 위쪽점에서 부터 그
																// 위치에 옮김(양쪽으로 똑같이 증가했다생각)
																// 이미지가 그려질때 이 위치를 (0,0)으로 인식하는듯
		int x = w / 2;
		int y = h / 2;

		at.rotate(rads, x, y);// 중심축을 이미지의 무게중심에 두고 정한 각도만큼 회전
		g2d.setTransform(at);// 적용
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, 0, 0, this);// 그리기
		g2d.dispose();

		return rotated;

	}

}
