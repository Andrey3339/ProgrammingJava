package dz5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут 
повторяющиеся имена с разными телефонами, их необходимо считать,
как одного человека с разными телефонами. Вывод должен быть
отсортирован по убыванию числа телефонов.
Пример:
Иванов 1231234
Иванов 3456345
Иванов 5676585
Петров 12345
Петров 82332 */

public class task {
    public static Map<String, ArrayList<String>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        phoneBook.put("Иванов", new ArrayList<>(Arrays.asList("1231234", "3456345", "5676585")));
        phoneBook.put("Петров", new ArrayList<>(Arrays.asList("12345", "82332")));
        phoneBook.put("Сидоров", new ArrayList<>(Arrays.asList("122333")));
        phoneBook.put("Суворов", new ArrayList<>(Arrays.asList("122333", "8723132", "1347873", "897213", "978232")));

        try (Scanner sc = new Scanner(System.in, "cp866")) {
            String str = "";
            while (!str.equals("exit")) {
                System.out.print("Введите действие(add, print) или exit для выхода: ");
                str = sc.nextLine();
                if (str.equals("add") && !str.equals("exit")) {
                    System.out.print("Введите фамилию и телефон через пробел: ");    
                    String namePhone = sc.nextLine();            
                    String[] nph = namePhone.split(" ");        
                    System.out.println(nph[0] + " " + addContact(namePhone));
                }
                if (str.equals("print") && !str.equals("exit")) {
                    printPhoneBook(phoneBook);
                }
            }
        }
    }

    public static String addContact(String str) {
        String[] nph = str.split(" "); 
        // если в справочнике нет такой фамилии(ключа)
        if (!phoneBook.containsKey(nph[0].trim())) {
            phoneBook.put(nph[0], new ArrayList<>(Arrays.asList(nph[1])));
            return nph[0] + " " + phoneBook.get(nph[0]);
        }
        else {
            // иначе - если контакт есть, но такого номера телефона у фамилии(контакта, ключа) нет
            if (!phoneBook.get(nph[0]).contains(nph[1])) { 
                ArrayList<String> temp = phoneBook.get(nph[0]);
                temp.add(nph[1]);
                phoneBook.put(nph[0], temp);
                return nph[0] + " " + phoneBook.get(nph[0]);
            }
            else {
                System.out.println("Контакт с таким номером уже есть.");
                return nph[0] + " " + phoneBook.get(nph[0]);
            }
        }    
    }

    public static void printPhoneBook(Map<String, ArrayList<String>> phone) {
        for (var item : sortPhoneBook(phone)) {
            System.out.println("фамилия: " + item + ", телефон(ы): " + phone.get(item));
        }
    }

    public static ArrayList<String> sortPhoneBook(Map<String, ArrayList<String>> map) {
        ArrayList<String> sl = new ArrayList<>(map.keySet());
        for (int i = 0; i < sl.size() - 1; i++) {
            for (int j = 0; j < sl.size() - i - 1; j++) {
                int count1 = map.get(sl.get(j)).size();
                int count2  =map.get(sl.get(j + 1)).size();
                if (count1 < count2) {
                    var temp = sl.get(j);
                    sl.set(j, sl.get(j + 1));
                    sl.set(j+1, temp);
                  }
            }
        }
        return sl;
    }
}
