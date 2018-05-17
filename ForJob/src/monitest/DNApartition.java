package monitest;

import java.util.Scanner;

public class DNApartition {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toCharArray();
            int res=0;int temp=0;
            for (int i=0;i<ch.length;i++){
                if (ch[i]=='A'||ch[i]=='T'||
                        ch[i]=='G'||ch[i]=='C'){
                    temp+=1;
                }else {
                    if (temp>res){
                        res=temp;
                    }
                    temp=0;
                }
            }
            if (temp>res){
                res=temp;
            }
            System.out.println(res);
        }
    }
}
