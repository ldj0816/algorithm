package org.example.Tree.avl;

import org.example.Tree.binary.BinaryNode;

import java.util.Comparator;

/**
 * @author: 吕东杰
 * @description: 平衡二叉树
 * @create: 2021-01-07 16:36
 **/
public class AvlTree<T> {

    private AvlNode<T> root;

    private Comparator<? super T> comparator;

    public AvlTree() {
        this.root = null;
    }

    public AvlTree(AvlNode<T> root) {
        this.root = root;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t){
        root = remove(t, root);
    }
    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }


    public boolean contains(T t){
        return contains(t, root);
    }

    public T findMin() throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        return findMin(root).t;
    }

    public T findMax() throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        return findMax(root).t;
    }

    public void printTree(){
        if(isEmpty()){
            System.out.println("empty tree");
        }else {
            printTree(root);
        }
    }

    private void printTree(AvlNode<T> node){
        if(node!=null){
            printTree(node.left);
            System.out.println(node.t);
            printTree(node.right);
        }
    }

    private int compare(T t1, T t2){
        if(comparator!=null){
            return comparator.compare(t1,t2);
        }
        return ((Comparable) t1).compareTo(t2);
    }

    private Boolean contains(T t, AvlNode<T> node){
        if(node==null){
            return false;
        }
        int compareResult = compare(t,node.t);
        if(compareResult<0){
            return contains(t, node.left);
        } else if(compareResult>0){
            return contains(t, node.left);
        }else {
            return true;
        }
    }

    private AvlNode<T> remove(T t, AvlNode<T> node){
        if(node==null){
            return node;
        }
        int compareResult = compare(t, node.t);
        if(compareResult<0){
            node.left = remove(t, node.left);
        }else if(compareResult>0){
            node.right = remove(t, node.right);
        }else if(node.left!=null && node.right!=null){
            node.t = findMin(node.right).t;
            node.right =  remove(t, node.right);
        } else {
            node = node.left!=null?node.left:node.right;
        }
        return balance(node);

    }

    private AvlNode<T> findMin(AvlNode<T> t){
        if(t==null){
            return null;
        }else if(t.left==null){
            return t;
        }
        return findMin(t);
    }

    private AvlNode<T>  findMax(AvlNode<T> t){
        if(t==null){
            return null;
        }else if(t.right==null){
            return t;
        }
        return findMax(t);
    }

    private AvlNode<T> insert(T t, AvlNode<T> node){
        if (node == null) {
            return new AvlNode<>(t, null, null);
        }
        int compareResult = compare(t, node.t);
        if(compareResult<0){
            node.left = insert(t, node.left);
        }else if(compareResult>0){
            node.right = insert(t, node.right);
        }
        return balance(node);
    }

    private AvlNode<T> balance(AvlNode<T> node){
        if(node==null){
            return node;
        }
        if(height(node.left)-height(node.right)>1){
            if(height(node.left.left)>=height(node.left.right)){
                //RR
                node = rotateWithLeftChild(node);
            }else {
                //RL
                node = doubleWithLeftChild(node);
            }
        }else if(height(node.right)-height(node.left)>1){
            if(height(node.right.right)>=height(node.right.left)){
                //RR
                node = rotateWithRightChild(node);
            }else {
                //RL
                node = doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    //一次右旋
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
        AvlNode<T> k1 = node.left;
        node.left = k1.right;
        k1.right = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        k1.height = Math.max(height(k1.left),node.height)+1;
        return k1;
    }

    //一次左旋
    private AvlNode<T> rotateWithRightChild(AvlNode<T> node){
        AvlNode<T> k1 = node.right;
        node.right = k1.left;
        k1.left = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        k1.height = Math.max(height(k1.right),node.height)+1;
        return k1;
    }

    //LR
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    //RL
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    private int height(AvlNode<T> node){
        return node==null?-1:node.height;
    }
}
