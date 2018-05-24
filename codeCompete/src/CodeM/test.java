package CodeM;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        //System.out.println((int)(Math.log(3)/Math.log(2)));
        ArrayList<Integer> ma=new ArrayList<>();
        for (int i=1;i<9;i+=3){
            ma.add(i);
        }
        System.out.println(ma);
        int la=-1;
        System.out.println(find(la,ma));
    }
    private static boolean check(char[][] next, ArrayList<hascode> st){
        long has1=0,has2=0;
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                has1=has1*131+next[i][j];
                has2=has2*137+next[i][j];
            }
        }
        hascode hasCode=new hascode(has1,has2);
        for (hascode has:st){
            if (has1==has.has0 &&has2==has.has1)
                return false;
        }
        st.add(hasCode);
            return true;

    }
    private static int find(int la,ArrayList<Integer> mark){
        int low=0,high=mark.size()-1;
        while(low<high){
            int mid=(low+high)/2;
            int t=mark.get(mid);
            if (t<=la){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        System.out.println(high);
        int res;
        if (mark.get(low)>la){
            res=low;
        }else res=-1;
        return res;
    }
}

