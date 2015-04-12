package com.io.flie;

import java.io.IOException;

public class Hello {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Send S = new Send();
		Recive R = new Recive();
		try{
			S.getOut().connect(R.getInput());
		}catch(Exception e){
			e.printStackTrace();
		}
		new Thread(S).start();
		new Thread(R).start();

	}

}
