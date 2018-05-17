package huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class simple_password {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] alph2Num=new int[26];int k=1;
        for (int i=0;i<alph2Num.length;i++){
            if (k<7 && i%3==0){
                k+=1;
            }else if (k==7 && (i-1)%6==0){
                k+=1;
            }else if (k>7 && k<9 && (i-1)%3==0){
                k+=1;
            }
            alph2Num[i]=k;
        }
        System.out.println(Arrays.toString(alph2Num));
        int gap='a'-'A';
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toCharArray();
            str="";
            for (int i=0;i<ch.length;i++){
                if (ch[i]>='A'&&ch[i]<'Z'){
                   int temp=ch[i]+gap+1;
                   str+=(char)temp;
                }else if (ch[i]=='Z'){
                    str+='a';
                }else if (ch[i]>='a'&& ch[i]<='z'){
                    str+=alph2Num[ch[i]-'a'];
                }else str+=ch[i];
            }
            System.out.println(str);
        }
    }
}
