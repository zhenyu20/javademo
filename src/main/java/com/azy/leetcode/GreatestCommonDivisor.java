package com.azy.leetcode;



/*
* 最大公约数
* * */

class GreatestCommonDivisor {
	public static void main(String[] args){
		int a = 6;
		int b = 4;
		int c = greatestCommonDivisor(a,b);
		System.out.println(c);
	}
	private static int greatestCommonDivisor(int a, int b){
        int r = Math.max(a,b);
        int l = Math.min(a,b);
        while(l != 0){
            int temp = l;
            l = r % l;
            r = temp;
        }
        return r;
    }
}

