package com.io.flie;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	
	public static void ListDirectory (File dir)throws IOException
	{
		if(!dir.exists())
		{
			throw new IllegalArgumentException(dir+"文件不存在");
		}
		if(!dir.isDirectory())
		{
			throw new IllegalArgumentException(dir+"不是文件夹");
		}
		//要进行子目录下文件的遍历，就要对File进行遍历操作，File提供直接返回file对象的API
		File[] files = dir.listFiles();//返回子目录的抽象
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
