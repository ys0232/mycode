package huawei;

import java.util.Scanner;

public class reversalSentence {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] strs=s.split(" ");
            for (int i=strs.length-1;i>0;i--)
                System.out.print(strs[i]+" ");
            System.out.println(strs[0]);
        }
    }
}
