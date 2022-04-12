package org.example.leecode.listnode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2021-12-20 19:59
 **/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums = nums1.length>nums2.length?nums2:nums1;
        Map<Integer,Integer> map = scoll(nums);
        int[] num0 = nums1.length>nums2.length?nums1:nums2;
        return pluss(num0,map);
    }

    private Map<Integer,Integer> scoll(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Integer n = map.get(nums[i]);
                n = n+1;
                map.put(nums[i],n++);
            }else{
                map.put(nums[i],1);
            }
        }
        return map;
    }

    private int[] pluss(int[] nums,Map<Integer,Integer> map){
        List<Integer> results = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&map.get(nums[i])>0){
                results.add(nums[i]);
                Integer m = map.get(nums[i]);
                m = m-1;
                map.put(nums[i],m);
            }
        }
        int[] res = new int[results.size()];
        for (int j = 0; j < results.size(); j++) {
            res[j] = results.get(j);
        }
        return res ;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution solution = new Solution();
        solution.intersect(nums1,nums2);
    }
}
