package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class listFromLists {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<LinkedList<Integer>> list = new LinkedList<>(); // листа од листи

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>()); // на секоја позиција, додади LinkedList
            for (int j = 0; j < m; j++) list.get(i).add(sc.nextInt());  // list.get(i) ќе ја врати
                                                                        // i-тата LinkedList и на
                                                                        // неа ќе го додаде бројчето
        }


        int product = 1;

        for (int i = 0; i < n; i++) {
            int sum = 0; // За секоја листа нова сума
            for (int j = 0; j < list.get(i).size(); j++) {
                sum += list.get(i).get(j); // На i-тата листа, ј-тиот елемент додади го на вкупната сума
            }
            product *= sum; // откако ќе се пресмета сумата, помножи ја за да се добие производ на сумите
        }

        System.out.println(product);

        // Иако во учебникот пишува „Напредни проблеми со двострано поврзани листи“,
        // задачава е доста лабава и не е многу тешка. Најтешкиот дел е знаејќи како
        // да иницијализираме и да создадеме листа од листи. Потребен ќе ни е вгнезден for циклус (за жал)
        // Каде што на почетокот од секоја итерација на првиот фор циклус, на нашата мастер листа
        // и додаваме под листа со методот list.add(new LinkedList<>());
        // Потоа во вториот фор, на i-тата листа која што сме ја создале и додале,
        // со методот list.get(i).add(sc.nextInt()); го додаваме соодветното бројче,
        // прочитано од стандарден влез, на подлистата.
        //

        // Како работи get методот?

        // Return type          Method
        //     E	            get(int index)
        //                      Returns the element at the specified position in this list.
        //
        // каде Е е генерички тип. Во оваа задача, имаме листа која што во неа содржи
        // LinkedList, а тие листи содржат цели броеви. (LinkedList<LinkedList<Integer>>)
        // Па нашиот return type овде ќе е LinkedList. Следува дека методот get(int index) ќе ја врати
        // листата што се наоѓа на позиција i.
    }

}
