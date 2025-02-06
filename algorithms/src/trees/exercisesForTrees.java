package trees;

public class exercisesForTrees {

    // задача
    public static BNode<Integer> findTheNode(BNode<Integer> node, int key) {
        if (node == null) return null; // ако се прати празен јазол врати празно
        if (node.left == null && node.right == null && node.info != key) return null;
        if (node.info == key) return node; // ако ти си јазолот, врати се!

        BNode<Integer> foundLeft = findTheNode(node.left, key); // вредност на лево поддрво
        BNode<Integer> foundRight = findTheNode(node.right, key); // вредност на десно поддрво
        if (foundLeft != null) return foundLeft;
        if (foundRight != null) return foundRight;

        // if (findTheNode(node.left, key) != null)
        //    return findTheNode(node.left, key);  // ако го ставев вака,
                                                  //    двапати ќе се повикуваше функцијата
                                                 // без причина
        return null;
    }

    public static int levelOfNode (BNode<Integer> node, int key) {
        if (node == null) return 0; // ако јазолот е празен врати нула
        if (node.info == key) return 1; // ако тоа е јазолот што го бараме, враќа 1 бидејќи
        // тоа е неговото ниво релативно за себе

        int left = levelOfNode(node.left, key); // вредноста на лево поддрво
        int right = levelOfNode(node.right, key); // вредноста на десно поддрво

        if (left != 0) return left + 1;   // ако левото не е нула (значи нешто е најдено таму),
        // врати лево + 1 (плус еден е за сегашниот јазол
        // бидејќи сегашниот јазол е едно ниво
        // погоре од неговото лево поддрво)
        if (right != 0) return right + 1;
        return 0;
    }

    public static void main (String[] args) {

        BTree<Integer> tree = new BTree<>(1);
        BNode<Integer> seven = tree.addChild(tree.root, 1, 7);
        BNode<Integer> two = tree.addChild(seven, 1, 2);
        BNode<Integer> nine = tree.addChild(tree.root, 2, 9);
        BNode<Integer> nineteen = tree.addChild(nine, 2, 19);
        BNode<Integer> fifteen = tree.addChild(nineteen, 1, 15);
        BNode<Integer> six = tree.addChild(seven, 2, 6);
        BNode<Integer> five = tree.addChild(six, 1, 5);
        BNode<Integer> eleven = tree.addChild(six, 2, 11);

        tree.inorder();

        System.out.println(findTheNode(tree.root, 6).info);
        System.out.println(levelOfNode(tree.root, 6));

    }

}
