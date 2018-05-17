package huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordVerification {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
           System.out.println(solve(str));

        }
    }
    private static String solve(String str){
        if (str.length()<=8)return "NG";
        int[] f=new int[4];
        String s="[^0-9]";
        Pattern p=Pattern.compile(s);
        Matcher m=p.matcher(str);
        f[0]=m.replaceAll("").trim().length();
        s="[^A-Z]";
        p=Pattern.compile(s);
        m=p.matcher(str);f[1]=m.replaceAll("").trim().length();
        s="[^a-z]";
        p=Pattern.compile(s);
        m=p.matcher(str);f[2]=m.replaceAll("").trim().length();
        f[3]=str.length()-f[1]-f[2]-f[0];
       // System.out.println(Arrays.toString(f));
        int cnt=0;
        for (int i=0;i<f.length;i++){
            if (f[i]!=0)cnt++;
        }
        if (cnt<3)return "NG";
        for (int i=0;i<str.length()-3;i++){
            s=str.substring(i,i+3);
            if (str.substring(i+1).contains(s)){
                return "NG";
            }
        }
        return "OK";
    }
}
