package LeetCode;

import java.util.*;

public class MinDifference {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        ArrayList<String> time=new ArrayList<>();
        time.add("23:59");time.add("00:00");
        System.out.println(findMinDifference(time));
    }
    private static int findMinDifference(List<String> timePoints) {
        int gap=24*60;
        int[] min=new int[timePoints.size()+1];
        for (String time:timePoints){

        }
        return min[0];
    }
}
