package com.junho.compositepattern;

import com.junho.compositepattern.component.Shape;
import com.junho.compositepattern.composite.Drawing;
import com.junho.compositepattern.leaf.Circle;
import com.junho.compositepattern.leaf.Square;
import com.junho.compositepattern.leaf.Triangle;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    /**
     * Drawing 객체를 통해서 Triangle, Circle, Square 같은 Leaf 객체를 그룹(Drwaing)으로 묶어서 한번에 동작 가능
     * 객체들을 트리 구조들로 구성한 후, 구조들과 개별 객체들 처럼 작업할 수 있도록 하는 구조 패턴
     * - 복합채 패턴은 앱의 핵심 모델이 트리로 표현 될 수 있을때만 사용하라.
     *
     * 객체 들의 관계를 트리 구조로 구성해 부분-전체 계층을 표현하는 패턴
     * 사용자는 composite 패턴을 통해 단일 객체(Leaf - Triangle...)와 복합 객체(Composite - Drawing)를 모두 동일하게 다룰 수 있다.
     *
     * 1. 전체 - 부분 관계 갖는 객체들 사이의 관계 정의시 유용
     * 2. 클라이언트는 전체와 부분을 구분하지 않고 동일한 인터페이스 활용 가능
     * 3. 구조 패턴 중 하나.
     *
     * 간단하게 정리하면, 인터페이스를 통해서 같은 방식으로 처리 가능. composite 객체에 draw() -> 알아서 처리해라.
     * 클라이언트 입장에서 동일하게 처리 가능.
     */
    public static void main(String[] args) {

        Shape triangle = new Triangle();
        Shape circle = new Circle();
        Shape square = new Square();

        Drawing drawing = new Drawing();
        drawing.add(triangle);
        drawing.add(circle);
        drawing.add(square);

        drawing.draw("RED");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(drawing);
        shapes.add(new Triangle());
        shapes.add(new Triangle());
        shapes.add(new Square());

        shapes.forEach(shape -> shape.draw("BLUE"));
    }
}
