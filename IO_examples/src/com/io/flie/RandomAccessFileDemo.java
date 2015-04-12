package com.io.flie;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	

	public static void main(String[] args) throws IOException{
		File demo = new File("demo");
		if(!demo.exists())demo.mkdir();
		
		File file = new File(demo,"raf.bat");
		if(!file.exists())
			file.createNewFile();
		//打开文件 ，进行随机操作
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		int i = 0x7ffffff;
		//序列化
		raf.write(i>>>24);
		raf.write(i>>>16);
		raf.write(i>>>8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		//反序列化
		raf.seek(0);//将指针定位到0位置
		int b=raf.read();
		i = i | (b<<24);
		b=raf.read();
		i = i | (b>>16);
		b = raf.read();
		i = i | (b<<8);
		b= raf.read();
		i = i |(b);
		System.out.println(Integer.toHexString(i));//将整型转换味16进制的字符串
		
		
		
		
		
	}


}
