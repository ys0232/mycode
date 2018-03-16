package easyOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/15.
 */
public class keepMaxNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String a=sc.next();
            int k=sc.nextInt();
            System.out.println(keepMax(a,k));
        }

    }
    private static String  keepMax(String  str,int k){
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        String s="";
       // System.out.println(Arrays.toString(ch)+"\t"+str+"\t"+k);
        for (char c:ch){
          //  System.out.println(Arrays.toString(ch)+"\t"+str+"\t"+k);
            if (k==0)break;
            k-=1;
            s="";
            for (int i=0;i<str.length();i++){
                if (c!=str.charAt(i)){
                    s+=str.charAt(i);
                }
            }
            str=s;
        }
        return str;
    }
}
