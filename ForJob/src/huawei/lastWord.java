package huawei;

import java.util.Scanner;

public class lastWord {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] strs=str.split(" ");
            System.out.println(strs[strs.length-1].length());
        }
    }
}
