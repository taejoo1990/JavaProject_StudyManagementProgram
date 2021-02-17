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
		
		
		if(e.getActionCommand().equals("��������")) {

 			FileDialog dlg = new FileDialog(ms,"��������",FileDialog.SAVE);

 			dlg.setVisible(true);

 			String filename=dlg.getDirectory()+dlg.getFile();
	

 			FileWriter fw = null;

 			try {

 				fw = new FileWriter(filename);

 				fw.write(ms.table.getRowCount()+"\n"); //������ ������ ���̺� ������ ���Ѵ�.

 				for(int i=0;i<ms.table.getRowCount();i++) 

 				{

 					for(int j=0;j<ms.table.getColumnCount();j++)

 					{

 						fw.write((String)ms.table.getValueAt(i, j)+"\n");

 						//�� ���� �࿡ ��簪�� �����Ѵ�.

 					}

 				}

 			} catch (IOException e1) {

 				// TODO Auto-generated catch block

 				e1.printStackTrace();

 			}

 			finally{

 				try{

 					fw.close(); //���� ���Ⱑ ������ �� �ݾ� ��� �Ѵ�.

 				

 				}catch(IOException e1)

 				{

 					e1.printStackTrace();

 				}
         	}
        } else if(e.getActionCommand().equals("���Ͽ���")) {
        	ms.model.setRowCount(0);// ���̺��� �ʱ�ȭ �Ѵ�.

			FileDialog dlg = new FileDialog(ms,"���Ͽ���",FileDialog.LOAD);

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

			int cnt=Integer.parseInt(br.readLine()); //���Ͽ� ����� ������ �� ������ �о�´�.

			for(int i =0; i<cnt; i++) //Row �� ���� �д´�.

			{

				String str[]=new String[2];

				

				for(int j =0; j<2;j++) 

				{

					str[j]=br.readLine();

				}

				ms.model.addRow(str); //���̺� �߰���Ų��
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

				br.close();// �ҷ����Ⱑ ������ �� close�� �ؾߵȴ�.

				fr.close();// �� ���� �ݾ���� �Ѵ�.

			}catch(Exception e2){

			}

			}
        }
		
	}	
}