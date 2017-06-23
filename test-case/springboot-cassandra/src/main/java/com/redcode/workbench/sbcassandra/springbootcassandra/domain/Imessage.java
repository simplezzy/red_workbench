package com.redcode.workbench.sbcassandra.springbootcassandra.domain;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;

@Table
public class Imessage implements Serializable{

    @PrimaryKey
    private String id;

    @Column("last_name")
    private String lastName;

    private int age;

    public Imessage() {
        super();
    }

    public Imessage(String id, String lastName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
