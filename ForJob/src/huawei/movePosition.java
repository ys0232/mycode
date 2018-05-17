package huawei;

import java.util.Scanner;

public class movePosition {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            String[] strs=str.split(";");
            int x=0,y=0;
            for (int i=0;i<strs.length;i++){
                if (strs[i].length()<2)continue;
                char c=strs[i].charAt(0);int t;
                try{
                    t=Integer.valueOf(strs[i].substring(1));
                }catch (Exception e){
                    continue;
                }
                switch (c){
                    case 'A':x-=t;break;
                    case 'S':y-=t;break;
                    case 'W':y+=t;break;
                    case 'D':x+=t;break;
                }
                System.out.println(strs[i]+"\t"+x+","+y);
            }
            System.out.println(x+","+y);

        }
    }
}
