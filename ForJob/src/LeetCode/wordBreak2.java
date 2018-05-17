package LeetCode;

import java.util.*;

public class wordBreak2 {
    public static void main(String [] args){
        String s="leetcode";
        Set<String> dict=new TreeSet<>();
        dict.add("leet");
        dict.add("le");
        dict.add("et");
        dict.add("code");
        System.out.println(wordBreak(s,dict));
    }
    private static ArrayList<String> wordBreak(String s, Set<String> dict){
        ArrayList<String> res=new ArrayList<>();
        boolean[][] pre=new boolean[s.length()+1][s.length()];
        boolean[] f=new boolean[s.length()+1];
        f[0]=true;
        for (int i=1;i<s.length()+1;i++){
            for (int j=i-1;j>=0;j--){
                if (f[j] && dict.contains(s.substring(j,i))){
                    f[i]=true;
                    pre[i][j]=true;
                }
            }
        }
        ArrayList<String> path=new ArrayList<>();
        gen_path(s,pre,s.length(),path,res);
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (s+t1).compareTo(t1+s);
            }
        });
        return res;
    }
    private static void gen_path(String s,boolean[][] pre,
                                 int cur,ArrayList<String> path,ArrayList res){

        if (cur==0){
            String temp="";
            if (path.size()>=1)
                temp=path.get(path.size()-1);
            for (int i=path.size()-2;i>=0;i--){
                temp+=" "+path.get(i);
            }
            res.add(temp);
        }
        for (int i=0;i<s.length();i++){
            if (pre[cur][i]){
                path.add(s.substring(i,cur));
                gen_path(s,pre,i,path,res);
                path.remove(path.size()-1);
            }
        }
    }
}
