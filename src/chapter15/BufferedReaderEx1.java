package chapter15;
import java.io.*; 
// https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/

public class BufferedReaderEx1 
{ 
    public static void main(String args[]) 
                  throws IOException 
    { 
        BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in)); 
        System.out.println("Enter an integer: "); 
        int a = Integer.parseInt(br.readLine()); 
        System.out.println("Enter a String: "); 
        String b = br.readLine(); 
        System.out.printf("You have entered:- " + a + 
                          " and name as " + b); 
    } 
} 