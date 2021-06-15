package ru.education.trening.collectionMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RealizationHashMap {

    public static void main(String[] args) {
    /*Внутри Map данные хранятся в формате “ключ”-”значение”, то есть по парам. и в качестве ключей,
     и в качестве значений могут выступать любые объекты — числа, строки или объекты других классов.*/

        HashMap<Integer, String> passportsAndNames = new HashMap<>();
        //Здесь мы создали словарь, в котором элементы будут храниться в формате “число-строка”.
        // Число будет выступать ключом, а строка — значением.(элементы могут быть любого типа)
        //Для этого используется метод put(). Кроме того, HashMap имеет переопределенный метод toString(),
        // поэтому ее можно выводить на консоль. Вывод будет выглядеть так:

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");
        System.out.println(passportsAndNames);

        //Попробуем добавить новый элемент с уже имеющимся в мапе ключом:

        passportsAndNames.put(162348, "Виктор Михайлович Стычкин");//повторный ключ, перезапишет
        // предыдущий элемент с ключом 162348
        System.out.println(passportsAndNames);
        //===============================================================================================================

        //“Ключ” назвали ключом не просто так. Доступ к значениям в HashMap осуществляется по ключу
        // (но никак не наоборот — ключ нельзя получить по значению, ведь значения могут быть повторяющимися).
        passportsAndNames.put(8082772, "Дракула");

        String lidiaName = passportsAndNames.get(8082772);//вызвать Дракулу
        System.out.println(lidiaName);
        System.out.println(passportsAndNames);

        passportsAndNames.remove(8082772);
        System.out.println("Удаляем Дракулу: "+passportsAndNames);

        // Номерных индексов, как в массивах или списках, в HashMap нет — доступ к значению осуществляется по ключу.
        //==========================================================================================================

        //В классах ArrayList и LinkedList мы могли проверить, содержится ли в списке какой-то конкретный элемент.
        //
        //HashMap тоже позволяет это делать, причем для обеих частей пары: у нее есть методы containsKey()(проверяет
        // наличие какого-то ключа) и containsValue() (проверяет наличие значения).
        System.out.println(passportsAndNames.containsKey(11111));//такого ключа нет, поэтому вернет false
        System.out.println(passportsAndNames.containsValue("Дональд Джон Трамп"));//такое значение есть,вернет true

        //=============================================================================================================
        // можно по-отдельности получить список всех ключей и всех значений.
        //Для этого используются методы keySet() и values()
        //Ключи извлекаются в коллекцию Set. Ее особенность в том, что в ней не может быть повторяющихся элементов.

        System.out.println("Значения ключей: "+passportsAndNames.keySet());


        // Сейчас главное запомни, что список всех ключей можно вынести из HashMap в отдельную коллекцию.
        //Значения мы в  примере сохранили в обычный ArrayList.
        Set<Integer> keys = passportsAndNames.keySet();
        System.out.println("Ключи: " + keys);

        ArrayList<String> values = new ArrayList<>(passportsAndNames.values());
        System.out.println("Значения: " + values);
        //===========================================================================================================

        //Методы size() и clear() делают ровно то же самое, что и в предыдущих структурах,
        // которые мы проходили: первый — возвращает число элементов в словаре на текущий момент,
        // второй — удаляет все элементы.

        System.out.println(passportsAndNames.size());
        passportsAndNames.clear();
        System.out.println(passportsAndNames);
        //===============================================================================================================

        //Для проверки того, есть ли в нашей HashMap хотя бы один элемент, можно использовать метод isEmpty():
        System.out.println(passportsAndNames.isEmpty());//вернет true
        //==============================================================================================================

        //Еще один интересный момент — две мапы можно объединить в одну.
        //Для этого существует метод putAll(). Мы вызываем его у первой HashMap, передаем вторую в качестве аргумента,
        // и элементы из второй будут добавлены в первую:

        HashMap<Integer, String> passportsAndNames2 = new HashMap<>();

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");

        passportsAndNames2.put(917352, "Алексей Андреевич Ермаков");
        passportsAndNames2.put(925648, "Максим Олегович Архаров");

        passportsAndNames.putAll(passportsAndNames2);
        System.out.println(passportsAndNames);
        //=============================================================================================================

        //перебор HashMap в цикле.
        //интерфейс Map.Entry обозначает  пару “ключ-значение” внутри словаря.
        //Метод entrySet() возвращает список всех пар в нашей HashMap (поскольку наша мапа состоит как раз из таких
        // пар-Entry, то мы перебираем именно пары, а не отдельно ключи или значения).

        for (Map.Entry entry: passportsAndNames.entrySet()) {
            System.out.println(entry);
        }

    }

}
