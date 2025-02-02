package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class consultationsBackAndForth {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> questions = new LinkedList<String>();
        Queue<String> problems = new LinkedList<String>();
        Queue<String> both = new LinkedList<String>();

        int n = Integer.parseInt(br.readLine().trim()); // колку студенти се само за прашања
        for (int i = 0; i < n; i++)
            questions.offer(br.readLine());

        int m = Integer.parseInt(br.readLine().trim()); // колку студенти се само за задачи
        for (int i = 0; i < m; i++)
            problems.offer(br.readLine());

        int k = Integer.parseInt(br.readLine().trim()); // колку студенти се и за двете
        for (int i = 0; i < k; i++)
            both.offer(br.readLine());

        LinkedList<String> events = new LinkedList<>(); // список на влегување

        while (!questions.isEmpty() || !problems.isEmpty() || !both.isEmpty()) {
            if (!questions.isEmpty()) events.add(questions.poll()); // ако не си празен топ, додаден на списокот
            else if (!both.isEmpty()) { // го правам ова за да не ми фрли исклучок
                String student = both.poll();
                events.add(student); // стај го на списокот (прашува кратки прашања)
                problems.offer(student); // стај го на крајот од редицата за задачи
            }
            if (!problems.isEmpty()) events.add(problems.poll());
            else if (!both.isEmpty()) {
                String student = both.poll();
                events.add(student); // стај го на списокот (прашува за задачи)
                questions.offer(student); // стај го на крајот од редицата за кратки прашања
            }
        }

        for (String event : events) System.out.println(event);

        // Во задачата се бара да ги обработуваме студентите еден по еден,
        // еднаш од кратки прашања еднаш од задачи. Доколку нема студенти за прашување на само кратки прашања
        // се земаат студентите коишто прашуваат и кратки прашања и задачи
        // Студентите коишто ќе прашуваат и кратки прашања и задачи, ги ставам во посебна редица both
        // Нејзината намена е кога тогаш да се испразни (со ова водам сметка да не ми се повторуваат по 5 пати студенти)
        // Еден студент при печатење може максимум двапати да се појави.


    }

}
