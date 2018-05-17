package testForJob;

import java.util.Scanner;

public class simpleEncrption {

    public static void main(String [] args){

        char[] alph={'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            char[] ch=str.toCharArray();
            str="";
            for (int i=0;i<ch.length;i++){

                if ((ch[i]>='a' && ch[i]<='z')
                        ||(ch[i]>='A' && ch[i]<='Z')){
                    if (ch[i]<'a'){
                        ch[i]=Character.toUpperCase(alph[(ch[i]-'A'+1)%alph.length]);
                    }else {
                        ch[i]=alph[(ch[i]-'a'+1)%alph.length];
                    }
                }
                str+=ch[i];
            }
            System.out.println(str);
        }
    }

}
