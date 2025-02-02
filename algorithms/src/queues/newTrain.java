package queues;

import java.util.*;

public class newTrain {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> wagons = new ArrayList<>();
        Stack<Integer> oldTrain = new Stack<>();

        for (int i = 0; i < n; i++) wagons.add(sc.nextInt());

        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i) > 0) oldTrain.push(wagons.get(i));
            else {
                wagons.remove(i);
                i--;
            }
        }

        Collections.sort(wagons); // како што ни се дадени обратно

        Queue<Integer> helper = new LinkedList<>();
        LinkedList<Integer> newTrainFromEnd = new LinkedList<>();

        while (!oldTrain.isEmpty()) {
            helper.offer(oldTrain.pop()); // сите стави ги на шината
        }

        int i = 0;
        while (!helper.isEmpty()) {
            int wagon = helper.poll();
            if (wagon == wagons.get(i)) {
                newTrainFromEnd.add(wagon);
                i++;
            }
            else helper.offer(wagon);
        }

        System.out.println(newTrainFromEnd);

        // Задачава е бесна нема да лажам. Има повеќе решенија, не знам дали е најреалистичното решение
        // ама не сум крива јас што таква ја имаат направено. Прво ги скокам сите нули, и сите
        // вагони ги ставам на oldTrain. Потоа ја сортирам низата вагони.
        // Во еден while, гледам дали вагонот што ќе го извадам е тој што ни треба,
        // ако е тој супер го ставам на newTrainFromEnd,
        // инаку го враќам на крај во редицата

    }

}
