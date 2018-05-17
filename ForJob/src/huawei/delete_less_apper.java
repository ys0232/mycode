package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class delete_less_apper {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            int[] apper=new int[26];
            for (int i=0;i<str.length();i++){
                apper[str.charAt(i)-'a']+=1;
            }
            int min=Integer.MAX_VALUE;
            ArrayList<Integer> dele=new ArrayList<>();
            for (int i=0;i<apper.length;i++){
                if (apper[i]>0 && apper[i]<min){
                    min=apper[i];
                    dele=new ArrayList<>();
                    dele.add(i);
                }else if (apper[i]==min){
                    dele.add(i);
                }
            }
            String res="";
            System.out.println(dele);
            for (int i=0;i<str.length();i++){
                int t=str.charAt(i)-'a';
                if (!dele.contains(t)){
                    res+=str.charAt(i);
                }
            }
            System.out.println(res);
        }
    }
}
