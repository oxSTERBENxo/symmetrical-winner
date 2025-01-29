package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class cancellingOutBalls {

    public static boolean canCancel (String ch, String cch) {
        if ((ch.equals("R+") && cch.equals("R-")) || (ch.equals("R-") && cch.equals("R+"))) return true;
        if ((ch.equals("G+") && cch.equals("G-")) || (ch.equals("G-") && cch.equals("G+"))) return true;
        if ((ch.equals("B+") && cch.equals("B-")) || (ch.equals("B-") && cch.equals("B+"))) return true;
        return false;
    }

    public static String partnerInCrime (String ch) {
        return switch (ch) {
            case "R+" -> "R-";
            case "R-" -> "R+";
            case "G+" -> "G-";
            case "G-" -> "G+";
            case "B+" -> "B-";
            case "B-" -> "B+";
            default -> "";
        };

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String[] tokens = token.split("\\s+");

        Stack<String> reds = new Stack<>();
        Stack<String> greens = new Stack<>();
        Stack<String> blues = new Stack<>();

//        Stack<String> redMinus = new Stack<>();
//        Stack<String> greenMinus = new Stack<>();
//        Stack<String> blueMinus = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].charAt(0) == 'R') { // домен на црвените
                if (reds.empty()) reds.push(tokens[i]);
                else
                    if (canCancel(reds.peek(), tokens[i])) reds.pop();
                    else reds.push(tokens[i]);

            }
            if (tokens[i].charAt(0) == 'G') {
                if (greens.empty()) greens.push(tokens[i]);
                else
                    if (canCancel(greens.peek(), tokens[i])) greens.pop();
                    else greens.push(tokens[i]);
            }
            if (tokens[i].charAt(0) == 'B') {
                if (blues.empty()) blues.push(tokens[i]);
                else
                    if (canCancel(blues.peek(), tokens[i])) blues.pop();
                    else blues.push(tokens[i]);
            }
        }

        System.out.println(reds);
        System.out.println(greens);
        System.out.println(blues);

        int counter = reds.size() + greens.size() + blues.size(); // колку парови можат да се направат

        System.out.println(counter);


        for (String ball : reds) {
            System.out.print(partnerInCrime(ball) + " ");
        }

        for (String ball : greens) {
            System.out.print(partnerInCrime(ball) + " ");
        }

        for (String ball : blues) {
            System.out.print(partnerInCrime(ball) + " ");
        }


        // Во оваа игра на располагање имаме топчиња во три различни бои (R-црвена,
        // G-зелена и B-сина), обележани со знакот + или -.
        // Поништување на топчиња може да настане само доколку
        // тие се од иста боја и со спротивен знак.
        // На почеток се генерира една случајна листа со топчиња.
        // Наша задача е од тоj влез, како
        // доаѓаат топчињата, да направиме поништување и да кажеме
        // уште колку топчиња фалат за да се поништат преостанатите топчиња.
        // Треба да го наведеме и типот и од која боја фалат

        // Влез:
        // R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
        // Парови кои можат да се формираат:
        // (R+, R-); (B+, B-); (B-, B+); (R+, R-); (G-, G+); (R+, R-)
        // Излез:
        // 4 (колку топчиња фалат)
        // R- G- G- B-

        // Споменато е дека треба да се користи стек. Задачава сум сигурна дека може и на друг начин да се реши.
        // Имав повеќе trial and error моменти но сепак успеав.
        // (ќе ги оставам моите неуспешни кодови во коментари, мора од некаде да се почне)
        //
        // Уште при прво читање на задачата, веднаш забележав
        // дека проблемот е сличен како проблемот со заградите (correctBrackets.java)
        //
        // При анализирање на тест примерот, сфатив дека ќе ми се потребни 3 различни стека,
        // по еден за секоја боја. За тест примерот R+, G- B+, R- доколку би користела еден стек,
        // не би можела да ги спарам R+ и R-.

        // Итерирам низ мојата листа со топчиња и секое топче го сместувам во соодветниот стек.
        // Доколку стекот за црвени топчиња е празен, ќе ставам црвено топче во него (без разлика дали е R+ или R-)
        // Ако повторно имам црвено топче, стекот веќе нема да е празен,
        // ќе можам успешно да ја извршам функцијата stack.peek() без да ми се фрли EmptyStackException.
        // Со peek() функцијата само го гледам елементот, (не го вадам), и проверувам дали можат да се поништат.
        // Ако можат да се поништат ќе го извадам елементот и стекот ќе е повторно празен, но ако не можат да се поништат
        // стекот ќе има уште еден елемент.

        // Имам напишано помошни функции. Едната ми проверува дали се поништуваат,
        // а пак другата ми враќа за секое топче соодветно партнерче (за G+ ќе врати G-)

        // За да видам колку топчиња уште фалат, само бројам уште колку има останато топчиња во секој од стековите.
        // (поништените топчиња не се во стековите, само тие без пар се во стековите)
        




//        for (int i = 0; i < tokens.length; i++) {
//            if (tokens[i].equals("R+")) redPlus.push(tokens[i]);
//            if (tokens[i].equals("G+")) greens.push(tokens[i]);
//            if (tokens[i].equals("B+")) blues.push(tokens[i]);
//            if (tokens[i].equals("R-")) redMinus.push(tokens[i]);
//            if (tokens[i].equals("G-")) greenMinus.push(tokens[i]);
//            if (tokens[i].equals("B-")) blueMinus.push(tokens[i]);
//        }

//        System.out.println(redMinus);
//        System.out.println(greenMinus);
//        System.out.println(blueMinus);



    }

}
