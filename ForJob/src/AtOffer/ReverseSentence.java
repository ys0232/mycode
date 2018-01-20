package AtOffer;


/**
 * Created by yolin on 2018/1/19.
 */
public class ReverseSentence {
    public static void main(String[] args){
        String str="noas sadsa csacsa";
        System.out.println(ReverseSentence(str));
    }
    private static String ReverseSentence(String str){
        String[] temp=str.split(" ");
        if (temp.length<=1)return str;
        str="";
        for (int i=temp.length-1;i>0;i--){
            str+=temp[i]+" ";
        }
        str+=temp[0];
        return str;
    }
}
