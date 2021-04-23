package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String key1="monarchy";
		System.out.print("암호키 : " + key1);
		//key1 = scan.next();
		
		String key2="He is a murderer";
		System.out.println("암호화할 문장 : " + key2);
		//key2 = scan.next();
		System.out.println("------------------");
		// 암호화 할 쌍자
		//work1(key2);
		work2(key1);
	}
	public static void work2(String key) {
		char[][] board = new char[5][5];
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
				System.out.print(board[j][k] + " ");
			}
			System.out.println("");
		}
		
	}
	public static void work1(String key) {
		char[] arr;
		ArrayList<String> arr1 = new ArrayList<String>(); //바꾸기 전 쌍자암호를 저장
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
