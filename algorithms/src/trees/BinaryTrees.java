package trees; // во него ми се ставени класите BNode и BTree
              // ставени ќе се на GitHub

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;


public class BinaryTrees {

    public static int countLeafs(BNode<String> node) {
        if (node == null) return 0; // ако е нул, не придонесува на никаков начин
        if (node.left == null && node.right == null) return 1; // океј ти си лист, го помина тестот, terminate the process, врати 1
        return countLeafs(node.left) + countLeafs(node.right); // инаку, имаш деца
                                                                // види што ќе ти кажат они
                                                                // (не си лист и не придонесуваш)
    }

    private static int countNonTerminalNodes(BNode<String> node) {
        if (node == null) return 0; // не си ништо не придонесуваш
        if (node.left == null && node.right == null) return 0; // ако си лист, не придонесуваш, terminal јазол си,
                                                                // terminate the process

        return 1 + countNonTerminalNodes(node.left) + countNonTerminalNodes(node.right);
        // чим сме тука ги помина сите тестови
        // ти имаш барем едно дете (го помина тестот дека не си лист),
        // придонесуваш на сумата и истовремено види твоите деца што ќе ги кажат
    }

    public static int nodesWithTwoChildren(BNode<String> node) {
        if (node == null) return 0; // ако дрвото е празно или ако нема веќе понатаму, не придонесуваш
        if (node.left == null && node.right == null) return 0; // лист, не придонесуваш
        if (node.left == null)
            return nodesWithTwoChildren(node.right); // имаш само едно дете,
                        // не придонесуваш но види што ќе ти каже твоето единствено дете
        if (node.right == null)
            return nodesWithTwoChildren(node.left); // ако имаш само едно дете, види твоето дете да не е нешто подобро
        return 1 + nodesWithTwoChildren(node.left) + nodesWithTwoChildren(node.right); // ако ги помина сите тестови,
                        // значи имаш две деца и придонесуваш кон сумата, види истовремено и твоите деца што ќе кажат
    }

    public static int maxDepth(BNode<String> node) {
        if (node == null) return 0; // ако е празно дрвото нема длабочина
        if (node.left == null && node.right == null) return 1; // ако си лист врати 1, terminate the process
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); // инаку ако ги помина сите тестови
        // врати 1 (за тебе) и види кој ќе ти даде поголема вредност за длабочина (кој ќе е подобар) и земи го него
    }

    public static int sumOfDegrees(BNode<String> node) {
        if (node == null) return 0; // празно е или нул
        if (node.left == null && node.right == null) return 0; // не придонесуваш, немаш деца :(
        if (node.left == null) return 1 + sumOfDegrees(node.right); // ти имаш еден степен(дете) и
        // види што ќе ти каже твоето десно дете
        if (node.right == null)
            return 1 + sumOfDegrees(node.left); // ти имаш еден степен(дете) и види левото што ќе ти каже
        return 2 + sumOfDegrees(node.left) + sumOfDegrees(node.right); // ако ги помина сите тестови,
        // ти имаш две деца, придонесуваш кон сумата
        // види успат твоите две деца што ќе ти кажат
    }

    public static int height(BNode<String> node) {
        if (node == null) return 0; // ако е празно дрвото
        return 1 + Math.max(height(node.left), height(node.right)); // исто со макс depth
        // почитко напишано бидејќи и да е лист, неговите „деца“ ќе вратат нула
        // ако има едно дете, само едното дете ќе врати нешто другото дете бидејќи е null ќе врати нула
    }

    public static int isBalanced(BNode<String> node) {
        if (node == null) return 0; // празно е

        int heightLeftSubTree = height(node.left); // висината на левото поддрво на моменталниот јазол
        int heightRightSubTree = height(node.right); // висината на десното поддрво на моменталниот јазол

        if (heightLeftSubTree > heightRightSubTree)
            if (heightLeftSubTree - heightRightSubTree > 1) return -1; // propagate failure
        else if (heightRightSubTree - heightLeftSubTree > 1) return -1; // ако висината на
        // твоето лево и десно поддрво се разликуваат за еден, propagate failure

        return 0; // океј е, таман му се поддрвата, ги помина сите тестови
    }

    public static BNode<String> findLCA (BNode<String> node, String key1, String key2) {
        if (node == null) return null; // нема што да вратиме
        if (node.info.equals(key1) || node.info.equals(key2)) return node;  // ако тековниот јазол е ист како дадените
                                                                            // може тој да е LCA
                                                                            // (и родител на другиот клуч)

        BNode<String> left = findLCA(node.left, key1, key2); // резултати од левото поддрво на тековниот јазол
        BNode<String> right = findLCA(node.right, key1, key2); // резултати од десното поддрво на тековниот јазол

        if (left != null && right != null) return node; // ако и левото и десното не се нулеви, значи дека најдени се во различни поддрва клучевите
                                                        // и значи дека тековниот јазол е тој што ни треба
        if (left != null) return left; // ако само левото не е нулево значи дека во левото поддрво е, барај таму
        return right; // инаку, мора да е во десното поддрво, барај таму

        // тука ќе дојдеме или до ситуацијата, LCA да биде едниот клуч и родител на другиот клуч
        // или пак LCA да биде родител на двата клуча
    }

    public static void main(String[] args) throws IOException {

        BTree<String> tree = new BTree<>(); // инстанцираме дрво
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] tokens = line.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        HashMap<String, BNode<String>> map = new HashMap<>(); // мапа којашто ни помага брзо да пристапуваме
        // до референците на јазлите
        // ние ја имаме само вредноста нивна,
        // и вредноста нивна се мапира во нивниот јазол (поинтер)

        LinkedList<Integer> results = new LinkedList<>(); // да печатам почитко ниш спец

        for (int i = 0; i < n + m; i++) {
            String command = br.readLine();
            String[] token = command.split(" ");
            String key = token[1];
            if (token[0].equals("root")) {
                tree.makeRoot(key);
                map.put(key, tree.root); // зачувај го како јазол
            }
            else if (token[0].equals("add")) {
                String value = token[2];
                String wh = token[3];
                int where = -1;
                if (wh.equals("LEFT")) where = 1; // лево
                else if (wh.equals("RIGHT")) where = 2; // десно
                map.put(value, tree.addChild(map.get(key), where, value)); // функцијата addChild враќа
                                                                // референца до јазолот што сме го ставиле
            }
            else if (token[0].equals("ask")) {
                results.add(sumOfDegrees(map.get(key)));
                // за кој било од методите погоре
                // само сменето го името и ќе работи
                // задачите се од „Дрва“ задачите за вежбање поставени на курсот
                // функциите ги именував на таков начин за да биде разбирливо
                // дури и да го немате текстот, да може да се снајдете што се бара од вас
                // сите функции детално ги имам објаснато на мој начин
                // што уствари се случува и како јас ги сфаќам нив
            }
        }

        for (int x : results) {
            System.out.println(x);
        }

        // ПОЈАСНУВАЊЕ:
        // Читањето од влез за сите задачи е ист
        // 5 3 (5 ставања во дрвото, 3 прашања за одреден јазол)
        // root 1 (направи го 1 да е корен на дрвото)
        // add 1 2 1 (додади го 2 како лево дете на 1)
        // add 1 3 2 (додади го 3 како десно дете на 1)
        // ask 3 (во зависност од задачата, треба да се отпечати резултатот за јазолот со вредност 3)
        // Прашањето може да биде,
        // која е максимум длабочината/висината
        // на поддрвото каде што 3 е коренот
        // height(BNode<Integer> node), каде node е референца на јазолот со вредност 3
    }
}