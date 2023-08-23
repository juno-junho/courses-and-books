package com.junho.compositepattern.leaf;

import com.junho.compositepattern.component.Shape;

public class Square implements Shape {

    @Override
    public void draw(final String paintColor) {
        System.out.println("사각형 색깔 : " + paintColor);
    }
}
