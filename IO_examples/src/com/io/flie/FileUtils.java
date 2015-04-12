package com.io.flie;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	
	public static void ListDirectory (File dir)throws IOException
	{
		if(!dir.exists())
		{
			throw new IllegalArgumentException(dir+"�ļ�������");
		}
		if(!dir.isDirectory())
		{
			throw new IllegalArgumentException(dir+"�����ļ���");
		}
		//Ҫ������Ŀ¼���ļ��ı�������Ҫ��File���б���������File�ṩֱ�ӷ���file�����API
		File[] files = dir.listFiles();//������Ŀ¼�ĳ���
		if(files!=null&&files.length>0){
		for (File file : files) {
			if(file.isDirectory())
			{
				ListDirectory(file);
			}
			else
			{
				System.out.println(file);
			}
		}
		}
	}
	

}
