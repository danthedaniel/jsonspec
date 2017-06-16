jsonspec
===

JSON structure checking for [org.json.simple](https://github.com/fangyidong/json-simple).

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

You can check against an array by specifying how all elements in the array
should be structured in the first element of the array in the spec string,
e.g.:

```json
{
  "foobar": "",
  "foo": [
    {
      "bar": 0
    }
  ]
}
```

The above specifies that there should be a key named `foobar` that
corresponds to a string, and a key named `foo` that corresponds to an
array of objects. These objects should all have the key `bar`, which
corresponds to a number.
