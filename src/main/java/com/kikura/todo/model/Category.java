package com.kikura.todo.model;

public enum Category {
    WORK("仕事"),
    PERSONAL("個人"),
    STUDY("学習"),
    OTHER("その他");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
