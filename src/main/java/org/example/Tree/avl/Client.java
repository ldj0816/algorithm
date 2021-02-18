package org.example.Tree.avl;

import java.util.Queue;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2021-01-08 19:27
 **/
public class Client {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(6);
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(4);
        avlTree.insert(3);
        avlTree.insert(8);
        avlTree.insert(11);
        avlTree.insert(7);
        avlTree.printTree();

    }
}
