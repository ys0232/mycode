package PinDuoDuo;

import java.util.*;

/**
 * Created by yolin on 2018/3/20.
 */
public class BigString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toCharArray();
            int[] alph=new int[256];
            ArrayList<Character> max=new ArrayList<>();
            int k=0;
            for (int i=0;i<ch.length;i++){
                alph[ch[i]]+=1;
                if (alph[ch[i]]==1)
                max.add(ch[i]);
            }
            Collections.sort(max, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2-o1;
                }
            });
           // System.out.println(max);
            str="";
            k=0;
            for (int i=0;i<ch.length;i++){
                if ((k<max.size() &&ch[i]<max.get(k)) && alph[ch[i]]>1){
                    alph[ch[i]]-=1;
                }else {
                    if (alph[ch[i]]==1 || (i+1<ch.length &&ch[i]>=ch[i+1])
                            || ch[i]>ch[i-1]){
                        str+=ch[i];
                    }
                   if (k<max.size() && ch[i]==max.get(k)){
                       k++;
                   }
                }
            }
            System.out.println(str);
        }
    }
}
