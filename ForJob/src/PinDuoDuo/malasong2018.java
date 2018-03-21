package PinDuoDuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/20.
 */
public class malasong2018 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            int low=0;int high=n-1;
            int count=0;
            while (high>=0 && a[high]==4){
                high--;
                count++;
            }
            while (low<=high){
                int temp=a[high]+a[low];
                if (temp==4){
                    count++;
                    low++;high--;
                }else if (temp>4){
                    count++;
                    high--;
                }else if (temp<4){
                    high--;
                    count++;low++;
                    while (low<=high && a[low]<=4-temp){
                        temp+=a[low];
                        low++;
                    }
                }
            }
            System.out.println(count);

        }
    }
}
