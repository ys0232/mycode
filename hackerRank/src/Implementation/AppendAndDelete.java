package Implementation;
import java.util.*;

public class AppendAndDelete {

	private static int AppendDelete(String s,String t){
		int count=0;
		char[] str=s.toCharArray();
		char[] tr=t.toCharArray();
		int i=0,j=0;
		while(i<str.length && j<tr.length){
			if(str[i]==tr[j]){
				i++;
				j++;
			}
			else{
				int k=i;
				while(k<str.length && str[k]!=tr[j]){
					k++;
				}
				if(k==str.length-1 && str[k]!=str[j]){
					i++;
					j++;
					count+=2;
				}
					
					
			}
		}
		count+=Math.abs(i-j);
		return count;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String t=sc.next();
		int k=sc.nextInt();
		sc.close();
		int count=0;
		count=AppendDelete(s,t);
		s=count>k?"No":"Yes";
		System.out.println(s);
	}
}
