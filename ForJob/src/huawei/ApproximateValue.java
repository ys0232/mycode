package huawei;

import java.util.Scanner;

public class ApproximateValue {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            double t=sc.nextDouble();
            String s=String.valueOf(t);
           // String[] strs=s.split(".");
            //System.out.println(Arrays.toString(strs)+"\t"+s);
            long res=0;
            for (int i=0;i<s.length();i++){
                int ch=s.charAt(i);
                if (ch=='.')break;
                ch-='0';
                res=res*10+ch;
            }
            res=t+0.5>=res+1?res+1:res;
            System.out.println(res);
        }
    }
}
