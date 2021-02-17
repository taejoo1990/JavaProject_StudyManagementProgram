package mainPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 

class MemoScheduler extends JFrame implements ActionListener

{

       String [] days = {"��","��","ȭ","��","��","��","��"};

       int year ,month,day,todays,memoday=0;

      

 

       Font f,f1;

       Color bc,fc;

       Calendar today;

       Calendar cal;

 
       JScrollPane s;
       JTable table;
       DefaultTableModel model;
 
       JMenuItem mnuSave,mnuLoad;
       JButton btnBefore,btnAfter;

       JButton btnAdd,btnOpen;

       //JButton[] calBtn = new JButton[49];
        JButton[] calBtn = new RoundedButton[49];

 

       JLabel thing;

       JLabel time;

 

       JPanel panWest;

       JPanel panSouth;

       JPanel panNorth;

       JPanel panEast;    

      

       JTextField txtMonth,txtYear;

       JTextField txtTime;
       
       JTextArea txtArea;

       BorderLayout bLayout= new BorderLayout();   
       
     

      
       MainGUI mGUI;

       public MemoScheduler(MainGUI mGUI){
    	     this.mGUI = mGUI;
             today = Calendar.getInstance(); //����Ʈ�� Ÿ�� �� �� �������� ����� �޷��� �����ɴϴ�.

             cal = new GregorianCalendar();

             

             year = today.get(Calendar.YEAR);

             month = today.get(Calendar.MONTH)+1;//1���� ���� 0

 

             panNorth = new JPanel();
             
             btnBefore = new RoundedButton("Before");
             btnBefore.setBackground(Color.LIGHT_GRAY);
             panNorth.add(btnBefore);             
             //panNorth.add(btnBefore = new JButton("Before"));           

             
             
             panNorth.add(txtYear = new JTextField(year+"��"));

             panNorth.add(txtMonth = new JTextField( month+"��"));

          /*   txtYear.setEnabled(false);

             txtMonth.setEnabled(false);*/

            
             btnAfter = new RoundedButton("After");
             btnAfter.setBackground(Color.LIGHT_GRAY);
             panNorth.add(btnAfter);  
            

             //panNorth.add(btnAfter = new JButton("After"));

             f=new Font("Sherif",Font.BOLD,24);

             txtYear.setFont(f);

             txtMonth.setFont(f);      
             
          
             String colName[] = {"���� ü��"," ���� ü��"};
             model = new DefaultTableModel(colName,0);
           
              table = new JTable(model);
             
             s= new JScrollPane(table);
            
             
             table.setPreferredScrollableViewportSize(new Dimension(302,242));
             
            
                          
            
             
             
             JTextField text1 = new JTextField(5);
             JTextField text2 = new JTextField(5);
             
                   
            
          
                 

            add(panNorth,"North");
             
             
             
             JButton button1 = new RoundedButton("add");
             button1.setBackground(Color.LIGHT_GRAY);
            
             JButton button2 = new RoundedButton("del");
             button2.setBackground(Color.LIGHT_GRAY);
             
             
             
             
             ImageIcon img = new ImageIcon("image/dd.png");
             JLabel imglabel= new JLabel(img);
             
           
            
             
            
            
             JLabel label1=new JLabel("���� : ");
             //label1.setFont(f1);
             JLabel label2=new JLabel("���� : ");
             //label2.setFont(f1);
             
             panNorth.add(imglabel);
             panNorth.add(label1);
             panNorth.add(text1);
             panNorth.add(label2);
             panNorth.add(text2);
             panNorth.add(button1);
             panNorth.add(button2);
             
         
             

             add(panNorth,"North");

             
             
             

             
 

             //�̳��� �޷��� ���� �ش��ϴ� �κ�

 

             panWest = new JPanel(new GridLayout(7,7));//���ڳ�,���������� ��ġ������

            // f=new Font("Sherif",Font.BOLD,12);

            // panWest.setBackground(Color.DARK_GRAY);

             gridInit();

             calSet();

             hideInit();

             add(panWest,"West");

 
                               
             
             
             
             panEast = new JPanel();  
                            
             panEast.add(s);      
             
             
                       
             button1.addActionListener(new AddActionListener(table,text1,text2));
             button2.addActionListener(new RemoveActionListener(table));
            
             
             add(panEast,"East");

            

      

            

             btnBefore.addActionListener(this);

             btnAfter.addActionListener(this);      

             
             
             JMenu menu= new JMenu("�޴�");
            
     		JMenuBar menuBar = new JMenuBar();

     		menuBar.add(menu);

     		this.setJMenuBar(menuBar);
      	

 			mnuSave = new JMenuItem("��������");
 			mnuLoad = new JMenuItem("���Ͽ���");
 			
 			mnuSave.addActionListener(new MyMenu(this));
 			menu.add(mnuSave);
 			mnuLoad.addActionListener(new MyMenu(this));
     		menu.add(mnuLoad);
 
             
             

 

            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             setTitle("ü�� �޷�");

             setBounds(100,100,668,400);
             
             setVisible(true);  
             
             panWest.setBackground(MainGUI.color);
 			 panNorth.setBackground(MainGUI.color);
 			 panEast.setBackground(MainGUI.color);
             
             setResizable(false);

            

       }//end constuctor

      

       public void calSet(){

             cal.set(Calendar.YEAR,year);

             cal.set(Calendar.MONTH,(month-1));

             cal.set(Calendar.DATE,1);

             int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

             /*

              * get �� set �� ���� �ʵ�ġ��, ������ ��Ÿ���ϴ�.

              * �� �ʵ��� ����,SUNDAY,MONDAY,TUESDAY,WEDNESDAY

              * ,THURSDAY,FRIDAY, �� SATURDAY �� �˴ϴ�.

              * get()�޼ҵ��� ���� ������ ���ڷ� ��ȯ

              */

 

             int j=0;

             int hopping=0;

             calBtn[0].setForeground(new Color(255,0,0));//�Ͽ��� "��"
             calBtn[0].setBackground(getBackground());
             
             for(int i=1; i<6 ; i++) {
            	 calBtn[i].setBackground(getBackground());
             }


             calBtn[6].setForeground(new Color(0,0,255));//����� "��"
             calBtn[6].setBackground(getBackground());


             for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){  j++;  }

             /*

              * �Ͽ��Ϻ��� �״��� ù���� ���ϱ��� ��ĭ���� �����ϱ� ����

              */

             hopping=j;

             for(int kk=0;kk<hopping;kk++){

                    calBtn[kk+7].setText("");
                   


             }

             for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);

                           i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){

                 cal.set(Calendar.DATE,i);

                    if(cal.get(Calendar.MONTH) !=month-1){

                           break;

                    }

                    

                    todays=i;

                   

                    if(memoday==1){

                           calBtn[i+6+hopping].setForeground(new Color(0,255,0));   
                          // calBtn[i+6+hopping].setBackground(Color.WHITE);

                    }

                    else{

                    	   
                           calBtn[i+6+hopping].setForeground(new Color(0,0,0));
                           //calBtn[i+6+hopping].setBackground(Color.WHITE);

                           
                           if((i+hopping-1)%7==0){//�Ͽ���

                                 calBtn[i+6+hopping].setForeground(new Color(255,0,0));
                                 //calBtn[i+6+hopping].setBackground(Color.WHITE);


                           }

                           if((i+hopping)%7==0){//�����

                                 calBtn[i+6+hopping].setForeground(new Color(0,0,255));
                                 //calBtn[i+6+hopping].setBackground(getBackground());


                           }

                    }

                    /*

                     * ������ ���� �������� ����ؾ� �ϴ� ������ ���� ��ư�� ������ ���ϰ�

                     * �ε����� 0���� �����̴� -1�� ���� ������ ������ ���ְ�

                     * ��ư�� ������ �������ش�.

                     */

                    calBtn[i+6+hopping].setText((i)+"");
                    calBtn[i+6+hopping].setBackground(getBackground());


             }//for

 

       }//end Calset()

       public void actionPerformed(ActionEvent ae){        

             if(ae.getSource() == btnBefore){

                    this.panWest.removeAll();

                    calInput(-1);

                    gridInit();

                    panelInit();              

                    calSet();

                    hideInit();

                    this.txtYear.setText(year+"��");

                    this.txtMonth.setText(month+"��");                  

             }                  

             else if(ae.getSource() == btnAfter){

                    this.panWest.removeAll();

                    calInput(1);

                    gridInit();

                    panelInit();

                    calSet();

                    hideInit();

                    this.txtYear.setText(year+"��");

                    this.txtMonth.setText(month+"��");                                      
                    mGUI.settingFont.setFont(MainGUI.font, mGUI.msd);
             }


             else if(Integer.parseInt(ae.getActionCommand()) >= 1 &&

                    Integer.parseInt(ae.getActionCommand()) <=31){

                    day = Integer.parseInt(ae.getActionCommand());

                    //��ư�� ��� �� 1,2,3.... ���ڸ� ���������� ��ȯ�Ͽ� Ŭ���� ��¥�� �ٲ��ش�.

                    System.out.println(day);

                               

                    

                    calSet();

             }     

       }//end actionperformed()

       public void hideInit(){

             for(int i = 0 ; i < calBtn.length;i++){

                    if((calBtn[i].getText()).equals(""))

                           calBtn[i].setEnabled(false);

                    //���� ������ ���� ������ ��ư�� ��Ȱ��ȭ ��Ų��.

             }//end for

       }//end hideInit()



 

       public void gridInit(){

         //jPanel3�� ��ư ���̱�

         for(int i = 0 ; i < days.length;i++)

               panWest.add(calBtn[i] = new RoundedButton(days[i]));                  

 

          for(int i = days.length ; i < 49;i++){               

                    panWest.add(calBtn[i] = new RoundedButton(""));                  

                    calBtn[i].addActionListener(this);

             }             

       }//end gridInit()

      

       public void panelInit(){

         GridLayout gridLayout1 = new GridLayout(7,7);

         panWest.setLayout(gridLayout1);  

       }//end panelInit()

       public void calInput(int gap){

             month+=(gap);

             if (month<=0){

                           month = 12;

                           year  =year- 1;

             }else if (month>=13){

                           month = 1;

                           year =year+ 1;

             }

       }//end calInput()

     

       
       
       

}//end class
