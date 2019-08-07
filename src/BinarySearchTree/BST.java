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
    //向二分搜索树添加新的元素e
    public void add(E e){
      root=add(root,e);
    }

    //向以NODE为根的二分搜索树中插入元素E，递归算法
    //返回插入新节点后，二分搜索树的根
    private Node add(Node node,E e)
    {
    if(node==null){
        size++;
        return new Node(e);
    }
    if (e.compareTo(node.e)<0)
        node.left=add(node.left,e);
    else if(e.compareTo(node.e)>0)
        node.right=add(node.right,e);
    return node;
    }

    public boolean contains(Node node,E e){
    if (node==null)
        return false;
    if (node.e.compareTo(e)==0)
        return true;
    else if (node.e.compareTo(e)>0){
        return contains(node.right,e);
    }
    else {//(node.e.compareTo(e)<0){
        return contains(node.left,e);
    }

    }

    //二分搜索树前序遍历
    public void preOrder(){
    preOrder(root);
    }
    private void preOrder(Node node){
    if(node==null)
        return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return  res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
    if(node==null){
        res.append(generateDepthString(depth)+"null\n");
        return;
    }
    res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private  String  generateDepthString(int depth){
    StringBuilder stringBuilder=new StringBuilder();
    for (int i=0;i<depth;i++)
        stringBuilder.append("--");
        return stringBuilder.toString();

    }
}
//    else if(e.compareTo(node.e)<0&&node.left==null){
//        node.left=new Node(e);
//        size++;
//        return;
//    }
//    else if(e.compareTo(node.e)>0&&node.right==null){
//        node.right=new Node(e);
//        size++;
//        return;
//    }