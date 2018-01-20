package AtOffer;

/**
 * Created by yolin on 2018/1/16.
 */
public class Add_Method {
    public static void main(String[] args){
        int n1=10,n2=12;
        System.out.println(Add(n1,n2));
    }
    private static int Add(int num1,int num2){
        while (num1!=0){
            int temp=(num1 & num2) << 1; // num1&num2  shl 1,left move
            num2 = num1 ^ num2;//num1 xor num2
            num1=temp;
        }
        return num2;
    }
}
