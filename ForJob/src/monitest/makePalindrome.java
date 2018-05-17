package monitest;

import java.util.HashMap;
import java.util.Scanner;

public class makePalindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[]ch=str.toCharArray();
            HashMap<Character,Integer> cnt=new HashMap<>();
            for (int i=0;i<ch.length;i++){
                if (!cnt.containsKey(ch[i])){
                    cnt.put(ch[i],1);
                }else {
                    int t=cnt.get(ch[i])+1;
                    cnt.put(ch[i],t);
                }
            }
            int res=0;
            for (Character c:cnt.keySet()){
                int t=cnt.get(c);
                if (t%2!=0){
                    res+=1;
                }
            }
            if (res==0)res+=1;
            System.out.println(res);

        }
    }
}
