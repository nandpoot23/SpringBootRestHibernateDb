package com.example.sample.hibernate.types;

import java.io.Serializable;

public class CustomerConfigIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
