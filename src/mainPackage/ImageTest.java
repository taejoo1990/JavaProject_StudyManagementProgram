package mainPackage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImageTest {
	
	JLabel  workout1;
	JLabel  workout2;
	JLabel  workout3;
	JLabel  workout4;
	JLabel  workout5;
	
	public ImageTest() {
		ImageIcon img1 = new ImageIcon("image/exercise/1.jpg");
		ImageIcon img2 = new ImageIcon("image/exercise/2.jpg");
		ImageIcon img3 = new ImageIcon("image/exercise/3.jpg");
		ImageIcon img4 = new ImageIcon("image/exercise/4.jpg");
		ImageIcon img5 = new ImageIcon("image/exercise/5.jpg");
		ImageIcon img6 = new ImageIcon("image/exercise/6.jpg");
		
		workout1= new JLabel(img1);
		workout2= new JLabel(img2);
		workout3= new JLabel(img3);
		workout4= new JLabel(img4);
		workout5= new JLabel(img5);
		workout5= new JLabel(img6);
		
		workout1.setSize(600, 600);
		workout1.setLocation(-15, 0);
		
		
		workout2.setSize(600, 600);
		workout2.setLocation(-15, 0);
		
		
		workout3.setSize(600, 600);
		workout3.setLocation(-15, 0);
		
		
		workout4.setSize(600, 600);
		workout4.setLocation(-15, 0);
		
		
		workout5.setSize(600, 600);
		workout5.setLocation(-15, 0);
		
		
		
	}

}
