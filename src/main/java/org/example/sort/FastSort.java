package org.example.sort;

/**
 * @author: 吕东杰
 * @description: 快速排序
 * @create: 2021-02-18 11:03
 **/
public class FastSort {

    private void sort(int[] list){
        if (list==null||list.length==0) {
            return;
        }
        int size = list.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i+1; j < size; j++) {
                if (list[min]>list[j]) {
                    min = j;
                }
            }
            if(min>i){
                int swap = list[i];
                list[i] = list[min];
                list[min] = swap;
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
        FastSort bubblingSort = new FastSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
