package url;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.*;
import java.net.InetAddress;
public class UDPTestServer {

	public static void main(String[] args)throws IOException{
		DatagramSocket socket = new DatagramSocket(8789);
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		socket.receive(packet);
		String str = new String(data, 0 ,packet.getLength());
		System.out.println(str);
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "»¶Ó­Äú£¡".getBytes();
		DatagramPacket p = new DatagramPacket(data2,data2.length,address,port);
		socket.send(p);
		socket.close();
		
		
	}
}
