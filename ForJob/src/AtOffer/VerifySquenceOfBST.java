package AtOffer;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * Created by yolin on 2018/3/3.
 */
public class VerifySquenceOfBST {
    public static void main(String[] args){
        int[] a={4,6,7,5};
        System.out.println(verifySquenceOfBST(a));

    }
    private static boolean verifySquenceOfBST(int[] sequence){
        if (sequence.length==0)return false;
        if (sequence.length==1)return true;
        return judge(sequence,0,sequence.length-1);
    }
    private static boolean judge(int[] a,int start,int end){
        if (start>=end)return true;
        int root=a[end];int i,k=-1;
        for (i=start;i<=end;i++){
            if (k==-1 && a[i]>root){
                k=i;
            }
            if (k!=-1 && i<=end && (a[i]-root)<0){
                return false;
            }
        }
        boolean fa=true,fb=true;
        System.out.println(k+"\t"+root+"\t");
        if (k!=-1 && k>start)
            fa=judge(a,start,k-1);
        if (k!=-1 && k<end)
            fb=judge(a,k,end-1);

        return fa && fb;
    }

}
