package com.io.flie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Print1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("f:"+File.separator+"IO.txt");
		System.err.println("��Щ�ڿ��������");
		/**
		 * System.err�ض��� �������Ҳ��ʾ���ǿ���ʹ�����ַ������������Ϣ
		 * */
		try{
			System.setErr(new PrintStream(new FileOutputStream(f,true)));
		}catch(Exception e){
			e.printStackTrace();
		}
        System.err.println("gaobin");
	}

}
