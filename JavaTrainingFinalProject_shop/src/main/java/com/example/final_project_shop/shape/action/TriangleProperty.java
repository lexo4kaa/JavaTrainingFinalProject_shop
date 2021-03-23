package com.example.final_project_shop.shape.action;

import com.example.final_project_shop.shape.entity.Point;
import com.example.final_project_shop.shape.entity.Triangle;

import java.util.List;

public class TriangleProperty {
    public static boolean isRectangular(Triangle triangle) {
        TriangleCalculation calculation = new TriangleCalculation();
        List<Point> points = triangle.getAllPoints();
        double a = calculation.distance(points.get(0), points.get(1));
        double b = calculation.distance(points.get(0), points.get(2));
        double c = calculation.distance(points.get(1), points.get(2));
        double cosA = (b*b + c*c - a*a) / 2*b*c;
        double cosB = (a*a + c*c - b*b) / 2*a*c;
        double cosC = (a*a + b*b - c*c) / 2*a*b;
        return  Math.abs(cosA) < Math.pow(10, -10) ||
                Math.abs(cosB) < Math.pow(10, -10) ||
                Math.abs(cosC) < Math.pow(10, -10);
    }

    public static boolean isAcute(Triangle triangle) {
        TriangleCalculation calculation = new TriangleCalculation();
        List<Point> points = triangle.getAllPoints();
        double a = calculation.distance(points.get(0), points.get(1));
        double b = calculation.distance(points.get(0), points.get(2));
        double c = calculation.distance(points.get(1), points.get(2));
        double cosA = (b*b + c*c - a*a) / 2*b*c;
        double cosB = (a*a + c*c - b*b) / 2*a*c;
        double cosC = (a*a + b*b - c*c) / 2*a*b;
        return cosA > Math.pow(10, -10) && cosB > Math.pow(10, -10) && cosC > Math.pow(10, -10);
    }

    public static boolean isObtuse(Triangle triangle) {
        TriangleCalculation calculation = new TriangleCalculation();
        List<Point> points = triangle.getAllPoints();
        double a = calculation.distance(points.get(0), points.get(1));
        double b = calculation.distance(points.get(0), points.get(2));
        double c = calculation.distance(points.get(1), points.get(2));
        double cosA = (b*b + c*c - a*a) / 2*b*c;
        double cosB = (a*a + c*c - b*b) / 2*a*c;
        double cosC = (a*a + b*b - c*c) / 2*a*b;
        System.out.println(cosA + " " + cosB + " " + cosC);
        return cosA < -Math.pow(10, -10) || cosB < -Math.pow(10, -10) || cosC < -Math.pow(10, -10);
    }

    public static boolean isIsosceles(Triangle triangle) {
        TriangleCalculation calculation = new TriangleCalculation();
        List<Point> points = triangle.getAllPoints();
        double a = calculation.distance(points.get(0), points.get(1));
        double b = calculation.distance(points.get(0), points.get(2));
        double c = calculation.distance(points.get(1), points.get(2));
        return ((a == b) && (a != c)) || ((a == c) && (a != b)) || ((b == c) && (a != c));
    }

    public static boolean isEquilateral(Triangle triangle) {
        TriangleCalculation calculation = new TriangleCalculation();
        List<Point> points = triangle.getAllPoints();
        double a = calculation.distance(points.get(0), points.get(1));
        double b = calculation.distance(points.get(0), points.get(2));
        double c = calculation.distance(points.get(1), points.get(2));
        return Math.abs(a - b) < Math.pow(10, -10) && Math.abs(a - c) < Math.pow(10, -10);
    }
}
