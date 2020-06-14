package com.example.fittracker;

public class Program {

    private String name;
    private int id;


    public Program(String name, int id) {
        this.name = name;
        this.id = id;

    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Program()
    {

    }
}
