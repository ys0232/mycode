package Tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class prim {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int s=sc.nextInt();
            ArrayList<Integer> res=new ArrayList<>();
            res.add(2);
            for (int i=3;i<s-1;i++){
                boolean flag=true;
                for (int j=2;j<i;j++){
                    if (i%j==0){
                        flag=false;break;
                    }
                }
                if (flag)
                res.add(i);
            }
            int count=0;
            //System.out.println(res);
            for (int i=0;2*res.get(i)<=s;i++){
                if (res.contains(s-res.get(i))){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
