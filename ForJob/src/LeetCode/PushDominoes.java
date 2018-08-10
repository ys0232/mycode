package LeetCode;

import java.util.Scanner;

public class PushDominoes {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        String str="..R..";
        System.out.println(pushDominoes(str));
    }
    private static String pushDominoes(String dominoes){
        char[] left=dominoes.toCharArray();
        int last=-2;
        for (int i=0;i<left.length;i++){
            //System.out.println(i+"\t"+left[i]);
            if (left[i]=='L'&& (i>0)&&left[i-1]=='.'){
                left[i-1]='L';last=i-1;
            }else if (left[i]=='R' && (i<left.length-1)&&left[i+1]=='.'){
                left[i+1]='R';last=i+1;
            }else if (left[i]=='L'&& last==i-1){
                left[last]='.';
            }

        }
        dominoes="";
        for (int i=0;i<left.length;i++){
            dominoes+=left[i];
        }
        return dominoes;
    }

        private static String pushDominoes1(String dominoes) {
            int N = dominoes.length();
            int[] indexes = new int[N+2];
            char[] symbols = new char[N+2];
            int len = 1;
            indexes[0] = -1;
            symbols[0] = 'L';

            for (int i = 0; i < N; ++i)
                if (dominoes.charAt(i) != '.') {
                    indexes[len] = i;
                    symbols[len++] = dominoes.charAt(i);
                }

            indexes[len] = N;
            symbols[len++] = 'R';

            char[] ans = dominoes.toCharArray();
            for (int index = 0; index < len - 1; ++index) {
                int i = indexes[index], j = indexes[index+1];
                char x = symbols[index], y = symbols[index+1];
                char write;
                if (x == y) {
                    for (int k = i+1; k < j; ++k)
                        ans[k] = x;
                } else if (x > y) { // RL
                    for (int k = i+1; k < j; ++k)
                        ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
                }
            }

            return String.valueOf(ans);
        }

}
