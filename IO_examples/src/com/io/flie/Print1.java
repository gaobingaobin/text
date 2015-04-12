package com.io.flie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Print1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("f:"+File.separator+"IO.txt");
		System.err.println("这些在控制条输出");
		/**
		 * System.err重定向 这个例子也提示我们可以使用这种方法保存错误信息
		 * */
		try{
			System.setErr(new PrintStream(new FileOutputStream(f,true)));
		}catch(Exception e){
			e.printStackTrace();
		}
        System.err.println("gaobin");
	}

}
