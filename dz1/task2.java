package projectsDZ.dz1;

import java.util.ArrayList;

/** 2) Вывести все простые числа от 1 до 1000 */

public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> listSimpleNumbers = new ArrayList<Integer>();
        for (int i = 2; i <= 1000; i++) {
            boolean fl = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    fl = true;
                }
            }
            if (fl == false) {
                listSimpleNumbers.add(i);
            }
        }
        System.out.println("Список простых чисел от 1 до 1000: ");
        for (int i = 0; i < listSimpleNumbers.size(); i++) {
            System.out.print(listSimpleNumbers.get(i) + " ");
        }
    } 
}
