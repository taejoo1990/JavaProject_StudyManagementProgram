package mainPackage;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class qrDialog extends JDialog {

	private ImageIcon img = new ImageIcon("image/qrCode.png");
	private JLabel jlb = new JLabel();
	private AlramSetting as;
	
	//바탕화면 크기
	private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private int width = gd.getDisplayMode().getWidth();
	private int height = gd.getDisplayMode().getHeight();

	
	
	//메인 시계용
	public qrDialog() {
	
		jlb.setIcon(img);
		add(jlb);
		// setLocation(0,0);
		setLocation(0, 0);
		//setLocation(width/2, height/2);
		setSize(500, 500);
		setModal(false);
		setVisible(true);
		
	}
	
	
	//알람용
	public qrDialog(AlramSetting as) {
		this.as = as;
		if(as.getqrBool()==true) {
			img = new ImageIcon("image/qrCode.png");
			setSize(500, 500);
		}else {
			img = new ImageIcon("image/alram/alramon3.gif");
			setSize(500, 375);
		}
		
	
		jlb.setIcon(img);
		add(jlb);
		// setLocation(0,0);
		setLocation(0, 0);
		setAlwaysOnTop(true);
		setModal(false);
		setVisible(true);
		
	}
	

	
	
}
