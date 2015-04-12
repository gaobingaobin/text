package com.io.flie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       File f = new File("f:"+File.separator+"hello.txt");
       File zip = new File("f:"+File.separator+"hello.zip");
       FileInputStream input= new FileInputStream(f);
       ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zip));
       zipOut.putNextEntry(new ZipEntry(f.getName()));
       zipOut.setComment("hello");
       int temp = 0;
       while((temp = input.read())!=-1)
       {
    	   zipOut.write(temp);
       }
       input.close();
       zipOut.close();
    
       }
      
	}

