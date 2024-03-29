package ru.education.trening.collectionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RealisArrayList {
    public static void main(String[] args) {
 //===========================================================
        //ArrayList работает с массивом внутри
        //===================================================
        //Creating a generic ArrayList
        ArrayList<String> arlTest = new ArrayList<String>();
        //Size of arrayList
        System.out.println("Size of ArrayList at creation: " + arlTest.size());
        //Lets add some elements to it
        arlTest.add("D");
        arlTest.add("U");
        arlTest.add("K");
        arlTest.add("E");
        //Recheck the size after adding elements
        System.out.println("Size of ArrayList after adding elements: " + arlTest.size());
        //Display all contents of ArrayList
        System.out.println("List of all elements: " + arlTest);
        //Remove some elements from the list
        arlTest.remove("D");
        System.out.println("See contents after removing one element: " + arlTest);
        //Remove element by index
        arlTest.remove(2);
        System.out.println("See contents after removing element by index: " + arlTest);
        //Check size after removing elements
        System.out.println("Size of arrayList after removing elements: " + arlTest.size());
        System.out.println(arlTest.indexOf("K"));
        System.out.println(arlTest.get(0));
        arlTest.set(0, "newString");
        System.out.println(arlTest.get(0));
        System.out.println("List of all elements after removing elements: " + arlTest);
        //Check if the list contains "K"
        System.out.println(arlTest.contains("K"));
        arlTest.clear();
        System.out.println( arlTest.size());
        String[] massivs = {"df","dfd","dfdfwedf"};
        arlTest = new ArrayList<>(Arrays.asList(massivs));
        System.out.println(arlTest);
    }
}
