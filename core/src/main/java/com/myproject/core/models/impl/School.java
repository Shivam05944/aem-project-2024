package com.myproject.core.models.impl;

import java.util.ArrayList;
import java.util.List;

public class School {

    public String name;
    private List<String> branches;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }


    public static School getSchoolBranches() {
        List<String> branches = new ArrayList<>();
        School school = new School();
        school.setName("SCMS");
        branches.add("Sch");
        branches.add("Comm");
        branches.add("Arts");
        school.setBranches(branches);
        return school;
    }

}
