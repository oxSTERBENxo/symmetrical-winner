package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class assigningTerms {

    public static boolean isThere(ArrayList<String> math, String person) {
        boolean yay = false;
        for (int i = 0; i < math.size(); i++) {
            if (math.get(i).equals(person)) {
                yay = true;
                break;
            }
        }
        return yay;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ;

        Queue<String> pollMath = new LinkedList<String>();
        Queue<String> pollAny = new LinkedList<String>();
        Queue<String> special = new LinkedList<>();
        ArrayList<String> trueMath = new ArrayList<String>(); // по индекс да можам да ги проверувам

        int capacity = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim()); // број на студенти кои кликнале опција 2 (математика)

        for (int i = 0; i < n; i++)
            pollMath.offer(br.readLine().trim());

        int m = Integer.parseInt(br.readLine().trim()); // број на студенти кои им е океј било кога
        for (int i = 0; i < m; i++)
            pollAny.offer(br.readLine().trim());

        int k = Integer.parseInt(br.readLine().trim()); // број на студенти коишто вистински полагаат Математика
        for (int i = 0; i < k; i++)
            trueMath.add(br.readLine().trim());

        LinkedList<String> termMath = new LinkedList<>(); // термин за Математика
        LinkedList<String> termAny = new LinkedList<>();

        while (!pollMath.isEmpty()) {
            String person = pollMath.poll(); // првиот човек на листата кој кликнал дека полага математика
            boolean isThere = isThere(trueMath, person);
            if (isThere && termMath.size() < capacity) termMath.add(person);
            else if (isThere) special.offer(person);
            else pollAny.offer(person);
        }

        while (!special.isEmpty()) {
            String person = special.poll();
            termAny.offer(person);
        }

        while (!pollAny.isEmpty()) {
            String person = pollAny.poll();
            if (termMath.size() < capacity) termMath.add(person);
            else termAny.add(person);
        }

        int numOfTerms = (int) Math.ceil((double) (n + m) / capacity); // колку термини ќе треба да направам

        int term = 1;

        System.out.println(term);
        for (String s : termMath) {
            System.out.println(s);
        }


        for (int i = 1; i < numOfTerms; i++) {
            term++;
            int printed = 0; // колку се испечатени
            System.out.println(term); // кој број на термин сме
            while (printed < capacity && !termAny.isEmpty()) { // морам вака за да ми се печатат правилно
                System.out.println(termAny.poll()); //
                printed++;
            }
        }

        // Задачата од нас бара да ги сместиме студентите во термини.
        // Предност се дава на студентите коишто истиот ден полагаат и Математика,
        // а студентите кои мамат на анкетата, се ставаат на крај од списокот за било кој термин.
        // (има два списоци, студенти кои полагаат Математика тој ден и студенти кога се океј во било кој термин да полагаат)
        // Правам 3 редици, една за тие што се пријавиле дека полагаат Математика, една за тие што им е океј било кога
        // и една специјална редица, за ако случајно има некои коишто полагаат Математика ама да нема доволно капацитет
        // во тој термин, ги ставам во специјалната редица, за да бидат први сместени во следниот најран термин
        // Печатењето малку е смешничко ама тоа е.

    }

}
