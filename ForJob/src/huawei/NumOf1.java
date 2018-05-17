package huawei;

import java.util.Scanner;

public class NumOf1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=0;
            while (n!=0){
                res+=1;
                n&=(n-1);
            }
            System.out.println(res);
        }
    }
}
