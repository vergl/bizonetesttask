package com.gileystanislav;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldTransformStringToMap() {
        String inputString = "сапог сарай арбуз болт бокс биржа";
        StringToMapTransformer transformer = new StringToMapTransformer();
        Map<String, List<String>> result = transformer.transform(inputString);
        assertEquals(result.toString(), "{б=[биржа, бокс, болт], с=[сапог, сарай]}");
    }
}
