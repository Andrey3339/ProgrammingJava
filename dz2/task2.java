package dz2;
/** Задача №2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.*/

import java.io.FileWriter;
import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        //int[] numbersArray = new int[] {2, 69, 71, 3, 94, 1, 4, 8, 20, 5, 9, 27, 45, 0, 6, 7};
        int[] numbersArray = new int[] {5, 4, 3, 2, 1};
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.print(numbersArray[i] + " ");
        }
        try (FileWriter fw = new FileWriter("log.txt")) {
            String stringsArray = Arrays.toString(numbersArray);
            fw.write("step 0: " + stringsArray + "\n");
            int count = 1;
            for (int i = 0; i < numbersArray.length; i++) {
                for (int j = 1; j < numbersArray.length; j++) {
                    if (numbersArray[j - 1] > numbersArray[j]) {
                        int temp = numbersArray[j - 1];
                        numbersArray[j - 1] = numbersArray[j];       
                        numbersArray[j] = temp;    
                    }
                    stringsArray = Arrays.toString(numbersArray);
                    fw.write("step " + count + ": "+ stringsArray + "\n");
                    count++;
                }
            }
        }
    catch (Exception e) {
        e.getStackTrace();
    }
        System.out.println("");
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.print(numbersArray[i] + " ");
        }
    }
}
