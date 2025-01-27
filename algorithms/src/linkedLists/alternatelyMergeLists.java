package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class alternatelyMergeLists {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            first.add(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            second.add(sc.nextInt());
        }

        LinkedList<Integer> merged = new LinkedList<>();
        int i = 0;
        int j = 0;

        boolean theFirst = true;
        boolean theSecond = true;

        while (i < n && j < m) {
            if (i == n - 1) { // сум завршила со првата
                theFirst = false; // првата има непарен број
                merged.add(first.get(i));
                break; // превентивно
            }
            merged.add(first.get(i));
            merged.add(first.get(i + 1));
            i += 2;
            if (j == m - 1) { // сум завршила со втората
                theSecond = false; // втората има непарен број
                merged.add(second.get(j));
                break;
            }
            merged.add(second.get(j));
            merged.add(second.get(j + 1));
            j += 2;
        }

        if (!theFirst || i == n) { // прво сценарио ако сум завршила со првата и ми фали од втората
            for (int k = j; k < m; k++) {
                merged.add(second.get(k));
            }
        } else if (!theSecond || j == m) { // второ сценарио ако сум завршила со втората и ми фали од првата
            for (int k = i; k < n; k++) {
                merged.add(first.get(k));
            }
        }

//        System.out.println(merged);

        System.out.print(merged.getFirst());
        for (int l = 1; l < merged.size(); l++) {
            System.out.print(" -> " + merged.get(l));
        }


        // Можеби решениево да личи комплицирано но, не е. Најчесто се трудам да нема гранење во моите програми
        // но, некогаш потребни се и тие (затоа постојат lol). Кога првпат го прочитав текстот, малку ме натера да почнам
        // да размислувам. Тоа што ми дозволи да стигнам до решението е гледањето на клучните моменти при итерациите, а тоа е дека
        // има повеќе сценарија.
        //
        // 1. двете листи се со парен број елементи и се си оди лабаво,
        // ако едната има помал број од другата, доле со if услов се проверува
        // која е таа (со споредување на i и j до кај се), и само додавање на преостанатите елементи од едната или другата листа
        //
        // 2. едната листа има непарен број елементи,
        // ставам flag проверувајќи која е таа листа, го прекинувам циклусот за подоле да не ми се јави
        // IndexOutOfBoundsException, и доле со if циклус гледам која е таа која што има непарен број на елементи
        // и ги додавам преостанатите елементи од другата
        //
        // 3. двете листи имаат непарен број елементи,
        // повторно ова се решава со flag, се прекинува циклусот за да нема IndexOufOfBoundsException
        // (може да има бидејќи зголемувам за парен број !)
        // Имам и while циклус кој што ми врти и условот за прекинување е ако било кој од i и j стаса до крајот на листите
        // (ова реално помага при првото сценарио, бидејќи во другите две сценарија секако е прекинат циклусот)

    }

}
