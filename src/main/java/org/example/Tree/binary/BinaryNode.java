package org.example.Tree.binary;

/**
 * @author: 吕东杰
 * @description: 树的节点
 * @create: 2020-12-08 19:34
 **/
public class BinaryNode<T> {

    T t;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T t) {
        this(t, null, null);
    }

    public BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {
        this.t = t;
        this.left = left;
        this.right = right;
    }
}
