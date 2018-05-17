package base;


import AtOffer.Match;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        String path="/home/yolin/tianchi/Advertising_transformation_prediction/result.txt";
        String path1="/home/yolin/tianchi/Advertising_transformation_prediction/result0417.txt";
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String str=br.readLine();
        int cnt=0;
        while (str!=null){
            cnt+=1;
            String[] t=str.split(" ");
            System.out.println(t[1]);
            str=br.readLine();
        }
        System.out.println(cnt);
    }
}
