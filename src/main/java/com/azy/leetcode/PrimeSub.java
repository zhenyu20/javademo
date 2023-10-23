package com.azy.leetcode;

import java.util.Scanner;

/*
* 线性筛素数
* 二分查找上下界
* */

public class PrimeSub {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(",");
        int [] numberArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numberArr[i]  = Integer.parseInt(strArr[i]);
        }
        PrimeSub ps = new PrimeSub();
        boolean b = ps.primeSubOperation(numberArr);
        System.out.println(b);
    }
    public boolean primeSubOperation(int[] nums) {
        int max = 1000;
        int[] primes = findPrime(max);
        for(int i = nums.length - 1; i > 0; i--){
            int left = i - 1;
            int right = i;
            if(nums[left] >= nums[right]){
                int sub = nums[left] - nums[right];
                int index = binarySortUpper(primes, 0, primes.length - 1, sub);
                if(index < primes.length){
                    nums[left] -= primes[index];
                    if(nums[left] < 0) {
                        return false;
                    }
                }else return false;
            }
        }
        return true;
    }
    public int[] findPrime(int max){
        boolean[] isNotPrime = new boolean[max];
        int[] primes = new int[168];
        int cnt = 0;
        for( int i = 2; i < max; i++){
            if(!isNotPrime[i]) primes[cnt++] = i;
            for(int j = 0;j < cnt && primes[j] * i < max;j++){
                isNotPrime[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
        return primes;
    }
    public int binarySortUpper(int[] nums, int left, int right, int value){
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(value < nums[mid]){
                right = mid - 1;
            } else if (value == nums[mid]) {
                left = mid + 1;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySortLower(int[] nums, int left, int right, int value){
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(value < nums[mid]){
                right = mid - 1;
            } else if (value == nums[mid]) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return right;
    }
}
