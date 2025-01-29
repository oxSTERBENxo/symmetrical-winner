package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfixNotation {

    public static boolean isOperator(String ch) {
        if (ch.length() > 1) return false; // фиксно не е операнд

        char c = ch.charAt(0);
        return switch (c) {
            case '+' -> true;
            case '-' -> true;
            case '*' -> true;
            case '/' -> true;
            default -> false;
        };
    }

    public static double evaluate(char ch, double operand1, double operand2) {
        if (ch == '+') return operand1 + operand2;
        if (ch == '-') return operand1 - operand2;
        if (ch == '*') return operand1 * operand2;
        if (ch == '/') return operand1 / operand2;
        return 0;
    }

    public static void main (String [] args) throws IOException {

        //5 9 + 2 * 6 5 * +
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        Stack<String> stack = new Stack<String>();

        String[] tokens = token.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) stack.push(tokens[i]);
            if (isOperator(tokens[i])) { // +, *, *, +
                double operandTwo = Double.parseDouble(stack.pop()); // 9
                double operandOne = Double.parseDouble(stack.pop()); // 5
                char ch = tokens[i].charAt(0); // +

                double result = evaluate(ch, operandOne, operandTwo); // 5 + 9
                stack.push(Double.toString(result)); // 14
            }
        }

        System.out.println(stack.pop());

        // Во задачата се бара да извршиме евалуација на изразот којшто е во
        // постфикс нотација и да го испечатиме резултатот.
        // Тоа го правиме со помош на stack, каде што прво ги ставаме сите операнди
        // и во моментот кога ќе наидеме на оператор, ги вадиме
        // првите два опепранди од горе со повикување на функцијата stack.pop() двапати,
        // операторот со се двата извадени операнди ги праќаме на функцијата evaluate
        // која што за нас ќе го пресмета резултатот.
        // Резултатот повторно го ставаме во stack.
        // На крај, ако е добро фразирано, треба да добиеме само едно бројче во stack
        // и тоа бројче треба да е нашиот конечен резултат.

        // youtube видеото кое ми помогна:
        // https://youtu.be/P5YWUXrPEyw

    }

}
