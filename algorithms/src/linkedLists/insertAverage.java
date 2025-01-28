package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class insertAverage {

    public static int findAverage(int a, int b) {
        return (int) Math.ceil((double) (a + b) / 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            int insert = findAverage(list.get(index), list.get(index + 1)); // Ќе го најде просекот на 1 и 2
            list.add(index + 1, insert); // ќе го додаде на прва позиција
            index += 2; // 2, 4 // Со += 2, го скокаме просекот кој што сме го додале и ги гледаме само OG елементите
        }

        System.out.print(list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" -> " + list.get(i));
        }

        // Клучните моменти во задачата се следните:
        // -знаејќи колку итерации да направиме (ако имаме n јазли, нас ни требаат n - 1 итерации/просеци за пресметување)
        // -користење на посебна променлива index која што ние рачно ја зголемуваме за 2 во форот, скокајќи го просекот
        // кој што сме го додале (да не се случи да правиме просек помеѓу ~просекот~ и еден од елементите)
        // -креирање на посебна функција горе за да го направиме кодот почитлив.
        // 
        // * Важно е да се знае дека со користење на add методата,
        // ние ги менуваме индексите на секој од елементите *
        //
        // Како работи add(int index, E element) функцијата?
        // Shifts the element currently at that position (if any)
        // and any subsequent elements to the right (adds one to their indices)

    }

}
