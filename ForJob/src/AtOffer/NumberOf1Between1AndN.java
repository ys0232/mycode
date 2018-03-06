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
        int count=0;
        for (long m=1;m<=n;m*=10){
            if (n/m%10==1)
            count+=(n/m+8)/10*m+(n%m+1);
            else count+=(n/m+8)/10*m;
        }
        return count;
    }
}
