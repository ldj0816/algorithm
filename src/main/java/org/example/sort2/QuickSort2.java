package org.example.sort2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2022-04-12 14:04
 **/
public class QuickSort2 {

    public void qucksort(int[] array){
        int length = array.length;
        sort(array,0,length-1);
        print(array);
    }

    private void sort(int[] array, int begin, int end){
        if(begin>=end){
            return;
        }
        int mid = (begin+end)/2;
        int left = begin;
        int right = end;
        int val = array[mid];
        while(left<right){
            while (array[left]<val){
                left++;
            }
            while (array[right]>val){
                right--;
            }
            if(left>=right){
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            if(array[left]==val){
                right--;
            }
            if(array[right]==val){
                left++;
            }
        }
        if(left==right){
            right--;
            left++;
        }
        if(begin<right){
            sort(array,begin,right);
        }
        if(end>left){
            sort(array,left,end);
        }
    }

    public void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,23,5,0,-9,78,-567};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.qucksort(a);
    }
}
