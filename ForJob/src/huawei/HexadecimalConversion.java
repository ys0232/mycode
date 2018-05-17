package huawei;

import java.util.Scanner;

public class HexadecimalConversion {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toUpperCase().toCharArray();
            int res=0;int k=1;
            for (int i=ch.length-1;i>1;i--){
                int t=0;
                if (ch[i]>='A'&&ch[i]<='Z'){
                    t=ch[i]-'A'+10;
                }else t=ch[i]-'0';
                res=res+t*k;
                k=k*16;
            }
            System.out.println(res);
        }
    }
}
