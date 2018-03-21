package PinDuoDuo;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yolin on 2018/3/20.
 */
public class calculate2018 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            int ans=sc.nextInt();
            ArrayList<Integer> mechine=new ArrayList<>();
            Stack<Integer> own=new Stack<>();
            char[] ch=str.toCharArray();
           // ArrayList<Character> op_own=new ArrayList<>();
            ArrayList<Character> op_mechine=new ArrayList<>();
            int tem=0;
            boolean flag=false;
            for (int i=0;i<ch.length;i++){
                if (ch[i]<='9'&&ch[i]>='0'){
                    tem=tem*10+ch[i]-'0';
                }else {
                    own.push(tem);
                    mechine.add(tem);
                    tem=0;
                    if (flag){
                        int t1=own.pop();
                        int t2=own.pop();
                      //  op_own.remove(op_own.size()-1);
                        own.push(t1*t2);
                    }
                    op_mechine.add(ch[i]);
                   // op_own.add(ch[i]);
                    if (ch[i]=='*'){
                        flag=true;
                    }else {
                        flag=false;
                    }
                }
            }
            own.push(tem);
            mechine.add(tem);
            while (own.size()>1){
                int t1=own.pop();
                int t2=own.pop();
                //op_own.remove(op_own.size()-1);
               // System.out.println(t1+"\t"+t2);
                own.push(t1+t2);
            }
            int k=0;int result=mechine.get(0);
            for (int i=1;i<mechine.size();){
                int t1=mechine.get(i++);
                if (op_mechine.get(k++)=='+'){
                    result+=t1;
                }else {
                    result*=t1;
                }
            }
          //  System.out.println(op_mechine+"\t"+mechine);
            //=mechine.get(mechine.size()-1);
         //   System.out.println(result+"\t"+ans+"\t"+own.peek());
            if (result==own.peek()){
                System.out.println("U");
            }else if (ans==result){
                System.out.println("L");
            }else if (ans==own.peek()){
                System.out.println("M");
            }else System.out.println("I");

        }
    }
}
