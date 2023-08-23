package com.junho.compositepattern.composite;

import com.junho.compositepattern.component.Shape;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(final String paintColor) {
        shapes.forEach(shape -> shape.draw(paintColor));
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void remove(Shape shape) {
        this.shapes.remove(shape);
    }

    public void clear() {
        System.out.println("모든 도형 제거합니다.");
        this.shapes.clear();
    }
}
