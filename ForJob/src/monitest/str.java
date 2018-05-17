package monitest;
import java.util.*;

public class str {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = s.length() - 2; i >= 0; i = i - 2) {
                s = s.substring(0, i);
                System.out.println(s+"\t"+s.substring(0, i / 2)+
                        "\t"+s.substring(i / 2));
                if (s.substring(0, i / 2).equals(s.substring(i / 2))) {
                    System.out.println(s.length());
                    break;
                }
            }
        }
        sc.close();
    }
}
