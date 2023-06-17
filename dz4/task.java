package dz4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1,-] - пример Deque
[5,4,3]- пример второго Deque
1) -123 * 345 = -42 435
Ответ всегда - связный список, в обычном порядке
[-,4,2,4,3,5] - пример ответа */
public class task {
    public static void main(String[] args) {
        Deque<String> num1 = new ArrayDeque<>();
        Deque<String> num2 = new ArrayDeque<>();

        num1.addLast("-"); num1.addLast("8"); num1.addLast("2"); num1.addLast("3");
        num2.addLast("-"); num2.addLast("3"); num2.addLast("4"); num2.addLast("5");
        System.out.println(multTwoNum(num1, num2)); 

        num1.addLast("-"); num1.addLast("1"); num1.addLast("2"); num1.addLast("3");
        num2.addLast("-"); num2.addLast("3"); num2.addLast("4"); num2.addLast("5");
        System.out.println(addTwoNum(num1, num2));
    }
    public static LinkedList<String> multTwoNum(Queue<String> n1, Queue<String> n2) {
        LinkedList<String> ls = new LinkedList<>();
        String s1 = "";
        String s2 = "";
        while (!n1.isEmpty()) {
             s1 += n1.remove();
        }
        while (!n2.isEmpty()) {
             s2 += n2.remove();
        }
         int a = Integer.parseInt(s1);
         int b = Integer.parseInt(s2);
        StringBuilder res = new StringBuilder(Integer.toString(a * b));
        for (int i = 0; i < res.length(); i++) {
            ls.add(String.valueOf(res.charAt(i)));    
        }
         return ls;
    }
    public static LinkedList<String> addTwoNum(Queue<String> n1, Queue<String> n2) {
        LinkedList<String> ls = new LinkedList<>();
        String s1 = "";
        String s2 = "";
        
        while (!n1.isEmpty()) {
             s1 += n1.remove();
        }
        while (!n2.isEmpty()) {
             s2 += n2.remove();
        }
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2); 
        StringBuilder res = new StringBuilder(Integer.toString(a + b));
        for (int i = 0; i < res.length(); i++) {
            ls.add(String.valueOf(res.charAt(i)));    
        }
        return ls;
    }
}
