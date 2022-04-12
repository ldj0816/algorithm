package org.example.leecode.listnode;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2021-10-11 14:46
 **/
public class Clac {

//    public static void main(String[] args) {
//        BigDecimal applyAmt = new BigDecimal("469.94");
//        BigDecimal u36Amt = new BigDecimal("1205.90");
//        BigDecimal subtract = applyAmt.subtract(u36Amt);
//        System.out.println(subtract);
//        int i = subtract.compareTo(BigDecimal.ZERO);
//        System.out.println(i);
//    }
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cc = Calendar.getInstance();
//
//        cc.set(Calendar.YEAR,2021);
//        cc.set(Calendar.MONTH,11);
//        cc.set(Calendar.DAY_OF_YEAR,31);
//        Date date = cc.getTime();
//        System.out.println(format.format(date));
//        for (int i = 10; i >=0; --i) {
//            System.out.println(i);
//        }
//        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),Arrays.asList(3,4)
                ,Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));


        Clac clac = new Clac();
        int sum = clac.minimumTotal(triangle);
        System.out.println(sum);


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        List<Integer> prevList = new ArrayList();
        prevList.addAll(triangle.get(0));

        int min = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            List<Integer> dpList = new ArrayList();
            for(int j = 0; j<list.size();j++){
                if(j==0){
                    dpList.add(prevList.get(0)+list.get(0));
                }else if(j==list.size()-1){
                    dpList.add(prevList.get(j-1)+list.get(j));
                }else{
                    dpList.add(Math.min(prevList.get(j-1),prevList.get(j))+list.get(j));
                }
                System.out.println("i: "+i+" j: "+j+" "+dpList.get(j));
                if(i==triangle.size()-1){
                    System.out.println("min: "+min);
                    min = Math.min(min,dpList.get(j));
                }

            }
            prevList = new ArrayList(dpList);
        }
        return min;
    }
}
