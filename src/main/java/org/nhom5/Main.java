package org.nhom5;

public class Main {
    static class Triangle{
        String type;
        public Triangle(String type){
            this.type = type;
        }
    }

    private static Triangle triangle(Long a,Long b,Long c){
        if(a + b <= c || a + c <= b ||  b + c <= a)
            throw new IllegalArgumentException("a and b must be");
        else
            if(a * a + b * b == c * c || a * c + c * c == b * b || b * b + c * c == a * c)
                return new Triangle("Vuong");
            if(a == b || a == c || b == c)
                return new Triangle("Can");
            else
                return new Triangle("Thuong");
    }
    public static void main(String[] args) {
    }
}