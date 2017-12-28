import java.io.File;
import java.io.IOException;
import java.util.*;

public class fileuser {

	public static void main(String[] args) throws IOException{
		File file=new File("e:\\JqueryMobile");
		if(!file.exists()){
			file.mkdir();
			System.out.println("文件不存在");
		}
		file.listFiles();
	}
}
