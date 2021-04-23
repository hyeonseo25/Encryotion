package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Encryption extends JPanel{
	ImageIcon backImg = new ImageIcon("image/background.png");
	Image back = backImg.getImage();
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	
	JTable jtb;
	
	JButton workbt;
	public Encryption(Object o) {
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		
		tf1.setBounds(295, 185, 275, 30);
		tf2.setBounds(295, 232, 275, 30);
		tf3.setBounds(295, 348, 275, 30);
		tf4.setBounds(295, 402, 275, 30);
		
		tf3.setDisabledTextColor(new Color(0,0,0));
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		
		workbt = new JButton(new ImageIcon());
		workbt.setText("��ȣȭ");
		workbt.setBounds(150, 277, 200, 60);	
		workbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				doEncryption();
			}
		});
		add(workbt);
		
		jtb = new JTable(5,5);
		jtb.setBounds(640, 130, 300, 300);
		jtb.setRowHeight(60);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��
		TableColumnModel tcm = jtb.getColumnModel() ; // ������ ���̺��� �÷����� ������

		//��ü ���� ����
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){
			tcm.getColumn(i).setCellRenderer(dtcr);  
		}
		// �÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ�
		// ������ ���������� �Ʊ� ������ dtcr�� set����
		add(jtb);
	}
	
	private void doEncryption() {
		work2(tf1.getText());
		work1(tf2.getText());
		
	}
	private void doDecryption() {
		
	}
	private void work1(String key) {
		char[] arr;
		ArrayList<String> arr1 = new ArrayList<String>(); //�ٲٱ� �� ���ھ�ȣ�� ����
		key = key.replace(" ", "");
		key = key.toUpperCase();
		arr = key.toCharArray();
		for(int i=0 ; i<arr.length ; i++) {
			if(Character.toString(arr[i]).equals("Z")) {
				arr1.add("Q");
			}else {
				arr1.add(Character.toString(arr[i]));
			}
		}
		for(int i=1 ; i<arr1.size() ; i++) { 
			if(arr1.get(i).equals(arr1.get(i-1))){
				arr1.add(i,"X");
			}
		}
		if(arr1.size()%2!=0) {
			arr1.add("X");
		}
		String ssangza = "";
		for(int i=0 ; i<arr1.size() ; i++) { 
			if(i%2==0&&i!=0) {
				ssangza +=" ";
			}
			ssangza += arr1.get(i); 
		}
		tf3.setText(ssangza);
	}
	
	public void work2(String key) {
		char[][] board = new char[5][5];
		key = key.replace(" ", "");
		key = key.toUpperCase();
		
		// �ߺ����� ����
		String result = ""; // �ߺ��� ���� ���� ���ڿ��� ������ ���ڿ� ����
		for(int i = 0; i < key.length(); i++) { // i�� 0���� ����ڰ� �Է��� ���ڿ��� ���̸�ŭ �ݺ����� ������.
			if(!result.contains(String.valueOf(key.charAt(i)))) { // ����ڰ� �Է¹��� ���ڿ��� i��° ���ڸ� String���� �ٲٰ� result�� �� ���ڰ� ���ԵǾ� ���� �ʴٸ�
				result += String.valueOf(key.charAt(i));  // result�� ��� �߰�, �� �ߺ����� ������ �߰�
			}
		}
		
		// ���� ��ȣ�ǿ� ���ĺ� ä���
		for(char i='A'; i<'Z'; i++) {
			if(!result.contains(String.valueOf(i))) { // ����ڰ� �Է¹��� ���ڿ��� i��° ���ڸ� String���� �ٲٰ� result�� �� ���ڰ� ���ԵǾ� ���� �ʴٸ�
				result += String.valueOf(i);  // result�� ��� �߰�, �� �ߺ����� ������ �߰�
			}
		}
		
		// ��ȣ�ǿ� �� ���� string���� �迭�� ���
		int num=0;
		for(int j=0; j<board.length; j++) {
			for(int k = 0; k<board[j].length; k++) {
				board[j][k] = result.charAt(num);
				num++;
			}
		}
			
		// ��ȣ�� ���
		for(int j=0; j<board.length; j++) {
			for(int k = 0; k<board[j].length; k++) {
				jtb.setValueAt(board[j][k], j, k);
			}
		}
		
		
		
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub	
		super.paintComponent(g);
		g.drawImage(back, 0, 0, this); // �޹��
	}

}
