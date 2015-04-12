package com.io.flie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SystemIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("f:"+File.separator+"IO.txt");
		if(!f.exists()){
			return;
		}else{
			try{
				System.setIn(new FileInputStream(f));
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			byte[] bytes = new byte[1024];
			int len = 0;
			try{
				len = System.in.read(bytes);
				
			}catch(IOException e){
				e.printStackTrace();
			}
	
		System.out.println("读入的内容为:"+new String(bytes,0,len));
		}
	}

}
