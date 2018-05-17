package monitest;

import java.util.Scanner;

public class colorfultile {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            int res=0;
            char[] ch=str.toCharArray();
            for (int i=1;i<ch.length;i++){
                if (ch[i]==ch[i-1]){
                    res+=1;i++;
                }
            }
            System.out.println(res);
        }
    }
}
