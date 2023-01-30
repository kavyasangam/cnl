package udps;
import java.net.*;
import java.net.InetAddress;

public class UDPS {
	public static void main(String args[])throws Exception
	{
		DatagramSocket serverSocket=new DatagramSocket(9876);
		byte[] receiveData=new byte[1024];
		byte[] sendData=new byte[1024];
		while(true)
		{
			System.out.println("server is up:");
			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence=new String(receivePacket.getData());
			System.out.println("RECEIVED:"+sentence);
			InetAddress IPAddress=receivePacket.getAddress();
			int port=receivePacket.getPort();
			String CapitalizedSentence=sentence.toUpperCase();
			sendData=CapitalizedSentence.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
			serverSocket.send(sendPacket);
		}
	}
}