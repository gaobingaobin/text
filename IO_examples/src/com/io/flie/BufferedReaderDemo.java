package com.io.flie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��System.in����ֽ���������Ϊ�ַ�������
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * ʹ�û������Ӽ��̶�������
		*/
		String str = null;
		System.out.println("����������");
		try{
			str = buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
     System.out.println("�����������Ϊ��"+str);
	}

	

}
