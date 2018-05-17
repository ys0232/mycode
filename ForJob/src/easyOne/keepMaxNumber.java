package easyOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/15.
 */
public class keepMaxNumber {
    static String max="";
    public static void main(String[] args){
        // OutOfMemoryError: Java heap space
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String a=sc.next();
            int k=sc.nextInt();
             max="";
            keepMax(a,0,k);
            System.out.println(max);
        }

    }
    private static void keepMax(String a,int cur, int k){

        if(a.length()==0 || cur==k){
            if (a.length()>1&&compare(a,max)>0){
                max=a;
            }

           // System.out.println("max= "+max);

            return;
        }
        char[] ch=a.toCharArray();
        String t="";
        for (int i=0;i<ch.length;i++){
            t=t+ch[i];int pos=(int)Math.pow(10,ch.length-i-1);
             String temp="";
             if (t.length()>1)temp=t.substring(0,i);
             if (ch.length-i>1){
                 temp+=a.substring(i+1);
             }
            System.out.println(a+"\t"+cur+"\t"+temp+"\t"+t+"\t"+i+"\t"+pos);
            keepMax(temp,cur+1,k);
        }
    }
    private static int compare(String a,String b){
        if (a.length()>b.length())return 1;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)==b.charAt(i))continue;
            if (a.charAt(i)>b.charAt(i)){
                return 1;
            }else return -1;
        }
        return 0;

    }
}
