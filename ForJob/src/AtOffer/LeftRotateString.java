package AtOffer;

/**
 * Created by yolin on 2018/1/18.
 */
public class LeftRotateString {
    public static void main(String[] args){
        String str="mniansuio1231jksa";
        int n=3;
        System.out.println(LeftRotateString(str,n));

    }
    private static String LeftRotateString(String str,int n){
        int len=str.length();
        if (len<=1)return str;
        n=n%len;
        String temp="";
        for (int i=n;i<len;i++){
            temp+=str.charAt(i);
        }
        for (int i=0;i<n;i++){
            temp+=str.charAt(i);
        }
        return temp;
    }
}
