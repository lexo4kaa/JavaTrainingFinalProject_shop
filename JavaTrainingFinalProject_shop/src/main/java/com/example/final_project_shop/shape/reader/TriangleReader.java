package com.example.final_project_shop.shape.reader;

import com.example.final_project_shop.shape.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleReader {
    public static Logger logger = LogManager.getLogger();
    public static List<String> fileReading(String path) throws ShapeException {
        if (path == null) {
            throw new ShapeException("Path is null");
        }
        Path filePath = Paths.get(path);
        List<String> listOfTriangles;
        try (Stream<String> streamLines = Files.lines(filePath)) {
            listOfTriangles = streamLines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("File in " + path + " not found", e);
            throw new ShapeException("File in " + path + " not found", e);
        }
        return listOfTriangles;
    }
}
