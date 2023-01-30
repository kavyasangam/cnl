package ford;
import java.util.Scanner;
public class Fords {
	private int D[];
	private int num_ver;
	public static final int max_value=999;
	public Fords(int num_ver)
	{
		this.num_ver=num_ver;
	    D=new int[num_ver+1];
	}
public void BellmanFordEvalution(int source,int A[][])
{
	for(int node=1;node<=num_ver;node++)
	{
		D[node]=max_value;
	}
	D[source]=0;
	for(int node=1;node<=num_ver-1;node++)
	{
		for(int sn=1;sn<=num_ver;sn++)
		{
			for(int dn=1;dn<=num_ver;dn++)
			{
				if(A[sn][dn]!=max_value)
				{
					if(D[dn]>D[sn]+A[sn][dn])
						D[dn]=D[sn]+A[sn][dn];
				}
			}
		}
		for(int sn=1;sn<=num_ver;sn++)
		{
			for(int dn=1;dn<=num_ver;dn++)
			{
				if(A[sn][dn]!=max_value)
				{
					if(D[dn]>D[sn]+A[sn][dn])
				System.out.println("the graph contain negative edge cycle\n");
				}
			}
		}
		for(int vertex=1;vertex<=num_ver;vertex++)
			System.out.println("distance of source"+source+"to"+vertex+"is"+D[vertex]);	
	}
}
public static void main(String args[])
{
	int num_ver=0;
	int source;
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the no.of vertices:\n");
	num_ver=scanner.nextInt();
	int A[][]=new int[num_ver+1][num_ver+1];
	System.out.println("enter the adjacency:\n");
	{
		for(int sn=1;sn<=num_ver;sn++)
		{
		for(int dn=1;dn<=num_ver;dn++)
		{
			A[sn][dn]=scanner.nextInt();
			if(sn==dn)
			{
			A[sn][dn]=0;
				continue;
				
			}
			if(A[sn][dn]==0)
			{
				A[sn][dn]=max_value;
			}
		}
	}
	System.out.println("enter the source vertex");
	source=scanner.nextInt();
	Ford b= new Ford(num_ver);
	b.BellmanFordEvalution(source,A);
	scanner.close();
}
}
}

