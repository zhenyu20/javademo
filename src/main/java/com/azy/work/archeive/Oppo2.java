package com.azy.work.archeive;

import java.util.Scanner;

/*
* 9/9
* 小欧有一个长度为n,首项为a,公差为d的等差数列。即
*  a,a+d,a＋ 2d,…,a＋(n - 1)d。现在，小欧把这n个数看作一个集合,
* 每次操作可以从集合中任意选两个数ai,aj,
* 如果ai+aj是偶数,那么可以将(ai＋aj)/2加入到集合中。
* 小欧想知道,经过若干次操作后,集合中最多能有多少个数。
*
*
* 1、如果d是奇数，那其实是没办法往集合里插入新元素的，假设挑出ai和aj(j > i)，若(j - i) % 2 == 1，则ai+aj必定不为偶数，不符合条件，若(j - i) % 2 == 0，则ai + aj / 2必然已在集合中，故当d是奇数直接返回n；
2、如果d是偶数，则可以往集合中插入n - 1个元素，因为每次只需要将相邻两个元素相加并除以2放到数组中就可以了，因为当两个元素不相邻时计算出来的新元素已经被前面的情况覆盖了。所以，当d是偶数，可以在集合中插入n-1个元素，并且，此时集合相当于变成了一共长度为2 * n - 1，公差为 d / 2的新等差数列，此时继续判断新的公差是否为偶数并继续插入即可。

作者：暴走番茄酱
链接：https://www.nowcoder.com/feed/main/detail/e32747fd976a460996ccf288f50692a1?sourceSSR=search
来源：牛客网
*
* */


public class Oppo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int d = sc.nextInt();
        while (d % 2 == 0) {
            d /= 2;
            n += n - 1;
        }
        System.out.println(n);
    }
}
