package dz2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/** Задача № 3. Дана строка (сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика. */

public class task3 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {
        File file = new File("string.json");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> inputString = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.replace("{", "");
                line = line.replace("},", "");
                line = line.replace("}", "");
                line = line.replace("\"", "");
                inputString.add(line.trim());
            }
            for (int i = 0; i < inputString.size(); i++) {
                System.out.println(ANSI_RED + parseString(inputString.get(i)) + ANSI_RESET);
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static String parseString(String string)
    {
        StringBuilder result = new StringBuilder();
        String[] arrayResult = string.split(","); 
        String[] name = arrayResult[0].split(":");
        String[] score = arrayResult[1].split(":");
        String[] grade = arrayResult[2].split(":");        
        result.append("Студент ");
        result.append(name[1]);
        result.append(" получил ");
        result.append(score[1]);
        result.append(" по предмету ");
        result.append(grade[1]);
        result.append(".");

        return result.toString();
    }    
}
