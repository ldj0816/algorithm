package org.example.sort;

import java.util.Collections;
import java.util.List;

/**
 * @author: 吕东杰
 * @description: 冒泡排序
 * @create: 2021-02-18 11:03
 **/
public class BubblingSort {

    private void sort(int[] list){
        if (list==null||list.length==0) {
            return;
        }
        int size = list.length;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (list[i]>list[j]) {
                    int swap = list[i];
                    list[i] = list[j];
                    list[j] = swap;
                }
            }
        }
        print(list);
    }

    private void print(int[] list){
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        BubblingSort bubblingSort = new BubblingSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
