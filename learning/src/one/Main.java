package one;
import java.util.*;
public class Main{
    public static void main(String[] args){
        int[] a=new int[10000];
        int[] b=new int[10000];
        Scanner sc=new Scanner(System.in);
        int[] sum=new int[10001];
        String s=sc.next();
        int lenA=s.length();
        char chA='+';
        if(s.charAt(0)=='-')
        {
        	chA='-';
        	lenA-=1;
        }
        
        for(int i=lenA-1;i>=0;i--)
           a[lenA-1-i]=s.charAt(i)-48;
           s=sc.next();
           int lenB=s.length();
           char chB='+';
           if(s.charAt(0)=='-')
           {
           	chB='-';
           	lenB-=1;
           }
           
           for(int i=lenB-1;i>=0;i--)
              b[lenB-1-i]=s.charAt(i)-48;
           int len=lenA>lenB?lenA:lenB;
           int flag=0;
           char chS='+';
           if(chA==chB){
        	   chS=chA;
        for(int i=0;i<len;i++){
           sum[i]=a[i]+b[i]+flag;
           flag=sum[i]/10;
           sum[i]=sum[i]%10;    
        }
        if(flag!=0){
			sum[len]=flag;
		    len=len+1;
		}		}
           else
           {
        	   if(lenA>lenB)
        		   chS=chA;
        	   else if(lenA==lenB && a[lenA-1]>=b[lenB-1])
        		   chS=chA;
        	   else
        		   chS=chB;
           }
		
        for(int i=len-1;i>=0;i--)
        System.out.print(sum[i]);
        System.out.println();
    }
}