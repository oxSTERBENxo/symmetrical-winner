package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class organizationForExam {

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> eTest = new LinkedList<String>();
        Queue<String> practical = new LinkedList<>();
        Queue<String> both = new LinkedList<>();

        int n = Integer.parseInt(br.readLine().trim()); // број на студенти кои ќе полагаат само теорија
        for (int i = 0; i < n; i++) {
            eTest.add(br.readLine());
        }

        int m = Integer.parseInt(br.readLine().trim()); // број на студенти кои ќе полагаат само задачи
        for (int i = 0; i < m; i++) {
            practical.add(br.readLine());
        }

        int k = Integer.parseInt(br.readLine().trim()); // број на студенти кои ќе ги полагаат и двата дела
        for (int i = 0; i < k; i++) {
            both.add(br.readLine());
        }

        LinkedList<String> eventETest = new LinkedList<>();
        LinkedList<String> eventPractical = new LinkedList<>();


        while (!eTest.isEmpty()) eventETest.add(eTest.poll()); // стави ги сите што се за е-тест во списокот за е-тест
        while (!both.isEmpty()) {
            String student = both.poll();
            eventETest.add(student); // стави ги на списокот за е-тест
            practical.offer(student); // стави ги на крајот од редот за задачи
        }

        while (!practical.isEmpty()) eventPractical.add(practical.poll());

        int eTestTerms = (int) Math.ceil((double) (n + k) / 20); // колку термини ќе треба да направам за е-тест
        int practicalTerms = (int) Math.ceil((double) (m + k) / 20); // колку термини ќе треба да направам за практично

        System.out.println("Полагаат е-тест:");

        for (int i = 1; i <= eTestTerms; i++) {
            System.out.println("термин " + i + ":");
            int printed = 0;
            while (printed < 20 && !eventETest.isEmpty()) { // вака ги цепкам списоците, редоследот е веќе запазен
                System.out.println(eventETest.poll()); // тука користам poll() за да го печатам првиот и воедно да ми се вадат од листата
                printed++;
            }
        }

        System.out.println("Полагаат задачи");

        for (int i = 1; i <= practicalTerms; i++) {
            System.out.println("термин " + i + ":");
            int printed = 0;
            while (printed < 20 && !eventPractical.isEmpty()) {
                System.out.println(eventPractical.poll());
                printed++;
            }
        }

        // Од нас се бара да ги сместиме студентите во термини,
        // а капацитетот во еден термин е 20 студенти
        // Најпрво се обработуваат студентите кои ќе полагаат само теорија (е-тест)
        // Доколку има уште место во терминот за теорија, а веќе нема студенти коишто
        // ќе полагаат САМО теорија, се земаат студентите коишто ќе полагаат и теорија и задачи
        // и се ставаат во тој термин со цел да се пополни место.
        // Студентите што ќе ги ставиме во терминот за теорија, а треба да полагаат и задачи
        // истите при завршување на испитот, одат на крајот од редицата што чека за терминот за задачи
        // Печатењето повторно личи смешно.

        // Задачата ја решавам со тоа што правам листи (списоци) и само ги ставам сите студенти
        // кои што се во редиците, на списокот и секако се запазува распоредот.
        // Според мене, најчудниот дел од задачата е самото печатење.
        // При печатењето, ги делам списоците на термини и ги печатам.
    }


}
