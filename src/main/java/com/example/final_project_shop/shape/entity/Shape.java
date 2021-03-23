package com.example.final_project_shop.shape.entity;

import java.util.UUID;

public abstract class Shape {
    private String shapeId;
    private String name;

    public Shape() {
        this.shapeId = UUID.randomUUID().toString();
    }

    public Shape(String name) {
        this.shapeId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id -- ").append(shapeId);
        sb.append("name -- ").append(name);
        return sb.toString();
    }
}
