package Ctrip;


import java.util.Scanner;
class room{
    int x,y,z,index;

    public room(int x, int y, int z,int index) {
        this.x = x;
        this.y = y;
        this.z = z;this.index=index;
    }
}

public class lowestRoom {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            room[] a=new room[n];
            for (int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                int z=sc.nextInt();
                a[i]=new room(x,y,z,i);
            }
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();
            double sum=z;
            int[] dp=new int[n];
            int k=0;
            k=x/a[0].x+1;
            if (k<y/a[0].y+1){
                k=y/a[0].y+1;
            }
            int[] count=new int[n];
            count[0]=k;
            dp[0]=a[0].z*k;
            for (int i=1;i<n;i++){
                int temp=a[i-1].z*(k-1);
                int m=(x-a[i-1].x)/a[i].x+1;
                if (m<(y-a[i-1].y)/a[i].y+1){
                    m=(y-a[i-1].y)/a[i].y+1;
                }
                temp+=m*a[i].z;
                dp[i-1]=Math.min(dp[i-1],temp);
                if (dp[i-1]==temp){
                    count[i-1]-=1;
                    count[i]+=1;
                }
                k=x/a[i].x+1;
                if (k<y/a[i].y+1){
                    k=y/a[i].y+1;
                }
                dp[i]=Math.min(dp[i-1],a[i].z*k);
                if (dp[i]==a[i].z*k){
                    count[i-1]=0;
                    count[i]=k;
                }
            }
            //System.out.println(Arrays.toString(dp));
            for (int i=0;i<n;i++)
                System.out.print(count[i]+",");
            System.out.println(dp[n-1]);

        }
    }
}
