package org.nhom5;

public enum Triangle {
    Vuong("Vuông"),

    Can("Cân"),
    Deu("Đều"),

    Thuong("Thường");
    private String value;

    public String getValue() {
        return value;
    }

    Triangle(String value) {
        this.value = value;
    }
}
