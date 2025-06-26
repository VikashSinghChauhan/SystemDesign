package org.example;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory home = new Directory("home");
        Directory docs = new Directory("docs");

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        root.add(home);
        home.add(docs);
        docs.add(file1);
        docs.add(file2);

        System.out.println("Initial file System :: ");
        root.display("");

        System.out.println("\n Deleting file 2: ");
        file2.delete();

        System.out.println("\n After deleting file 2: ");
        root.display("");
    }
}