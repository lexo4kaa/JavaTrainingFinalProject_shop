package com.example.final_project_shop.shape.observer;

import com.example.final_project_shop.shape.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle)super.getSource();
    }
}
