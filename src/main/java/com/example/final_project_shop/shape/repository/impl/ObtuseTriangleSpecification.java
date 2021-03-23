package com.example.final_project_shop.shape.repository.impl;

import com.example.final_project_shop.shape.action.TriangleProperty;
import com.example.final_project_shop.shape.entity.Shape;
import com.example.final_project_shop.shape.entity.Triangle;
import com.example.final_project_shop.shape.repository.Specification;

public class ObtuseTriangleSpecification implements Specification {
    @Override
    public boolean specify(Shape shape) {
        if (shape == null || shape.getClass() != Triangle.class) {
            return false;
        }
        Triangle triangle = (Triangle) shape;
        return TriangleProperty.isObtuse(triangle);
    }
}