package com.io.flie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

//合并流

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	/*	
	 * 将两个文本文件合并为另一个文本文件
		*/
		File file1 = new File("f:"+File.separator+"hello1.txt");
		File file2 = new File("f:"+File.separator+"hello2.txt");
		File file = new File("f:"+File.separator+"hello.txt");
		if(!file1.exists())
		{
			 file1.createNewFile();
		}
		if(!file2.exists())
		{
			 file2.createNewFile();
		}
		if(!file.exists())
		{
			 file.createNewFile();
		}
		FileInputStream input1 = new FileInputStream(file1);
		FileInputStream input2 = new FileInputStream(file2);
		FileOutputStream output = new FileOutputStream(file);
		SequenceInputStream sis = new SequenceInputStream(input1,input2); //合并流
		int temp = 0;
		while((temp =sis.read())!=-1){
			output.write(temp);
		}
		input1.close();
		input2.close();
		output.close();
		sis.close();

	}

}
