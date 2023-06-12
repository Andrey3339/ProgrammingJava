package dz2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Задание №1. Дана строка sql-запроса "select * from students WHERE ". 
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
 * Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow */

public class task1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) throws IOException {
        File file = new File("input.json");
        String[] strings = new String[10];
        StringBuilder result = new StringBuilder();
        ArrayList<String> inputStrings = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("{", "");
                line = line.replace("}", "");
                line = line.replace(",", "");
                line = line.replace("\"", "");
                line = line.replace(":", "=");
                inputStrings.add(line.trim());
             }
            ArrayList<String> inputStringWithoutNull = new ArrayList<>();
            for (int i = 0; i < inputStrings.size() ; i++) {
                String[] partInputString = inputStrings.get(i).split("\\=");
                if (!partInputString[1].equals("null"))
                    inputStringWithoutNull.add(inputStrings.get(i));    
            }
            ArrayList<String> arrayOfStrings = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                arrayOfStrings.add(strings[i]);    
            }
            result.append(String.join(" AND ", inputStringWithoutNull));
            if (inputStringWithoutNull.size() != 0) {
                String linePrefix = "select * from students WHERE ";
                result.insert(0, linePrefix);
            }
            else {
                result.delete(0, 4);
                result.append("select * from students");
            }
            System.out.println(ANSI_RED + "\n" + result + "\n" + ANSI_RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}