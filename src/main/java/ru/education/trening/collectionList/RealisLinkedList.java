package ru.education.trening.collectionList;

import java.util.*;

public class RealisLinkedList {
    public static void main(String[] args) {
        //======================================================
        /*В LinkedList элементы фактически представляют собой звенья одной цепи.
         У каждого элемента помимо тех данных, которые он хранит, имеется ссылка на предыдущий и следующий элемент.
         По этим ссылкам можно переходить от одного элемента к другому */
//========================================================================================================
        String str1 = new String("Hello World!");
        String str2 = new String("My name is Earl");
        String str3 = new String("I love Java");
        String str4 = new String("I live in Moscow");
//Добавление эелементов в LincedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(str1);
        linkedList.add(str2);
        linkedList.add(str3);
        linkedList.add(str4);
        System.out.println("Add new elements" + linkedList);
//====================================================================
        /*В результате str2 и str1 становятся связанными через хранящиеся в них ссылки next и previous
        Теперь тебе должна стать понятной главная идея двусвязного списка. Элементы LinkedList являются единым списком
        именно благодаря вот этой цепочке ссылок. Внутри LinkedList нет массива, как в ArrayList, или чего-то похожего.
        Вся работа с ArrayList (по большому счету) сводится к работе с внутренним массивом.
         Вся работа с LinkedList сводится к изменению ссылок.
         */
//=========================================================================================
        //Со вставкой мы более-менее разобрались, а что с удалением элементов?
        //Принцип работы тот же. Мы просто переопределяем ссылки у двух элементов “по бокам” от удаляемого:
        linkedList.remove(1);
        System.out.println("Add new elements before remove" + linkedList);
            /*В отличие от удаления в ArrayList здесь нет никаких сдвигов элементов массива и тому подобного.
       Мы просто переопределяем ссылки у элементов str1 и str3. Теперь они указывают друг на друга, а объект str2 “выпал” из
        этой цепочки ссылок, и больше не является частью списка. */
        //===============================================================================================
        //У LinkedList есть много общих с ArrayList методов.
        //Например, такие методы как add(), remove(), indexOf(), clear(), contains() (содержится ли элемент в списке),
        // set() (вставка элемента с заменой) и size() есть в обоих классах.
        //================================================================================
        /*addFirst(), addLast(): методы для добавления элемента в начало/конец списка*/
        String newWordFirst = new String("this is new First Word");
        String newWordLast = new String("this is new Last Word");
        linkedList.addFirst(newWordFirst);
        linkedList.addLast(newWordLast);
        System.out.println("Add in First and Last position" + linkedList);
        //=============================================================================
        // peekFirst(), peekLast(): возвращают первый/последний элемент списка. Возвращают null, если список пуст.
        System.out.println("Return First position: " + linkedList.peekFirst());
        System.out.println("Return Last position: " + linkedList.peekLast());
        //==============================================================================================
        // pollFirst(), pollLast(): возвращают первый/последний элемент списка и удаляют его из списка. Возвращают null, если список пуст

        System.out.println("Return First position and remove: " + linkedList.pollFirst());
        System.out.println("Return Last position and remove: " + linkedList.pollLast());
        System.out.println("Return content LinKedList: " + linkedList);
        //===================================================================================================
        //toArray(): возвращает массив из элементов списка
        String[] carsArray = linkedList.toArray(new String[3]);//TODO зачем в примере new String[3] так и не понял
        System.out.println(Arrays.toString(carsArray));
        //================================================================================================================
        //при вставке в середину списка ArrayList работает быстрее чем LinkedList
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list.add(new Integer(i));
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.add(2_000_000, new Integer(Integer.MAX_VALUE));
        }
        System.out.println("Время работы для LinkedList (в милисекундах) = " + (System.currentTimeMillis() - start));


        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list2.add(new Integer(i));
        }

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list2.add(2_000_000, new Integer(Integer.MAX_VALUE));
        }
        System.out.println("Время работы для ArrayList (в миллисекундах) = " + (System.currentTimeMillis() - start1));
        //В итоге при каждой вставке (удалении) в середине списка ArrayList уже знает точный адрес в памяти,
        // к которому он должен обратиться, а вот LinkedList’у еще надо до нужного места “дотопать”.
        //===========================================================================================================
        /*А вот в ситуациях, когда “топать” до нужного индекса не нужно, LinkedList действительно
         показывает себя лучше. Например, если вставка происходит в начало списка.
         */
        getTimeMsOfInsert(new LinkedList());
        getTimeMsOfInsert(new ArrayList());
        /*На вставку миллиона элементов в начало списка ArrayList затратил больше секунд,
        в то время как LinkedList справился за 0,1 секунды!
         */
    }

    public static long getTimeMsOfInsert(List list) {
        //напишите тут ваш код
        Date currentTime = new Date();
        insert1000000(list);
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Результат в миллисекундах: " + msDelay);
        return msDelay;

    }

    public static void insert1000000(List list) {
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Object());
        }
    }


}
