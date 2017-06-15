jsonspec
===

JSON structure checking for org.json.simple

### Usage

After parsing a JSON string, pass the resulting object with a spec string
to `JSONSpec.testObject`:

```java
String spec = "{\"foo\": {\"bar\": {}}}";
String jsonString = "{\"foo\": {\"bar\": 0}}";
JSONObject json = (JSONObject) new JSONParser().parse(jsonString);
JSONSpec.testObject(spec, json);
```

The above code results in a `JSONFormatException` with the message `Expected
value at foo.bar to be of type class org.json.simple.JSONObject`.
