package url;
import java.io.*;
import java.net.*;

public class EchoServer {
    private int port=8000;
    private ServerSocket serverSocket;
    
    public EchoServer() throws IOException{
        serverSocket=new ServerSocket(port);
        System.out.println("����������");
        }
    public String echo(String msg){
        return "echo:"+msg;
    }
    public PrintWriter getWriter(Socket socket)throws IOException{
        OutputStream socketOut=socket.getOutputStream();
        return new PrintWriter(socketOut,true);
    }
    public BufferedReader getReader(Socket socket)throws IOException{
        InputStream socketIn=socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }
    public void service(){
        while(true){
            Socket socket=null;
            try{
                socket=serverSocket.accept();//�ȴ��ͻ�������
                System.out.println("New aonnection accepted"
                                        +socket.getInetAddress()+":"
                                        +socket.getPort());
                BufferedReader br=getReader(socket);
                PrintWriter pw=getWriter(socket);
                
                String msg=null;
                while((msg=br.readLine())!=null){
                    System.out.println(msg);
                   pw.println(echo(msg));
                    if(msg.equals("bye"));
                        break;
                }
            }catch(IOException e){e.printStackTrace();
            }finally{
                try{
                    if(socket!=null)
                        socket.close();
                }catch(IOException e){e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        new EchoServer().service();
    }

}