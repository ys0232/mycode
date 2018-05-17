package huawei;

import java.util.Scanner;

public class reversalStr {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            for (int i=s.length()-1;i>=0;i--)
                System.out.print(s.charAt(i));
        }
    }

}
