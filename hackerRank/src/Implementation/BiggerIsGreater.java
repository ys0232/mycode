package Implementation;
import java.util.*;

public class BiggerIsGreater {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.nextLine();
		while(n-->0){
			 s=sc.nextLine();
			char[] ch=s.toCharArray();
			int len=ch.length;
			int k=len-1;
			int i;
			for(i=len-2;i>=0;i--){
				k=len-1;
			while(ch[i]>ch[k] && k>0)
			  k--;
			if(ch[i]<ch[k])break;
			}
			if(ch[0]>=ch[1] && i<0)
				System.out.println("no answer");
			else
			{
				char tmp=' ';
				tmp=ch[k];
				ch[k]=ch[i];
				ch[i]=tmp;
				s="";
				for(int j=0;j<ch.length;j++)
				System.out.print(ch[j]);
				System.out.println();
				}
			
		}
		sc.close();
	}
}
