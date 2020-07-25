package com.wawa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Member {
    Integer id;
    String name;

    List<Group> groups = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
