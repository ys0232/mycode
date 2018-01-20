package AtOffer;

/**
 * Created by yolin on 2018/1/19.
 */
public class NumberOf1Between1AndN {
    public static void main(String[] args){
        int n=1300;
        System.out.println(NumberOf1Between1AndN_Solution(n));

    }
    private static int NumberOf1Between1AndN_Solution(int n){
        if (n<0)return 0;
        if (n<10)return 1;
        int[] a=new int[32];
        int temp=n,k=0;
        while (temp!=0){
            a[k]=temp%10;
            k++;temp/=10;
        }
        int sum=1;
        for (int j=0;j<k;j++){
            sum+=10;
        }

       // return (n/10)%10*NumberOf1Between1AndN_Solution(n/10)+NumberOf1Between1AndN_Solution(n%10);
       int count=1;
        for (int i=10;i<=n;i++){
            int t=i;
            while (t!=0){
               if(t%10==1)count++;
               t/=10;
            }
        }
        return count;
    }
}
