package ru.khusyainov.gb.java1.hw6;

enum AnimalType {
    DOG, CAT;

    String toUpperCamelCase() {
        StringBuilder builder = new StringBuilder();
        String[] words = this.name().split("[\\W_]+");
        for (String word : words) {
            word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) +
                    word.substring(1).toLowerCase();
            builder.append(word);
        }
        return builder.toString();
    }
}
