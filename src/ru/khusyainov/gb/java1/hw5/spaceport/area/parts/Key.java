package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

public class Key {
    private final String code;

    public Key(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Key{" +
                "code='" + code + '\'' +
                '}';
    }
}
