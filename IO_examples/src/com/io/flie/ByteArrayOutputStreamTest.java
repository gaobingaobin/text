package com.io.flie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
	/*
	 * 
	 * 前面列举的输出输入都是以文件进行的，现在我们以内容为输出输入目的地，使用内存操作流
 

      ByteArrayInputStream 主要将内容写入内容
 

     ByteArrayOutputStream  主要将内容从内存输出
 

                  使用内存操作流将一个大写字母转化为小写字母
*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="GGGEOOOONN";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		while((temp=input.read())!=-1)
		{
			char ch = (char)temp;
			output.write(Character.toLowerCase(ch));
		}
		String outStr = output.toString();
		input.close();
		System.out.println(outStr);
		

	}

}
