package dz2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class task3_1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) throws SecurityException, IOException {
 
        Logger ll = Logger.getLogger(task3_1.class.getName());
        ll.setUseParentHandlers(false);
        String logPath = "log2.txt";
        FileHandler fh = new FileHandler(logPath, false);
        ll.addHandler(fh);
        //SimpleFormatter sp = new SimpleFormatter();
        XMLFormatter xmlf = new XMLFormatter();
        //fh.setFormatter(sp);
        fh.setFormatter(xmlf);

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
                ll.log(Level.INFO, parseString(inputString.get(i)));
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
