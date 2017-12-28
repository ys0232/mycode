package Implementation;
import java.util.*;

public class RepeatedString {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		long n=sc.nextLong();
		sc.close();
		long len=s.length();
		long count=0;
		int cc=0;
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='a')
				count++;
			if(s.charAt(i)=='a' && i<n%len)
				cc++;
		}
		count=count*(n/len)+cc;
		System.out.println(count);
	}
}
