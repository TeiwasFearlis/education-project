package ru.education.trening.collectionMap;

import java.util.TreeMap;

public class RealizationTreeMap {
    public static void main(String[] args) {


        //иногда необходимо хранить данные в структурированном виде с возможностью навигации по ним.
        // В таком случае на помощь приходит другая реализация интерфейса Map — TreeMap.
        //имплементируя интерфейсы NavigableMap и SortedMap, TreeMap получает дополнительный функционал,
        // которого нет в HashMap, но плата за это — производительность.
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(56,"1");
        map.put(160,"2");
        map.put(4,"3");
        map.put(477,"4");
        map.put(32,"5");
        map.put(43,"6");
        map.put(89,"7");
        map.put(99,"8");
        map.put(345,"9");
        map.put(867,"10");
        map.put(3453,"11");
        System.out.println(map);
        //==================================================================================================

        //в TreeMap есть все те методы, что и в HashMap.
        // Но вдобавок TreeMap реализует интерфейсы SortedMap и NavigableMap, получая дополнительный функционал из них.
        //SortedMap — интерфейс, который расширяет Map и добавляет методы, актуальные для отсортированного набора данных:
        //============================================================================================================

        //firstKey(): возвращает ключ первого элемента мапы;
        System.out.println("ключ первого элемента мапы: "+map.firstKey());
        //============================================================================================================

        //lastKey(): возвращает ключ последнего элемента;
        System.out.println("ключ последнего элемента: "+map.lastKey());
        //=============================================================================================================

        //headMap(K end): возвращает мапу, которая содержит все элементы текущей, от начала до элемента с ключом end;
        System.out.println("мапа от начала до элемента с ключом end,не включительно: "+map.headMap(345));
        //============================================================================================================

        //tailMap(K start): возвращает мапу, которая содержит все элементы текущей, начиная с элемента start и до конца;
        System.out.println("мапа начиная с элемента start и до конца: "+map.tailMap(345));
        //=============================================================================================================

        //subMap(K start, K end): возвращает мапу, которая содержит все элементы текущей,начиная с элемента start и до элемента с ключом end.
        System.out.println("мапа начиная с элемента start и до элемента с ключом end, не включительно: "+map.subMap(345,867));
        //========================================================================================================

        //NavigableMap — интерфейс, который расширяет SortedMap и добавляет методы для навигации между элементами мапы:

        //firstEntry(): возвращает первый пару “ключ-значение”;
        System.out.println("первая пара “ключ-значение”: "+map.firstEntry());
        //============================================================================================================

        //lastEntry(): возвращает последнюю пару “ключ-значение”;
        System.out.println("последняя пара “ключ-значение”: "+map.lastEntry());
        //============================================================================================================

        //pollFirstEntry(): возвращает и удаляет первую пару;
        System.out.println("возвращает и удаляет первую пару: "+map.pollFirstEntry());
        System.out.println(map);
        //============================================================================================================

        //pollLastEntry(): возвращает и удаляет последнюю пару;
        System.out.println("возвращает и удаляет последнюю пару: "+map.pollLastEntry());
        System.out.println(map);
        //============================================================================================================

        //ceilingKey(K obj): возвращает наименьший ключ k, который больше или равен ключу obj. Если такого ключа нет, возвращает null;
        System.out.println("возвращает наименьший ключ k, который больше или равен ключу obj: "+map.ceilingKey(1));
        System.out.println("возвращает наименьший ключ k, который больше или равен ключу obj: "+map.ceilingKey(867));
        System.out.println("возвращает наименьший ключ k, который больше или равен ключу obj: "+map.ceilingKey(868));
        //============================================================================================================

        //floorKey(K obj): возвращает самый большой ключ k, который меньше или равен ключу obj. Если такого ключа нет, возвращает null;
        System.out.println("возвращает самый большой ключ k, который меньше или равен ключу obj: "+map.floorKey(1));
        System.out.println("возвращает самый большой ключ k, который меньше или равен ключу obj: "+map.floorKey(32));
        System.out.println("возвращает самый большой ключ k, который меньше или равен ключу obj: "+map.floorKey(868));
        //============================================================================================================

        //lowerKey(K obj): возвращает наибольший ключ k, который меньше ключа obj. Если такого ключа нет, возвращает null;
        System.out.println(" возвращает наибольший ключ k, который меньше ключа obj: "+map.lowerKey(1));
        System.out.println(" возвращает наибольший ключ k, который меньше ключа obj: "+map.lowerKey(32));
        System.out.println(" возвращает наибольший ключ k, который меньше ключа obj: "+map.lowerKey(868));
        //============================================================================================================

        //higherKey(K obj): возвращает наименьший ключ k, который больше ключа obj. Если такого ключа нет, возвращает null;
        System.out.println(" возвращает наибольший ключ k, который больше ключа obj: "+map.higherKey(1));
        System.out.println(" возвращает наибольший ключ k, который больше ключа obj: "+map.higherKey(32));
        System.out.println(" возвращает наибольший ключ k, который больше ключа obj: "+map.higherKey(868));
        //============================================================================================================

        //ceilingEntry(K obj): аналогичен методу ceilingKey(K obj), только возвращает пару “ключ-значение” (или null);
        System.out.println("возвращает пару “ключ-значение” (или null), который больше или равен ключу obj: "+map.ceilingEntry(1));
        System.out.println("возвращает пару “ключ-значение” (или null), который больше или равен ключу obj: "+map.ceilingEntry(867));
        System.out.println("возвращает пару “ключ-значение” (или null), который больше или равен ключу obj: "+map.ceilingEntry(868));
        //============================================================================================================

        //floorEntry(K obj): аналогичен методу floorKey(K obj), только возвращает пару “ключ-значение” (или null);
        System.out.println("возвращает пару “ключ-значение” (или null), который меньше или равен ключу obj: "+map.floorEntry(1));
        System.out.println("возвращает пару “ключ-значение” (или null), который меньше или равен ключу obj: "+map.floorEntry(32));
        System.out.println("возвращает пару “ключ-значение” (или null), который меньше или равен ключу obj: "+map.floorEntry(868));
        //============================================================================================================

        //lowerEntry(K obj): аналогичен методу lowerKey(K obj), только возвращает пару “ключ-значение” (или null);
        System.out.println(" возвращает пару “ключ-значение” (или null), который меньше ключа obj: "+map.lowerEntry(1));
        System.out.println(" возвращает пару “ключ-значение” (или null), который меньше ключа obj: "+map.lowerEntry(32));
        System.out.println(" возвращает пару “ключ-значение” (или null), который меньше ключа obj: "+map.lowerEntry(868));
        //============================================================================================================

        //higherEntry(K obj): аналогичен методу higherKey(K obj), только возвращает пару “ключ-значение” (или null);
        System.out.println(" возвращает пару “ключ-значение” (или null), который больше ключа obj: "+map.higherEntry(1));
        System.out.println(" возвращает пару “ключ-значение” (или null), который больше ключа obj: "+map.higherEntry(32));
        System.out.println(" возвращает пару “ключ-значение” (или null), который больше ключа obj: "+map.higherEntry(868));
        //============================================================================================================

        //descendingKeySet(): возвращает NavigableSet, содержащий все ключи, отсортированные в обратном порядке;
        System.out.println("возвращает NavigableSet, содержащий все ключи, отсортированные в обратном порядке: "+map.descendingKeySet());
        //============================================================================================================

        //descendingMap(): возвращает NavigableMap, содержащую все пары, отсортированные в обратном порядке;
        System.out.println("возвращает NavigableSet, содержащий все пары, отсортированные в обратном порядке: "+map.descendingMap());
        //============================================================================================================

        //navigableKeySet(): возвращает объект NavigableSet, содержащий все ключи в порядке хранения;
        System.out.println("возвращает объект NavigableSet, содержащий все ключи в порядке хранения: "+map.navigableKeySet());
        //============================================================================================================

        //headMap(K upperBound, boolean incl): возвращает мапу, которая содержит пары от начала
        // и до элемента upperBound. Аргумент incl указывает, нужно ли включать элемент upperBound в возвращаемую мапу;
        System.out.println("возвращает мапу, которая содержит пары от начала и до элемента upperBound: "+map.headMap(100));
        //============================================================================================================

        //tailMap(K lowerBound, boolean incl): функционал похож на предыдущий метод, только возвращаются пары от lowerBound и до конца;
        System.out.println("возвращает мапу, которая содержит пары от от lowerBound и до конца: "+map.tailMap(100));
        //============================================================================================================

        //subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl): как и в предыдущих методах,
        // возвращаются пары от lowerBound и до upperBound, аргументы lowIncl и highIncl указывают,
        // включать ли граничные элементы в новую мапу.
        System.out.println("возвращает мапу, в заданных пределах: "+map.subMap(1,200));
        //============================================================================================================
        
    }
}
