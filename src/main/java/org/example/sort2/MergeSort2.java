package org.example.sort2;


/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2022-07-12 17:19
 **/
public class MergeSort2 {
    private void print(int[] list){
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MergeSort2 mergeSort2 = new MergeSort2();
        int[] a = new int[]{4,2,6,5,9,8,1,7,3};
        mergeSort2.mergeSort(a);

    }

    public int[] mergeSort(int[] array){
        if (array == null) {
            return null;
        }
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        print(array);
        return array;
    }

    private void mergeSort(int[] array,int lo,int hi,int[] temp){
        if(lo>=hi){
            return;
        }
        int mid = (lo+hi)/2;
        System.out.println(lo+":"+mid+":"+hi);
        mergeSort(array,lo,mid,temp);
        mergeSort(array,mid+1,hi,temp);
        merge(array,lo,mid,hi,temp);
    }

    private void merge(int[] array,int left,int mid,int right,int[] temp){
        //左边数组索引下标
        int i = left;
        //右边数组 索引下标
        int j = mid+1;
        //临时数组索引下标
        int t = 0;
        //填充temp数组
        while(i<=mid && j<=right){
            if(array[i]<array[j]){
                temp[t] = array[i];
                i++;
            }else {
                temp[t] = array[j];
                j++;
            }
            t++;
        }
        while(i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        while(j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }
        //temp 数组 copy 到 array
        t=0;
        int posLeft = left;
        while(posLeft<=right){
            array[posLeft] = temp[t];
            t++;
            posLeft++;
        }
    }

}
