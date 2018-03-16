package PinDuoDuo;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/16.
 */
public class BigMultiply {
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            System.out.println(Bigmultiply(s1,s2));
        }
    }
    private static String Bigmultiply(String s1,String s2){
        //System.out.println(s1+"\t"+s2);
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
      //  System.out.println(ac+"\t"+median+"\t"+bd);
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
