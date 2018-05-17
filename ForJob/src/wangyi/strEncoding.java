package wangyi;

import java.util.Scanner;

public class strEncoding {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            char[] chs=s.toCharArray();
            s="";char th='-';
            int cnt=0;
            for (int i=0;i< chs.length;i++){
                if (th!=chs[i]){
                    if (cnt!=0){
                        s+=String.valueOf(cnt)+th;
                    }
                    th=chs[i];
                    cnt=1;
                }else cnt++;
            }
            s+=String.valueOf(cnt)+th;
            System.out.println(s);
        }
    }
}
