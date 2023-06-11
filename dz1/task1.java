package projectsDZ.dz1;

import java.util.Scanner;

/** Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n) */

class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Введите число, сумму всех чисел до которого нужно найти:  ");        
        int number = Integer.parseInt(sc.next());
        int sum_all_numbers = number * (number + 1) / 2;
        System.out.printf("Сумма всех чисел от 1 до %d равна %d", number, sum_all_numbers);
        System.out.print("\nВведите число, произведение всех чисел до которого нужно найти:  ");        
        int number2 = Integer.parseInt(sc.next());
        sc.close();
        int mult_all_numbers = 1; 
        for (int i = 1; i <= number2; i++) {
            mult_all_numbers = mult_all_numbers * i;
        }
        System.out.printf("Произведение всех чисел от 1 до %d равна %d", number2, mult_all_numbers);
    }
}



