package com.io.flie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo {
  public static void main(String[] args) throws Exception  {
	String file = "demo"+File.separator+"raf.bat";
	ObjectSeriaDemo f = new ObjectSeriaDemo();
	//f.Xuliehua(file);
    f.Fan(file);
	
	
	
}
 public void Xuliehua(String file) throws FileNotFoundException, IOException{
	 /*
	 * ��������л�
	 * 
	 * */
	 ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));
			             Student stu = new Student(10001, "����", 20);
			             oos.writeObject(stu);
			              oos.flush();
			              oos.close();
 }
public void Fan(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
	//�����л�
		ObjectInputStream iss = new ObjectInputStream(new  FileInputStream(file));
		Student stu = (Student)iss.readObject();
		System.out.println(stu);
		iss.close();
}
}
