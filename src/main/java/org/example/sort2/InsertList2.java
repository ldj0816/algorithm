package org.example.sort2;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2022-04-12 17:47
 **/
public class InsertList2 {

    public void insetSort(int[] array){
        if (array==null|| array.length==0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int i1 = i; i1 > 0; i1--) {
                if(array[i1]<array[i1-1]){
                    int swap = array[i1-1];
                    array[i1-1] = array[i1];
                    array[i1] = swap;
                }
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
        InsertList2 insertList2 = new InsertList2();
        int[] a = new int[]{7,23,5,0,-9,78,-567};
        insertList2.insetSort(a);
    }
}
