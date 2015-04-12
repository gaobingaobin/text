package com.io.flie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//将System.in这个字节输入流变为字符输入流
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 使用缓冲区从键盘读入内容
		*/
		String str = null;
		System.out.println("请输入内容");
		try{
			str = buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
     System.out.println("你输入的内容为："+str);
	}

	

}
