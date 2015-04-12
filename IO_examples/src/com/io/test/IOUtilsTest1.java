package com.io.test;

import java.io.IOException;

import com.io.flie.IOUtils;

public class IOUtilsTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
               try {
				IOUtils.PrintHex("C:\\Users\\Administrator\\Desktop\\2015.3.31.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
