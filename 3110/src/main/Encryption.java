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
	
	char[][] board; // 암호판
	ArrayList<String> ssangArr = new ArrayList<String>(); // 쌍자
	ArrayList<Character> AmhoArr; // 쌍자
	char[][] ssangza;
	
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
		workbt.setText("암호화");
		workbt.setBounds(150, 277, 200, 60);	
		workbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				doEncryption();
			}
		});
		add(workbt);
		
		jtb = new JTable(5,5) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		 
		jtb.setBounds(640, 130, 300, 300);
		jtb.setRowHeight(60);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = jtb.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		//전체 열에 지정
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){
			tcm.getColumn(i).setCellRenderer(dtcr);  
		}
		// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		add(jtb);
	}
	
	private void doEncryption() {
		work1(tf2.getText());
		
	}
	private void doDecryption() {
		
	}
	private void work1(String key) {
		char[] arr;
		ssangArr = new ArrayList<String>(); //바꾸기 전 쌍자암호를 저장
		key = key.replace(" ", "");
		key = key.toUpperCase();
		arr = key.toCharArray();
		for(int i=0 ; i<arr.length ; i++) {
			if(Character.toString(arr[i]).equals("Z")) {
				ssangArr.add("Q");
			}else {
				ssangArr.add(Character.toString(arr[i]));
			}
		}
		for(int i=0 ; i<ssangArr.size()-1 ; i=i+2) { 
			if(ssangArr.get(i).equals(ssangArr.get(i+1))){
				ssangArr.add(i+1,"X");
			}
		}
		if(ssangArr.size()%2!=0) {
			ssangArr.add("X");
		}
		String ssangzaStr = "";
		for(int i=0 ; i<ssangArr.size() ; i++) { 
			if(i%2==0&&i!=0) {
				ssangzaStr +=" ";
			}
			ssangzaStr += ssangArr.get(i); 
		}
		tf3.setText(ssangzaStr);
		
		work2(tf1.getText());
	}
	
	public void work2(String key) {
		board = new char[5][5];
		AmhoArr = new ArrayList<Character>();
		key = key.replace(" ", "");
		key = key.toUpperCase();
		
		// 중복글자 제거
		String result = ""; // 중복이 되지 않은 문자열을 저장할 문자열 생성
		for(int i = 0; i < key.length(); i++) { // i가 0부터 사용자가 입력한 문자열의 길이만큼 반복문을 돌린다.
			if(!result.contains(String.valueOf(key.charAt(i)))) { // 사용자가 입력받은 문자열의 i번째 문자를 String으로 바꾸고 result에 이 문자가 포함되어 있지 않다면
				result += String.valueOf(key.charAt(i));  // result에 계속 추가, 즉 중복되지 않으면 추가
			}
		}
		
		// 남는 암호판에 알파벳 채우기
		for(char i='A'; i<'Z'; i++) {
			if(!result.contains(String.valueOf(i))) { // 사용자가 입력받은 문자열의 i번째 문자를 String으로 바꾸고 result에 이 문자가 포함되어 있지 않다면
				result += String.valueOf(i);  // result에 계속 추가, 즉 중복되지 않으면 추가
			}
		}
		
		// 암호판에 들어갈 글자 string에서 배열에 담기
		int num=0;
		for(int j=0; j<board.length; j++) {
			for(int k = 0; k<board[j].length; k++) {
				board[j][k] = result.charAt(num);
				num++;
			}
		}
			
		// 암호판 출력
		for(int j=0; j<board.length; j++) {
			for(int k = 0; k<board[j].length; k++) {
				jtb.setValueAt(board[j][k], j, k);
			}
		}
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //쌍자 암호 두 글자의 각각의 행,열 
		for(int i = 0 ; i < ssangArr.size()-1 ; i=i+2 )
		{
			
			char[] tmpArr = new char[2];
			for( int j = 0 ; j < board.length ; j++ ) //쌍자암호의 각각 위치체크
			{
				for( int k = 0 ; k < board[j].length ; k++ )
				{
					if(Character.toString(board[j][k]).equals(ssangArr.get(i)))
					{
						x1 = j;
						y1 = k;
					}
					if(Character.toString(board[j][k]).equals(ssangArr.get(i+1)))
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			if(x1==x2) //행이 같은경우
			{
				tmpArr[0] = board[x1][(y1+1)%5];
				tmpArr[1] = board[x2][(y2+1)%5];
			}
			else if(y1==y2) //열이 같은 경우
			{
				tmpArr[0] = board[(x1+1)%5][y1];
				tmpArr[1] = board[(x2+1)%5][y2];
			} 
			else //행, 열 모두 다른경우
			{
				tmpArr[0] = board[x2][y1];
				tmpArr[1] = board[x1][y2];
			}
			AmhoArr.add(tmpArr[0]);
			AmhoArr.add(tmpArr[1]);
			
		}
		String amhoStr = "";
		for(int i=0 ; i<AmhoArr.size() ; i++) { 
			if(i%2==0&&i!=0) {
				amhoStr +=" ";
			}
			amhoStr += AmhoArr.get(i); 
		}
		tf4.setText(amhoStr);
	}
	public void work3() {
		
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub	
		super.paintComponent(g);
		g.drawImage(back, 0, 0, this); // 뒷배경
	}

}
