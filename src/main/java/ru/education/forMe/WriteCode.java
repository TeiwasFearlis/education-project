package ru.education.forMe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WriteCode {
    public void ar() {
        int [] array = new int[2];
        array[1]=2;
        array[0]=1;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public StringBuilder rev(String word){
        StringBuilder stringBuilder = new StringBuilder(word);
        System.out.println(stringBuilder.reverse());
        return stringBuilder.reverse();
    }
    public void change(int ch){
        switch (ch){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
    public void col(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        System.out.println(hashSet);

        HashMap<String ,Integer> hashMap = new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("2",2);
        System.out.println(hashMap);
    }

    public static void main(String[] args) {
        WriteCode writeCode = new WriteCode();
        writeCode.ar();
        String word = "word";
        writeCode.rev(word);
        writeCode.change(3);
        writeCode.col();
    }
}
