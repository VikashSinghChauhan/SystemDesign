package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{

    String name;
    List<FileSystemComponent> children;
    Directory parent;

    public Directory(String name)
    {
        this.name = name;
        children = new ArrayList<>();
    }

    public void add(FileSystemComponent component){
        component.setParent(this);
        children.add(component);
    }

    public void remove(FileSystemComponent component){
        children.remove(component);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ Directory: " + name);
        for(FileSystemComponent component : children){
            component.display(indent + " ");
        }
    }

    @Override
    public void delete() {
        System.out.println("Deleting directory: " + name);
        //First delete all children..
        //when you try to delete from same list, it will cause error, so use copy list
        for(FileSystemComponent component : new ArrayList<>(children)){
            component.delete();
        }

        //remove self from parent
        if(parent != null){
            parent.remove(this);
        }
    }

    @Override
    public void setParent(Directory directory) {
        this.parent = directory;
    }

    @Override
    public Directory getParent() {
        return parent;
    }
}
