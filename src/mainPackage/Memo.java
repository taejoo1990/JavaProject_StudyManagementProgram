package mainPackage;


import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class Memo extends JFrame{
	int fromindex = 0;
	private static final Border emptyBorder = null;

	@SuppressWarnings("deprecation")
	public Memo() {
		// 프레임
		super("메모장");
		
		
		setSize(520, 550);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 패널1. 타이틀 (위쪽 패널)
		JPanel titlePanel = new JPanel(); // 타이틀패널 선언
		JLabel titlelabel = new JLabel("메모"); // 타이틀 패널에 붙일 글씨
		titlelabel.setFont(new Font("궁서", Font.BOLD, 30)); // 라벨 글씨
		titlePanel.setBounds(10, 10, 500, 55); // 타이틀패널의 크기
		titlePanel.setBackground(Color.white); // 타이틀패널 색상. 굳이 원래 흰색이다.
		titlePanel.add(titlelabel); // 패널에 라벨을 붙여준다.

		// 패널2. 텍스트 (아래쪽 패널)
		JPanel textPanel = new JPanel();// 텍스트패널 선언

		JTextArea ta = new JTextArea("", 22, 52);// 텍스트를 선언
		ta.setLineWrap(true); // 텍스트에서 엔터치면 행이 넘어감.
		ta.setWrapStyleWord(true); // 행 넘길 때 행의 마지막 단어가 두 행에 걸쳐 나뉘지 않도록
		ta.setToolTipText("이 곳에 텍스트를 입력하세요"); // 텍스트에 마우스 가져다 대면 뜸.
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 8); // 텍스트에 테두리선
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));// 테두리선이 보이도록 여백생성
		add(new JScrollPane(ta)); // 스크롤생성
		
		
		ta.setBounds(2, 0, 500, 420);
		textPanel.setLayout(null);
		textPanel.add(ta); // 텍스트패널에 텍스트상자 붙임
		textPanel.setBounds(2, 50, 500, 420);

		// 패널3. 찾기
		JPanel searchPanel = new JPanel();
		JButton searchBtn = new JButton("찾기");
		JButton replaceBtn = new JButton("바꾸기");
		searchPanel.add(searchBtn);
		searchPanel.add(replaceBtn);
		searchPanel.setLayout(null); // 레이아웃 NULL값주고 내 맘대로 잡을 수 있음,.

		searchPanel.setBounds(0, 550, 520, 100);

		TextField searchTF = new TextField();

		searchBtn.setBounds(290, 500, 60, 30);
		searchTF.setBounds(40, 500, 230, 30);
		replaceBtn.setBounds(360, 500, 80, 30);

		searchPanel.add(searchTF);

		searchPanel.add(replaceBtn);

		JTextArea printResult = new JTextArea("");
		searchPanel.add(printResult);
		printResult.setEditable(false);
		printResult.setBounds(40, 540, 400, 40);

		printResult.setLineWrap(true);
		// JScrollPane searchScroll = (JScrollPane) searchPanel.add(new
		// JScrollPane(printResult));
		printResult.setToolTipText("원하는 텍스트를 검색하고, 바꾸실 수 있습니다");
		searchBtn.setToolTipText("원하는 단어를 검색");
		replaceBtn.setToolTipText("원하는 단어로 교체");
		searchPanel.setVisible(false);
		searchBtn.setVisible(false);
		replaceBtn.setVisible(false);
		searchTF.setVisible(false);

		printResult.setVisible(false);

		// 찾기 바꾸기 버튼 만들기
		ImageIcon Search = new ImageIcon("image/Search3.png");
		JLabel searchLabel = new JLabel(Search);
		searchLabel.setBounds(380, -10, 50, 80);
		add(searchLabel);

		// 프레임에 패널붙이기
		add(textPanel);
		add(titlePanel);
		add(searchPanel);

		// 메뉴바
		JMenuBar menuBar = new JMenuBar();

		// 메뉴바에 들어갈 메뉴
		JMenu menuFile = new JMenu("파일");
		JMenu searchFile = new JMenu("찾기&바꾸기");

		// 파일 메뉴에 들어갈 메뉴아이템 (소메뉴)
		JMenuItem newDoc = new JMenuItem("새 파일");
		JMenuItem open = new JMenuItem("열기");
		JMenuItem save = new JMenuItem("저장");
		JMenuItem close = new JMenuItem("닫기");

		// 찾기 메뉴에 들어갈 메뉴아이템 (소메뉴)
		JMenuItem search = new JMenuItem("찾기/바꾸기");

		// 열기, 닫기버튼 만들고 프레임에 붙임
		JButton bt1 = new JButton("닫기");
		bt1.setBounds(400, 500, 500, 30);
		// titlePanel.add(bt1);

		// 메뉴바 셋팅
		setJMenuBar(menuBar);
		// 메뉴바에 메뉴를 붙임
		menuBar.add(menuFile);
		menuBar.add(searchFile);

		menuFile.add(newDoc);
		menuFile.add(open);
		menuFile.add(save);
		menuFile.add(close);

		searchFile.add(search);

		// 새파일기능 구현

		newDoc.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		newDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveQ(ta, Memo.this);
				ta.setText("");
				setTitle("메모장");
				setSize(520, 550);
			}
		});

		// 닫기기능 구현
		close.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveQ(ta, Memo.this);
				dispose();
			}
		});

		// x눌러 닫을 때 구현
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				saveQ(ta, Memo.this);
				dispose();

			}

		});

		// 열기기능구현
		open.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog dialog = new FileDialog(Memo.this, "저장", FileDialog.LOAD);
				dialog.setVisible(true);

				String path = dialog.getDirectory() + dialog.getFile();
				String s = "";

				try {
					FileReader r = new FileReader(path);

					int k;

					for (;;) {
						k = r.read();
						if (k == -1)
							break;
						s += (char) k;
					}
					r.close();
				} catch (Exception e2) {
					System.out.println("오류" + e);
				}
				ta.setText(s);
			}
		});

		// 저장기능 구현

		save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog dialog = new FileDialog(Memo.this, "저장", FileDialog.SAVE);
				dialog.setVisible(true);

				String path = dialog.getDirectory() + dialog.getFile();

				try {

					FileWriter w = new FileWriter(path + ".txt");
					String s = ta.getText();
					w.write(s);
					w.close();

				} catch (Exception e2) {
					System.out.println("저장 오류");
				}

			}
		});

		// 찾기기능 구현.
		search.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(520, 670);

				searchPanel.setVisible(true);
				searchTF.setVisible(true);
				searchBtn.setVisible(true);

				replaceBtn.setVisible(true);

				printResult.setVisible(true);
				printResult.setEditable(false);
				// searchScroll.setVisible(true);

				searchBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						// 찾을 단어 받기
						String find = searchTF.getText();
						// 내용 전체 받기
						String tmp = ta.getText();
						

						int pos = tmp.indexOf(find, fromindex);

						if (pos == -1) {
							fromindex = 0;
							pos = 0;
							pos = tmp.indexOf(find, fromindex);

							printResult.setText("검색완료");

						} else {
							printResult.setText("원하시는 단어는" + pos + "번 째에 있습니다");
							fromindex = pos + find.length();
						}
					}
				});

				replaceBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 찾을 단어와 바꿀 단어 받기
						String find = searchTF.getText();
						String replace = "";
						// 내용 전체 받기
						String tmp = ta.getText();
						int fromindex = 0;

						int pos = tmp.indexOf(find, fromindex);

						if (pos == -1) {
							fromindex = 0;
							pos = 0;
							pos = tmp.indexOf(find, fromindex);

							printResult.setText("검색완료");
				

						  } else {
							printResult.setText("어떤 단어로 바꾸시겠습니까?");
							replace = JOptionPane.showInputDialog("단어를 입력하세요");
							ta.replaceRange(replace, pos, pos + find.length());
							printResult.setText(find + " 를 " + replace + "로 바꾸었습니다.");
							fromindex = pos + find.length();
						}

					}
				});

			}
		});
 
		setVisible(true);
		this.getContentPane().setBackground(MainGUI.color);
		textPanel.setBackground(MainGUI.color);
		titlePanel.setBackground(MainGUI.color);
		searchPanel.setBackground(MainGUI.color);
		titlePanel.setBackground(MainGUI.color);
	}
 
	public void saveQ(JTextArea ta, JFrame f) {
		String str = ta.getText().toString();
		if (!str.isEmpty()) {

			int result = JOptionPane.showConfirmDialog(null, "입력된 내용이 있습니다. 저장하시겠습니까?", "새 메모",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {
				ta.getText();
			} else if (result == JOptionPane.YES_OPTION) {
				FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);
				dialog.setVisible(true);

				String path = dialog.getDirectory() + dialog.getFile();

				try {
					FileWriter w = new FileWriter(path + ".txt");
					String s = ta.getText();
					w.write(s);
					w.close();

				} catch (Exception e2) {
					System.out.println("저장 오류");
				}
			} else if (result == JOptionPane.NO_OPTION) {

			}

		}
	}
	
	
}