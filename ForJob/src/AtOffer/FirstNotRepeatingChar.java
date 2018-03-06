package AtOffer;

/**
 * Created by yolin on 2018/3/3.
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args){
       String chs="NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println(firstNotRepeatingChar(chs));
    }
    private static int firstNotRepeatingChar(String str){
        if (str.length()==1)
        return 0;
        char[] chars=str.toCharArray();
        int[] a=new int[256];
        for (char ch:chars){
            a[ch]++;
        }
        int i=0;
        for (;i<chars.length;i++){
            if (a[(int)chars[i]]==1)break;
        }
        return i<chars.length?i:-1;
    }

}
