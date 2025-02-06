package trees;

public class BNode<E> {

    static int LEFT = 1;
    static int RIGHT = 2;

    public E info;
    public BNode<E> left;
    public BNode<E> right;
    public BNode<E> parent;

    public BNode(E info, BNode<E> parent) { // конструктор, со родител (дете буквално)
        this.parent = parent;
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info) { // конструктор, изгубен тоталка
        this.parent = null;
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) { // конструктор без родител
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
