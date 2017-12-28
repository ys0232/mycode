package one;
import java.io.*;
import java.util.*;
public class test3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String s=new String();
        
        int len=time.length();
        int num=(time.charAt(0)-48)*10+time.charAt(1)-48;
        
        if(time.charAt(len-2)=='P'&&num<12){
            num=num+12;}
           else if(num==12)
               num=12;
          
          if(time.charAt(len-2)=='A'&&num==12){
           num=00;
        }
        for(int i=2;i<len-2;i++){
            s+=time.charAt(i);
        }
        if(num==0)
            System.out.println(num+"0"+s);
            else
                System.out.println(num+s);
           
    }
}
