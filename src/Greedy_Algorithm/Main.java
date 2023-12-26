package Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int resumeRank;
    int interviewRank;

    public Person(int resumeRank, int interviewRank) {
        this.resumeRank = resumeRank;
        this.interviewRank = interviewRank;
    }

    @Override
    public int compareTo(Person o) {
        return this.resumeRank - o.resumeRank;
    }
}

public class Main {
    public int solution(Person[] persons) {
        int answer = 1;

        Arrays.sort(persons);
//        3 2   =>      1 4                 3 6     =>      1 4                 1 4     =>      1 4
//        1 4   =>      2 3                 7 3     =>      2 5                 2 3     =>      2 3
//        4 1   =>      3 2                 4 2     =>      3 6                 3 2     =>      3 2
//        2 3   =>      4 1                 1 4     =>      4 2                 4 1     =>      4 1
//        5 5   =>      5 5                 5 7     =>      5 7                 5 7     =>      5 7
//                                          2 5     =>      6 1                 6 6     =>      6 6
//                                          6 1     =>      7 3                 7 5     =>      7 5
        Person person = persons[0];
        for (int i = 1; i < persons.length; i++) {
            if (person.interviewRank > persons[i].interviewRank) {
                person = persons[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            Person[] persons = new Person[N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int resumeRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());
                persons[j] = new Person(resumeRank, interviewRank);
            }

            System.out.println(main.solution(persons));
        }
    }
}