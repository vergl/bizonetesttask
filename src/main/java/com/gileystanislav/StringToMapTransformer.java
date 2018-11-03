package com.gileystanislav;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс преобразует полученную строку в структуру данных,
 * которая группирует слова по первой букве в слове,
 * убирает группы, в которых меньше двух слов,
 * а также сортирует слова в группах.
 *
 * @author Станислав Гилей
 * @version 1.0
 */
public class StringToMapTransformer {

    private Map<String, List<String>> dictionary = new TreeMap<>();

    /**
     * Компаратор, который сортирует слова по убыванию (количеству символов);
     * если число символов равное, то сортирует в алфавитном порядке.
     */
    private Comparator<String> customWordsComparator = (firstWord, secondWord) ->
            firstWord.length() == secondWord.length()
                    ? firstWord.compareTo(secondWord)
                    : secondWord.length() - firstWord.length();


    /**
     * Открытый метод, принимающий строку для обработки и возвращающий сгруппированный словарь.
     *
     * @param inputString - строка для преобразования.
     * @return словарь со сгруппированными по первой букве словами.
     */
    public Map<String, List<String>> transform(String inputString) {
        String preparedString = prepareString(inputString);
        transformStringToMap(preparedString);
        return dictionary;
    }

    /**
     * Преобразует строку в структуру данных, которая группирует слова по первой букве в слове.
     *
     * @param stringToTransform - строка для преобразования.
     */
    private void transformStringToMap(String stringToTransform) {
        List<String> wordsList = Arrays.asList(stringToTransform.split(" "));

        wordsList.stream()
                .distinct()
                .collect(Collectors.groupingBy(word -> word.substring(0, 1)))
                .forEach((key, value) -> {
                    if (value.size() > 1) {
                        value.sort(customWordsComparator);
                        dictionary.put(key, value);
                    }
                });
    }

    /**
     * Преобразует введённую строку в другую строку, содержащую только слова маленькими буквами,
     * разделенные единичным пробелом.
     *
     * @param rawString - строка, переданная пользователем.
     * @return строка со словами, разделенными единичным пробелом.
     */
    private String prepareString(String rawString) {
        return rawString.trim()
                .toLowerCase()
                .replaceAll("[^а-яa-z\\s]+", "")
                .replaceAll(" +", " ");
    }


}
