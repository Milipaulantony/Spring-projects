package org.example.CollectionEg;

import java.util.*;

public class Mapeg {
    Map<Integer, String> mapeg = new HashMap<>();

    public void mapOperation(){
        mapeg.put(1,"name");
        mapeg.put(2,"addr");

        for(int key:mapeg.keySet())
            System.out.println(mapeg.get(key));
    }

    public void multiple_oper(){
        HashMap<String, HashMap<String, String>> libraryCatalog = new HashMap<>();
        HashMap<String, String> bookDetails = new HashMap<>();
        bookDetails.put("title", "To Kill a Mockingbird");
        bookDetails.put("author", "Harper Lee");
        bookDetails.put("year_published", "1960");
        libraryCatalog.put("123", bookDetails);
        System.out.println(libraryCatalog.get("123").get("title"));
    }

    public void multiple_oper_2(){
        HashMap<String, Integer> voteCounts = new HashMap<>();
        String[] votes = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};
        for (String vote : votes) {
            //voteCounts.put(vote, voteCounts.getOrDefault(vote, 0) + 1);
        }
        System.out.println(voteCounts);
    }

    public void multiple_oper_3(){
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples", 100);
        inventory.put("Bananas", 80);
        inventory.put("Apples", inventory.get("Apples") + 20); // Update quantity
        System.out.println(inventory.get("Apples"));
    }
    public void multiple_oper_4(){
        HashMap<String, List<String>> subjectToStudents = new HashMap<>();
        subjectToStudents.putIfAbsent("Math", new ArrayList<>());
        subjectToStudents.get("Math").add("Alice");
        System.out.println(subjectToStudents);
    }
    public void multiple_oper_5(){
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = "hello world hello".split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);
    }

    public void collision_eg(){
        HashMap<String, String> equal_hash = new HashMap<>();
        equal_hash.put("FB","A");
        equal_hash.put("Ea","B");
        for (String x: equal_hash.keySet()){
            System.out.println(x.hashCode());
        }
    }
}
