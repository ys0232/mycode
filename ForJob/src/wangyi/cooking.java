package wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cooking {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> res=new ArrayList<>();
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] strs=s.split(" ");
            for (String str:strs){
                if (!res.contains(str)){
                    res.add(str);
                }
            }
            //System.out.println(res.size());
        }
        System.out.println(res.size());
    }
}
