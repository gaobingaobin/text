package com.io.flie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {
	/**
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 * 单字节读取不适合大文件，大文件效率很低
	 */
	public static void PrintHex(String Filename) throws IOException{
		//把文件作为字节流做输出操作
		FileInputStream in = new FileInputStream(Filename);
		int b;
		int i = 1;
		while((b = in.read())!=-1)
		{
			if(b<=0xf)
			{
				//单数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"  ");
			if(i++%10==0)
			{
				System.out.println();
			}
		}
		in.close();
	}
/*
 * 
 * 
*/
	public static void printHexBy(String filename) throws IOException 
	{
		/*从in中批量读取字节，放入到buf这个字节数组中，
		 * 从第0个位置开始放，最多放buf.length个 
		 * 返回的是读到的字节的个数
		*/
		 FileInputStream in = new FileInputStream(filename);
		 byte[] buf = new byte[20*1024];
		 int bytes = 0;
		 int i = 1;
		 while((bytes = in.read(buf,0,buf.length))!=-1)
		 {
			 for(int j=1; j<bytes;j++)
			 {
				 System.out.print(Integer.toHexString(buf[j] & 0xff)+"  ");
				 
			 
			 if(i++%10==0)
			 {
				 System.out.println();
			 }
			 }
		 }
		 in.close();
		 
		
	}
/*
 * 文件拷贝，字节批量读取

*/
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件:"+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int c ;
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//刷新缓冲区
		}
		bis.close();
		bos.close();
	}
	/*
	 * 将文件拷贝，利用带缓冲的字节流

*/
	public static void copyFileBuffer(File srcfile, File destfile) throws IOException
	{
		if(!srcfile.exists())
		{
			throw new IllegalArgumentException("文件："+srcfile+"不存在");
		}
		if(!srcfile.isFile())
		{
			throw new IllegalArgumentException(srcfile+"不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcfile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destfile));
		int c;
		while((c = bis.read())!=-1)
		{
		
				bos.write(c);
		
			bos.flush();
			
		}
		bis.close();
		bos.close();
	}
	
}
