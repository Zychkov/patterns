package ru.zychkov.web.dao.example1;

public class DAOMain {
//    static Db db = new Db();
//    static FileSystem fileSystem = new FileSystem();

    static Data data = new FileSystem();

    public static void main(String[] args) {

//        System.out.println(db.getFromTable());
        System.out.println(data.getData());
    }
}

interface Data {
    String getData();
}

class Db implements Data{
    String getFromTable() {
        return "data from table";
    }

    @Override
    public String getData() {
        return getFromTable();
    }
}

class FileSystem implements Data{
    String getDataFromFS() {
        return "data from fs";
    }

    @Override
    public String getData() {
        return getDataFromFS();
    }
}