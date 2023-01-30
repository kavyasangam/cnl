package crc1;
import java.util.Scanner;
import java.io.*;
public class CRC1 {
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the message:");
    String message=sc.nextLine();
    System.out.println("enter the generator:");
    String generator=sc.nextLine();
    int data[]=new int[message.length()+generator.length()-1];
    int divisor[]=new int[generator.length()];
    for(int i=0;i<message.length();i++)
    data[i]=Integer.parseInt(message.charAt(i)+"");
    for(int i=0;i<generator.length();i++)
    	divisor[i]=Integer.parseInt(generator.charAt(i)+"");
    for(int i=0;i<message.length();i++)
    {
    	if(data[i]==1)
    		for(int j=0;j<divisor.length;j++)
    			data[i+j]^=data[j];
    }
    System.out.println("the checksum code is:\t");
    for(int i=0;i<message.length();i++)
    	data[i]=Integer.parseInt(message.charAt(i)+"");
    for(int i=0;i<data.length;i++)
    	System.out.println(data[i]);
    System.out.println();
    System.out.println("enter the checksum code:");
    message=sc.nextLine();
    System.out.println("enter the generator:");
    generator=sc.nextLine();
    data=new int[message.length()+generator.length()-1];
    divisor=new int[generator.length()];
    for(int i=0;i<message.length();i++)
    	data[i]=Integer.parseInt(message.charAt(i)+"");
    for(int i=0;i<generator.length();i++)
    	divisor[i]=Integer.parseInt(generator.charAt(i)+"");
    for(int i=0;i<message.length();i++)
    {
    	if(data[i]==1)
    		for(int j=0;j<divisor.length;j++)
    			data[i+j]^=data[j];
    }
    boolean valid=true;
    for(int i=0;i<data.length;i++)
    	if(data[i]==1)
    	{
    		valid=false;
    		break;
    }
    if(valid==true)
    	System.out.println("stream is valid\n");
    	else
    		System.out.println("stream is invalid\n");
}
    }
    
    
    
