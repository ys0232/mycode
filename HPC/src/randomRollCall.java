import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;

public class randomRollCall {
    private int StuNum;
    private float avg;

    public randomRollCall() {

    }

    public randomRollCall(int s) {
        this.StuNum = s;
    }

    private void rollCall(File nameFile, File weightFile) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
        String[] name = new String[StuNum];
        int k = 0;
        String tmp;
        while ((tmp = in.readLine()) != null) {
            //导入班级学生名单
            name[k] = tmp;
            k++;
        }
        System.out.println(Arrays.toString(name));
        in.close();

        float[] weight = new float[StuNum];//建一个对应的权重表，在人未到时增加其权重，人已到，则减少权重
        if (!weightFile.exists()) {
            weightFile.createNewFile();
            PrintWriter pw = new PrintWriter(weightFile);
            for (int i = 0; i < StuNum; i++) {
                //初始化权重表
                weight[i] = (float) 1 / StuNum;
                pw.write(String.valueOf(weight[i] + "\n"));
                pw.flush();
            }
            System.out.println(Arrays.toString(weight));
            pw.close();
            avg = (float) 1 / StuNum;
        } else {
            BufferedReader weightin = new BufferedReader(new InputStreamReader(new FileInputStream(weightFile)));
            k = 0;
            String string;
            float sum = 0.0f;
            while ((string = weightin.readLine()) != null) {
                weight[k] = Float.parseFloat(string);
                sum += weight[k];
                k++;
            }
            System.out.println(Arrays.toString(weight));
            avg = (float) sum / StuNum;
            weightin.close();
        }


        boolean flag = true;//
        System.out.println("开始随机点名，人已到输入  1 ，人未到输入  0 。输入OK结束点名");
        int count = 0;
        int[] alreadyCall = new int[StuNum];
        int[] sort=new int[StuNum];
        for (int i=0;i<StuNum;i++){
            alreadyCall[i]=-1;
            sort[i]=i;
        }

          while (flag == true) {
           sort = sortWeight(weight,sort);
            int random;
            random = (int) (Math.random() * (StuNum / 2));//随机点权重在全班前二分之一的学生
            boolean f = true;
            for (int i = 0; i < count + 1; i++) {//检查本次点名是否已经点过该学生
                if (alreadyCall[i] == sort[random]) {
                    f = false;
                    break;
                }
            }
            boolean twoThrid=true;
            int two=0;
            while (f == false) {// 若点过，则随机点权重在全班前三分之二的学生
                two++;
                random = (int) (Math.random() * (2*StuNum / 3));
                for (int i = 0; i < count + 1; i++) {//检查本次点名是否已经点过该学生
                    if (alreadyCall[i] == sort[random]) {
                        f = false;
                        break;
                    }
                }
                if (two>=(2*StuNum / 3)){
                    f=true;
                    twoThrid=false;
                }
            }
            while (twoThrid==false){
                random = (int) (Math.random() * StuNum);
                for (int i = 0; i < count + 1; i++) {//检查本次点名是否已经点过该学生
                    if (alreadyCall[i] != sort[random]) {
                       twoThrid = true;
                        break;
                    }
                }
            }
            alreadyCall[count] = sort[random];//本次已点过的学生序号
            count++;
            System.out.println("\nrandom是" + random + " \n" + "若人已到，请输入1，未到输入0");
            System.out.println(name[sort[random]] + "\n" + "若人已到，请输入1，未到输入0");
            Scanner sc = new Scanner(System.in);
            int note = sc.nextInt();//接收是否到场变量
            if (note == 0)//未到场，增加权重
                weight[random] += avg;
            else if (note == 1)//已到场，减少权重
                weight[random] -= avg;
            System.out.println("点名是否结束，结束则输入OK，输入NO，点名继续");
            String st;
            st = sc.next();

            if (st.equals("OK") || st.equals("ok")) {
                flag = false;
                System.out.println("点名结束");
                String str;
                PrintWriter pw = new PrintWriter(weightFile);
                for (int i = 0; i < StuNum; i++) {
                    str = String.valueOf(weight[i] + "\n");
                    pw.print(str);
                    pw.flush();
                    System.out.println(weight[i]);
                }
                pw.close();
            }
            if (st.equals("NO") || st.equals("no")) {
                flag = true;
                System.out.println("点名继续");
            }
            while ((st.equals("OK") || st.equals("ok")) && (st.equals("NO") || st.equals("no"))) {
                System.out.println("未识别输入，请重新输入");
                st = sc.nextLine();
                if (st == "OK")
                    flag = false;
                if (st == "NO")
                    flag = true;
            }
            if (count >= StuNum - 1) {
                flag = false;
                System.out.println("所有学生都已点过名");
            }

        }
        PrintWriter printWriter =new PrintWriter(weightFile);
        for (int i=0;i<StuNum;i++){
            printWriter.write(String.valueOf(weight[i])+"\n");
            printWriter.flush();
        }

    }

    public int[] sortWeight(float[] w,int[] t) {
        for (int i = 0; i < StuNum - 1; i++) {
            for (int j = i; j < StuNum; j++) {
                if (w[i] < w[j]) {
                    float tmp;
                    tmp = w[i];
                    w[i] = w[j];
                    w[j] = tmp;
                    int tp;
                    tp = t[i];
                    t[i] = t[j];
                    t[j] = tp;
                }
            }
        }
        System.out.println(Arrays.toString(w) + "\n" + Arrays.toString(t));
        return t;
    }

    public static void main(String[] args) throws IOException {
        File name = new File("c:\\name.txt");
        File weight = new File("c:\\weight.txt");
        randomRollCall rrd =new randomRollCall(9);
        rrd.rollCall(name, weight);

    }
}
