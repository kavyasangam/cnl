package rsa;
import java.util.*;
import java.math.*;
public class Rsa {
	static Scanner scan=new Scanner(System.in);
	static int p,q,n,z,e,d,ed[],dd[],num[];
	static BigInteger temp;
	static String msg;
	static int gcd(int a,int b)
	{
		if(a==0)
			return b;
		return gcd(b%a,a);
	}
	static void rsaAlg(String msg)
	{
		p=7;
		q=11;
		n=p*q;
		z=(p-1)*(q-1);
		for(int i=2;i<z;i++)
			if(gcd(i,z)==1)
			{
				e=i;
				break;
			}
		for(int i=2;i<z;i++)
			if((e*i)%z==1)
			{
				d=i;
				break;
			}
		System.out.println("p= "+p+ "q= "+q+ "\nn= "+n+ "z= "+z+ "\ne= "+e+ "d= "+d);
		num=new int[msg.length()];
		ed=new int[msg.length()];
		dd=new int[msg.length()];
		for(int i=0;i<msg.length();i++)
			num[i]=msg.charAt(i)-'a'+1;
		for(int i=0;i<msg.length();i++)
		{
			temp=new BigInteger(Integer.toString(num[i]));
		temp=temp.pow(e);
		temp=temp.mod(new BigInteger(Integer.toString(n)));
		ed[i]=temp.intValue();
		}
		System.out.println("encrypted data");
		for(int i=0;i<msg.length();i++)
			System.out.println(ed[i]);
		System.out.println();
		
		for(int i=0;i<msg.length();i++)
		{
			temp=new BigInteger(Integer.toString(ed[i]));
		temp=temp.pow(d);
		temp=temp.mod(new BigInteger(Integer.toString(n)));
		dd[i]=temp.intValue();
		}
		System.out.println("decrypted data");
		for(int i=0;i<msg.length();i++)
			System.out.print((char)(dd[i]+'a'-1));
		System.out.println();
	}
	public static void main(String args[]) {
	System.out.println("enter the msg:");
	msg=scan.next();
	rsaAlg(msg);
	}
}
	
