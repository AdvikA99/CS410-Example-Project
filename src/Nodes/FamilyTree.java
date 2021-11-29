package Nodes;

import java.util.Random;

public class FamilyTree {

    private final String[] names = {"Abigail", "Ace", "Adam", "Addie", "Admiral", "Aggie", "Aires", "Aj", "Ajax", "Aldo", "Alex", "Alexus", "Alf", "Alfie", "Allie", "Ally", "Amber", "Amie", "Amigo", "Amos", "Amy", "Andy", "Angel", "Angus", "Annie", "Apollo", "April", "Archie", "Argus", "Aries", "Armanti", "Arnie", "Arrow", "Ashes", "Ashley", "Astro", "Athena", "Atlas", "Audi", "Augie", "Aussie", "Austin", "Autumn", "Axel", "Axle", "Babbles", "Babe", "Baby", "Baby-doll", "Babykins", "Bacchus", "Bailey", "Bam-bam", "Bambi", "Bandit", "Banjo", "Barbie", "Barclay", "Barker", "Barkley", "Barley", "Barnaby", "Barney", "Baron", "Bart", "Basil", "Baxter", "Bb", "Beamer", "Beanie", "Beans", "Bear", "Beau", "Beauty", "Beaux", "Bebe", "Beetle", "Bella", "Belle", "Ben", "Benji", "Benny", "Benson", "Bentley", "Bernie", "Bessie", "Biablo", "Bibbles", "Big Boy", "Big Foot", "Biggie", "Billie", "Billy", "Bingo", "Binky", "Birdie", "Birdy", "Biscuit", "Bishop", "Gus", "Guy", "Gypsy", "Hailey", "Haley", "Hallie", "Hamlet", "Hammer", "Hank", "Hanna", "Hannah", "Hans", "Happy", "Hardy", "Harley", "Harpo", "Harrison", "Harry", "Harvey", "Heather", "Heidi", "Henry", "Hercules", "Hershey", "Higgins", "Hobbes", "Holly", "Homer", "Honey", "Honey-Bear", "Hooch", "Hoover", "Hope", "Houdini", "Howie", "Hudson", "Huey", "Hugh", "Hugo", "Humphrey", "Hunter", "India", "Indy", "Iris", "Isabella", "Isabelle", "Itsy", "Itsy-bitsy", "Ivory", "Ivy", "Izzy", "Jack", "Jackie", "Jackpot", "Jackson", "Jade", "Jagger", "Jags", "Jaguar", "Jake", "Jamie", "Jasmine", "Jasper", "Jaxson", "Jazmie", "Jazz", "Jelly", "Jelly-bean", "Jenna", "Jenny", "Jerry", "Jersey", "Jess", "Jesse", "Jesse James", "Jessie", "Jester", "Jet", "Jethro", "Jett", "Jetta", "Jewel", "Jewels", "Jimmy", "Jingles", "JJ", "Joe", "Joey", "Johnny", "Jojo", "Joker", "Jolie", "Jolly", "Jordan", "Josie", "Joy", "JR", "Judy", "Julius", "June", "Misty", "Mitch", "Mittens", "Mitzi", "Mitzy", "Mo", "Mocha", "Mollie", "Molly", "Mona", "Muffy", "Nakita", "Nala", "Nana", "Natasha", "Nellie", "Nemo", "Nena", "Peanut", "Peanuts", "Pearl", "Pebbles", "Penny", "Phoebe", "Phoenix", "Sara", "Sarah", "Sasha", "Sassie", "Sassy", "Savannah", "Scarlett", "Shasta", "Sheba", "Sheena", "Shelby", "Shelly", "Sienna", "Sierra", "Silky", "Silver", "Simone", "Sissy", "Skeeter", "Sky", "Skye", "Skyler", "Waldo", "Wallace", "Wally", "Walter", "Wayne", "Weaver", "Webster", "Wesley", "Westie"};

    private int maxDepth;
    private Node rootNode;
    private Random rand;

    public FamilyTree(int maxDepth) {
        this.maxDepth = maxDepth;
        rand = new Random();
        rootNode = generatePerson(maxDepth);
    }

    private Person generatePerson(int depth) {
        int maxChildren = 4;
        int maxAnimals = 3;

        if (depth == 0) {
            return null;
        } else if (depth == 1) {
            maxChildren = 0;
            maxAnimals = 0;
        }

        String name = names[rand.nextInt(names.length)];
        int numChildren = rand.nextInt(maxChildren + 1);
        int numPets = rand.nextInt(maxAnimals + 1);

        Person children[] = new Person[numChildren];
        Animal pets[] = new Animal[numPets];

        for (int i = 0; i < numChildren; i++) {
            children[i] = generatePerson(depth - 1);
        }

        for (int i = 0; i < numPets; i++) {
            pets[i] = generatePet(depth - 1);
        }

        Person newPerson = new Person(name, children, pets);
        return newPerson;
    }

    public Animal generatePet(int depth) {
        int maxChildren = 4;

        if (depth == 0) {
            return null;
        } else if (depth == 1) {
            maxChildren = 0;
        }

        String name = names[rand.nextInt(names.length)];
        int numChildren = rand.nextInt(maxChildren + 1);

        Animal children[] = new Animal[numChildren];

        for (int i = 0; i < numChildren; i++) {
            children[i] = generatePet(depth - 1);
        }

        Animal pet = new Animal(name, children);
        return pet;
    }

    public int calcNumberOfNodes() {
        int totalNodes = 0;
        if (rootNode != null) {
            totalNodes += calcNumberOfChildNodes((Person) rootNode);
        }

        return totalNodes;
    }

    private int calcNumberOfChildNodes(Person person) {
        int totalNodes = 1;
        Person children[] = person.getChildren();
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                totalNodes += calcNumberOfChildNodes(children[i]);
            }
        }

        Animal pets[] = person.getPets();
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null) {
                totalNodes += calcNumberOfChildNodes(pets[i]);
            }
        }

        return totalNodes;
    }

    private int calcNumberOfChildNodes(Animal pet) {
        int totalNodes = 1;

        Animal children[] = pet.getChildren();
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                totalNodes += calcNumberOfChildNodes(children[i]);
            }
        }

        return totalNodes;
    }

}
