package org.example;

public interface FileSystemComponent {
    String getName();
    void display(String indent);
    void delete();
    void setParent(Directory directory);
    FileSystemComponent getParent();
}
