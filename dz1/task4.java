package projectsDZ.dz1;

import java.util.Scanner;

/** Задача 4. (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства. Знаки вопроса - одинаковые цифры.
Предложить хотя бы одно решение или сообщить, что его нет. */

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите последовательность, например 2? + ?5 = 69:  ");
        String inputString = sc.nextLine();
        sc.close();
        String[] parts = inputString.split("\\=");
        String yesNo = "Решения нет.";    
        int firstSum = 0, secondSum = 0, summand = 0; 
        for (int i = 0; i < 10; i++) {
            String resultString = parts[0].replace("?", Integer.toString(i));
            String[] partResult = resultString.split("\\+");
            firstSum = Integer.parseInt(partResult[0].trim());
            secondSum = Integer.parseInt(partResult[1].trim());
            summand = Integer.parseInt(parts[1].trim());
            if ((firstSum + secondSum) == summand) 
                yesNo = "Есть решение: " + firstSum + " + " + secondSum + " = " + summand;
        }
        System.out.println(yesNo);
    }
}
