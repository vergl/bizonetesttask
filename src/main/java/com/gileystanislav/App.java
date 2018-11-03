package com.gileystanislav;

import java.util.List;
import java.util.Map;

/**
 * Тестовое задание для собеседования в компанию BI.Zone.
 * <p>
 * Текст задания:
 * Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.
 * Нужно преобразовать строку в такую структуру данных, которая группирует слова
 * по первой букве в слове. Затем вывести только группы, содержащие более одного элемента.
 * Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове.
 * Слова внутри группы нужно сортировать по убыванию (количеству символов);
 * если число символов равное, то сортировать в алфавитном порядке.
 * <p>
 * Пример строки: String s = "сапог сарай арбуз болт бокс биржа"
 * Отсортированная строка: [б=[биржа, бокс, болт], c=[сапог, сарай]]
 *
 * @author Станислав Гилей
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {
        String inputString = "сапог сарай арбуз   болт бокс биржа";
        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> dictionary = transformer.transform(inputString);
        System.out.println(dictionary);
    }


}
