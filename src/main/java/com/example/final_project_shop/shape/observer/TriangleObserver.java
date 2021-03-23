package com.example.final_project_shop.shape.observer;

import com.example.final_project_shop.shape.action.TriangleCalculation;
import com.example.final_project_shop.shape.entity.Triangle;
import com.example.final_project_shop.shape.exception.ShapeException;
import com.example.final_project_shop.shape.warehouse.ShapeValue;
import com.example.final_project_shop.shape.warehouse.Warehouse;

import static com.example.final_project_shop.shape.reader.TriangleReader.logger;

public class TriangleObserver implements CustomerObserver {
    @Override
    public void parameterChanged(TriangleEvent event) throws ShapeException {
        if (event == null) {
            logger.error("argument is null");
            throw new ShapeException("argument is null");
        }
        Triangle triangle = event.getSource();
        TriangleCalculation action = new TriangleCalculation();
        double perimeter = action.perimeter(triangle);
        double square = action.square(triangle);
        ShapeValue shapeValue = new ShapeValue(perimeter, square);
        Warehouse warehouse = Warehouse.getWarehouse();
        warehouse.putShapeValue(triangle.getShapeId(), shapeValue);
    }
}
