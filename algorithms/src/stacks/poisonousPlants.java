package stacks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class poisonousPlants {

    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        ArrayList<Integer> plants = new ArrayList<Integer>();
        ArrayList<Integer> markers = new ArrayList<>();

        int days = -1; // морам вака за да личи почитко, во while за плус едно ми пресметува

        for (int i = 0; i < n; i++) {
            plants.add(sc.nextInt());
            markers.add(1);
        }

        for (int i = 0; i < plants.size(); i++) {
            if (stack.isEmpty()) stack.push(plants.get(i)); // првиот секако мора
            else
                if (plants.get(i) <= stack.peek()) stack.push(plants.get(i)); // може да те ставиме само ако си помал или
                                                                                // еднаков на елементот што е најгоре

        }

        while (!stack.equals(plants)) { // се додека не ја достигнеме крајната состојба на растенијата

            for (int i = 1; i < plants.size(); i++) {
                if (plants.get(i) > plants.get(i - 1)) markers.set(i, 0); // ставам маркери, на растенијата кои треба да се бришат
            }
            for (int i = 0; i < plants.size(); i++) {
                if (markers.get(i) == 0) {
                    plants.remove(i); // избриши го растението
                    markers.remove(i); // избриши ја келијата во маркери
                    i--; // намали го i, за да не скокаме елементи
                }
            }
            days++; // зголеми денови
        }

        if (days <= 0) System.out.println(0); // ако воопшто не сме влегле во while-от (не умираат)
        else System.out.println(days); //
//        System.out.println(stack);

        // Задачава може да се реши и само со стек но јас одлучив да ја решам со низа и со стек.
        // На почеток пресметувам која ќе биде крајната состојба на растенијата.
        // Се додека не ја постигнеме крајната состојба, ќе го извршуваме кодот во while-от
        // На почеток, гледам кои растенија сега за сега треба да ги избришам,
        // потоа одам доле и ги бришам (бришам од растенија, бришам од маркери и го намалувам i,
        // за да не скокам елементи)
        // За секој успешен влез во кодот (растенијата умираат), ги зголемувам деновите.
        // Денови ми почнува од -1 бидејќи почнуваме од ден 0 (на ден 0 умираат растенија)
        




    }

}
