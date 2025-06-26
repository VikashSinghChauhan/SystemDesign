package org.example;

public class File implements FileSystemComponent{

    String name;
    Directory parent;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- File: " + name);
    }

    @Override
    public void delete() {
        System.out.println("Deleting file : "+name);
        if(parent != null)
        {
            parent.remove(this);
        }
    }

    @Override
    public void setParent(Directory directory) {
        this.parent = parent;
    }

    @Override
    public Directory getParent() {
        return parent;
    }
}
