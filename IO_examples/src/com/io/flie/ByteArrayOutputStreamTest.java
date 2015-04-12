package com.io.flie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
	/*
	 * 
	 * ǰ���оٵ�������붼�����ļ����еģ���������������Ϊ�������Ŀ�ĵأ�ʹ���ڴ������
 

      ByteArrayInputStream ��Ҫ������д������
 

     ByteArrayOutputStream  ��Ҫ�����ݴ��ڴ����
 

                  ʹ���ڴ��������һ����д��ĸת��ΪСд��ĸ
*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str="GGGEOOOONN";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		while((temp=input.read())!=-1)
		{
			char ch = (char)temp;
			output.write(Character.toLowerCase(ch));
		}
		String outStr = output.toString();
		input.close();
		System.out.println(outStr);
		

	}

}
