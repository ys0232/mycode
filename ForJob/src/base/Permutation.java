package base;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yolin on 2018/3/14.
 */
public class Permutation {
    public static void main(String [] args){
        String s="bcad";
        ArrayList<String > res=perm(s);
        for (int i=0;i<res.size();i++) {
            System.out.println(res.get(i)+"\t"+i);
        }
    }
    private static ArrayList<String> perm(String s){
        char[] chs=s.toCharArray();
        Arrays.sort(chs);
        ArrayList<String > res=new ArrayList<>();
        int count=1;
        for (int k=2;k<=chs.length;k++){
            count*=k;
        }
        System.out.println(count);
        while (count-->0){
            res.add(Arrays.toString(chs));
            int k=-1;
        for (int i=chs.length-1;i>0;i--){
            if (chs[i]>chs[i-1]){
                k=i-1;
                break;
            }
        }
        int b=-1;
        if (k!=-1){
        for (int j=chs.length-1;j>k;j--){
            if (chs[k]<chs[j]){
                b=j;
                break;
            }
        }
            char ch =chs[k];chs[k]=chs[b];chs[b]=ch;
            for (int i=k;i<chs.length-1;i++){
                for (int j=k+1;j<chs.length-1;j++){
                    if (chs[j]>chs[j+1]){
                        ch=chs[j];chs[j]=chs[j+1];
                        chs[j+1]=ch;
                    }
                }
            }
        }

          //  System.out.println(Arrays.toString(chs)+"\t"+k+"\t"+"\t"+ch);
        }
        return res;
    }
}
