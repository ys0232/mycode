package url;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{

	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
		
	}
	public void run(){
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try{
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str = null;
			while((str = br.readLine())!=null){
				System.out.println(str);
			}
			socket.shutdownInput();
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("»¶Ó­Äú£¡");
			pw.flush();
		}catch(IOException e){
			 e.printStackTrace();
        }finally{
            if(pw != null)
            	pw.close();
            if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            if(isr != null)
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            if(is != null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
            
        }
		}
	}

