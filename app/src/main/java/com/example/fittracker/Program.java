package com.example.fittracker;

public class Program {

    private String name;
    private int id;
    private String programName;


    public Program(String name, int id, String programName) {
        this.name = name;
        this.id = id;
        this.programName = programName;

    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", programName='" + programName + '\'' +
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

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Program()
    {

    }
}
