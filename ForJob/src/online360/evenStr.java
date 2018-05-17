package online360;

import java.util.Arrays;
import java.util.Scanner;

public class evenStr {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            long res=0;
            for (int i=0;i<str.length()-1;i++){
                int[] alph=new int[26];
                for (int j=i;j<str.length();j++){
                    //System.out.println(str.charAt(j));
                    alph[str.charAt(j)-'a']+=1;
                    if (alph[str.charAt(j)-'a']%2!=0)continue;
                    if ((j-i+1)%2==0){
                        boolean flag=true;
                      for (int k=0;k<alph.length;k++){
                          if (alph[k]%2!=0){
                              flag=false;
                              break;
                          }
                      }
                      if (flag)res+=1;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
