package url;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class socketTestSever{


	public static void main(String[] args) throws IOException{
		ServerSocket sock = new ServerSocket(8989);
		System.out.println("��������������");
		Socket so=sock.accept();
		InputStream is=so.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		String info=null;
		OutputStream os = so.getOutputStream();
		PrintWriter pw= new PrintWriter(os);
		info=br.readLine();
			System.out.println("���Ƿ����������յ��ͻ��˵���Ϣ��"+info);
			pw.println(info);
			pw.flush();
		so.shutdownInput();
		br.close();
		isr.close();
		is.close();
		os.close();
		pw.close();
		so.close();
		sock.close();
	}

}
