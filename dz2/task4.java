package dz2;
/** Задача №4 К калькулятору из предыдущего ДЗ добавить логирование.
4+2=6
6-1=5 */

import java.io.FileWriter;
import java.io.IOException;
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

public class task4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первый аргумент: ");
        int a = sc.nextInt();
        System.out.print("Введите действие (+, -, *, /): ");
        String act = sc.next();
        System.out.print("Введите второй аргумент: ");
        int b = sc.nextInt();
        System.out.println();
        sc.close();
        try (FileWriter fw = new FileWriter("calcLog.txt", true)) {
            if (act.equals("+")) {
                int sum = a + b;
                System.out.printf("Сумма %d и %d равна: %d", a, b, sum);
                //fw.write("Сумма " + a + " и "+ b + " равна " + sum + "\n");
                fw.write(a + " + "+ b + " = " + sum + "\n");
            }
            else if (act.equals("-")) {
                int diff = a - b;
                System.out.printf("Разность %d и %d равна: %d", a, b, diff);
                //fw.write("Разность " + a + " и "+ b + " равна " + diff + "\n");
                fw.write(a + " - "+ b + " = " + diff + "\n");
            }
            else if (act.equals("*")) {
                int mult = a * b;
                System.out.printf("Произведение %d и %d равно: %d", a, b, mult);
                //fw.write("Произведение " + a + " и "+ b + " равно " + mult + "\n");
                fw.write(a + " * "+ b + " = " + mult + "\n");
            }
            else if (act.equals("/")) {
                int div = a / b;
                System.out.printf("Частное %d и %d равно %d", a, b, div);
                //fw.write("Частное " + a + " и "+ b + " равно " + div + "\n");
                fw.write(a + " / "+ b + " = " + div + "\n");
            }
            else {
                System.out.println("Некорректный ввод данных.");
                fw.write("Некорректный ввод данных:  " + a + " " + act + " " + b + "\n");
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }    
}
