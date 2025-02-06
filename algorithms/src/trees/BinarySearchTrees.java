package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class BinarySearchTrees {

    public static int countBiggerThan (BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (x >= node.info) return countBiggerThan(node.right, x) + countBiggerThan(node.left, x);
        // не придонесувај на броењето, (не си поголем од х)
        // види твоите деца можеби се подобри
        return 1 + countBiggerThan(node.left, x) + countBiggerThan(node.right, x);
        // придонеси на броењето, и види твоите деца што како
    }

    public static int depth(BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (node.info == x) return 1; // terminate the process
        if (x > node.info) return 1 + depth(node.right, x); // од таму кај што си,
                                        // оди десно
                                        // (со цел да го најдеме јазолот со вредност х)

        return 1 + depth(node.left, x); // од таму кај што си,
        // оди лево (со цел да го најдеме јазолот со вредност х)
    }

    public static int countSmallerThan (BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (x <= node.info)
            return countSmallerThan(node.right, x) + countSmallerThan(node.left, x);
        // не си ти еден од нив којшто е помал од х но, види децата твои што ќе кажат
        return 1 + countSmallerThan(node.left, x) + countSmallerThan(node.right, x);
        // си еден од нив којшто е помал од х,
        // види и децата што ќе ги кажат
        // ги броиме јазлите каде, х е поголем од нив
    }

    public static void main (String[] args) throws IOException {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); // инстанцирање на пребарувачкото дрво
        HashMap<Integer, BNode<Integer>> map = new HashMap<>(); // од вредност до референца на јазолот
                                                                // со таа вредност (поинтер до тој јазол)
        LinkedList<Integer> list = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String [] tokens = line.split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        for (int i = 0; i < n + m; i++) {
            String input = br.readLine();
            String[] tokens2 = input.split(" ");
            String command = tokens2[0];
            int key = Integer.parseInt(tokens2[1]);
            if (command.equals("insert")) {
                bst.insert(key); // враќа void
                map.put(key, bst.find(key)); // мора со find функцијата
                                // да го најдам покажувачот до јазолот со вредност key
            }
            else {
                list.add(countSmallerThan(bst.getRoot(), key)); // само сменете го името на
                                                // функцијата за соодветен метод
            }
        }

        for (int x : list)
            System.out.println(x);

        // ПОЈАСНУВАЊЕ:
        // Читањето од влез за сите задачи е ист
        // 11 9 (5 ставања во дрвото, 3 прашања за одреден јазол)
        // insert 6 (стави го 6)
        // insert 7 (стави го 7, во случајов ќе е десно од 6 бидејќи е поголем од 6)
        // ask 7 (во зависност од задачата, треба да се отпечати резултатот за јазолот со вредност 7)

        // Прашањето може да биде,
        // колку јазли се помали од јазолот со вредност 7
        // countSmallerThan(BNode<Integer> node, int x),
        // каде node е референца на јазолот со вредност 7, а х е вредноста 7


    }

}
