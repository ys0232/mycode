package solveAtNiuKe;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/7.
 */
public class StringMove {
    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);

        String str=sc.nextLine();
        System.out.println(move(str));

    }
    private static String move(String str){
        if (str==null || str.length()<=1)return str;
        char[] ch=str.toCharArray();
       str="";
        for (int i=0;i<ch.length;i++){
            for (int j = ch.length - 1; j>i;j--){
                if (ch[j]>='a'&& ch[j]<='z' && ch[j-1]>='A' && ch[j-1]<='Z'){
                    char temp=ch[j];
                    ch[j]=ch[j-1];
                    ch[j-1]=temp;
                }

            }
            str+=String.valueOf(ch[i]);
            System.out.println(ch[i]);
        }
        return str;
    }
}
