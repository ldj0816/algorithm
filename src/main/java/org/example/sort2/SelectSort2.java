package org.example.sort2;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2022-04-14 17:41
 **/
public class SelectSort2 {

    public void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min]>array[j]){
                    min = j;
                }
            }
            if(min>i){
                int swap = array[min];
                array[min] = array[i];
                array[i] = swap;
            }
        }
        print(array);
    }

    public void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        SelectSort2 sort2 = new SelectSort2();
        int[] a = new int[]{7,23,5,0,-9,78,-567,5,99,3};
        sort2.selectSort(a);

    }
}
