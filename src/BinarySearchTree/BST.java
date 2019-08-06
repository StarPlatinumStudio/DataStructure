package BinarySearchTree;

/**
 * 二分搜索树，支持泛型，拥有可比较性
 * @param <E>
 */
public class BST<E extends Comparable<E>>{//拥有可比较性
private class Node{
    public  E e;
    public  Node left,right;
    public Node(E e){
        this.e=e;
        left=null;
        right=null;
    }
}
private Node root;
private int size;
public BST(){
    root=null;
    size=0;
}

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
    return size==0;
    }
}
