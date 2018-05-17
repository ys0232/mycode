package Ctrip;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongBracket {
    public static void main(String [] args){
        //temp used to store the number of pairs when stack is empty
        //if the string is a legal bracket,temp can add the previous one.
        //otherwise,store the number of pairs in the next temp.
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char[] ch=str.toCharArray();
            int res=0;int[] temp=new int[ch.length/2+1];

            Stack<Character> st=new Stack<>();
            int k=1;boolean flag=true;
            for (int i=0;i<ch.length;i++){
                if (ch[i]=='('){
                    st.push(ch[i]);
                }else if (ch[i]==')' && !st.isEmpty()){
                    st.pop();
                    temp[k]++;
                }else if (ch[i]==')'&& st.isEmpty()){
                    flag=false;
                }
                if (st.isEmpty()){
                    if (flag){
                    temp[k]+=temp[k-1];
                    }else flag=true;
                    k++;
                }
            }
            System.out.println(str+"\t"+Arrays.toString(temp));
            for (int i=0;i<k;i++)
                if (res<temp[i]){
                res=temp[i];
                }
            System.out.println(2*res);
        }
    }

}
