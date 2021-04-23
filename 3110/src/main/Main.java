package main;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends ListenerAdapter{ 
	// �ʿ��� �޼��带 �׶��׶� �������̵� �ϱ� ���ؼ� ���� �߻�Ŭ������ ���� ��ӹ�����
	// ���⼭ ��� implement �޾Ƶθ� �� ���� �޼��嵵 �������̵� �ؾ� ��
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
		frame.setTitle("��ȣȭ"); // ���α׷� �̸� ����
		frame.setSize(1161,658);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cl = new CardLayout();
		frame.getContentPane().setLayout(cl); // �������� ī�巹�̾ƿ����� ����
		
		// �гο� main�� �ִ� �����ʸ� �־���
		encryption = new Encryption(this); 
		
		// ��� �г��� ���̾ƿ��� null�� ��ȯ
		encryption.setLayout(null);
		
		// �����ӿ� �гε��� �߰��Ѵ�.(ī�� ���̾ƿ��� ���� �гε�)
		frame.getContentPane().add(encryption, "encryption");
		
		cl.show(frame.getContentPane(), "encryption"); 
		encryption.requestFocus(); 
		
		frame.setVisible(true); // â ���̰��ϱ�
	}
	
	@Override
	public void mousePressed(MouseEvent e) { // mouseClicked�� ���氡��
		
	}
}
