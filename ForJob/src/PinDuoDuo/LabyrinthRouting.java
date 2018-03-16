package PinDuoDuo;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/16.
 */
public class LabyrinthRouting {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            String[] Laby=new String[n];
            for (int i=0;i<n;i++)
                    Laby[i]=sc.next();

            System.out.println(route(Laby));
            }
        }
        private static int route(String[] str){
        return 0;
        }
}

