package com.myproject.core.models.impl;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    public int id;
    List<String> boys;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.boys = new ArrayList<>();
    }

    public void addBoys(String boy) {
        boys.add(boy);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public static void main(String[] args) {

    }
}
