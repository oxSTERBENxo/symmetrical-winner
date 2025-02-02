package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Subject {
    String name;
    int assistantsNeeded;

    Subject(String name, int assistantsNeeded) {
        this.name = name;
        this.assistantsNeeded = assistantsNeeded;
    }

    @Override
    public String toString() {
        return name;
    }
}


public class colloquiumWeek {

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Subject> subjects = new ArrayList<Subject>();
        ArrayList<String> absent = new ArrayList<String>();
        ArrayList<String> input = new ArrayList<String>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++)
            input.add(br.readLine()); // го правам ова за подоцна да видам дали да ги ставам во редицата (финалниот избор) или не

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");
            String subject = tokens[0];
            int assistantsNeeded = Integer.parseInt(tokens[1]);
            subjects.add(new Subject(subject, assistantsNeeded));
        }

        int k = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < k; i++) {
            absent.add(br.readLine());
        }

        Queue<String> assistants = new LinkedList<String>();

        for (int i = 0; i < input.size(); i++) {
            String assistant = input.get(i);
            if (!absent.contains(assistant)) assistants.offer(assistant); // ако не е во отсутни списокот, стај го во редицата
        }

        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println(subject);
            System.out.println(subject.assistantsNeeded);
            for (int j = 0; j < subject.assistantsNeeded; j++) {
                String assistant = assistants.poll();
                System.out.println(assistant);
                assistants.offer(assistant);
            }
        }

        // Во задачата се бара да се одредат асистенти за секој од предметите дадени на влез.
        // Притоа од вкупните асистенти, има список на отсутни асистенти коишто не треба
        // да се имаат предвид кога ќе се прават списоците.
        // Правам едноставна класа со два атрибути (име и колку асистенти се потребни)
        // со цел полесно да ги земам податоците.
        // Важно во задачата е дека кога еднаш ќе се запази редот во редицата
        // колкав сака нека е тест примерот, секогаш по тој редослед ќе одиме,
        // а нас на почеток ни се веќе сортирани од најмал до најстар


    }

}
