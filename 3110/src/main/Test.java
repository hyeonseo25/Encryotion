package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String key1="monarchy";
		System.out.print("��ȣŰ : " + key1);
		//key1 = scan.next();
		
		String key2="He is a murderer";
		System.out.println("��ȣȭ�� ���� : " + key2);
		//key2 = scan.next();
		System.out.println("------------------");
		// ��ȣȭ �� ����
		//work1(key2);
		work2(key1);
	}
	public static void work2(String key) {
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
				System.out.print(board[j][k] + " ");
			}
			System.out.println("");
		}
		
	}
	public static void work1(String key) {
		char[] arr;
		ArrayList<String> arr1 = new ArrayList<String>(); //�ٲٱ� �� ���ھ�ȣ�� ����
		key = key.replace(" ", "");
		key = key.toUpperCase();
		System.out.println(key);
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
		System.out.println("");
		
		for(int i=0 ; i<arr1.size() ; i++) { 
			if(i%2==0&&i!=0) {
				System.out.print(" ");
			}
			System.out.print(arr1.get(i)); 
		}
	}

}
