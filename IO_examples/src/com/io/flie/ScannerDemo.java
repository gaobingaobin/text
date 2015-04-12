package com.io.flie;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		/*
		 * Scanner的小例子， 从键盘读取数据
		
*/
		Scanner sca = new Scanner(System.in);
		//读取一个整数
		int temp = sca.nextInt();
		System.out.println("输入的数为："+temp);
		float flo = sca.nextFloat();
		System.out.println("输入浮点数"+flo);
		
	}

}
