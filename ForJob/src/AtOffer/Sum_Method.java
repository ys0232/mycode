package AtOffer;

/**
 * Created by yolin on 2018/1/16.
 */
public class Sum_Method {
    public static void main(String[] args){

        int n=10,sum=0;
        for (int i=1;i<=n;i++)
            sum+=i;
        System.out.println(Sum_Solution(n)+"\t"+sum);
    }
    private static int Sum_Solution(int n){
        if (n==1)return 1;
        return n+Sum_Solution(n-1);
    }
}
