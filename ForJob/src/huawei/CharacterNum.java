package huawei;

import java.util.Scanner;

public class CharacterNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String s=sc.next();
            char[] strs=str.toUpperCase().toCharArray();
            char[] s1=s.toUpperCase().toCharArray();
            int res=0;
            for (int i=0;i<strs.length;i++){
                if (strs[i]==s1[0]){
                    res++;
                }
            }
            System.out.println(res);

        }
    }
}
