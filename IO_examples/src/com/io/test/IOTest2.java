package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "F:"+File.separator+"IO.txt";
		
		File f = new File(fileName);
		if(!f.exists())
		{
			throw new IllegalArgumentException(fileName+"不存在");
		}
		if(!f.isFile())
		{
			throw new IllegalArgumentException(fileName+"不是文件");
		}
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		int c;
		while((c = in.read())!=-1)//当读到文件末尾的时候会返回-1.正常情况下是不会返回-1的
		{
			in.read(b);
		}
		in.close();
		System.out.println(new String(b));

	}

}
