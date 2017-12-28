package url;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTestClient {

	public static void main(String[] args) throws IOException{
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8789;
		byte[] data = "ÓÃ»§Ãû£ºadmin;ÃÜÂë£º897823".getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		byte[] data2 = new byte[1024];
		DatagramPacket p = new DatagramPacket(data2,data.length);
		socket.receive(p);
		String reply = new String(data2,0,p.getLength());
		System.out.println(reply);
		socket.close();
	}
}
