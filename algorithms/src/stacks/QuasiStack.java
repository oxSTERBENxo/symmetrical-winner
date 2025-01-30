//package stacks;
//
//import com.finki.DLLNode;
//import com.finki.Stack;
//
//import java.util.NoSuchElementException;
//
//class QuasiStack<E extends Comparable<E>> extends Stack<E> {
//    private DLLNode top, bottom;
//
//    QuasiStack() {
//        top = null;
//        bottom = null;
//    }
//
//    public boolean isEmpty() {
//        return top == null;
//    }
//
//    @Override
//    public E peek() {
//        return null;
//    }
//
//    public E peekTop() {
//        if (top == null) {
//            throw new NoSuchElementException();
//        }
//        return top.element;
//    }
//
//    public E peekBottom() {
//        if (bottom == null) {
//            throw new NoSuchElementException();
//        }
//        return bottom.element;
//    }
//
//    public void clear() {
//        top = null;
//        bottom = null;
//    }
//
//    public void push(E e) {
//        DLLNode<E> ins = new DLLNode<E>(e, null, top);
//        if (top == null)
//            bottom = ins;
//
//        else
//            top.pred = ins;
//        top = ins;
//    }
//
//    public E pop() {
//        if (top == null)
//            throw new NoSuchElementException();
//
//        E topElem = top.element; // vidi koj e elementot pred da go ubies
//        E bottomElem = bottom.element;
//
//        if (top == bottom) {
//            top = null;
//            bottom = null;
//            return topElem;
//        }
//
//        if (topElem.compareTo(bottomElem) < 0) {
//            bottom = bottom.pred;
//            bottom.succ = null;
//            return bottomElem;
//        }
//
//        top = top.succ;
//        top.pred = null;
//        return topElem;
//
//    }
//
//}