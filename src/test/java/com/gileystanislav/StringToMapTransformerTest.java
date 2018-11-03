package com.gileystanislav;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для основного функционала класса.
 *
 * @author Станислав Гилей
 * @version 1.0
 */
public class StringToMapTransformerTest {

    @Test
    public void shouldIgnoreExtraSpaces() {
        String inputString = "           сапог сарай            арбуз болт бокс биржа              ";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }

    @Test
    public void shouldBeCaseInsensitive() {
        String inputString = "СаПоГ саРАЙ арбуз БОЛТ Бокс бИРЖА";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }


    @Test
    public void shouldIgnoreDigitsAndSymbols() {
        String inputString = "сапог +++ ' ' 58935735 сарай ||||| арбуз _ ~@$ $@$ 2323болт бокс биржа";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }


    @Test
    public void shouldWorkBothWithCyrillicAndLatinCharacters() {
        String inputString = "сапог сарай арбуз болт бокс биржа table duck deer";
        String expected = "{d=[deer, duck], б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }

    @Test
    public void shouldReturnEmptyMapForEmptyString() {
        String inputString = "";
        String expected = "{}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }

    @Test
    public void shouldReturnEmptyMapForSingleWord() {
        String inputString = "word";
        String expected = "{}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }


    @Test
    public void shouldIgnoreDuplicates() {
        String inputString = "сапог сарай арбуз болт бокс биржа биржа биржа биржа";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }


    @Test
    public void shouldReturnEmptyMapForSingleChar() {
        String inputString = "с";
        String expected = "{}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }
}