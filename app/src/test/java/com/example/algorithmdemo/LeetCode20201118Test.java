package com.example.algorithmdemo;

import org.junit.Test;

/**
 *
 * 1030. 距离顺序排列矩阵单元格
 * 备注：
 *
 */
public class LeetCode20201118Test {

    @Test
    public void test(){
        int[] a = new int[]{5,1,2,3,4};
        int[] b = new int[]{4,4,1,5,1};
        System.out.println(canCompleteCircuit(a,b));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalOil = 0; //总油量
        int totalConsume = 0; //总消耗
        for (int i = 0; i < gas.length; i++) {
            totalOil += gas[i];
            totalConsume += cost[i];
        }
        if (totalConsume > totalOil){
            return -1;
        }
        int position = 0;//出发的位置
        int leftOil = 0; //剩余的油
        int cnt = 0;//每次移动的数量
        for (int i = position; i < gas.length+position; i++) {
            leftOil = leftOil+gas[i%(gas.length)]-cost[i%(gas.length)];
            if (leftOil < 0){
                //从position出发不行 优化2：从n的位置到i的位置不行 则n到i之间任何位置都不行
                position = position+cnt+1;
                i = position -1; //外循环有 i++。需要减1
                leftOil = 0; //从下一个加油站开始计算，充值剩余油量
                cnt = 0; //计数器重置
            }else if (i ==  gas.length+position -1){
                //优化1 最后一项了 还有油
                return position;
            }
            cnt++;

        }
        return -1;
    }public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;

    }






}