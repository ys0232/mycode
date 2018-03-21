import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yolin on 2018/3/17.
 */
public class forecast {
    static int timeN=7;
    static int vmNum=30;
    public static void main(String[] args)throws IOException{
        File file=new File("E:\\mycode\\HUAWEI\\src\\data\\TrainData_2015.1.1_2015.2.19.txt");
        ArrayList<String > data=new dataProcessing().processing(file);

        training(data);
    }
    public static void training(ArrayList<String > data){
        double[][] weight=new double[vmNum][timeN];
        int[][] st=new int[data.size()][vmNum];
        for (int i=0;i<data.size();i++){
            String[] temp=data.get(i).split("\t");
            for (int j=1;j<temp.length;j++){
                int id=Integer.valueOf(temp[j]);
                st[i][id]+=1;
            }
            System.out.println(Arrays.toString(st[i]));
        }

    }
}
