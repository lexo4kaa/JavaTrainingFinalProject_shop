package com.example.final_project_shop.shape.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final static Warehouse warehouse = new Warehouse();
    private Map<String, ShapeValue> shapesValues = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getWarehouse() {
        return warehouse;
    }

    public ShapeValue putShapeValue(String shapeId, ShapeValue shapeValue) {
        return shapesValues.put(shapeId, shapeValue);
    }

    public ShapeValue removeShapeValue(String shapeId) {
        return shapesValues.remove(shapeId);
    }

    public ShapeValue getShapeValue(String shapeId) {
        return shapesValues.get(shapeId);
    }
}
