package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class openTagClosedTag {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.trim()); // колку редови ќе ни бидат дадени
        Stack<String> stack = new Stack<String>();

        int valid = 1;


        for (int i = 0; i < n; i++) {
            String token = br.readLine();
            if (n == 1) {
                System.out.println(0);
                break;
            }
            if (token.charAt(0) == '[') { // ако си таг
                if (token.charAt(1) != '/') stack.push(token); // ако не си затворачки таг, стави се во стек
                else {
                    if (!stack.isEmpty() && stack.peek().charAt(1) != token.charAt(2)) {
                        valid--;
                        break;
                    } else if (!stack.isEmpty()) stack.pop();
                    else {
                        valid--;
                        break;
                    }
                }
            }
        }

        System.out.println(valid);

        // Во задачава се бара да видам дали валидни се таговите или не.
        // Валидни тагови се ако за секој отворачки таг имам затворачки
        // [tag1][/tag1]
        // Невалидно е ако е вака: [tag1][/tag2]
        // [tag1][tag2][/tag1][tag2]

        // Задачата ја решавам со тоа што користам стек,
        // секогаш кога ќе наидам на [ карактер, проверувам дали е отворачки или затворачки
        // ако е отворачки го ставам во стекот ако е затворачки проверувам дали
        // најгорниот елемент на стекот е соодветен на затворачкиот таг. Ако е соодветен, го тргнувам од стекот
        // ако не е соодветен, го кршам форот, валид е 0 и го печатам валид

    }


}
