package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class divideByAverage {

    public static double findAverage(LinkedList<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) sum += list.get(i);
        return sum / list.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        LinkedList<Integer> winners = new LinkedList<>(); // поголеми од просекот
        LinkedList<Integer> losers = new LinkedList<>(); // помали или еднакви на просекот

        double average = findAverage(list); // просекот на листата

        for (int i = n - 1; i >= 0; i--) { // обратен фор
            if (list.get(i) <= average) losers.add(list.get(i)); // ако си помал или еднаков на просекот, одиш кај лузерите
            else winners.add(list.get(i)); // инаку одиш кај победниците
        }

        System.out.print(losers.getFirst());
        for (int i = 1; i < losers.size(); i++) {
            System.out.print(" -> " + losers.get(i));
        }

        System.out.println();

        System.out.print(winners.getFirst());
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(" -> " + winners.get(i));
        }

        // Креирам две резултантни листи, лузери и победници. Во лузери одат сите елементи кои што се
        // помали или еднакви на просекот, а во победници одат сите елементи кои што се поголеми од просекот.
        // Во задачата е напоменато да итерираме во обратен редослед (обратен фор)
        // Погоре имам направено функција findAverage која што го бара просекот на целата листа, и истата
        // функција ја повикувам и резултатот го сместувам во променливата average.
        // Внатре во форот проверувам за секој елемент дали треба да оди во лузери или во победници
        // и го сместувам соодветно.


    }

}
