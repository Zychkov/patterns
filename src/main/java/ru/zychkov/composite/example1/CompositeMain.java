package main.java.ru.zychkov.composite.example1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositeMain {

    public static void main(String[] args) {

    }
}

class File {

    String fileName;
}

class Folder {

    String name;
    Date creationDate;
    List<Folder> folders = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void removeFolder(Folder folder) {
        folders.remove(folder);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public List<File> getFiles() {
        return files;
    }
}