package AtOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yolin on 2018/3/3.
 */
public class PermutationString {
    public static void main(String[] args){
        String str="aabc";
        ArrayList<String> res=Permutation(str);
        for (String string:res)
            System.out.println(string);

    }
    private static ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        // System.out.print(str);
        if (str.length()==0)return res;
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        int num=1,a=0,b=0;
        int len=chars.length;
        for (int i=1;i<=len;i++)
            num*=i;
        // System.out.println(String.valueOf(chars)+num);
        while (num>0){
            num--;
            res.add(String.valueOf(chars));
            Collections.sort(res);
            for (int i=1;i<res.size();i++){
                if (res.get(i).equals(res.get(i-1)))
                    res.remove(i);
            }
            // System.out.println(String.valueOf(chars));
            for (int i=len-1;i>0;i--){
                if (chars[i-1]<chars[i]){
                    a=i-1;break;
                }
            }
            for (int j=len-1;j>a;j--){
                if (chars[j]>chars[a]){
                    b=j;break;
                }
            }
            char ch=chars[a];chars[a]=chars[b];chars[b]=ch;
            //sort(chars,a,len)
            for (int i=a;i<len-1;i++){
                for (int j=a+1;j<len-1;j++){
                    if (chars[j]>chars[j+1]){
                        ch=chars[j];
                        chars[j]=chars[j+1];
                        chars[j+1]=ch;
                    }

                }
            }
        }
        Collections.sort(res);
        for (int i=1;i<res.size();i++){
            if (res.get(i).equals(res.get(i-1)))
                res.remove(i);
        }
        return res;
    }

}
