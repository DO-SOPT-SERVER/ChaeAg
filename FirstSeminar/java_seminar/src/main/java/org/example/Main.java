package org.example;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World");
        Poketmon poketmon = new AquaPoketmon("꼬부기");
        System.out.println(poketmon.getName() + " " + poketmon.getType());

        Child child = new Child();
        child.인사();
        child.자기소개();

        Monkey 잌숭이 = new Monkey();
        잌숭이.울다();
        Cat 개냥이 = new Cat();
        개냥이.울다();
    }
}