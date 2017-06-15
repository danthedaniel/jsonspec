package me.teaearlgraycold.jsonspec;

/**
 * JSONFormatException is used when deserialized JSON doesn't match a specification.
 */
public class JSONFormatException extends Exception {
    public JSONFormatException(String message) {
        super(message);
    }
}