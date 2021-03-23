package com.example.final_project_shop.shape.comparator;

import com.example.final_project_shop.shape.action.TriangleCalculation;
import com.example.final_project_shop.shape.entity.Shape;
import com.example.final_project_shop.shape.entity.Triangle;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Shape> {
    ID {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            return shape1.getShapeId().compareTo(shape2.getShapeId());
        }
    },
    PERIMETER {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            TriangleCalculation action = new TriangleCalculation();
            return Double.compare(action.perimeter((Triangle)shape1), action.perimeter((Triangle)shape2));
        }
    },
    SQUARE {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            TriangleCalculation action = new TriangleCalculation();
            return Double.compare(action.square((Triangle)shape1), action.square((Triangle)shape2));
        }
    },
    X {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            Triangle triangle1 = (Triangle) shape1;
            Triangle triangle2 = (Triangle) shape2;
            return Double.compare(triangle1.getPoint1().getX(),triangle2.getPoint1().getX());
        }
    },
    Y {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            Triangle triangle1 = (Triangle) shape1;
            Triangle triangle2 = (Triangle) shape2;
            return Double.compare(triangle1.getPoint1().getY(),triangle2.getPoint1().getY());
        }
    }
}