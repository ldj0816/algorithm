package org.example.Tree.binary;

import java.util.Comparator;

/**
 * @author: 吕东杰
 * @description: 二叉查找数
 * @create: 2020-12-08 19:32
 **/
public class BinarySearchTree<T> {

    private BinaryNode<T> root;

    private Comparator<? super T> comparator;

    public BinarySearchTree(){
        root = null;
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

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree(T t) {

    }

    private int compare(T t1, T t2){
        if(comparator!=null){
            return comparator.compare(t1,t2);
        }
        return ((Comparable) t1).compareTo(t2);
    }

    private BinaryNode<T>  findMin(BinaryNode<T> t){
        if(t==null){
            return null;
        }else if(t.left==null){
            return t;
        }
        return findMin(t);
    }

    private BinaryNode<T>  findMax(BinaryNode<T> t){
        if(t==null){
            return null;
        }else if(t.right==null){
            return t;
        }
        return findMax(t);
    }

    private Boolean contains(T t, BinaryNode<T> node){
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

    private BinaryNode<T> insert(T t, BinaryNode<T> node){
        if(node==null){
            return new BinaryNode<>(t,null,null);
        }
        int compareResult = compare(t,node.t);
        if(compareResult<0){
            node.left = insert(t, node.left);
        }else if(compareResult>0){
            node.right = insert(t, node.right);
        }
        return node;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node){
        if(node==null){
            return node;
        }
        int compareResult = compare(t,  node.t);
        if(compareResult<0){
            node.left = remove(t, node.left);
        }else if(compareResult>0){
            node.right = remove(t, node.right);
        }else{
            if(node.left!=null&& node.right != null){
                node.t = this.findMin(node.right).t;
                node.right = remove(node.t, node.right);
            }else {
                node = node.left!=null?node.left:node.right;
            }
        }
        return node;
    }

}
