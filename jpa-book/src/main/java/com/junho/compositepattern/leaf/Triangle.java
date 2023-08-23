package com.junho.compositepattern.leaf;

import com.junho.compositepattern.component.Shape;

public class Triangle implements Shape {

    @Override
    public void draw(final String paintColor) {
        System.out.println("삼각형 색깔 : " + paintColor);
    }
}
