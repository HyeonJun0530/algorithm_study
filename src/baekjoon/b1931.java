package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1931 {
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Time> timeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeList.add(new Time(Integer.parseInt(st.nextToken(" "))
                    ,Integer.parseInt(st.nextToken())));
        }

        Collections.sort(timeList);

        int endTime = 0;
        int answer = 0;
        for (Time time : timeList) {
            if(endTime<= time.start) {
                answer++;
                endTime = time.end;
            }
        }

        System.out.println(answer);

    }
}
