package com.example.final_project_shop.shape.observer;

import com.example.final_project_shop.shape.exception.ShapeException;

public interface CustomerObserver {
    void parameterChanged (TriangleEvent event) throws ShapeException;
}
