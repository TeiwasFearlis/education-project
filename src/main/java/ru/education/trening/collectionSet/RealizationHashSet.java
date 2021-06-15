package ru.education.trening.collectionSet;

import java.util.HashSet;
import java.util.Iterator;

public class RealizationHashSet {
    public static void main(String[]args) {
        HashSet<String> hashSet = new HashSet<String>();
        //=================================================================================================
    /*Класс HashSet реализует интерфейс Set, основан на хэш-таблице.
     *В HashSet элементы не упорядочены, нет никаких гарантий, что элементы будут в том же порядке спустя какое-то время.
     *Операции добавления, удаления и поиска будут выполняться за константное время при условии,
     что хэш-функция правильно распределяет элементы по «корзинам», о чем будет рассказано далее.
     * Т.к. класс реализует интерфейс Set, он может хранить только уникальные значения;
     *Может хранить NULL – значения;
     *Порядок добавления элементов вычисляется с помощью хэш-кода;
      *HashSet также реализует интерфейсы Serializable и Cloneable.
      * Начальная емкость – изначальное количество ячеек («корзин») в хэш-таблице. Если все ячейки будут заполнены,
       их количество увеличится автоматически.
       * Коэффициент загрузки – показатель того, насколько заполненным может быть HashSet до того момента,
       когда его емкость автоматически увеличится.
       * Коэффициент загрузки = Количество хранимых элементов в таблице / размер хэш-таблицы
       *HashSet не является структурой данных с встроенной синхронизацией, поэтому если с ним работают одновременно
        несколько потоков, и как минимум один из них пытается внести изменения, необходимо обеспечить
        синхронизированный доступ извне. Часто это делается за счет другого синхронизируемого объекта,
        инкапсулирующего HashSet. Если такого объекта нет, то лучше всего подойдет метод Collections.synchronizedSet().
         На данный момент это лучшее средство для предотвращения несинхронизированных операций с HashSet.
     */
        //=================================================================================================
        /*Конструкторы HashSet:
HashSet hashSet = new HashSet(); — конструктор по умолчанию. Начальная емкость по умолчанию – 16, коэффициент загрузки – 0,75.
HashSet hashSet = new HashSet(int initialCapacity) – конструктор с заданной начальной емкостью. Коэффициент загрузки – 0,75.
HashSet hashSet = new HashSet(int initialCapacity, float loadFactor); — конструктор с заданными начальной емкостью и коэффициентом загрузки.
HashSet hashSet = new HashSet(Collection C) – конструктор, добавляющий элементы из другой коллекции.
         */

//================================================================================================================
        // Добавляем элементы в HashSet с помощью метода add()
        hashSet.add("Australia");
        hashSet.add("South Africa");
        System.out.println(hashSet.add("India"));//добавляем элемент,такого в таблице нет,поэтому вернет true
        System.out.println( hashSet.add("India"));// пытаемся добавить еще один такой же элемент(он не добавиться,т.к в HashSet может содержаться только
        //одно уникальное значение),вернет false
        //Object clone(): выполняет поверхностное клонирование HashSet.
        HashSet <String> newHashSet = (HashSet<String>) hashSet.clone();

        // Выводим элементы HashSet в консоль
        System.out.println(hashSet);
        System.out.println("clone hashSet: "+newHashSet);
        //метод contains возвращает true если в коллекции есть искомый объект
        System.out.println("List contains India or not:" + hashSet.contains("India"));

        // Удаляем элементы из множества с помощью метода remove()
        hashSet.remove("Australia");
        System.out.println("List after removing Australia:"+hashSet);

        // Проходимся по элементам HashSet с помощью итератора:
        System.out.println("Iterating over list:");
        Iterator<String> i = hashSet.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        //void clear(): удаляет все элементы из множества.
        hashSet.clear();
        System.out.println(hashSet);//вернет пустой массив
        //boolean isEmpty(): возвращает true, если в множестве нет элементов.
        System.out.println(hashSet.isEmpty());
        //boolean contains(Object o): Возвращает true, если данный элемент присутствует в множестве.
        System.out.println(newHashSet.contains("Australia"));



















    }
}
