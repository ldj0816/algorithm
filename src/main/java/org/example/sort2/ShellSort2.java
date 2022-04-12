package org.example.sort2;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2022-04-12 18:51
 **/
public class ShellSort2 {

    public void shellSort(int[] array){
        int len = array.length;
        int h = 1;
        while (h<len/2){
            h = h*2+1;
        }
        while (h>=1){
            for (int i = h; i < len; i++) {
                for (int j = i; j >=h ; j-=h) {
                    if(array[j]<array[j-h]){
                        int swap = array[j-h];
                        array[j-h] = array[j];
                        array[j] = swap;
                    }
                }
            }
            h = h/2;
        }
        print(array);

    }

    public void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        ShellSort2 sort2 = new ShellSort2();
        int[] a = new int[]{7,23,5,0,-9,78,-567};
        sort2.shellSort(a);
    }
}
