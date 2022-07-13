package org.example.sort;

/**
 * @author: 吕东杰
 * @description: 归并排序
 * @create: 2021-02-18 11:03
 **/
public class MergeSort {

    private int[] aux;

    private void sort(int[] list){
        aux = new int[list.length];
        sort(list,0,list.length-1);
        print(list);
    }

    private void sort(int[] list, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int mid = lo+(hi-lo)/2;
        sort(list,lo,mid);
        sort(list,mid+1,hi);
        merge(list,lo,mid,hi);
    }



    private void merge(int[] list, int lo,int mid, int hi){
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++){
            aux[k] = list[k];
        }
        for (int k = lo; k<=hi; k++){
            if(i>mid){
                list[k] = aux[j++];
            } else if(j>hi){
                list[k] = aux[i++];
            } else if(aux[j]<aux[i]){
                list[k] = aux[j++];
            }else {
                list[k] = aux[i++];
            }
        }
    }

    private void print(int[] list){
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MergeSort bubblingSort = new MergeSort();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        bubblingSort.sort(a);
    }

}
