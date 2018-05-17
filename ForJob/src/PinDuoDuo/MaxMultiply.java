package PinDuoDuo;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/16.
 */
public class MaxMultiply {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
           ArrayList<Integer> arr=new ArrayList<>();
           while (sc.hasNext()){
               int t=sc.nextInt();
                arr.add(t);
           }
            System.out.println(multiply(arr));
    }
    private static long multiply(ArrayList<Integer> arr){
        long max=0;
        long[] max_t=new long[3];
        long[] min_t=new long[2];
        min_t[0]=Long.MAX_VALUE;
        min_t[1]=Long.MAX_VALUE;
        for (int i=0;i<max_t.length;i++)
            max_t[i]=Integer.MIN_VALUE;
        for (int i=0;i<arr.size();i++){
            if (max_t[0]<arr.get(i)){
                max_t[2]=max_t[1];
                max_t[1]=max_t[0];
                max_t[0]=arr.get(i);
            }else if (max_t[1]<arr.get(i)){
                max_t[2]=max_t[1];
                max_t[1]=arr.get(i);
            }else if (max_t[2]<arr.get(i)){
                max_t[2]=arr.get(i);
            }
            if (min_t[0]>arr.get(i)){
                min_t[1]=min_t[0];
                min_t[0]=arr.get(i);
            }else if (min_t[1]>arr.get(i)){
                min_t[1]=arr.get(i);
            }
        }
        max=Math.max(min_t[0]*min_t[1],max_t[1]*max_t[2])*max_t[0];
        System.out.println(Arrays.toString(max_t)+"\n"+Arrays.toString(min_t));

        return max;
    }
    private static String Bigmultiply(String s1,String s2){
        System.out.println(s1+"\t"+s2);
        if (s1.length()*s2.length()==0)return "0";
        if (s1.length()<=3 && s2.length()<=3)
            return String.valueOf(Long.valueOf(s1)*Long.valueOf(s2));
        int len=s1.length()<s2.length()?s1.length():s2.length();
        String a=s1.substring(0,s1.length()-len/2-1);
        String b=s1.substring(a.length());
        String c=s2.substring(0,s2.length()-len/2-1);
        String d=s2.substring(c.length());
        String ab=BigAdd(a,b);
        String cd= BigAdd(c,d);
        String ac=Bigmultiply(a,c);
        String bd=Bigmultiply(b,d);
        String median=BigSub(Bigmultiply(ab,cd),BigAdd(ac,bd));
      //  System.out.println("mul & add "+Bigmultiply(ab,cd)+"\t"+BigAdd(ac,bd));
        for (int i=0;i<2*(len/2+1);i++){
            ac+="0";
            if (i<len/2+1)
                median+="0";
        }
         System.out.println(ac+"\t"+median+"\t"+bd);
        return BigAdd(ac,BigAdd(median,bd));
    }
    private static String BigAdd(String s1,String s2){
        int c=0;
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int len=ch1.length>ch2.length?ch1.length+1:ch2.length+1;
        int[] ans=new int[len];
        for (int i=0;i<len;i++){
            int c1=0,c2=0;
            if (i<ch1.length){
                c1=ch1[ch1.length-i-1]-'0';
            }
            if (i<ch2.length){
                c2=ch2[ch2.length-i-1]-'0';
            }
            ans[i]=(c1+c2+c)%10;
            c=(c1+c2+c)/10;
        }
        String res="";
        boolean flag=false;
        for (int i=len-1;i>=0;i--){
            if (ans[i]!=0 && !flag){
                flag=true;
            }
            if (flag){
                res+=ans[i];
            }
        }
        return res;
    }
    private static String BigSub(String s1,String s2){
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int len=ch1.length;
        int[] ans=new int[len];
        int c=0;
        for (int i=0;i<len;i++){
            int c1=0,c2=0;
            if (i<ch2.length){
                c2=ch2[ch2.length-1-i]-'0';
            }
            c1=ch1[ch1.length-1-i]-'0';
            int t=c1-c2-c;
            if (t<0){
                t+=10;
                c=1;
            }else c=0;
            ans[i]=t%10;
        }
        String res="";
        boolean flag=false;
        for (int i=len-1;i>=0;i--){
            if (ans[i]!=0 && !flag){
                flag=true;
            }
            if (flag){
                res+=ans[i];
            }
        }
        return res;
    }
}
