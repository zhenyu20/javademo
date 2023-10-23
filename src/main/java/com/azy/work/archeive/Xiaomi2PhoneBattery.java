package com.azy.work.archeive;

import java.util.Arrays;
import java.util.Scanner;

/*
*
* 手机需要完成一组任务，每组任务有规定消耗的电量和执行该任务所需的最低手机电量，
* 任务可以不按顺序执行，但必须都执行。手机最大电量为4800。不能充电，
* 请问如何求手机的最小初始电量，使其能完成给出的所有任务
*
* 程序有误 1:10,2:12,3:11
* 09/10 已修正
* */
public class Xiaomi2PhoneBattery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tasks = sc.next();
        int minInitialBattery = calculateMinInitialBattery(tasks);
        System.out.println(minInitialBattery);
    }

    public static int calculateMinInitialBattery(String tasks) {
        // 解析任务字符串
        String[] taskArr = tasks.split(",");
        int n = taskArr.length;
        int[][] taskInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] info = taskArr[i].split(":");
            taskInfo[i][0] = Integer.parseInt(info[0]);
            taskInfo[i][1] = Integer.parseInt(info[1]);
        }

//        Arrays.sort(taskInfo, (x1, x2) -> {
//            if (x1[1] != x2[1]) {
//                return x2[1] - x1[1];
//            } else {
//                return x1[0] - x2[0];
//            }
//        });
        // 按照最低结束电量降序排序
        Arrays.sort(taskInfo,(x0,x1)-> (x1[1]-x1[0]) - (x0[1]-x0[0]));


//        if(taskInfo[n - 1][0] > taskInfo[n - 1][1]) return -1;
//        int minInitialBattery = taskInfo[0][1], temp = taskInfo[0][1];
//        for (int i = 1; i < n; i++) {
//            if (temp - taskInfo[i - 1][0] < taskInfo[i][1]) {
//                minInitialBattery += taskInfo[i][1] - (temp - taskInfo[i - 1][0]);
//                temp = taskInfo[i - 1][1];
//            }
//            temp = temp - taskInfo[i - 1][0];
//        }
        //简化
        int minInitialBattery = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            minInitialBattery = Math.max(minInitialBattery + taskInfo[i][0],taskInfo[i][1]);
        }

        return minInitialBattery > 4800 ? -1 : minInitialBattery;
    }
}
