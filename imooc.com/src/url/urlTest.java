package url;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class urlTest {

	public static void main(String[] args) throws IOException{
		URL url=new URL("http://www.imooc.com/learn/122");
		InputStream is=url.openStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		String data=br.readLine();
		while(data!=null){
			System.out.println(data);
			data=br.readLine();
		}
		br.close();
		isr.close();
		is.close();		
	}
}
