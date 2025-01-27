package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class Palindrome {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        String fromBeginning = "";
        String fromEnding = "";

        for (int i = 0; i < list.size(); i++) {
            fromBeginning += list.get(i) + " "; // list.get(i).toString() + " " // Java handles the string conversion automatically // секој објект има toString() метода
        }

        for (int i = n - 1; i >= 0; i--) {
            fromEnding += list.get(i) + " ";
        }

        if (fromBeginning.equals(fromEnding)) System.out.println(1);
        else System.out.println(-1);

	
	// Задачава во учебникот е од делот двојно поврзани лист.
	// Имам дилема дали ова е прифатливо решение за испит, бидејќи
	// различно е решението кога работам со LinkedList имплементирано
	// од Java, и DLL/SLL класата имплементирана од ФИНКИ xD
	// LinkedList класата е имплементација на doubly-linked list
	// податочната структура и е одлична класа со прекрасни методи
	// кои што го прават манипулирањето на елементи помалку мизерно :D

	// Моето решение е доста едноставно, имам два string-ови кои што
	// на почетокот ги иницијализирам како празни. Со два фор циклуси
	// прво итерирам од почеток до крај и тоа вредностите на секој
	// од елементите го ставам во string-от
	// наречен fromBeginning. Истата постапка ја правам уште еднаш само
	// што тука итерирам од крај до почеток и вредностите на елементите
	// ги ставам во string-от fromEnding. На крај, ги споредувам дали
	// овие стрингови се исти, ако се исти супер тогаш е палиндром,
	// ако не се исти тогаш не е супер.

	// Во учебникот задачава е решена користејќи ја класата
	// DLL која што е направена од ФИНКИ, и според мене решението е 
	// покомплицирано.

    }

}
