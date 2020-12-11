package com.example.algorithmdemo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 柠檬水找零
 */
public class LeetCode20201210Test {

    @Test
    public void test() {
        int[] a = new int[]{10,10};
        System.out.println(lemonadeChange2(a));


    }

    public boolean lemonadeChange(int[] bills) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            switch (bill) {
                case 5:
                    list.add(bill);
                break;
                case 10:
                    if (list.contains(5)) {
                        list.remove(list.indexOf(5));
                    } else {
                        return false;
                    }
                    list.add(bill);
                    break;
                case 20:
                    if (list.contains(10) && list.contains(5)) {
                        list.remove(list.indexOf(10));
                        list.remove(list.indexOf(5));
                    } else if (list.contains(5)) {
                        int count = 0;
                        while (list.contains(5)) {
                            count += 5;
                            list.remove(list.indexOf(5));
                            if (count == 15) {
                                break;
                            }
                        }
                        if (count != 15) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 10) {
                Integer integer = map.get(5);
                if (integer != null && integer > 0) {
                    map.put(5, integer - 1);
                } else {
                    return false;
                }
                map.put(bill, map.getOrDefault(bill, 0) + 1);
            } else if (bill == 20) {
                Integer integer10 = map.get(10);
                Integer integer5 = map.get(5);
                if (integer10 > 0 && integer5 > 0) {
                    map.put(10, integer10 - 1);
                    map.put(5, integer5 - 1);
                } else if (integer5 > 2) {
                    map.put(5, integer5 - 3);
                } else {
                    return false;
                }
            } else {
                map.put(bill, map.getOrDefault(bill, 0) + 1);
            }
        }
        return true;

    }
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;


    }


}