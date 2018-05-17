package huawei;


import java.util.ArrayList;
import java.util.Scanner;


public class getSingleNum {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            ArrayList<Integer> queue=new ArrayList<>();
            for (int i=s.length()-1;i>=0;i--){
                int t=s.charAt(i)-'0';
                if (!queue.contains(t)){
                    queue.add(t);
                }
            }
            for (int i:queue){
                System.out.print(i);
            }
        }
    }
}
