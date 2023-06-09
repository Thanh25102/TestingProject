package org.nhom5;

public class CalculateTriangle {

    public static class Triangle {
        public org.nhom5.Triangle type;

        public Triangle(org.nhom5.Triangle type) {
            this.type = type;
        }
    }

    public Triangle triangle(Long a, Long b, Long c) {
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Ba canh a, b, c khong phai la ba canh cua mot tam giac");
        else if (a * a + b * b == c * c || a * c + c * c == b * b || b * b + c * c == a * c)
            return new Triangle(org.nhom5.Triangle.Vuong);
        else if (a == b && b == c)
            return new Triangle(org.nhom5.Triangle.Deu);
        if (a == b || a == c || b == c)
            return new Triangle(org.nhom5.Triangle.Can);
        else
            return new Triangle(org.nhom5.Triangle.Thuong);
    }

    public Long getPerimeter(Long a, Long b, Long c) {
        return a + b + c;
    }

    public Double getArea(Long a, Long b, Long c) {
        Double p = getPerimeter(a, b, c).doubleValue();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
