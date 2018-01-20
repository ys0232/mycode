package AtOffer;

/**
 * Created by lenovo on 2018/1/13.
 */
public class replaceSpace {
    public static void main(String[] args){
        String str="we are happy!";
        //String str1=str.replace(" ","%20");
        String str2="";
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                str2+="%20";
            }else str2+=str.charAt(i);
        }
        System.out.println(str2);
    }
}
