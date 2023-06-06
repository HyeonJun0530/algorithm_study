package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] nums = str.split("-");
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;

            String[] add = nums[i].split("\\+");

            for (String s : add) {
                tmp += Integer.parseInt(s);
            }


            if (answer == Integer.MAX_VALUE) {
                answer = tmp;
            } else {
                answer -= tmp;
            }

        }

        System.out.println(answer);
    }
}
