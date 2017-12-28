package ACMTest;
import java.util.*;
import java.io.*;

public class t1516 {

	public static char[] LSC(char[] ch1,char[] ch2){
		String s = "";
		int len1=ch1.length+1;
		int len2=ch2.length+1;
		int[][] c=new int[len1][len2];
		for(int i=1;i<len1;i++) 
			c[i][0]=0;
		for(int j=0;j<len2;j++)
			c[0][j]=0;
		for(int i=1;i<len1;i++){
	
			for(int j=1;j<len2;j++){
				if(ch1[i-1]==ch2[j-1]){
					c[i][j]=c[i-1][j-1]+1;
				}
				else if(c[i-1][j]>=c[i][j-1])
					c[i][j]=c[i-1][j];
				else
					c[i][j]=c[i][j-1];
			}
		}
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++)
				System.out.print(c[i][j]+" ");
		System.out.println();}
		int k=c[len1-1][len2-1];
		int j=len2-2;
		int i=j;
		while(k!=0){
			if(ch1[i]==ch2[j] &&k==c[i+1][j+1]){
				s+=ch1[i];
				i=i-1;
				j=j-1;
				k--;
				}
			else if(ch1[i-1]==ch2[j] &&k==c[i+1][j+1]){
				s+=ch1[i-1];
				i=i-1;
				j=j-1;
				k--;
				}
			else if(ch1[i]==ch2[j-1] &&k==c[i+1][j+1]){
				s+=ch1[i];
				i=i-1;
				j=j-1;
				k--;
				}
			else
			{
				i=i-1;
				j=j-1;
				}
				
		}
		char[] strTmp=new char[s.length()];
		for(int p=s.length()-1;p>=0;p--)
			strTmp[p]=s.charAt(p);
		return strTmp;
	}
	public static String[] oprate(char[] ch1,char[] ch2,char[] strLsc,int procNum){
		String[] s=new String[procNum];
		int k=0;int j=0;
		while(k<ch1.length){
	        
	        if(ch1[k]==ch2[j]){
	        	k++;j++;
	        }
	        	
	        	k++;
		}
		return s;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str1,str2;
		char[] strLsc;
		str1=sc.nextLine();
		str2=sc.nextLine();
		char[] ch1 =new char[str1.length()];
		char[] ch2=new char[str2.length()];
		for(int i=0;i<str1.length();i++)
			ch1[i]=str1.charAt(i);
		for(int i=0;i<str2.length();i++)
			ch2[i]=str2.charAt(i);
		strLsc=LSC(ch1,ch2);
		System.out.println(LSC(ch1,ch2));
		int procNum=ch1.length>ch2.length?ch1.length-strLsc.length:ch2.length-strLsc.length;
		System.out.println(procNum);
		for(int k=1;k<=procNum;k++){
			System.out.print(k+" ");
			
			
		}
			
		
	}
}
