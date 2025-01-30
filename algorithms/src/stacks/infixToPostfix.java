package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class infixToPostfix {

    public static boolean isNumber (String str) {
        return !(str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '*' || str.charAt(0) == '/' || str.charAt(0) == '^' || str.charAt(0) == '(' || str.charAt(0) == ')');
    }

    public static int priority (Character ch) {
        if (ch == '(') return 4;
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();
        String [] tokens = infix.split("\\s+");
        Stack<Character> stack = new Stack<Character>();

        StringBuilder postfix = new StringBuilder();

        for (String token : tokens) {
            if (isNumber(token)) postfix.append(token).append(" "); // ако си број, супер испринтај се
            else if (token.charAt(0) == '(') stack.push(token.charAt(0));
            else if (token.charAt(0) == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') postfix.append(stack.pop()).append(" ");
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && priority(stack.peek()) >= priority(token.charAt(0)))
                    postfix.append(stack.pop()).append(" ");
                stack.push(token.charAt(0));
            }
        }

        while (!stack.isEmpty()) postfix.append(stack.pop()).append(" ");

        System.out.println(postfix);

        // Со задачава си помогнав малку од интернет за да можам да сфатам
        // што точно треба да се прави и која е процедурата.
        // На многу интересен начин се користи стекот тука и научив дека
        // postfix нотација им е полесна на компјутерите.
        // Прво пишувам функција која што проверува кој е приоритетот на операторите
        // и функција која проверува дали е број или оператор.
        // Доколку е број веднаш го ставам во postfix StringBuilder-от.
        // Доколку е „(“ тогаш ја ставам на стекот, а ако е „)“
        // имам while loop којшто ми врти се додека стекот не остане празен и
        // се додека на врв не наидеме на „(“, ќе ги ставаме операторите во postfix.
        // Во моментов кога ќе заврши while циклусот,
        // ќе направиме stack.pop() за да ја тргнеме „(“ заградата.

        // Инаку, ако наидеме на оператор,
        // повторно имаме while loop којшто врти се додека не е празен стекот,
        // се додека не наидеме на „(“ (не сакаме да ја попнеме оваа заграда, како граница е на некој начин),
        // и се додека приоритетот на тоа што е внатре во стекот е поголем од приоритетот на токенот што доаѓа
        // Откако ќе заврши циклусот, можеме да го ставиме токенот што дошол во стекот.
        // На крај, проверуваме да не има останати последни оператори кои истите треба да ги
        // ставиме во postfix.

        // youtube видеото кое ми помогна:
        // https://youtu.be/ymG0zxuC__I?t=68

    }


}
