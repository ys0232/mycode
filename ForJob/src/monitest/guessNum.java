package monitest;

import java.util.ArrayList;
import java.util.Scanner;

public class guessNum {
    static int res=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
           int n=sc.nextInt();
           res=0;String str="Y";
            dfs(str,2,n);
           System.out.println(res);
        }
    }
    private static void dfs(String str,int cur,int n){
        if (cur>n){
            res+=1;
            System.out.println(str+"\t"+cur+"\t"+res);
            if (res>1000000007){
                res=res%1000000007;
            }
            return;
        }
        int i;boolean flag=true;
        ArrayList<Integer> a=new ArrayList<>();
        for (i=2;i<cur;i++){
            if (cur%i==0)a.add(i);
            if (cur%i==0&& str.charAt(i-1)=='N'){
                flag=false;
            }
        }
        boolean f1=true;int tem=0;
        for (Integer m:a){
            if (cur/m!=m && a.contains(cur/m)&&
                    str.charAt(m-1)==str.charAt(cur/m-1)){
                f1=false;
                tem=m-1;
            }
        }
       // System.out.println(str+"\t"+cur+"\t"+res+"\t"+flag);
        if (!flag){
            //str+='N';
            dfs(str+'N',cur+1,n);
        }else if (!f1){
            dfs(str+str.charAt(tem),cur+1,n);
        }
        else {
            dfs(str+'Y',cur+1,n);
            dfs(str+'N',cur+1,n);
        }
    }
}
