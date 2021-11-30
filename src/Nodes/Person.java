package Nodes;

public class Person extends Node {

    private String name;
    private Person children[];
    private Animal pets[];

    public Person(String name, Person[] children, Animal[] pets) {
        this.name = name;
        this.children = children;
        this.pets = pets;
    }

    public Person[] getChildren() {
        return children;
    }

    public Animal[] getPets() {
        return pets;
    }

}
