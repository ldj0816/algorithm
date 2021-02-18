package org.example.sort;

/**
 * @author: 吕东杰
 * @description: 插入排序  比较前j个 并依据大小移动位置
 * @create: 2021-02-18 11:03
 **/
public class InsertSort {

    private void sort(int[] list){
        if (list==null||list.length==0) {
            return;
        }
        int size = list.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j]<list[j-1]) {
                    int swap = list[j];
                    list[j] = list[j-1];
                    list[j-1] = swap;
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
        InsertSort bubblingSort = new InsertSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
