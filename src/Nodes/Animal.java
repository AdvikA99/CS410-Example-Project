package Nodes;

public class Animal extends Node {

    private String name;
    private Animal[] children;

    public Animal(String name, Animal[] children) {
        this.name = name;
        this.children = children;
    }

    public Animal[] getChildren() {
        return children;
    }
}
