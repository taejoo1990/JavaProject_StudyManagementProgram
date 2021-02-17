package mainPackage;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyMenu implements ActionListener{
	
	MemoScheduler ms;
	public MyMenu(MemoScheduler ms) {
		this.ms=ms;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("파일저장")) {

 			FileDialog dlg = new FileDialog(ms,"파일저장",FileDialog.SAVE);

 			dlg.setVisible(true);

 			String filename=dlg.getDirectory()+dlg.getFile();
	

 			FileWriter fw = null;

 			try {

 				fw = new FileWriter(filename);

 				fw.write(ms.table.getRowCount()+"\n"); //저장할 내용의 테이블 갯수를 구한다.

 				for(int i=0;i<ms.table.getRowCount();i++) 

 				{

 					for(int j=0;j<ms.table.getColumnCount();j++)

 					{

 						fw.write((String)ms.table.getValueAt(i, j)+"\n");

 						//각 열과 행에 행당값을 저장한다.

 					}

 				}

 			} catch (IOException e1) {

 				// TODO Auto-generated catch block

 				e1.printStackTrace();

 			}

 			finally{

 				try{

 					fw.close(); //파일 쓰기가 끝나면 꼭 닫아 줘야 한다.

 				

 				}catch(IOException e1)

 				{

 					e1.printStackTrace();

 				}
         	}
        } else if(e.getActionCommand().equals("파일열기")) {
        	ms.model.setRowCount(0);// 테이블을 초기화 한다.

			FileDialog dlg = new FileDialog(ms,"파일열기",FileDialog.LOAD);

			dlg.setVisible(true);

			String filename = dlg.getDirectory()+dlg.getFile();

			

			FileReader fr=null;

			BufferedReader br = null;

			

			try {

				fr = new FileReader(filename);	

			}

			catch (FileNotFoundException e1) 

			{

				e1.printStackTrace();

			}

			br = new BufferedReader(fr);

			try{

			int cnt=Integer.parseInt(br.readLine()); //파일에 저장된 내용을 줄 단위로 읽어온다.

			for(int i =0; i<cnt; i++) //Row 를 먼저 읽는다.

			{

				String str[]=new String[2];

				

				for(int j =0; j<2;j++) 

				{

					str[j]=br.readLine();

				}

				ms.model.addRow(str); //테이블에 추가시킨다
				 DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
				 tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				 TableColumnModel tcmSchedule = ms.table.getColumnModel();
				 for (int k = 0; k < tcmSchedule.getColumnCount(); k++) {

					 tcmSchedule.getColumn(k).setCellRenderer(tScheduleCellRenderer);
					 }

			}

			}catch(Exception e1)

			{

				System.out.println(e1.getMessage());

			}finally{

				try{

				br.close();// 불러오기가 끝나면 꼭 close를 해야된다.

				fr.close();// 꼭 같이 닫아줘야 한다.

			}catch(Exception e2){

			}

			}
        }
		
	}	
}