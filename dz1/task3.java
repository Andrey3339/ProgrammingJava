package projectsDZ.dz1;

import java.util.Scanner;

/** Реализовать простой калькулятор
+ - / *
Введите первое число: A \n
Введите знак: *
Введите второе число: B
Результат: A*B

sc.next() -- считывает символ
sc.nextLine() -- считывает всю строчку
sc.nextInt() -- считывает число, но без перехода на след. строчку */

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первый аргумент: ");
        int a = sc.nextInt();
        System.out.print("Введите действие (+, -, *, /): ");
        String act = sc.next();
        System.out.print("Введите второй аргумент: ");
        int b = sc.nextInt();
        System.out.println();
        if (act.equals("+")) {
            System.out.printf("Сумма %d и %d равна: %d", a, b, a + b);
        }
        else if (act.equals("-")) {
            System.out.printf("Разность %d и %d равна: %d", a, b, a - b);
        }
        else if (act.equals("*")) {
            System.out.printf("Произведение %d и %d равно: %d", a, b, a * b);
        }
        else if (act.equals("/")) {
            System.out.printf("Частное %d и %d равно %d", a, b, a / b);
        }
        else {
            System.out.println("Вы ввели какую то ерунду...");
        }
        sc.close();
    }    
}
