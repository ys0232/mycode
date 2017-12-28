package url;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class socketTestClient {

	public static void main(String[] args )throws IOException{
		Socket	socket = new Socket("localhost",9088);
		System.out.println("客户端已启动！");
		OutputStream os=socket.getOutputStream();
		PrintWriter pw =new PrintWriter(os);
		pw.println("用户名：admin；密码：123455");
		pw.flush();
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String msg = br.readLine();
		System.out.println(msg);
	
		socket.shutdownInput();
		is.close();isr.close();
		br.close();
		pw.close();
		os.close();
		socket.close();
		
	}
}
