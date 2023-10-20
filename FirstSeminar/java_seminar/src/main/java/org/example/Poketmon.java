package org.example;

public abstract class Poketmon {
    private String name;
    private PoketmonType type;

    public Poketmon(String name, PoketmonType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public PoketmonType getType() {
        return type;
    }
}