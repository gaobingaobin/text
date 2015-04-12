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
		 s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
		 s.writeInt(age);//自己完成stuage的序列化
	 }
	 private void readObject(java.io.ObjectInputStream s)
		        throws java.io.IOException, ClassNotFoundException{
		  s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
		  this.age = s.readInt();//自己完成stuage的反序列化操作
	}

}
