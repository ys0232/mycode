package ThirdDaysTest;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class day28 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] str=new String[N];
		String[] tmp=new String[N];
		String delimiter="@";
		int k=0;
		for(int i=0;i<N;i++){
			String firstName=sc.next();
			String emailID=sc.next();
			tmp=emailID.split(delimiter);
			if(tmp[1].equals("gmail.com")){
				str[k++]=firstName;
				}
		}
		int i=0;
		while(str[i]!=null){
			i++;
		}
		String[] firstStr=new String[i];
		for(int j=0;str[j]!=null;j++){
			firstStr[j]=str[j];
		}
		Arrays.sort(firstStr);
		sc.close();
	for(int j=0;j<firstStr.length;j++)
		System.out.println(firstStr[j]);
		
		
	}

}
