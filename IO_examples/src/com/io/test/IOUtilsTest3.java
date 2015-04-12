package com.io.test;

import java.io.File;
import java.io.IOException;

import com.io.flie.IOUtils;

public class IOUtilsTest3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		IOUtils.copyFile(new File("C:\\Users\\Administrator\\Desktop\\2015.3.31.txt"),
				new File( "C:\\Users\\Administrator\\Desktop\\2015.3.32.txt"));

	}

}
