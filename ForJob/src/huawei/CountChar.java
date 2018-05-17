package huawei;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int[] alph=new int[128];
            String s=sc.next();int res=0;
            for (int i=0;i<s.length();i++){
                alph[s.charAt(i)]+=1;
                if (alph[s.charAt(i)]==1){
                    res+=1;
                }
            }
            System.out.println(res);
        }
    }
}
