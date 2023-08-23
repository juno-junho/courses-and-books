package com.junho.compositepattern.leaf;

import com.junho.compositepattern.component.Shape;

public class Circle implements Shape {

    @Override
    public void draw(final String paintColor) {
        System.out.println("동그라미 색깔 : " + paintColor);
    }
}
