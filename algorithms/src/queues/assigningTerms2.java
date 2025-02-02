package queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class assigningTerms2 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> pollBoth = new LinkedList<String>(); // и двата предмети
        Queue<String> pollAPS = new LinkedList<String>(); // само апс
        Queue<String> cheaters = new LinkedList<>(); // тие што лажат
        ArrayList<String> input = new ArrayList<String>(); // влез
        ArrayList<String> trueBoth = new ArrayList<>(); // список вистински што полагаата два предмети во исти ден

        int capacity = Integer.parseInt(br.readLine().trim()); // капацитет во лабораторија

        int n = Integer.parseInt(br.readLine().trim()); // колку студенти наводно полагаат и АПС и Математика
        for (int i = 0; i < n; i++)
            input.add(br.readLine().trim());

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++)
            pollAPS.offer(br.readLine());

        int k = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < k; i++)
            trueBoth.add(br.readLine().trim()); // списокот на студенти што вистински полагаат два предмета

        for (int i = 0; i < n; i++) { // одам до n за секој од луѓето што се во таа анкета, адекватно да се сместат
            if (trueBoth.contains(input.get(i))) pollBoth.offer(input.get(i)); // ако ги има во списокот стави ги
            else cheaters.add(input.get(i)); // инаку стави ги во лажговци
        }

        LinkedList<String> events = new LinkedList<>(); // списокот којшто подоцна ќе го цепкам на термини

        while (!pollBoth.isEmpty()) events.add(pollBoth.poll()); // прво тие кои што полагаат два предмети во ист ден
        while (!pollAPS.isEmpty()) events.add(pollAPS.poll()); // па тие што полагаат само еден предмет (АПС)
        while (!cheaters.isEmpty()) events.add(cheaters.poll()); // на крај лажговците

        int numOfTerms = (int) Math.ceil((double) (n + m) / capacity); // колку термини ќе ми се потребни

        System.out.println();

        for (int i = 1; i <= numOfTerms; i++) { // цепкање на термини
            System.out.println(i);
            int printed = 0;
            while (!events.isEmpty() && printed < capacity) {
                System.out.println(events.poll());
                printed++;
            }
        }

        // Тек на крајот од решавањето сфатив дека истата задача
        // по двапати ја имаат ставено во учебникот.
        // Некако оваа верзија поубаво ја имам напишано.
        // Работата е иста, се дава предност на тие што полагаат два предмети
        // на крај се ставаат тие што лажат на анкетата дека полагаат два предмети.



    }

}
