package ru.education.trening.collectionSet;

import java.util.LinkedHashSet;

public class RealizationLinkedHashSet {
    //Основное различие в том, что LinkedHashSet сохраняет порядок вставки элементов,
    // а HashSet - нет. При этом LinkedHashSet также как и HashSet использует хэш таблицу, в отличие от того же TreeSet.

    public static void main(String args[]) {
        // Создаём хэш-набор
        LinkedHashSet hs = new LinkedHashSet();

        // Добавляем элементы к хэш-набору
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
    }







}
