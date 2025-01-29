package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class correctBrackets {

    public static boolean areMarried (char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '[' && b == ']') return true;
        if (a == '{' && b == '}') return true;
        return false;
    }

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // нов начин на примање од стандарден влез
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean isOkay = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') { // ако карактерот е еден од отворените загради
                stack.push(ch); // стави го во стекот
            }
            else if (ch == ')' || ch == '}' || ch == ']') { // ако карактерот е еден од затворените загради

                if (stack.empty()) isOkay = false;

                char c = stack.peek(); // види прво кој е (ако веднаш го извадам, ќе ми фрли EmptyStackException)

                if (!areMarried(c, ch)) isOkay = false;

                if (isOkay) stack.pop(); // чим океј поминало, извади го од стекот (ќе дојдеме до тука ако isOkay e true ^-^)
            }
        }

        System.out.println("The brackets are " + (isOkay ? "correct " : "not correct ") + "in " + input + ".");

        // Во задачава нема нешто комплицирано, вовед на Stack е.
        // Можеме да ја видиме примената на стекот, ни дозволува да запазуваме
        // редослед со заградите и адекватно да споредуваме.

        // Горе имам направено едноставна функција која проверува
        // дали отворената и затворената заграда се исти.

        // Ако случајно наидеме на затворена заграда, а стекот е празен,
        // тоа е знак дека претходно немало отворена заграда никаде (во стекот ставаме само отворени загради)

        // Стекот како би изгледал доколку го имавме изразот: x + (x (2 - 3) - [6 + 6] * {23} / x - (s-a))

        // (
        // {
        // [
        // (
        // (
    }

}
