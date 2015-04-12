package com.io.flie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {
	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨
	 * ����ÿ���10��byte����
	 * @param fileName
	 * ���ֽڶ�ȡ���ʺϴ��ļ������ļ�Ч�ʺܵ�
	 */
	public static void PrintHex(String Filename) throws IOException{
		//���ļ���Ϊ�ֽ������������
		FileInputStream in = new FileInputStream(Filename);
		int b;
		int i = 1;
		while((b = in.read())!=-1)
		{
			if(b<=0xf)
			{
				//����ǰ�油0
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
		/*��in��������ȡ�ֽڣ����뵽buf����ֽ������У�
		 * �ӵ�0��λ�ÿ�ʼ�ţ�����buf.length�� 
		 * ���ص��Ƕ������ֽڵĸ���
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
 * �ļ��������ֽ�������ȡ

*/
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ�:"+srcFile+"������");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int c ;
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//ˢ�»�����
		}
		bis.close();
		bos.close();
	}
	/*
	 * ���ļ����������ô�������ֽ���

*/
	public static void copyFileBuffer(File srcfile, File destfile) throws IOException
	{
		if(!srcfile.exists())
		{
			throw new IllegalArgumentException("�ļ���"+srcfile+"������");
		}
		if(!srcfile.isFile())
		{
			throw new IllegalArgumentException(srcfile+"�����ļ�");
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
