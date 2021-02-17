package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AddActionListener implements ActionListener {

	JTable table;
	JTextField text1;
	JTextField text2;

	AddActionListener(JTable table, JTextField text1, JTextField text2) {
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;

	}

	public void actionPerformed(ActionEvent e) {
		String[] arr = new String[2];
		Date date = new Date();
		String dateToStr = String.format("%1$tY-%1$tm-%1$td  , ", date);

		arr[0] = dateToStr + text1.getText() + " �� ";
		arr[1] = dateToStr + text2.getText() + " �� ";

		if (arr[0].isEmpty()) {
			arr[0] = "null";
		}

		if (arr[1].isEmpty()) {
			arr[1] = "null";
		}

		if (!text1.getText().isEmpty() && Double.parseDouble(text1.getText()) >= 35.5
				&& Double.parseDouble(text1.getText()) <= 37.5) {
			JOptionPane.showMessageDialog(null, "���� ü���� " + text1.getText() + " �� ,  ����ü���Դϴ�!");
		} else {
			JOptionPane.showMessageDialog(null, "��! ������ ����ü���� �ƴϿ���!");
		}

		if (!text2.getText().isEmpty() && Double.parseDouble(text2.getText()) >= 35.5
				&& Double.parseDouble(text2.getText()) <= 37.5) {
			JOptionPane.showMessageDialog(null, "���� ü���� " + text2.getText() + " ��  , ����ü���Դϴ�!");
		} else {
			JOptionPane.showMessageDialog(null, "��! ���Ĵ� ����ü���� �ƴϿ���!");
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.addRow(arr);
		text1.setText(null);
		text2.setText(null);

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {

			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

	}
}
