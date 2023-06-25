package dz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class task1
{

    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("ertu", 5);
        map.put("burak", 4);

        map.put("selin", 2);
        map.put("can", 1);
        map.put("yell", 4);
        System.out.println(sortByComparator(map,false));
        
        Integer dizi[] = new Integer[map.size()];
        
        Set<String> anahtarlar = map.keySet();
        
        Iterator<String> t = anahtarlar.iterator();
        
        int a = 0;
        while (t.hasNext()) {
            dizi[a] = map.get(t.next());
            a++;
        }

        Arrays.sort(dizi, Collections.reverseOrder());
        
        for (int i = 0; i < map.size(); i++) {
            t = anahtarlar.iterator();
            while (t.hasNext()) {
                String temp = (String)t.next();
                if (dizi[i].equals(map.get(temp))) {
                    System.out.println(dizi[i] + " = " + temp);
                }
            }
        }
    }
    
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

    return sortedMap;
}
}