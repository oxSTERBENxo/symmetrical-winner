package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class creatingH2OMolecule {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String[] tokens = token.split(" ");

        Stack<Character> hydrogen = new Stack<Character>();
        Stack<Character> oxygen = new Stack<>();

        int counter = 0;

        for (String atom : tokens) {
            if (atom.equals("H")) {
                if (hydrogen.isEmpty()) hydrogen.push('H'); // види дали е празен
                else
                    if (hydrogen.size() >= 2 && !oxygen.isEmpty()) { // ако не е празен и има повеќе од два и оксиген не е празен
                        hydrogen.pop(); // има само еден поп, бидејќи ова што дошло новово треба да го ставиме, па да тргнам redundancy, да не биде вади вади стави, може само да биде вади и толку xD
                        oxygen.pop();
                        counter++;
                    } else hydrogen.push('H'); // ако не се изврши кодот горе, тогаш значи дека сепак треба да те ставиме
            }
            if (atom.equals("O")) {
                if (oxygen.isEmpty())
                    if (hydrogen.size() >= 2) {
                        hydrogen.pop();
                        hydrogen.pop();
                        counter++;
                    }
                    else oxygen.push('O');
                else
                    if (hydrogen.size() >= 2) { // ако е празен оксиген, нема што да го ставаме новово (затоа не правам oxygen.push())
                        hydrogen.pop();
                        hydrogen.pop();
                        counter++;
                    } else oxygen.push('O');
            }
        }

        if (hydrogen.size() >= 2 && !oxygen.isEmpty()) {
            hydrogen.pop();
            hydrogen.pop();
            oxygen.pop();
            counter++;
        }

        System.out.println(counter);
        for (Character h : hydrogen) System.out.print(h + " ");
        for (Character o : oxygen) System.out.print(o + " ");


        // Задачава на почеток ми личеше страшна но,
        // веднаш видов дека е слична со cancellingOutBalls.java
        // Повторно морам да користам два стека бидејќи
        // немам како да ја направам молекулата ако го имам тест примерот
        // О О О О Н О О Н
        // На секое влегување на атомче,
        // проверувам прво што е, (или е Н или е О)
        // ако е Н и водородниот стек е празен тогаш го ставам,
        // а пак ако е О и кислородниот стек е празен,
        // пред да го ставам проверувам дали водородниот стек има веќе две Н атомчиња.
        // Ако има, ич не го ставам дојденото атомче О, ги попнувам двете атомчиња Н и си продолжувам со животот.

        // Ако ми дојде Н атомче и ако не е празен водородниот стек,
        // тогаш пред да го ставам во стекот повторно проверувам дали водородниот стек
        // има 2 или повеќе водородни атомчиња и дали кислородниот стек има барем едно.
        // Ако се исполнети овие претходно наведени услови, тогаш вадам само едно Н и вадам едно О
        // Ако не се исполнети овие услови ќе морам да го ставам во стекот и да чекаме поубави денови.
        // Сличново работи и за О. На кратко, на секое атомче проверувам дали има можност
        // да тргнам две Н атомчиња и едно О.

        // На крајот проверувам случајно да не сум пропуштила нешто.
        // Потребно ми е последното проверување најмногу за овој тест пример:
        // О О О О Н О О Н
        // Јас проверувам дали има можност да се извадат атомчиња секогаш кога доаѓаат атомчиња.
        // Но кога последното атомче ќе го ставам, јас ќе имам на крај доволно атоми за да извадам
        // две водородни и едно кислородно атомче но никогаш нема да проверам
    }

}
