package mainPackage;

import javax.swing.JDialog;

public class OptionScreen extends JDialog {
	
	
	//qrȭ��ũ�� ����
	private int qrWidth=500; 
	private int qrHeight=500;
	//private boolean 
	
	
	public OptionScreen() {

		setSize(400, 400);
		setVisible(true);
		
	}
	
	
	
	public void qrSize(int qrWidth, int qrHeight) {
		this.qrWidth = qrWidth;
		this.qrHeight = qrWidth;
	}
	
	
	
	
	
}
