package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestFile {

	public void test() {

		// 파일 인풋 스트림

		// 파일 객체
		File f = new File("D:\\220407dev\\abc.txt");

		boolean result = f.isFile();
		System.out.println(result);

		// 파일에서 데이터 읽기
		// 1. 파일
		// 2. 인풋 스트림 (FileInputStream(1byte) FileReader(2char))

		// FileInputStream 사용시 문제
		// 1. 숫자로 나옴
		// 2. 한글자만 읽음
		
		FileReader fr = null;
		try {
			fr = new FileReader(f);
			int data;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch(FileNotFoundException fe) {
			System.out.println("파일 못찾음");
		} catch (IOException e) {
			System.out.println("입출력 예외 발생 !!");
		} finally {
			// 예외 발생 여부와 관계 없이 무조건 실행하는 코드
			try {fr.close();} catch (IOException e) {System.out.println("close 중 예외 발생");}
		}
		
	}
	
	public void test2() {
		
		System.out.println("글씨 입력하기");
		
		String str = new Scanner(System.in).nextLine();
		
		//파일에 글씨 쓰기
		
		//1. 파일 정보 얻기
		String path = "D:\\220407dev\\abc.txt";
		File f = new File(path);
		
		//2. 파일이랑 연결
		FileWriter fw = null; //finally close 위해
		try {
			fw = new FileWriter(f);
			//3. 데이터 전송
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			System.out.println("입출력 예외 발생");
		} finally {
			try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
		
	}

	public void test3() {
		
		//보조스트림 활용해서 입력받기 : BufferedReader
		
		//파일 객체 생성
		String path = "D:\\220407dev\\abc.txt";
		File f = new File(path);
		
		//스트림 생성
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch (IOException e) {
			System.out.println("읽기 에러");
		}
		
	}
	
}// class
