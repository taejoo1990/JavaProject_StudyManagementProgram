package mainPackage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutTest1 extends JFrame implements ActionListener{
	
	   JPanel jp;
	   Cards cards;
	   Font font;
	    
	   public CardLayoutTest1(){
		   Toolkit tk=Toolkit.getDefaultToolkit();
		  
		   setTitle("여러분의 경추 보안관!");
//		   setBounds(((int) tk.getScreenSize().getWidth()) / 2, 
//					((int) tk.getScreenSize().getHeight()) / 2,
//					630,680);
		  setBounds(100, 100, 630, 680);
		   
	      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setResizable(false);
	      
	       
	      jp = new JPanel(new GridLayout(0, 5, 10, 0));
	       
	      font=new Font("맑은고딕",Font.BOLD,40);
	      jp.setFont(font);
	      addButton("◀◀", jp);
	      addButton("◀", jp);
	      addButton("▶", jp);
	      addButton("▶▶", jp);
	      addButton("종료", jp);
	      add(jp, BorderLayout.NORTH);
	      cards = new Cards();
	      add(cards, BorderLayout.CENTER);
	       
	      setVisible(true);
	       
	   }//end of constructor
	    
	   public void addButton(String str, Container target){
	      JButton bt = new RoundedButton(str);
	      bt.addActionListener(this);
	      bt.setBackground(new Color(216,216,216));
	      target.add(bt);
	   }//end of addButton method
	    
	   
	   
	  public class Cards extends JPanel{
	      CardLayout layout;
	      ImageTest img;
	      public Cards(){
	    	  layout=new CardLayout();
	         setLayout(layout);
	         
	         img=new ImageTest();
	        add(img.workout1, BorderLayout.CENTER);
	        add(img.workout2, BorderLayout.CENTER);
	        add(img.workout3, BorderLayout.CENTER);
	        add(img.workout4, BorderLayout.CENTER);
	        add(img.workout5, BorderLayout.CENTER);
	         }//end of Cards constructor
	       
	   }//end of Cards class
	    
	   
	   public void actionPerformed(ActionEvent e) {
	    
	         if(e.getActionCommand().equals("종료")){
	            setVisible(false);
	            dispose();
	 
	         }
	          
	         if(e.getActionCommand().equals("◀◀")){
	            cards.layout.first(cards);
	         }
	          
	         if(e.getActionCommand().equals("◀")){
	            cards.layout.previous(cards);
	         }
	          
	         if(e.getActionCommand().equals("▶")){
	            cards.layout.next(cards);
	         }
	          
	         if(e.getActionCommand().equals("▶▶")){
	            cards.layout.last(cards);
	         }
	   }//end of actionPerformed method
	   	
	   
	   public class RoundedButton extends JButton {
			public RoundedButton() { 
				super(); 
				decorate();
				}
			public RoundedButton(String text) { 
				super(text); 
				decorate(); 
				} 
			public RoundedButton(Action action) { 
				super(action); 
				decorate(); 
				} 
			public RoundedButton(Icon icon) { 
				super(icon); 
				decorate();
				} 
			public RoundedButton(String text, Icon icon) { 
				super(text, icon); 
				decorate(); 
				} 
			protected void decorate() { 
				setBorderPainted(false); 
				setOpaque(false); 
				} 

		@Override protected void paintComponent(Graphics g) {
			int width = getWidth(); 
			int height = getHeight(); 
			Graphics2D graphics = (Graphics2D) g;
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			if (getModel().isArmed()) { 
				graphics.setColor(getBackground().darker()); 
			} else if (getModel().isRollover()) { graphics.setColor(getBackground().brighter()); 
			} else { graphics.setColor(getBackground()); 
			} 
			
			graphics.fillRoundRect(0, 0, width, height, 10, 10);
			FontMetrics fontMetrics = graphics.getFontMetrics(); 
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
			int textX = (width - stringBounds.width) / 2; 
			int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
			graphics.setColor(getForeground()); 
			graphics.setFont(getFont()); 
			graphics.drawString(getText(), textX, textY); 
			graphics.dispose(); 
			super.paintComponent(g); 
			}
	
	   }

}
