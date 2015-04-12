package com.io.test;

import java.io.File;
import java.io.IOException;

import com.io.flie.IOUtils;

public class IOUtilsTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			long start = System.currentTimeMillis();
			IOUtils.copyFileBuffer(new File("F:"+File.separator+"IO.txt"),
					new File("F:"+File.separator+"IO1.txt"));
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
