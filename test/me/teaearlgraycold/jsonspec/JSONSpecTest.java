package me.teaearlgraycold.jsonspec;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JSONSpecTest {
    @Test
    void testEmptyObject() throws ParseException, JSONFormatException {
        String spec = "{}";
        JSONObject json = (JSONObject) new JSONParser().parse(spec);
        JSONSpec.testObject(spec, json);
    }

    @Test
    void testEmptyArray() throws ParseException, JSONFormatException {
        String spec = "[]";
        JSONArray json = (JSONArray) new JSONParser().parse(spec);
        JSONSpec.testObject(spec, json);
    }

    @Test
    void testObject() throws ParseException, JSONFormatException {
        String spec = "{\"foo\": [\"\"], \"bar\": 0}";
        JSONObject json = (JSONObject) new JSONParser().parse(spec);
        JSONSpec.testObject(spec, json);
    }

    @Test
    void testNestedObject() throws ParseException, JSONFormatException {
        String spec = "{\"foo\": {\"bar\": {}}}";
        JSONObject json = (JSONObject) new JSONParser().parse(spec);
        JSONSpec.testObject(spec, json);
    }

    @Test
    void testOutOfSpec() throws ParseException, JSONFormatException {
        Throwable exception = assertThrows(JSONFormatException.class, () ->
        {
            String spec = "{\"foo\": {\"bar\": {}}}";
            String jsonString = "{\"foo\": {\"bar\": 0}}";
            JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
            JSONSpec.testObject(spec, json);
        });
        assertEquals("Expected value at foo.bar to be of type class org.json.simple.JSONObject", exception.getMessage());
    }

    @Test
    void testDifferentTopLevelType() throws ParseException, JSONFormatException {
        Throwable exception = assertThrows(JSONFormatException.class, () ->
        {
            String spec = "[]";
            String jsonString = "{}";
            JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
            JSONSpec.testObject(spec, json);
        });
        assertEquals("Expected root value to be of type org.json.simple.JSONArray", exception.getMessage());
    }
}