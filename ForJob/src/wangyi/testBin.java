package wangyi;

import java.util.Scanner;

public class testBin {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        int[] a={1,2,3,4,6,8,9,17};
        int t=5;
        solve(a,t);
    }
    private static void solve(int[]a,int t){
        int low=0,high=a.length-1;
        boolean flag=true;
        while (low<high){
            int mid=(low+high)/2;
            System.out.println(low+"\t"+high+"\t"+mid+"\t"+a[mid]);
            if (t==a[mid]){
                System.out.println(a[mid]);flag=false;
                break;
            }
            if (t<a[mid]){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        if (flag){
            int min=low<high?low:high;
            if (t>=a[min]){
            System.out.println(a[min]);
            }else if (t>=a[min-1]){
                System.out.println(a[min-1]);
            }

        }
    }
}
