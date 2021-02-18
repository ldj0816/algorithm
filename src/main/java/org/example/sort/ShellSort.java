package org.example.sort;

/**
 * @author: 吕东杰
 * @description: 希尔排序
 * @create: 2021-02-18 11:03
 **/
public class ShellSort {

    private void sort(int[] list){
        if (list==null||list.length==0) {
            return;
        }
        int size = list.length;
        int h=1;
        while (h<size/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i = h; i < size; i++) {
                for (int j = i; j >=h ; j-=h) {
                    if (list[j]<list[j-h]) {
                        int swap = list[j];
                        list[j] = list[j-h];
                        list[j-h] = swap;
                    }
                }
            }
            h = h/3;
        }
        print(list);
    }

    private void print(int[] list){
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ShellSort bubblingSort = new ShellSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
