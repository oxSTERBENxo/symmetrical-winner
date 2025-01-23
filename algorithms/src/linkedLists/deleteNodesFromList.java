package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class deleteNodesFromList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println(list);

//        if (list.get(1) != null) list.remove(1); Не работи со null да споредуваш integers

        int counter = 3;
        int k = 2;
        
        if (list.size() >= 2) list.remove(1); // тука

        while(list.size() > counter) {
            int l = list.remove(counter); // во debug да излегува
            counter*=k;
            k++;
        }

        System.out.println(list);

        // Бројчињава, counter и k, личат смешно на почеток кога ќе ги прочиташ и ќе се запрашаш зошто ги задавам?
        // Прва интуиција ми беше да одам со фор циклус и да итерирам од i = 0 до n,
        // поминав низ повеќе варијанти и првично ги пресметував дека мене индексите за бришење треба да ми се
        // 1 4 8 13 19 26 ... но откако ми излегоа 3 "IndexOutOfBoundsException" исклучоци при тестирање 
        // набрзо сфатив дека не е толку идеален светот во кој жиевееме.
        
        // Со remove функцијата јас истовремено ја менувам големината на листата
        // и индексите на секој од елементите се менуваат
        // 0  1 2  3 4 5  6  7  8   9  10 11 12 13 14  15 16 17 18 19 20 21   <--  индекси
        // 1  3 4  6 7 8  10 11 12 13  15 16 17 18 19  21 22 23 24 25 26 27   <--  хипотетички елементи на низа
        //  2    5      9            14              20                  xх   <--  избришани елементи
        //                                                                   
        //                                                        (хx значи дека тој елемент треба да се брише)
        // 
        // Со чекор по чекор итерирање успеав да стигнам до заклучок дека всушност, трикот на задачата е дека
        // индексите се делат со бројот 3 (multiples of three) (со исклучок на 1 ~ edge case)
        // Во 25та линија, проверувам дали големината на листата е поголема од индексот
        // кој што сакам да го избришам со цел да спречам IndexOutOfBoundsException исклучок
    }

}
