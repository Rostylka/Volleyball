package com.rostylka.Volleyball.models;


import lombok.Getter;

@Getter
public enum Position {
    SETTER("Setter"),
    OUTSIDE_HITTER("Outside Hitter"),
    OPPOSITE_HITTER("Opposite"),
    MIDDLE_BLOCKER("Middle Blocker"),
    LIBERO("Libero");

    private final String name;

    Position(String name) {
        this.name = name;
    }

}