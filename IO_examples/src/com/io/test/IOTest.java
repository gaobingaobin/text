package com.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String fileName = "F:"+File.separator+"IO.txt";
		File f = new File(fileName);
		if(!f.exists())
		{
			throw new IllegalArgumentException(fileName+"������");
		}
		if(!f.isFile())
		{
			throw new IllegalArgumentException(fileName+"�����ļ�");
		}
		FileOutputStream out = new FileOutputStream(f,true);
		
		String str = "\r\ngaobin";//���Ի���
		byte[] b = str.getBytes();
		for(int i = 0; i<b.length; i++)
		{
			out.write(b[i]);
		}
		out.close();
 
	}

}
