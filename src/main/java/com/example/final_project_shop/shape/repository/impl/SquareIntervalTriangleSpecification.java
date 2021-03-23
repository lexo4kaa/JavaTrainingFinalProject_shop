package com.example.final_project_shop.shape.repository.impl;

import com.example.final_project_shop.shape.action.TriangleCalculation;
import com.example.final_project_shop.shape.entity.Shape;
import com.example.final_project_shop.shape.entity.Triangle;
import com.example.final_project_shop.shape.repository.Specification;

public class SquareIntervalTriangleSpecification implements Specification {
    private TriangleCalculation calculation;
    private double from;
    private double to;

    public SquareIntervalTriangleSpecification(double from, double to) {
        this.from = from;
        this.to = to;
        calculation = new TriangleCalculation();
    }

    @Override
    public boolean specify(Shape shape) {
        double perimeter = calculation.square((Triangle)shape);
        return perimeter >= from && perimeter <= to;
    }
}
