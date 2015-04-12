package com.io.flie;

import java.io.Serializable;

public class Student implements Serializable{
	private int number;
	private String name;
	private transient int age;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(){}
	public Student(int number, String name, int age) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", age=" + age
				+ "]";
	}
	
	 private void writeObject(java.io.ObjectOutputStream s)
		        throws java.io.IOException{
		 s.defaultWriteObject();//��jvm��Ĭ�����л���Ԫ�ؽ������л�����
		 s.writeInt(age);//�Լ����stuage�����л�
	 }
	 private void readObject(java.io.ObjectInputStream s)
		        throws java.io.IOException, ClassNotFoundException{
		  s.defaultReadObject();//��jvm��Ĭ�Ϸ����л���Ԫ�ؽ��з����л�����
		  this.age = s.readInt();//�Լ����stuage�ķ����л�����
	}

}
