package chapter15;
import java.io.*;

class Person implements Serializable{
	int id;
	String name;
	transient int age;//Now it will not be serialized
	public Person(int id, String name,int age) {
		this.id = id;
		this.name = name;
		this.age=age;
	}
}

public class DeserializationEx1{
	public static void main(String args[])throws Exception{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:\\Test.txt "));
		Person s=(Person)in.readObject();
		System.out.println(s.id+" "+s.name+" "+s.age);
		in.close();
		System.out.println("Object stored in the file c:\\Test.txt  successfully");
	}
}

