package com.gileystanislav;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование примера из условия задачи.
 */
public class AppTest {

    @Test
    public void shouldTransformStringToMap() {
        String inputString = "сапог сарай арбуз болт бокс биржа";
        String expected = "{б=[биржа, бокс, болт], с=[сапог, сарай]}";

        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);

        assertEquals(expected, result.toString());
    }
}
