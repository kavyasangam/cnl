package leakybucket;
import java.util.*;
public class Leakybucket {
	public final static int max=25;
	static int min(int a,int b)
	{
		if(a<b)
			return a;
		return b;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int cap,optr,ch,count,nsec,i=0;
		int inp[]=new int[max];
		System.out.println("leaky bucket algo");
		System.out.println("enter the leaky bucket size:");
		cap=scan.nextInt();
		System.out.println("enter the output rate:");
		optr=scan.nextInt();
		do
		{
			System.out.println("enter the packet received at"+(i+1)+"seconds");
			inp[i]=scan.nextInt();
			i++;
			System.out.println("enter 1 to send more packet else 0 to quit:");
			ch=scan.nextInt();
		}while(ch!=0);
		nsec=i;
		System.out.println("n(seconds):(pkt received):(pkt in bucket):(packsend):(packleft)");
		count=0;
		for(i=0;i<nsec;i++) {
			count+=inp[i];
			if(count>cap) {
		System.out.println("accept the incoming packet from bucket");
		System.out.println("the excess the rejected packet from at"+(i+1)+"sec in"+(count-cap));
		count=cap;
		System.out.println();
	}
	System.out.print("c("+(i+1)+ "):");
	System.out.print("\t\t(" +inp[i]+ "):");
	System.out.print("\t\t(" +count+ "):");
	System.out.print("\t\t(" +min(count,optr)+ "):");
	count=count-min(count,optr);
	System.out.print("\t\t(" +count+ "):");
	System.out.println();
		}		
	}	
}

