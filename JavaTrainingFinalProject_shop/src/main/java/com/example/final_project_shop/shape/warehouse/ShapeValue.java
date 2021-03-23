package com.example.final_project_shop.shape.warehouse;

public class ShapeValue {
    private double perimeter;
    private double square;

    public ShapeValue(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)perimeter;
        result = prime * result + (int)square;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShapeValue other = (ShapeValue) obj;
        if (perimeter != other.perimeter) {
            return false;
        }
        if (square != other.square) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape value:\n");
        sb.append("perimeter -- ").append(perimeter).append("\n");
        sb.append("square -- ").append(square).append("\n");
        return sb.toString();
    }
}
