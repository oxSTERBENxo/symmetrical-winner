package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class twistTheList {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        LinkedList<Integer> twisted = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) twisted.add(list.get(i)); // почнувајќи од крај, прво парните елементи ги ставаме како
                                                                // први во twisted листата
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 != 0) twisted.add(list.get(i)); // почнувајќи од крај, сега ги додаваме непарните елементи
        }

        
        System.out.print(twisted.getFirst());
        for (int i = 1; i < twisted.size(); i++) System.out.print(" -> " + twisted.get(i));
            
        // Решението на задачата е доста едноставно, но може да се направи и премногу комплицирано без потреба.
        // Правам помошна листа twisted каде ќе ги „превртувам“ јазлите.
        // Во првиот фор циклус само ги разгледувам елементите
        // кои што се парни (занемарувајќи ги непарните елементи) и нив ги додавам во twisted.
        // Го копирам фор циклусот, само со една мала промена во if условот,
        // сега само разгледувајќи ги непарните елементи (занемарувајќи ги парните)
        // Ги „превртувам“ и непарните елементи со тоа што ги ставам
        // во обратен редослед во листата twisted.
    }
        
}
