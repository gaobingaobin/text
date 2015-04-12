package com.io.flie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*
 * 输入输出重定向
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
		System.out.println("这些内容在文件中才能看到！");
	}

}
