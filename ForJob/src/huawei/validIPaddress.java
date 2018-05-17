package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class validIPaddress {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] res=new int[7];
        String s;
        while (sc.hasNext()){
             s=sc.next();
             if (s.length()==0)break;
             String[] ip=s.trim().split("~");
             System.out.println(Arrays.toString(ip));
             boolean valid=true;
             for (int i=ip.length-1;i>=0;i--) {
                 String[] num = ip[i].split("\\.");
                 //System.out.println(Arrays.toString(num));
                 if (i == 0 && valid) {
                     try {
                         int t1 = Integer.valueOf(num[0]);
                         int t2 = Integer.valueOf(num[1]);
                         int t3 = Integer.valueOf(num[2]);
                         int t4 = Integer.valueOf(num[3]);
                         if (judge(t1) && judge(t2) && judge(t3) && judge(t4)) {
                             if (t1 >= 240) {
                                 res[4] += 1;
                             } else if (t1 >= 224) {
                                 res[3] += 1;
                             } else if (t1 >= 192) {
                                 res[2] += 1;
                             } else if (t1 >= 128) {
                                 res[1] += 1;
                             } else if (t1<=126 && t1>=1)
                                 res[0] += 1;
                             if (t1 == 10 || (t1 == 172&&t2==16)
                                     || (t1 == 192&&t2==168))
                                 res[6] += 1;
                         } else res[5] += 1;
                     } catch (Exception e) {
                         //System.out.println(e.getMessage()+"\t"+Arrays.toString(res));
                         res[5] += 1;
                     }
                    // System.out.println(Arrays.toString(num)+"\t"+Arrays.toString(res));
                 } else if (i == 1 && valid) {
                     boolean flag = true;
                     boolean f1=true;
                     for (int j = 0; j < num.length; j++) {
                         int t = Integer.valueOf(num[j]);
                         if (!judge(t)) {
                             valid = false;
                             break;
                         }
                         if (t!=0)f1=false;
                         if (flag && t == 0) {
                             flag = false;
                             continue;
                         }else if (!flag && t!=0){
                             valid=false;
                             break;
                         }
                             String s1 = Integer.toBinaryString(t);
                            // System.out.println(s1+"\t"+t);
                             for (int k = 0; k < s1.length(); k++) {
                                 if (!s1.equals("0") && s1.length()<8)
                                 {
                                     valid=false;break;
                                 }
                                 if (s1.charAt(k) == '0') flag = false;
                                 if (!flag && s1.charAt(k) == '1') {
                                     valid = false;
                                     break;
                                 }
                               //  System.out.println(valid+"\t"+f1+"\t"+s1);
                             }
                         if (!valid)break;
                     }
                     if (flag||f1)valid=false;

                 } else {
                     valid = false;
                 }
                // System.out.println(valid+"\t"+i);
             }
             if (!valid)
                 res[5]+=1;
             System.out.println(Arrays.toString(res));
        }
        for (int i=0;i<6;i++)
            System.out.print(res[i]+" ");
        System.out.println(res[6]);
    }
    private static boolean judge(int t){
        if (t>=0 && t<=255)return true;
        return false;
    }
}
