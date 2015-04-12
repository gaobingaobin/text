package com.io.test;

import java.io.IOException;

import com.io.flie.IOUtils;

public class IOUtilsTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			long start = System.currentTimeMillis();
			IOUtils.printHexBy("C:\\Users\\Administrator\\Desktop\\2015.3.31.txt");
			System.out.println();
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
