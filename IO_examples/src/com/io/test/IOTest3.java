package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class IOTest3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    String fileName = "d:"+File.separator+"IO.txt";
    File f = new  File(fileName);
    Writer out =new  OutputStreamWriter(new FileOutputStream(f));
    FileInputStream in = new  FileInputStream(f);
    out.write("gaobin");
    out.close();
   
	}


	

}
