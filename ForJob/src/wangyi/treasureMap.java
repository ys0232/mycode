package wangyi;

import java.util.Scanner;

public class treasureMap {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            String str=sc.next();int k=0;
            for (int i=0;i<s.length();i++){
                if (k<str.length() && s.charAt(i)==str.charAt(k)){
                    k++;
                }
                if (k==str.length())break;
            }
            System.out.println(k==str.length()?"Yes":"No");
        }
    }
}
