import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yolin on 2018/3/17.
 */
public class dataProcessing {
    public static int vmNum=30;

    public static void main(String [] args)throws IOException{
        File file=new File("E:\\mycode\\HUAWEI\\src\\data\\TrainData_2015.1.1_2015.2.19.txt");

        processing(file);
    }
    public static ArrayList<String> processing(File file)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String str=br.readLine();
            ArrayList<String> data=new ArrayList<>();
        while (str!=null){
            String[] strs=str.split("\t");
            String vmName=strs[1];
            String date=strs[2].split(" ")[0];
            Pattern p=Pattern.compile("[^0-9]");
            Matcher m=p.matcher(vmName);
            int vmId=Integer.valueOf(m.replaceAll("").trim());
                String temps;
            if (data.size()==0){
                temps=date+"\t"+vmId;
                data.add(temps);
            }else {
                temps=data.get(data.size()-1).split("\t")[0];
                if (temps.equals(date)){
                    temps=data.get(data.size()-1)+"\t"+vmId;
                    data.remove(data.size()-1);
                 data.add(temps);
                }else {
                    temps=date+"\t"+vmId;
                    data.add(temps);
                }
            }
            str=br.readLine();
        }
      /*  for (String date:data){
            System.out.println(date);
        }*/
        return data;
    }
}
