package LeetCode;

import java.util.*;

public class wordBreak {
    private static boolean wordbreak(String s,Set<String> dict){
        boolean[] f=new boolean[s.length()+1];
        f[0]=true;
        for (int i=1;i<=s.length();i++){
            for (int j=i-1;j>=0;j--){
             //   System.out.println(i+"\t"+j);
                String t=s.substring(j,i);
                if (f[j] && dict.contains(t)){
                    f[i]=true;
                    break;
                }
            }
        }

        return f[s.length()];
        }
        public static void main(String [] args){
        String s="leetcode";
        Set<String> dict=new TreeSet<>();
        dict.add("le");
        dict.add("et");
        dict.add("code");
        System.out.println(wordbreak(s,dict));
        }
}
