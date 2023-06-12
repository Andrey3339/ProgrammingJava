package dz3;

import java.util.ArrayList;
import java.util.Arrays;

/** 
Задание 3.
Пусть дан произвольный список целых чисел.
1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение */
public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayIntegers = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 8, 7, 8, 1, 7, 6, 5, 4, 3, 2));
        System.out.println("Минимальное значение массива: " + findMinValue(arrayIntegers));
        System.out.println("Максимальное значение массива: " + findMaxValue(arrayIntegers));
        System.out.println("Среднее значение массива: " + findAverageValue(arrayIntegers));
        System.out.println("Список без четных чисел: " + evenNumberDel(arrayIntegers));
    }   
    public static ArrayList<Integer> evenNumberDel(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i).toString()) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
    public static int findMinValue(ArrayList<Integer> list) {
        int min = Integer.parseInt(list.get(0).toString());
        for (int i = 1; i < list.size(); i++) {
            int num = Integer.parseInt(list.get(i).toString());
            if (num < min) 
                min = num;
        }
        return min;
    }
    public static int findMaxValue(ArrayList<Integer> list) {
        int max = Integer.parseInt(list.get(0).toString());
        for (int i = 1; i < list.size(); i++) {
            int num = Integer.parseInt(list.get(i).toString());
            if (num > max) 
                max = num;
        }
        return max;
    }
    public static String findAverageValue(ArrayList<Integer> list) {
        double count = 0; 
        double average = 0;
        for (int i = 0; i < list.size(); i++) {
            count += Integer.parseInt(list.get(i).toString());
        }
        average = count / list.size();
        return String.format("%.2f", average);
    }
}
