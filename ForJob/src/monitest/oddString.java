package monitest;

import java.util.Scanner;

public class oddString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toCharArray();
            int res=0;int len=ch.length;
            if (len%2!=0){
                len--;
            }
            len-=2;// every string have to be removed more than one character!
            int mid=len/2;
            while (mid>0){
                String s1=str.substring(0,mid);
                String s2=str.substring(mid,len);
               // System.out.println(s1+"\t" +s2+"\t"+len);
                if (s1.equals(s2)){
                    res=s1.length();
                    break;
                }else {
                    len-=2;mid=len/2;
                }
            }
            System.out.println(2*res);
        }
    }
}
