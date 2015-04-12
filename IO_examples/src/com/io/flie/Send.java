package com.io.flie;

import java.io.IOException;
import java.io.PipedOutputStream;
/*
 * 消息发送类
*/
public class Send implements Runnable {
	 private PipedOutputStream out = null;
	 public Send()
	 {
		 out = new PipedOutputStream();
	 }
	 public PipedOutputStream getOut()
	 {
		 return this.out;
		 
	 }
	 public void run()
	 {
		 String message = "hello gaobin";
		 try {
			out.write(message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try{
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	 }
	
	 
	
 
}
