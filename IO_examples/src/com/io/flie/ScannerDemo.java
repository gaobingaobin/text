package com.io.flie;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		/*
		 * Scanner��С���ӣ� �Ӽ��̶�ȡ����
		
*/
		Scanner sca = new Scanner(System.in);
		//��ȡһ������
		int temp = sca.nextInt();
		System.out.println("�������Ϊ��"+temp);
		float flo = sca.nextFloat();
		System.out.println("���븡����"+flo);
		
	}

}
