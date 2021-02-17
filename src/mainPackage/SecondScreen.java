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
	
	// ���
	public ImageIcon backGroundImg = new ImageIcon("image/backGround.png");

	// �����нð�
	JLabel curTime = new JLabel();
	JPanel hi = new JPanel();
	
	//�ð�Ŭ���� QR ��ư
	JButton clockQR = new JButton();
	

	// �ϴ� �г� ������
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

	// �Ƴ��α� �ð�
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
		
		
		// ��ư�� ���� �Ϻ��� ����
		MainGUI.perfectButton(clockQR, null, null);
		MainGUI.perfectButton(alramIcon, alramIcon_off, alramIcon_on);
		MainGUI.perfectButton(memoIcon, memoIcon_off, memoIcon_on);
		MainGUI.perfectButton(returnIcon, returnIcon_off, returnIcon_on);
		MainGUI.perfectButton(calendarIcon, calendarIcon_off, calendarIcon_on);
		MainGUI.perfectButton(exerciseIcon, exerciseIcon_off, exerciseIcon_on);
		MainGUI.perfectButton(settingIcon, settingIcon_off, settingIcon_on);
		
		
		// ��ư ��� �߰�1
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
		
		// ������ �ð� ����, �۵�
		curTime.setHorizontalAlignment(JLabel.CENTER);
		curTime.setBounds(0, 10, 400, 100);
		curTime.setFont(new Font("DS-Digital", Font.BOLD, 35));
		add(curTime);
		Thread realtimeLabel = new Thread(new SecondRealtime(this,mGUI.as));
		realtimeLabel.start();

		// �Ƴ��α� �ð� �̹��� �ҷ�����
		try {
			ii8 = ImageIO.read(new File("image/clock_hour.png"));
			ii9 = rotate(ii8, i);
			ii10 = ImageIO.read(new File("image/12clock_minute.png"));
			ii11 = rotate(ii10, j);
			ii12 = ImageIO.read(new File("image/analogClock_outter.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// �Ƴ��α� �ð� �۵�
		
		analogClock.start();

		//�ȳ��ؽ�Ʈ
		qrInfo.setText("�ð踦 ������ QR�ڵ尡 ��Ÿ���ϴ�.");
		//��� ����
		qrInfo.setHorizontalAlignment(JLabel.CENTER);
		qrInfo.setBounds(0, 385, 400, 85);
		qrInfo.setFont(new Font(MainGUI.font, Font.BOLD, 15));
		add(qrInfo);

		// ----�ϴ� ������ ����
		// �˶�������
		alramIcon.setIcon(alramIcon_off);
		alramIcon.setBounds(58, 450, 72, 72);
		add(alramIcon);

		// �����췯 ������
		calendarIcon.setIcon(calendarIcon_off);
		calendarIcon.setBounds(164, 450, 72, 72);
		add(calendarIcon);

		// �޸�
		memoIcon.setIcon(memoIcon_off);
		memoIcon.setBounds(270, 450, 72, 72);
		add(memoIcon);
		
		// �ٸ� ô�� �
		exerciseIcon.setIcon(exerciseIcon_off);
		exerciseIcon.setBounds(58, 552, 72, 72); // +82
		add(exerciseIcon);

		// ���� ������
		settingIcon.setIcon(settingIcon_off);
		settingIcon.setBounds(164, 552, 72, 72);
		add(settingIcon);
		
		// ���ư��� ������
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

	// ȸ�� �Լ�, ���� ����, �����Ѵ�� �ּ��޾ƺ�
	public BufferedImage rotate(BufferedImage img, double angle) {

		double rads = Math.toRadians(angle); // ȸ���� ����
		double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads)); // ��ǥ��ȯ�Ŀ� ���� ����� �̹��� ũ�⸦ ���� �ﰢ�Լ����
		int w = img.getWidth();
		int h = img.getHeight();
		int newWidth = (int) Math.floor(w * cos + h * sin); // ��ǥ��ȯ�� �޶��� �̹��� ���� ũ��(���簢��) ���
		int newHeight = (int) Math.floor(h * cos + w * sin);// ��ǥ��ȯ�� �޶��� �̹��� ���� ũ��(���簢��) ���

		BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);// ����� ũ��� �̹��� ����
		Graphics2D g2d = rotated.createGraphics();
		AffineTransform at = new AffineTransform();// ���� �̹����� ���� ��ġ�� �ջ���� ������������ ���ɺ�ȯ
		at.translate((newWidth - w) / 2, (newHeight - h) / 2);// ����,���� �Ѵ� ���� ������ �ݸ�ŭ ���̸� ���ؼ� ���� ������� �̹����� �� ���������� ���� ��
																// ��ġ�� �ű�(�������� �Ȱ��� �����ߴٻ���)
																// �̹����� �׷����� �� ��ġ�� (0,0)���� �ν��ϴµ�
		int x = w / 2;
		int y = h / 2;

		at.rotate(rads, x, y);// �߽����� �̹����� �����߽ɿ� �ΰ� ���� ������ŭ ȸ��
		g2d.setTransform(at);// ����
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, 0, 0, this);// �׸���
		g2d.dispose();

		return rotated;

	}

}
