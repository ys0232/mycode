package AtOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yolin on 2018/3/4.
 */
public class FirstAppearingOnceChar {
    static String str="";
    public static void main(String[] args){
        char[] ch="k".toCharArray();
        for (char c:ch)
           Insert(c);

        System.out.println(FirstAppearingOnce());
    }
    private static void Insert(char c){
        str+=c;
    }
    private static char FirstAppearingOnce(){
        if (str==null || str.length()==0)return '#';

        char[] ch=str.toCharArray();
        System.out.println(str);
        int[] cnt=new int[256];
        for (char c:ch)
            cnt[c]++;
        for (char c:ch){
            if (cnt[c]==1)return c;
        }
        return '#';
    }
}
