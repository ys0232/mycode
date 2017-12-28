package url;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = new ServerSocket(9088);
		Socket socket = null;
		while(true){
			socket=serversocket.accept();
			ServerThread serverThread = new ServerThread(socket);
			serverThread.start();
			
		}
		
	}
}
