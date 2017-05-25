package com.example.a15017274.p06_taskmanager;

import java.io.Serializable;

/**
 * Created by 15017274 on 25/5/2017.
 */

public class Task implements Serializable {
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
