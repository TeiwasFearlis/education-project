package ru.education.trening.collectionSet;

import java.lang.reflect.Array;
import java.util.*;

public class RealizationTreeSet {
    public static void main(String[] args) {

        //Класс TreeSet в Java обеспечивает реализацию интерфейса Set, который использует древо для хранения.
        // Объекты хранятся в отсортированном и возрастающем порядке.
        //Время доступа и поиска довольно быстрое, что делает TreeSet отличным выбором при хранении большого
        // количества отсортированной информации, которая должна быть найдена быстро.

        //Конструктор и описание
        //1	TreeSet( )Этот конструктор создает пустое дерево, которое будет сортироваться в порядке возрастания в
        // соответствии с естественным порядком его элементов.
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("2");
        treeSet.add("1");
        treeSet.add("4");
        treeSet.add("3");
        treeSet.add("5");
        System.out.println(treeSet);
        //2	TreeSet(Collection c)Этот конструктор создает набор деревьев, содержащий элементы коллекции c.
        //3	TreeSet(Comparator comp)Этот конструктор создает пустой набор деревьев, который будет сортироваться в соответствии с данным компаратором.
        //4	TreeSet(SortedSet ss)Этот конструктор создает TreeSet, который содержит элементы данного SortedSet.
        //=============================================================================================================
        //Методы и описание
        String [] massiv = {"6", "7", "8", "9"};
        //	boolean addAll(Collection c)Добавляет все элементы в указанной коллекции к этому набору.
        List<String> list = Arrays.asList(massiv);
        System.out.println(list);
        treeSet.addAll(list);//тот самый метод
        System.out.println(treeSet);

        //	Object clone()Возвращает мелкую копию этого экземпляра TreeSet.
        TreeSet<String> copeTreeSet = (TreeSet<String>)treeSet.clone();
        System.out.println("This is clone: "+copeTreeSet);

        //5	Comparator comparator()Возвращает компаратор, используемый для порядка этого отсортированного набора,
        // или null (нуль), если этот набор деревьев использует свои элементы естественного упорядочения.
        System.out.println(treeSet.comparator());//вернет null

        //6	boolean contains(Object o)Возвращает true, если этот набор содержит указанный элемент.
        System.out.println(treeSet.contains("3"));//вернет true
        System.out.println(treeSet.contains("10"));//вернет false

        //7	Object first()Возвращает первый (самый низкий) элемент, находящийся в этом отсортированном наборе.
        System.out.println(treeSet.first());

        //8	SortedSet headSet(Object toElement)Возвращает представление (вид) части этого набора, элементы которого строго меньше, чем toElement,
        //не включая сам toElement.
        System.out.println(treeSet.headSet("5"));//1,2,3,4

        //10	Iterator iterator()Возвращает итератор над элементами этого набора.
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //11	Object last()Возвращает последний (самый высокий) элемент, находящийся в этом отсортированном наборе.
        System.out.println(treeSet.last());

        //13	int size()Возвращает количество элементов в этом наборе (его мощность).
        System.out.println(treeSet.size());

        //12	boolean remove(Object o)Удаляет указанный элемент из этого набора, если он присутствует.
        treeSet.remove("1");
        System.out.println(treeSet);

        //14	SortedSet subSet(Object fromElement, Object toElement)Возвращает представление (вид) части этого
        // набора, элементы которого варьируются от fromElement, включительно, до toElement, исключительно.
        System.out.println(treeSet.subSet("3","5"));

        //15	SortedSet tailSet(Object fromElement)Возвращает представление (вид) части этого набора,
        // элементы которого больше или равны fromElement.
        System.out.println(treeSet.tailSet("5"));

        //3	void clear()Удаляет все элементы из этого набора.
        treeSet.clear();

        //9	boolean isEmpty()Возвращает true, если этот набор не содержит элементов.
        System.out.println(treeSet.isEmpty());//true


    }
}
