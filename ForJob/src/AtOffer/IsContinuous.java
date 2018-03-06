package AtOffer;

/**
 * Created by yolin on 2018/3/7.
 */
public class IsContinuous {
    public static void main(String[] args){

    }
    private static boolean isContinuous(int[] numbers){
        if (numbers.length!=5)return false;
        int min=14;
        int max=-1;
        int flag=0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==0)continue;
            if (numbers[i]<0 || numbers[i]>13)return false;
            if (((flag>>numbers[i])&1)==1)return false;
            flag|=(1<<numbers[i]);
            if (numbers[i]>max){
                max=numbers[i];
            }
            if (numbers[i]<min){
             min=numbers[i];
            }
            if (max-min>=5)return false;

        }
        return true;

    }
}
