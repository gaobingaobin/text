package com.io.flie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*
 * ��������ض���
*/
public class Print {
	public static void main(String[] args) {
		System.out.println("hello");
		File f = new File("F:"+File.separator+"IO.txt");
		try{
			System.setOut(new PrintStream(new FileOutputStream(f)));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("��Щ�������ļ��в��ܿ�����");
	}

}
