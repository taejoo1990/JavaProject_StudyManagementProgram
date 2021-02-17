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
		// ������
		super("�޸���");
		
		
		setSize(520, 550);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �г�1. Ÿ��Ʋ (���� �г�)
		JPanel titlePanel = new JPanel(); // Ÿ��Ʋ�г� ����
		JLabel titlelabel = new JLabel("�޸�"); // Ÿ��Ʋ �гο� ���� �۾�
		titlelabel.setFont(new Font("�ü�", Font.BOLD, 30)); // �� �۾�
		titlePanel.setBounds(10, 10, 500, 55); // Ÿ��Ʋ�г��� ũ��
		titlePanel.setBackground(Color.white); // Ÿ��Ʋ�г� ����. ���� ���� ����̴�.
		titlePanel.add(titlelabel); // �гο� ���� �ٿ��ش�.

		// �г�2. �ؽ�Ʈ (�Ʒ��� �г�)
		JPanel textPanel = new JPanel();// �ؽ�Ʈ�г� ����

		JTextArea ta = new JTextArea("", 22, 52);// �ؽ�Ʈ�� ����
		ta.setLineWrap(true); // �ؽ�Ʈ���� ����ġ�� ���� �Ѿ.
		ta.setWrapStyleWord(true); // �� �ѱ� �� ���� ������ �ܾ �� �࿡ ���� ������ �ʵ���
		ta.setToolTipText("�� ���� �ؽ�Ʈ�� �Է��ϼ���"); // �ؽ�Ʈ�� ���콺 ������ ��� ��.
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 8); // �ؽ�Ʈ�� �׵θ���
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));// �׵θ����� ���̵��� �������
		add(new JScrollPane(ta)); // ��ũ�ѻ���
		
		
		ta.setBounds(2, 0, 500, 420);
		textPanel.setLayout(null);
		textPanel.add(ta); // �ؽ�Ʈ�гο� �ؽ�Ʈ���� ����
		textPanel.setBounds(2, 50, 500, 420);

		// �г�3. ã��
		JPanel searchPanel = new JPanel();
		JButton searchBtn = new JButton("ã��");
		JButton replaceBtn = new JButton("�ٲٱ�");
		searchPanel.add(searchBtn);
		searchPanel.add(replaceBtn);
		searchPanel.setLayout(null); // ���̾ƿ� NULL���ְ� �� ����� ���� �� ����,.

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
		printResult.setToolTipText("���ϴ� �ؽ�Ʈ�� �˻��ϰ�, �ٲٽ� �� �ֽ��ϴ�");
		searchBtn.setToolTipText("���ϴ� �ܾ �˻�");
		replaceBtn.setToolTipText("���ϴ� �ܾ�� ��ü");
		searchPanel.setVisible(false);
		searchBtn.setVisible(false);
		replaceBtn.setVisible(false);
		searchTF.setVisible(false);

		printResult.setVisible(false);

		// ã�� �ٲٱ� ��ư �����
		ImageIcon Search = new ImageIcon("image/Search3.png");
		JLabel searchLabel = new JLabel(Search);
		searchLabel.setBounds(380, -10, 50, 80);
		add(searchLabel);

		// �����ӿ� �гκ��̱�
		add(textPanel);
		add(titlePanel);
		add(searchPanel);

		// �޴���
		JMenuBar menuBar = new JMenuBar();

		// �޴��ٿ� �� �޴�
		JMenu menuFile = new JMenu("����");
		JMenu searchFile = new JMenu("ã��&�ٲٱ�");

		// ���� �޴��� �� �޴������� (�Ҹ޴�)
		JMenuItem newDoc = new JMenuItem("�� ����");
		JMenuItem open = new JMenuItem("����");
		JMenuItem save = new JMenuItem("����");
		JMenuItem close = new JMenuItem("�ݱ�");

		// ã�� �޴��� �� �޴������� (�Ҹ޴�)
		JMenuItem search = new JMenuItem("ã��/�ٲٱ�");

		// ����, �ݱ��ư ����� �����ӿ� ����
		JButton bt1 = new JButton("�ݱ�");
		bt1.setBounds(400, 500, 500, 30);
		// titlePanel.add(bt1);

		// �޴��� ����
		setJMenuBar(menuBar);
		// �޴��ٿ� �޴��� ����
		menuBar.add(menuFile);
		menuBar.add(searchFile);

		menuFile.add(newDoc);
		menuFile.add(open);
		menuFile.add(save);
		menuFile.add(close);

		searchFile.add(search);

		// �����ϱ�� ����

		newDoc.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		newDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveQ(ta, Memo.this);
				ta.setText("");
				setTitle("�޸���");
				setSize(520, 550);
			}
		});

		// �ݱ��� ����
		close.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveQ(ta, Memo.this);
				dispose();
			}
		});

		// x���� ���� �� ����
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				saveQ(ta, Memo.this);
				dispose();

			}

		});

		// �����ɱ���
		open.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog dialog = new FileDialog(Memo.this, "����", FileDialog.LOAD);
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
					System.out.println("����" + e);
				}
				ta.setText(s);
			}
		});

		// ������ ����

		save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog dialog = new FileDialog(Memo.this, "����", FileDialog.SAVE);
				dialog.setVisible(true);

				String path = dialog.getDirectory() + dialog.getFile();

				try {

					FileWriter w = new FileWriter(path + ".txt");
					String s = ta.getText();
					w.write(s);
					w.close();

				} catch (Exception e2) {
					System.out.println("���� ����");
				}

			}
		});

		// ã���� ����.
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
						// ã�� �ܾ� �ޱ�
						String find = searchTF.getText();
						// ���� ��ü �ޱ�
						String tmp = ta.getText();
						

						int pos = tmp.indexOf(find, fromindex);

						if (pos == -1) {
							fromindex = 0;
							pos = 0;
							pos = tmp.indexOf(find, fromindex);

							printResult.setText("�˻��Ϸ�");

						} else {
							printResult.setText("���Ͻô� �ܾ��" + pos + "�� °�� �ֽ��ϴ�");
							fromindex = pos + find.length();
						}
					}
				});

				replaceBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ã�� �ܾ�� �ٲ� �ܾ� �ޱ�
						String find = searchTF.getText();
						String replace = "";
						// ���� ��ü �ޱ�
						String tmp = ta.getText();
						int fromindex = 0;

						int pos = tmp.indexOf(find, fromindex);

						if (pos == -1) {
							fromindex = 0;
							pos = 0;
							pos = tmp.indexOf(find, fromindex);

							printResult.setText("�˻��Ϸ�");
				

						  } else {
							printResult.setText("� �ܾ�� �ٲٽðڽ��ϱ�?");
							replace = JOptionPane.showInputDialog("�ܾ �Է��ϼ���");
							ta.replaceRange(replace, pos, pos + find.length());
							printResult.setText(find + " �� " + replace + "�� �ٲپ����ϴ�.");
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

			int result = JOptionPane.showConfirmDialog(null, "�Էµ� ������ �ֽ��ϴ�. �����Ͻðڽ��ϱ�?", "�� �޸�",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {
				ta.getText();
			} else if (result == JOptionPane.YES_OPTION) {
				FileDialog dialog = new FileDialog(f, "����", FileDialog.SAVE);
				dialog.setVisible(true);

				String path = dialog.getDirectory() + dialog.getFile();

				try {
					FileWriter w = new FileWriter(path + ".txt");
					String s = ta.getText();
					w.write(s);
					w.close();

				} catch (Exception e2) {
					System.out.println("���� ����");
				}
			} else if (result == JOptionPane.NO_OPTION) {

			}

		}
	}
	
	
}