package com.citi.insight.model;

import java.util.List;

public class Test {

    private String id;
    private String value;
    private Integer number;

    public Test() {
    }

    public Test(String id, String value, Integer number) {
        this.id = id;
        this.value = value;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
