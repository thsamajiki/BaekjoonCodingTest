package Greedy_Algorithm;

import java.util.*;
import java.io.*;

public class Main {
    static class Conference {
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Conference[] conferenceTimes = new Conference[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferenceTimes[i] = new Conference(0, 0);
            conferenceTimes[i].startTime = Integer.parseInt(st.nextToken());
            conferenceTimes[i].endTime = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conferenceTimes, (o1, o2) -> {
            if (o1.endTime == o2.endTime) {
                return o1.startTime - o2.startTime;
            }

            return o1.endTime - o2.endTime;
        });

        int count = 0;
        int prevEndTime = 0;
        for(int i = 0; i < N; i++) {
            if(prevEndTime <= conferenceTimes[i].startTime) {
                prevEndTime = conferenceTimes[i].endTime;
                count++;
            }
        }

        System.out.println(count);
    }
}
