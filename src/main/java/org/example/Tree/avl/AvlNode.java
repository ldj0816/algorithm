package org.example.Tree.avl;

/**
 * @author: 吕东杰
 * @description: avl树节点类
 * @create: 2021-01-07 16:31
 **/
public class AvlNode<T> {

    T t;
    AvlNode<T> left;
    AvlNode<T> right;
    int height;

    public AvlNode(T t) {
        this(t, null, null);
    }

    public AvlNode(T t, AvlNode<T> left, AvlNode<T> right) {
        this.t = t;
        this.left = left;
        this.right = right;
    }
}
