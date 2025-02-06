package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class BinarySearchTrees {

    public static int countBiggerThan (BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (x >= node.info) return countBiggerThan(node.right, x) + countBiggerThan(node.left, x); // не придонесувај на броењето,
                                                                                                    // види твоите деца можеби се подобри
        return 1 + countBiggerThan(node.left, x) + countBiggerThan(node.right, x); // придонеси на броењето, и види твоите деца што како
    }

    public static int depth(BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (node.info == x) return 1; // terminate the process
        if (x > node.info) return 1 + depth(node.right, x); // од таму кај што си, оди десно
        return 1 + depth(node.left, x); // од таму кај што си, оди лево
    }

    public static int countSmallerThan (BNode<Integer> node, int x) {
        if (node == null) return 0;
        if (x <= node.info) return countSmallerThan(node.right, x) + countSmallerThan(node.left, x); // не си ти еден од нив ама види децата твои што ќе кажат
        return 1 + countSmallerThan(node.left, x) + countSmallerThan(node.right, x); // си еден од нив, види и децата што ќе ги кажат
        // ги броиме јазлите каде, х е поголем од нив
    }

    public static void main (String[] args) throws IOException {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        HashMap<Integer, BNode<Integer>> map = new HashMap<>();
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
                bst.insert(key);
                map.put(key, bst.find(key));
            }
            else {
                list.add(countSmallerThan(bst.getRoot(), key));
            }
        }

        for (int x : list)
            System.out.println(x);


    }

}
