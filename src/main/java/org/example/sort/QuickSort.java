package org.example.sort;

/**
 * @author: 吕东杰
 * @description: 快速排序
 * @create: 2021-02-18 11:03
 **/
public class QuickSort {

    private void sort(int[] list){
        if (list==null||list.length==0) {
            return;
        }
        int size = list.length;
        sort(list, 0, size-1);
        print(list);
    }

    private void sort(int[] list, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int j = partition(list, lo, hi);
        sort(list, lo, j-1);
        sort(list, j+1, hi);
    }

    private int partition(int[] list, int lo, int hi){
        int i = lo;
        int j = hi+1;
        int v = list[lo];
        while (true){
            while (list[++i]<v){
                if(i==hi){
                    break;
                }
            }
            while (list[--j]>v){
                if(j==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            int swap = list[i];
            list[i] = list[j];
            list[j] = swap;
        }
        int swap = list[lo];
        list[lo] = list[j];
        list[j] = swap;
        return j;
    }

    private void print(int[] list){
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        QuickSort bubblingSort = new QuickSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
