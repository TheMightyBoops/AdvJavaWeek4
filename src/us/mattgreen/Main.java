package us.mattgreen;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_","").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }
        }
        int mostUsed = 0;
        String mostUsedWord = "";
        int wordsOccurringOnce= 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if(entry.getValue() > mostUsed) {
                mostUsed = entry.getValue();
                mostUsedWord = entry.getKey();
            }

            if(entry.getValue() == 1) {
                wordsOccurringOnce++;
            }
        }
        System.out.println(mostUsedWord + " " + mostUsed);
        System.out.println(wordsOccurringOnce);

    }
}