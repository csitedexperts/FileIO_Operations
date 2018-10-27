package chapter15;
/* J15_08.java   */
/* Writing and Reading Objects in Data File  */
import java.io.*;
import java.util.*;
class Student{  
	int    Roll;
	String Name;
	double Mark;

	public Student( int R, String N, double M) {  
		Roll = R;
		Name = N;
		Mark = M;
	}
	public Student() // Empty Constructor
	{
	}
	public void WriteData(PrintWriter PR) throws IOException
	{  
		PR.println(Roll + "|" + Name + "|" + Mark); // | as delimiter
	}
	public void ReadData(BufferedReader in) throws IOException
	{  
		String Str = in.readLine();
		StringTokenizer t = new StringTokenizer(Str, "|");
		Roll = Integer.parseInt(t.nextToken());
		Name = t.nextToken();
		Mark = Double.parseDouble(t.nextToken());
	}
	public void display()
	{  
		System.out.println( Roll + "  " + Name + "  " + Mark); 
		// Blank Space ("  ") as delimiter
	}
}

public class J15_08{  
	static void WriteData(Student[] S, PrintWriter PR) 
			throws IOException
	{  
		PR.println(S.length);
		int i;
		for (i = 0; i < S.length; i++)
		{   
			S[i].WriteData(PR);
		}
	}
	static Student[] ReadData(BufferedReader BR) throws IOException
	{  
		int n = Integer.parseInt(BR.readLine());
		Student S[] = new Student[n];
		int i;
		for (i = 0; i < n; i++)
		{  
			S[i] = new Student();
			S[i].ReadData(BR);
		}
		return S;
	}
	public static void main(String[] args)
	{  
		Student s[] = new Student[4];
		s[0] = new Student(101, "Mira   ", 70.5);
		s[1] = new Student(102, "Masud  ", 75.5);
		s[2] = new Student(103, "Monira ", 85.5);
		s[3] = new Student(104, "Monirul", 80.5);
		int i;
		try{  
			PrintWriter PR = new PrintWriter(new 
					FileWriter("c:\\student.txt"));
			WriteData(s, PR);
			PR.close();
		}
		catch(IOException e)
		{  
			System.out.print("Error: " + e);
			System.exit(1);
		}
		try{  
			BufferedReader BR = new BufferedReader(new 
					FileReader("c:\\student.txt"));   
			Student S[] = ReadData(BR);
			System.out.println( "Roll  Name   Mark");
			System.out.println( "~~~~  ~~~~   ~~~~");
			for (i = 0; i < S.length; i++) 
			{
				S[i].display();
			}
			BR.close();
		}
		catch(IOException e)
		{  
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
}
