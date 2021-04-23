package main;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends ListenerAdapter{ 
	// 필요한 메서드를 그때그때 오버라이드 하기 위해서 따로 추상클래스를 빼서 상속받은듯
	// 여기서 모두 implement 받아두면 안 쓰는 메서드도 오버라이드 해야 함
	private JFrame frame;
	private Encryption encryption;
	private CardLayout cl;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
	}
	
	public Main() {
		init();
	}
	
	public CardLayout getCl() {
		return cl;
	}
	
	private void init() {
		frame = new JFrame();
		frame.setTitle("암호화"); // 프로그램 이름 지정
		frame.setSize(1161,658);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cl = new CardLayout();
		frame.getContentPane().setLayout(cl); // 프레임을 카드레이아웃으로 변경
		
		// 패널에 main에 있는 리스너를 넣어줌
		encryption = new Encryption(this); 
		
		// 모든 패널의 레이아웃을 null로 변환
		encryption.setLayout(null);
		
		// 프레임에 패널들을 추가한다.(카드 레이아웃을 위한 패널들)
		frame.getContentPane().add(encryption, "encryption");
		
		cl.show(frame.getContentPane(), "encryption"); 
		encryption.requestFocus(); 
		
		frame.setVisible(true); // 창 보이게하기
	}
	
	@Override
	public void mousePressed(MouseEvent e) { // mouseClicked로 변경가능
		
	}
}
